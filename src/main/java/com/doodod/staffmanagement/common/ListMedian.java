package com.doodod.staffmanagement.common;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ListMedian {
	private ComparatorPointX cmpX;
	private ComparatorPointY cmpY;
	private List<Point> midianList;
	private boolean checkX;
	
	public ListMedian() {
		this.checkX = true;
		this.cmpX = new ComparatorPointX();
		this.cmpY = new ComparatorPointY();
		this.midianList = new ArrayList<Point>();
	}
	
	public void getMedian(List<Point> numList) {
		if (numList.size() == 0) {
			return;
		}
		sortList(numList);
		this.checkX = !this.checkX;

		if (numList.size() == 1) {
			this.midianList.add(numList.get(0));
			return;
		}
		int size = numList.size() / 2;
		this.midianList.add(numList.get(size));
		
		List<Point> left = new ArrayList<Point>();
		List<Point> right = new ArrayList<Point>();

		for (int i = 0; i < size; i++) {
			left.add(numList.get(i));
		}
		getMedian(left);
		
		for (int i = size + 1; i < numList.size(); i++) {
			right.add(numList.get(i));
		}
		getMedian(right);
		
	}
	
	private void sortList(List<Point> list) {
		if (this.checkX) {
			Collections.sort(list, cmpX);
		}
		else {
			Collections.sort(list, cmpY);
		}		
	}
	
	public List<Point> getMidianList() {
		return this.midianList;
	}
	
	public List<Point> getMidianList(List<Point> originList) {
		getMedian(originList);
		return this.midianList;
	}
	
}
