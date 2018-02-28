package com.doodod.staffmanagement.common;
//add by lifeng
public class Common {
	public static final char MERGE_TAG_P = 'P';
	public static final char MERGE_TAG_T = 'T';

	
	public static final String CTRL_A  = "\u0001";
	public static final String CTRL_B  = "\u0002";
	public static final String CTRL_C  = "\u0003";
	public static final String COMMA   = ",";
		
	public static final String TABLE_NAME  = "Locations";
	public static final String TIME_FORMAT = "yyyy-MM-dd HH:mm:ss";
	public static final String DATE_FORMAT = "yyyy-MM-dd";
	public static final String MAC_FORMAT  = "%02x";
	public static final String NUM_FORNAT  = "0.00";
	
	public static final String EMPLOYEE_SYSTEM_BIZDATE = "employee.system.bizdate";
	public static final String EMPLOYEE_SYSTEM_TODAY   = "employee.system.today";
	public static final String EMPLOYEE_SYSTEM_TOMORROW   = "employee.system.tomorrow";
	public static final String EMPLOYEE_SYSTEM_FLOORS  = "employee.system.floors";
	public static final String EMPLOYEE_SYSTEM_COLUMNS = "employee.system.columns";
	

	public static final String BUSINESSTIME_START = "company.businesstime.start";
	public static final String BUSINESSTIME_NOW   = "company.businesstime.now";
	public static final String BUSINESSTIME_OUT   = "businesstime";
	
	public static final String MERGE_INPUT_PART  = "merge.input.part";
	public static final String MERGE_INPUT_TOTAL = "merge.input.total";
	
	public static final String LOCATION_X = "X";
	public static final String LOCATION_Y = "Y";
	public static final String LOCATION_Z = "PlanarGraph";
	public static final String LOCATION_PRO  = "PositioningSystem";
	public static final String LOCATION_TIME = "ClientTime";	
	public static final String FLOW_TIME_MIN  = "flow.time.min";
	public static final String FLOW_TIME_HOUR = "flow.time.hour";
	public static final String FLOW_TAG_MIN   = "min";
	public static final String FLOW_TAG_HOUR  = "hour";
	public static final String FLOW_TAG_DAY   = "day";
	public static final String FLOW_INPUT_MIN  = "flow.input.min";
	public static final String FLOW_INPUT_HOUR = "flow.input.hour";
	public static final String FLOW_INPUT_DAY  = "flow.input.day";

//	public static final String DWELL_TAG_SHOP   = "shop";
//	public static final String DWELL_TAG_FLOOR  = "floor";
	
	public static final String SHOP_CONF_FRAME  = "shop.conf.frame";
	public static final String SHOP_CONF_PUBLIC = "shop.conf.public";
	public static final String SHOP_CONF_STORE  = "shop.conf.store";
	public static final String SHOP_CONF_DISTANCE = "shop.public.distance";
	public static final String CUSTOMER_CONF_VIP  = "customer.conf.vip";
	public static final String CONF_MACHINE_LIST  = "conf.machine.list";
	public static final String CONF_EMPLOYEE_LIST = "conf.employee.list";
	public static final String CONF_PASSENGER_FILTER = "conf.passenger.filter";

	public static final String CONF_MAC_BRAND     = "conf.mac.brand";
	public static final String CONF_BRAND_LIST    = "conf.brand.list";
	public static final String DEFAULT_MAC_BRAND  = "其他";
	public static final String BRAND_UNKNOWN      = "unknown";
	
	public static final String MONGO_OPTION_SET  = "$set";
	public static final String MONGO_SERVER_LIST = "mongo.server.list";
	public static final String MONGO_SERVER_PORT = "mongo.server.port";
	public static final String MONGO_DB_NAME     = "mongo.db.staffmanagement";
	
	public static final String MONGO_COLLECTION_MALL        = "mongo.collection.mall";
	public static final String MONGO_COLLECTION_MALL_ID     = "mongo.collection.mall.id";
	public static final String MONGO_COLLECTION_MALL_TAG    = "mongo.collection.mall.tag";
	public static final String MONGO_COLLECTION_MALL_TIME   = "mongo.collection.mall.time";
	public static final String MONGO_COLLECTION_MALL_NUMBER = "mongo.collection.mall.number";	
	
