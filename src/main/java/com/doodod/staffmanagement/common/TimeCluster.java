package com.doodod.staffmanagement.common;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.doodod.staffmanagement.message.Company.Employee;
import com.doodod.staffmanagement.message.Company.Location;



public class TimeCluster {
	public static List<Long> getTimeList(Employee customer) {
		List<Long> timeList = new ArrayList<Long>();		
		for (Location loc : customer.getLocationList()) {
			for (Long time : loc.getTimeStampList()) {
				timeList.add(time);
			}
		}	
		
		return timeList;
	}
	
	public static List<List<Long>> getTimeZone(List<Long> timeList, long timeSplit) {
		List<Long> timeListNew = new ArrayList<Long>();
		for (Long time : timeList) {
			timeListNew.add(time);
		}
		
		List<List<Long>> zoneList = new ArrayList<List<Long>>();	
		if (timeListNew.size() == 1) {
			zoneList.add(timeListNew);
			return zoneList;
		}
		
		Collections.sort(timeListNew);
		int size = timeListNew.size();
		zoneList.add(new ArrayList<Long>());
		for (int i = 0; i < size - 1; i++) {
			long zone = timeListNew.get(i + 1) - timeListNew.get(i);
			zoneList.get(zoneList.size() - 1).add(timeListNew.get(i));

			if (zone > timeSplit) {
				zoneList.add(new ArrayList<Long>());
			}
			
			if (i == size - 2) {
				zoneList.get(zoneList.size() - 1).add(timeListNew.get(i + 1));
			}
		}
		
		return zoneList;
	}
	
	public static long getTimeDwell(Employee customer, long timeSplit) {
		List<Long> timeList = getTimeList(customer);
		
		return getTimeDwell(timeList, timeSplit);
	}
	
	public static long getTimeDwell(List<Long> timeList, long timeSplit) {
		List<List<Long>> zoneList = getTimeZone(timeList, timeSplit);
		long timeDwell = 0;
		for (List<Long> times : zoneList) {
			if(times.size() < 1){
				continue;
			}
			if (times.size() == 1) {
				//one point means 2 second
				timeDwell += 1 * Common.MINUTE_FORMATER / 30;
			}
			else {
				timeDwell += times.get(times.size() - 1)
						- times.get(0);
			}
		}
		return timeDwell;
	}
	
	
	public static long getMinTimeStamp(Employee customer) {
		long timeStamp = Long.MAX_VALUE;
		for (Location loc : customer.getLocationList()) {
			for (long time : loc.getTimeStampList()) {
				if (timeStamp > time) {
					timeStamp = time;
				}
			}
		}
		return timeStamp;	
	}
	
	public static long getMaxTimeStamp(Employee customer) {
		long timeStamp = 0;
		for (Location loc : customer.getLocationList()) {
			for (long time : loc.getTimeStampList()) {
				if (timeStamp < time) {
					timeStamp = time;
				}
			}
		}
		return timeStamp;	
	}
	
	public static double getAvgTimeSplit(Employee customer) {
		List<Long> timeList = getTimeList(customer);
		int size = timeList.size();
		if (size < 2) {
			return Double.MAX_VALUE;
		}
		
		Collections.sort(timeList);
		long sumSplit = 0;
		for (int i = 0; i < timeList.size() - 1; i++) {
			sumSplit += timeList.get(i + 1) - timeList.get(i);
		}
		
		double avgTimeSplit = (1.0 * sumSplit) / (size - 1);
		return avgTimeSplit;
	}
	
	public static void main(String[] args) {
		Location.Builder lcb0 = Location.newBuilder();
	
		lcb0.addTimeStamp(1419325854302L);
		//lcb0.addTimeStamp(1419325865309L);
		
		Location.Builder lcb1 = Location.newBuilder();
		lcb1.addTimeStamp(1419326873577L);
		//lcb1.addTimeStamp(1419326885457L);
		//lcb1.addTimeStamp(1419326897460L);

		
		Employee.Builder cb = Employee.newBuilder();
		cb.addLocation(lcb0.build());
		cb.addLocation(lcb1.build());
		
//		System.out.println(getTimeDwell(cb.build(), 18000000) / Common.MINUTE_FORMATER);
		
		System.out.println(getMaxTimeStamp(cb.build()));

	}

}
