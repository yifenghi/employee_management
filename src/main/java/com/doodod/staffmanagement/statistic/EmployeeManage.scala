/**
 * employee management project code
 */
package com.doodod.staffmanagement.statistic
import org.apache.spark.streaming.{ Minutes, StreamingContext }
import org.apache.spark.streaming.flume._
import com.doodod.staffmanagement.common._
import com.mongodb.casbah.Imports._
import org.apache.spark.streaming.StreamingContext._
import org.apache.spark.storage.StorageLevel
import org.apache.spark.SparkConf
import org.apache.spark.streaming._
import org.netlib.util.Second
import com.doodod.staffmanagement.message.Company.Employee
import com.doodod.staffmanagement.message.Company.Location
import java.util._
import com.google.protobuf.ByteString
import com.doodod.staffmanagement.common.Coordinates
import scala.collection.mutable.ArrayBuffer
import scala.collection.immutable.List
import scala.math._
import java.text.SimpleDateFormat
/**
 * @author lifeng
 *
 */
object EmployeeManage {

  def main(args: Array[String]) {
    if (args.length < 2) {
      System.err.println("Usage: Input <directory> TimeOut")
      System.exit(1)
    }
    val sparkConf = new SparkConf().setAppName("EmployeeManage")
    val streamContext = new StreamingContext(sparkConf, Minutes(1))
    
    val stream = FlumeUtils.createStream(streamContext, "hadoop-store2", 19998, StorageLevel.MEMORY_ONLY_SER_2)
    stream.count().map(cnt => "Received " + cnt + " flume events.").print()
    stream.map { x => new String(x.event.getBody.array()) }.print()
    
    streamContext.checkpoint(".")
//    val lines = streamContext.textFileStream(args(0))
    val events = stream.map { x => new String(x.event.getBody.array()) }
    val items = events.filter { _.split("\\s+").length == 4 }.map { line =>
      {
        val parts = line.split("\\s+")

        (parts(0), setEmployee(parts(0), parts(1), parts(2), parts(3)))

      }
    }
    val output = items.updateStateByKey[Employee](updateFunc _)
    println("========Project Runing2=========")
    output.print()
    output.foreachRDD { rdd =>
      rdd.foreachPartition { partitionOfRecords =>
        {
          val rs1 = new ServerAddress("192.168.1.200", 27017)
          val rs2 = new ServerAddress("192.168.1.200", 27017)
          val rs3 = new ServerAddress("192.168.1.200", 27017)
          val mongoClient = MongoClient(List(rs1, rs2, rs3))
          val db = mongoClient("staffmanagement")
          //          val db = MongoManager.getDB("scala_test")
          try {
            val coll = db("employee")
            val coll_business = db("business_work_time")
            val business_time = coll_business.findOne()
            val mac_info = db("mac_info").find()
            val mac_list = ArrayBuffer[String]()
            for (doc <- mac_info) {
              mac_list += doc.get("mac").toString
            }
            val today = new Date
            val timeFormat = new SimpleDateFormat("yyyy-MM-dd ")
            val tf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
            val midStart = tf.parse(timeFormat.format(today) + "00:00:00").getTime
            val midEnd = tf.parse(timeFormat.format(today) + business_time.get("BEFORE_WORK_TIME")).getTime
            val nightStart = tf.parse(timeFormat.format(today) + business_time.get("AFTERNOON_END_WORK_TIME")).getTime
            val nightEnd = tf.parse(timeFormat.format(today) + "23:59:59").getTime

            partitionOfRecords.foreach(record => {
              val mac = record._1
              if (mac_list.contains(mac)) {
                val time = getStartAndEndTime(record._2)
                val start = time._1
                val end = time._2
                val dwell = getDwell(record._2)
                val overTime = calculateOverTime(record._2, 0, midStart, midEnd, nightStart, nightEnd)
                val k1: String = "phoneMac"
                val query = MongoDBObject(k1 -> mac)
                val update = MongoDBObject(k1 -> mac, "startTime" -> start, "endTime" -> end, "dwell" -> dwell,
                  "overTime" -> overTime, "date" -> midStart)
                coll.update(query, update, upsert = true)
              }
            })
            //mongoClient.close()
          } finally {
            mongoClient.close()
          }

        }
      }
    }
    streamContext.start()
    //    streamContext.awaitTermination(86400000l)
    streamContext.awaitTermination(args(1).toLong)

  }
  def setEmployee(mac: String, x: String, y: String, timeStamp: String): Employee = {
    val emp = Employee.newBuilder()
    emp.setPhoneMac(ByteString.copyFrom(mac.getBytes()))
    val loc = Location.newBuilder()
    loc.setLocationX(x.toDouble)
    loc.setLocationY(y.toDouble)
    loc.addTimeStamp(timeStamp.toLong)
    emp.addLocation(loc)
    emp.build()
  }
//  def setEmployee(columns: String*): Employee = {
//    //使用不定长参数
//    val emp = Employee.newBuilder()
//    emp.setPhoneMac(ByteString.copyFrom(columns(0).getBytes()))
//    val loc = Location.newBuilder()
//    loc.setLocationX(columns(1).toDouble)
//    loc.setLocationY(columns(2).toDouble)
//    loc.addTimeStamp(columns(3).toLong)
//    loc.addClientTime(columns(4).toLong)
//    loc.setPlanarGraph(columns(5).toLong)
//    loc.setPositionSys(ByteString.copyFrom(columns(6).getBytes()))
//    emp.addLocation(loc)
//    emp.build()
//  }