	public static final String MONGO_COLLECTION_FLOOR        = "mongo.collection.floor";
	public static final String MONGO_COLLECTION_FlOOR_ID     = "mongo.collection.floor.id";
	public static final String MONGO_COLLECTION_FlOOR_TAG    = "mongo.collection.floor.tag";
	public static final String MONGO_COLLECTION_FlOOR_TIME   = "mongo.collection.floor.time";
	public static final String MONGO_COLLECTION_FlOOR_NUMBER = "mongo.collection.floor.number";
	
	public static final String MONGO_COLLECTION_STORE        = "mongo.collection.shop";
	public static final String MONGO_COLLECTION_STORE_ID     = "mongo.collection.shop.id";
	public static final String MONGO_COLLECTION_STORE_CAT    = "mongo.collection.shop.cat";
	public static final String MONGO_COLLECTION_STORE_TAG    = "mongo.collection.shop.tag";
	public static final String MONGO_COLLECTION_STORE_TIME   = "mongo.collection.shop.time";
	public static final String MONGO_COLLECTION_STORE_NUMBER = "mongo.collection.shop.number";

	public static final String MONGO_COLLECTION_CUSTOMER       = "mongo.collection.customer";
	public static final String MONGO_COLLECTION_CUSTOMER_MAC   = "mongo.collection.customer.mac";
	public static final String MONGO_COLLECTION_CUSTOMER_VALUE = "mongo.collection.customer.value";
	public static final String MONGO_COLLECTION_CUSTOMER_TIME  = "mongo.collection.customer.time";
	
	public static final String MONGO_COLLECTION_DWELL        = "mongo.collection.dwell";
	public static final String MONGO_COLLECTION_DWELL_USER   = "mongo.collection.dwell.user";
	public static final String MONGO_COLLECTION_DWELL_POS    = "mongo.collection.dwell.pos";
	public static final String MONGO_COLLECTION_DWELL_TYPE   = "mongo.collection.dwell.type";
	public static final String MONGO_COLLECTION_DWELL_TIME   = "mongo.collection.dwell.time";
	public static final String MONGO_COLLECTION_DWELL_NUMBER = "mongo.collection.dwell.number";
	
	public static final String MONGO_COLLECTION_VISIT        = "mongo.collection.visit";
	public static final String MONGO_COLLECTION_VISIT_ID     = "mongo.collection.visit.id";
	public static final String MONGO_COLLECTION_VISIT_TAG    = "mongo.collection.visit.tag";
	public static final String MONGO_COLLECTION_VISIT_TIME   = "mongo.collection.visit.time";
	public static final String MONGO_COLLECTION_VISIT_DWELL    = "mongo.collection.visit.dwell";
	public static final String MONGO_COLLECTION_VISIT_DWELLDIS = "mongo.collection.visit.dwelldis";
	public static final String MONGO_COLLECTION_VISIT_FLOOR    = "mongo.collection.visit.floor";
	public static final String MONGO_COLLECTION_VISIT_FLOORDIS = "mongo.collection.visit.floordis";
	public static final String MONGO_COLLECTION_VISIT_SHOP     = "mongo.collection.visit.shop";
	public static final String MONGO_COLLECTION_VISIT_SHOPDIS  = "mongo.collection.visit.shopdis";	
	public static final String MONGO_COLLECTION_VISIT_ZONE     = "mongo.collection.visit.zone";
	public static final String MONGO_COLLECTION_VISIT_ZONEDIS  = "mongo.collection.visit.zonedis";
	public static final String MONGO_COLLECTION_VISIT_TIMES    = "mongo.collection.visit.times";
	public static final String MONGO_COLLECTION_VISIT_TIMESDIS = "mongo.collection.visit.timesdis";
	public static final String MONGO_COLLECTION_VISIT_FREQ     = "mongo.collection.visit.freq";
	public static final String MONGO_COLLECTION_VISIT_FREQDIS  = "mongo.collection.visit.freqdis";
	public static final String MONGO_COLLECTION_VISIT_TAGTYPE  = "mongo.collection.visit.tagtype";
	public static final String MONGO_COLLECTION_VISIT_NEWCUST  = "mongo.collection.visit.newcust";
	public static final String MONGO_COLLECTION_VISIT_OLDCUST  = "mongo.collection.visit.oldcust";
	
