package com.doodod.staffmanagement.common;

import java.util.Comparator;

public class ComparatorPointX implements Comparator<Point> {
	public int compare(Point o1, Point o2) {
		if (o1.x() > o2.x()) {
			return 1;
		}
		else if (o1.x() < o2.x()) {
			return -1;
		}
		else {
			return 0;
		}
	}
}
