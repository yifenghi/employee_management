package com.doodod.staffmanagement.common;

public class EmployeeInfo {
	private String phoneMac;
	private long date;
	private long startTime;
	private long endTime;
	private long workTime;
	private long overTime;
	private int incorrect;
	public EmployeeInfo() {
		super();
		
	}
	public String getPhoneMac() {
		return phoneMac;
	}
	public void setPhoneMac(String phoneMac) {
		this.phoneMac = phoneMac;
	}
	public long getDate() {
		return date;
	}
	public void setDate(long date) {
		this.date = date;
	}
	public long getStartTime() {
		return startTime;
	}
	public void setStartTime(long startTime) {
		this.startTime = startTime;
	}
	public long getEndTime() {
		return endTime;
	}
	public void setEndTime(long endTime) {
		this.endTime = endTime;
	}
	public long getWorkTime() {
		return workTime;
	}
	public void setWorkTime(long workTime) {
		this.workTime = workTime;
	}
	public long getOverTime() {
		return overTime;
	}
	public void setOverTime(long overTime) {
		this.overTime = overTime;
	}
	public int getIncorrect() {
		return incorrect;
	}
	public void setIncorrect(int incorrect) {
		this.incorrect = incorrect;
	}
	
	
}