	public static final String MONGO_COLLECTION_LOCATION      = "mongo.collection.location";
	public static final String MONGO_COLLECTION_LOCATION_ID   = "mongo.collection.location.id";
	public static final String MONGO_COLLECTION_LOCATION_X    = "mongo.collection.location.x";
	public static final String MONGO_COLLECTION_LOCATION_Y    = "mongo.collection.location.y";
	public static final String MONGO_COLLECTION_LOCATION_NUM  = "mongo.collection.location.number";
	public static final String MONGO_COLLECTION_LOCATION_TIME = "mongo.collection.location.time";

	public static final String MONGO_COLLECTION_TRACE      = "mongo.collection.trace";
	public static final String MONGO_COLLECTION_TRACE_ID   = "mongo.collection.trace.id";
	public static final String MONGO_COLLECTION_TRACE_LIST = "mongo.collection.trace.list";
	public static final String MONGO_COLLECTION_TRACE_X    = "mongo.collection.trace.x";
	public static final String MONGO_COLLECTION_TRACE_Y    = "mongo.collection.trace.y";
	public static final String MONGO_COLLECTION_TRACE_Z    = "mongo.collection.trace.z";
	public static final String MONGO_COLLECTION_TRACE_TIME = "mongo.collection.trace.time";
	
	public static final String MONGO_COLLECTION_BRAND       = "mongo.collection.brand";
	public static final String MONGO_COLLECTION_BRAND_NAME  = "mongo.collection.brand.name";
	public static final String MONGO_COLLECTION_BRAND_COUNT = "mongo.collection.brand.count";
	public static final String MONGO_COLLECTION_BRAND_TIME  = "mongo.collection.brand.time";

	public static final String MONGO_COLLECTION_COUNT           = "mongo.collection.count";
	public static final String MONGO_COLLECTION_COUNT_ID        = "mongo.collection.count.id";
	public static final String MONGO_COLLECTION_COUNT_CUSTOMER  = "mongo.collection.count.customer";
	public static final String MONGO_COLLECTION_COUNT_EMPLOYEE  = "mongo.collection.count.employee";
	public static final String MONGO_COLLECTION_COUNT_MACHINE   = "mongo.collection.count.machine";
	public static final String MONGO_COLLECTION_COUNT_PASSENGER = "mongo.collection.count.passenger";
	public static final String MONGO_COLLECTION_COUNT_TOTAL     = "mongo.collection.count.total";
	public static final String MONGO_COLLECTION_COUNT_TIME      = "mongo.collection.count.time";


	
	public static final String LOCATION_DWELL_FILTER = "location.dwell.filter";
	public static final String DWELL_PER_LOCATION_FILTER = "dwell.per.location.filter";
	public static final String VISIT_TIMES_FILTER = "visit.times.filter";
	
	

	public static final int AP_MAC_LENGTH    = 1;
	public static final int MONGO_SERVER_NUM = 3;
	public static final int MINUTE_FORMATER  = 60000;
	
	public static final int DWELL_TYPE_SHOP  = 0;
	public static final int DWELL_TYPE_FLOOR = 1;
	public static final int DWELL_TYPE_MALL  = 2;
	public static final int DEFAULT_TAG_TYPE = 0;

	
	public static final int DEFAULT_MONGO_PORT = 27017;
	public static final int DEFAULT_COLUMN_NUM = 20;
	public static final int DEFAULT_FLOOR_NUM  = 6;
	public static final int DEFAULT_LOCATION_DWELL     = 10;
	public static final int DEFAULT_DWELL_PER_LOCATION = 25;
	public static final int DEFAULT_PASSENGER_FILTER   = 1;
	public static final int DEFAULT_VISIT_TIMES = 3;
	public static final int DEFAULT_MALL_ID     = 67;
	public static final int MAC_KEY_LENGTH = 8;
	
	
	
