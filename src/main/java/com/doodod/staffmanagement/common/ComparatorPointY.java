package com.doodod.staffmanagement.common;

import java.util.Comparator;

public class ComparatorPointY implements Comparator<Point>{
	public int compare(Point o1, Point o2) {
		if (o1.y() > o2.y()) {
			return 1;
		}
		else if (o1.y() < o2.y()) {
			return -1;
		}
		else {
			return 0;
		}
	}
}
