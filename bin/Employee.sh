#!/bin/bash

set -ux

work_dir=$(readlink -f $(dirname $0))/..
class=com.doodod.staffmanagement.statistic.EmployeeManage

export HADOOP_CONF_DIR=/etc/hadoop/conf
spark-submit \
--class $class \
--master yarn-cluster \
--executor-memory 1G \
--total-executor-cores 1 \
--jars $work_dir/lib_jars/employee_management-1.0-SNAPSHOT-jar-with-dependencies.jar \
"$work_dir/target/employee_management-1.0-SNAPSHOT.jar" \
"hdfs://hadoop-manager:8020/user/hdfs/stream_input"

exit 0