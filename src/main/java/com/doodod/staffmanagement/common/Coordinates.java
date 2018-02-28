/**
 * @author yupeng.cao@palmaplus.com
 */
package com.doodod.staffmanagement.common;

public class Coordinates {
	//private double x;
	//private double y;
	Point point;
	private long z;
	
	public Coordinates(double x, double y, long z) {
		this.point = new Point(x, y);
		this.z = z;
	}
	
	public double getX() {
		return this.point.x();
	}
	
	public double getY() {
		return this.point.y();
	}
	
	public long getZ() {
		return this.z;
	}
	
	//hashmap 使用重载的 equals, 参数不能变
	public boolean equals(Object co) {
		return equals((Coordinates) co);
	}
	
	public boolean equals(Coordinates co) {
		if (co.getX() == this.point.x()
				&& co.getY() == this.point.y()
				&& co.getZ() == this.z ) {
			return true;
		}			
		return false;
	}
	
	public void set(Coordinates co) {
		this.point = new Point(co.getX(), co.getY());
		this.z = co.getZ();
	}
	
	public Point getPoint() {
		return this.point;
	}
	
	public int hashCode() {
		int hashX = (new Double(point.x())).hashCode();
		int hashY = (new Double(point.y())).hashCode();
		int hashZ = (new Long(this.z)).hashCode();
		
		int hash = hashX * 1 + hashY * 2 + hashZ * 3;
		return hash;
	}
}