  def updateFunc(e1: Seq[Employee], e2: Option[Employee]): Option[Employee] = {
    val result = e2.getOrElse(Employee.newBuilder().build()).toBuilder()
    var i = 0
    var j = 0
    while (i < e1.length) {
      var flag = true
      while (j < result.getLocationCount && flag) {
        if (e1(i).getLocation(0).getLocationX == result.getLocation(j).getLocationX.toDouble
          && e1(i).getLocation(0).getLocationY.toDouble == result.getLocation(j).getLocationY.toDouble) {
          result.getLocationBuilder(j).addTimeStamp(e1(i).getLocation(0).getTimeStamp(0))
          flag = false
        }
        j += 1
      }
      if (flag && e1(i).getLocationCount != 0) {
        result.addLocation(e1(i).getLocation(0))
      }
      i += 1
    }
    Some(result.build())
  }
  def getStartAndEndTime(e1: Employee): (Long, Long) = {
    var start: Long = Common.MAX
    var end: Long = Common.MIN
    var i = 0    
    while (i < e1.getLocationCount) {
      start = min(start, e1.getLocation(i).getTimeStamp(0).toLong)
      val length = e1.getLocation(i).getTimeStampCount - 1
      end = max(end, e1.getLocation(i).getTimeStamp(length).toLong)
      i += 1
    }
    (start, end)
  }

  def getDwell(e1: Employee): Long = {
    val dwell = TimeCluster.getTimeDwell(e1, 0)
    dwell.toLong
  }

  def calculateOverTime(customer: Employee, timeSplit: Long,
                        midStart: Long, midEnd: Long, nightStart: Long, nightEnd: Long): Long = {
    val eb = Employee.newBuilder();
    for (i <- 0 until customer.getLocationCount) {
      val loc = Location.newBuilder();
      for (j <- 0 until customer.getLocation(i).getTimeStampCount) {
        val t = customer.getLocation(i).getTimeStamp(j)
        if (t >= midStart && t <= midEnd) {
          loc.addTimeStamp(t)
        }
        if (t >= nightStart && t <= nightEnd) {
          loc.addTimeStamp(t)
        }
      }
      if (loc.getTimeStampList() != null && loc.getTimeStampCount() != 0) {
        eb.addLocation(loc)
      }
    }
    val overTime = TimeCluster.getTimeDwell(eb.build(), timeSplit);
    overTime.toLong
  }
}