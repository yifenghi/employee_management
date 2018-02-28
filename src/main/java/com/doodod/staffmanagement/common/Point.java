package com.doodod.staffmanagement.common;

public class Point {
	private double x;
	private double y;
	
	public double x() {
		return x;
	}
	
	public double y() {
		return y;
	}
	
	public Point(double x, double y) {
		this.x = x;
		this.y = y;
	}
	
	public boolean equals(Object co) {
		return equals((Point) co);
	}
	
	public boolean equals(Point p) {
		if (this.x == p.x() 
				&& this.y == p.y()) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public int hashCode() {
		int hashX = (new Double(this.x)).hashCode();
		int hashY = (new Double(this.y)).hashCode();
		return hashX + 2 * hashY; 
	}
	
	public String toString() {
		return String.valueOf(x) + "_" + String.valueOf(y);
	}
	
	public double getDistance(Point point) {
		double distance = Math.pow(x - point.x(), 2) 
				+ Math.pow(y - point.y(), 2);
		distance = Math.sqrt(distance);
		return distance;
	}

}