	// add by lifeng
	public static final String CONF_MAC_LIST     = "conf.mac.list";
	public static final String COMPANY_ID ="lanxin";
	public static final String TAG_MAC = "01";	
	public static final long MAX = 32973840000000l;
	public static final long MIN = 0;
	public static final String FILTER_COUNT = "filter.count";
	public static final String FILTER_LIST  = "filter.list";
	public static final String SEE_MAC = "see.mac";
	
	
	public static final String CONF_AREA = "area";
	
	public static final long FILTER_TIME = 900000l;
	
	public static final long FLOORID = 1108;
//	public static String BEFORE_WORK_TIME = "company.worktime.before";
//	public static String MONING_START_WORK_TIME = "company.worktime.moningstart";
//	public static String MONING_END_WORK_TIME = "company.worktime.moningend";
//	public static String AFTERNOON_START_WORK_TIME = "company.worktime.afternoonstart";
//	public static String AFTERNOON_END_WORK_TIME = "company.worktime.afternoonend";
//	public static String OVERWORK_START_TIME = "company.overtime.start";


	public static final String BEFORE_WORK_TIME = "BEFORE_WORK_TIME";//"06:00:00";
	public static final String MONING_START_WORK_TIME = "MONING_START_WORK_TIME";//"08:00:00";
	public static final String MONING_END_WORK_TIME = "MONING_END_WORK_TIME";//"12:00:00";
	public static final String AFTERNOON_START_WORK_TIME = "AFTERNOON_START_WORK_TIME";//"13:00:00";
	public static final String AFTERNOON_END_WORK_TIME = "AFTERNOON_END_WORK_TIME";//"18:00:00";
	public static final String OVERWORK_START_TIME = "OVERWORK_START_TIME";//"19:00:00";	
	
	public static final String MONGO_COLLECTION_EMPLOYEE               = "mongo.collection.employee";	
	public static final String MONGO_COLLECTION_EMPLOYEE_DATE          = "mongo.collection.employee.date";
	public static final String MONGO_COLLECTION_EMPLOYEE_MAC           = "mongo.collection.employee.mac";
	public static final String MONGO_COLLECTION_EMPLOYEE_STARTTIME     = "mongo.collection.employee.starttime";
	public static final String MONGO_COLLECTION_EMPLOYEE_ENDTIME       = "mongo.collection.employee.endtime";
	public static final String MONGO_COLLECTION_EMPLOYEE_WORKTIME      = "mongo.collection.employee.worktime";
	public static final String MONGO_COLLECTION_EMPLOYEE_OVERTIME      = "mongo.collection.employee.overtime";
	public static final String MONGO_COLLECTION_EMPLOYEE_INCORRECT     = "mongo.collection.employee.incorrect";
	public static final String MONGO_COLLECTION_EMPLOYEE_BUSINESSSTART = "mongo.collection.employee.businessstart";
	public static final String MONGO_COLLECTION_EMPLOYEE_BUSINESSEND   = "mongo.collection.employee.businessend";
	public static final String MONGO_COLLECTION_EMPLOYEE_LATECOUNT	   = "mongo.collection.employee.latecount";
	public static final String MONGO_COLLECTION_EMPLOYEE_LEAVEEARLYCOUNT  = "mongo.collection.employee.leaveearlycount";
	public static final String MONGO_COLLECTION_EMPLOYEE_ABSENTEEISMCOUNT = "mongo.collection.employee.absenteeismcount";
	public static final String MONGO_COLLECTION_EMPLOYEE_INCORRECTCOUNT   = "mongo.collection.employee.incorrectcount";
	
	
	
	public static final String MONGO_COLLECTION_WORKTIME               = "mongo.collection.worktime";
	public static final String MONGO_COLLECTION_WORKTIME_NAME		   = "mongo.collection.worktime.name";
	public static final String MONGO_COLLECTION_WORKTIME_TIME          = "mongo.collection.worktime.time";
	
	public static final String MONGO_COLLECTION_MACINFO				   = "mongo.collection.macinfo";
	public static final String MONGO_COLLECTION_MACINFO_MAC			   = "mongo.collection.macinfo.mac";

	//scala mongoDB conf
	public static final String MONGO_HOST = "192.168.1.200";
	public static final int MONGO_PORT = 27017;
	public static final int MONGO_POOLSIZE = 20;
	public static final int MONGO_BLOCKSIZE = 30;
}
