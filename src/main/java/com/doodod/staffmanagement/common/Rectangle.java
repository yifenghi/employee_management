package com.doodod.staffmanagement.common;

public class Rectangle {
	private double minX;
	private double maxX;
	private double minY;
	private double maxY;
	
	public Rectangle(double minx, double maxx,
			double miny, double maxy) {
		this.minX = minx;
		this.maxX = maxx;
		this.minY = miny;
		this.maxY = maxy;
	}
	
	public double minX() { return minX;}
	public double minY() { return minY;}
	public double maxX() { return maxX;}
	public double maxY() { return maxY;}
	
	public double getDistance(Point point) {
		if (minX <= point.x() && point.x() <= maxX) {
			if (minY <= point.y() && point.y() <= maxY) {
				return 0;
			}
			else {
				if (minY > point.y()) {
					return minY - point.y();
				}
				else {
					return point.y() - maxY;
				}
			}
		}
		else {
			if (minY <= point.y() && point.y() <= maxY) {
				if (minX > point.x()) {
					return minX - point.x();
				}
				else {
					return point.x() - maxX;
				}
			}
			else {
				if (point.x() > maxX && point.y() > maxY) {
					return Math.sqrt(
							Math.pow(point.x() - maxX, 2) + Math.pow(point.y() - maxY, 2));
				}
				else if (point.x() > maxX && point.y() < minY) {
					return Math.sqrt(
							Math.pow(point.x() - maxX, 2) + Math.pow(minY - point.y(), 2));
				}
				else if (point.x() < minX && point.y() < minY) {
					return Math.sqrt(
							Math.pow(minX - point.x(), 2) + Math.pow(minY - point.y(), 2));
				}
				else {
					return Math.sqrt(
							Math.pow(minX - point.x(), 2) + Math.pow(point.y() - maxX, 2));
				}
			}

		}

	}

	
}
