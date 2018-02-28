/**
 * @author yupeng.cao@palmaplus.com
 */
package com.doodod.staffmanagement.common;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Polygon {
	List<Coordinates> coordinates;
	
	public Polygon(List<Coordinates> src) {
		coordinates = new ArrayList<Coordinates>(src);
	}
	
	public boolean coordinateInPolygon(Coordinates coordinate) {
		boolean in = false;
		for (int i = 0; i < coordinates.size() - 1; i++ ) {
			int next = i + 1;
			Coordinates a = coordinates.get(i);
			Coordinates b = coordinates.get(next);
			
			if ((a.getY() < coordinate.getY() && b.getY() >= coordinate.getY()
					|| b.getY() < coordinate.getY() && a.getY() >= coordinate.getY())
					&& (a.getX() <= coordinate.getX() || b.getX() <= coordinate.getX())) {
				in ^= (a.getX() + ((coordinate.getY() - a.getY()) * (b.getX() - a.getX()) / (b.getY() - a.getY()))) 
						- coordinate.getX() < 1e-6;
			}
		}
		
		return in;
	}
	

	public static void main(String[] args) throws IOException {
//		String publicPath = "/Users/paul/Documents/code_dir/doodod/mall_info/public";
//		String storePath = "/Users/paul/Documents/code_dir/doodod/mall_info/shop";
//		String framePath = "/Users/paul/Documents/code_dir/doodod/mall_info/frame";
//
//		Map<Coordinates, String> publicMap = new HashMap<Coordinates, String>();
//
//		Charset charSet =  Charset.forName("UTF-8");
//
//		BufferedReader publicReader = new BufferedReader(new InputStreamReader(
//				new FileInputStream(publicPath), charSet));
//		String line = "";
//		while ((line = publicReader.readLine()) != null) {
//			String[] arrBrand = line.split(Common.CTRL_A, -1);
//			if (arrBrand.length != 4) {
//				continue;
//			}
//			int floor = Integer.parseInt(arrBrand[0]);
//			String shopInfo = arrBrand[1] + Common.CTRL_A + arrBrand[2];
//			
//			String coorArr[] = arrBrand[3].split(Common.CTRL_C, -1);
//			if (coorArr.length != 2) {
//				continue;
//			}
//			double x = Double.parseDouble(coorArr[0]);
//			double y = Double.parseDouble(coorArr[1]);
//			
//			Coordinates coordinate = new Coordinates(x, y, floor);
//			if (publicMap.containsKey(coordinate)) {
//			}
//			else {
//				publicMap.put(coordinate, shopInfo);
//			}
//		}
//		publicReader.close();
		
//		List<List<Coordinates>> shopList = new ArrayList<List<Coordinates>>();
//		BufferedReader storeReader = new BufferedReader(new InputStreamReader(
//				new FileInputStream(storePath), charSet));
//		line = "";
//		while ((line = storeReader.readLine()) != null) {
//			String[] arrBrand = line.split(Common.CTRL_A, -1);
//			if (arrBrand.length != 4) {
//				continue;
//			}
//			int floor = Integer.parseInt(arrBrand[0]);
//			String shopInfo = arrBrand[0] + Common.CTRL_A +
//					arrBrand[1] + Common.CTRL_A + arrBrand[2];
//			
//			String coorList[] = line.split(Common.CTRL_B, -1);
//			List<Coordinates> coordinatesList = new ArrayList<Coordinates>();
//			for (int i = 0; i < coorList.length; i++) {
//				String coorArr[] = line.split(Common.CTRL_C, -1);
//				if (coorArr.length != 2) {
//					continue;
//				}
//				double x = Double.parseDouble(coorArr[0]);
//				double y = Double.parseDouble(coorArr[1]);
//				
//				Coordinates coordinate = new Coordinates(x, y, floor);
//				coordinatesList.add(coordinate);
//			}
//			shopList.add(coordinatesList);
//		}
//		storeReader.close();
//		
//		List<List<Coordinates>> res = new ArrayList<List<Coordinates>>();
//		BufferedReader frameReader = new BufferedReader(new InputStreamReader(
//				new FileInputStream(framePath), charSet));
//		line = "";
//		while ((line = frameReader.readLine()) != null) {
//			String[] arrFrame = line.split(Common.CTRL_A, -1);
//			if (arrFrame.length != 4) {
//				continue;
//			}
//			int floor = Integer.parseInt(arrFrame[0]);
//			String shopInfo = arrFrame[0] + Common.CTRL_A + arrFrame[1];
//			
//			String coorList[] = arrFrame[3].split(Common.CTRL_B, -1);
//			List<Coordinates> coordinatesList = new ArrayList<Coordinates>();
//			for (int i = 0; i < coorList.length; i++) {
//				String coorArr[] = coorList[i].split(Common.CTRL_C, -1);
//				if (coorArr.length != 2) {
//					continue;
//				}
//				double x = Double.parseDouble(coorArr[0]);
//				double y = Double.parseDouble(coorArr[1]);
//				
//				Coordinates coordinate = new Coordinates(x, y, floor);
//				coordinatesList.add(coordinate);
//			}
//			res.add(coordinatesList);
//		}
//		frameReader.close();
//		
//		Polygon polygon0 = new Polygon(res.get(0));
//		Polygon polygon1 = new Polygon(res.get(1));
//		
//		for (List<Coordinates> list : shopList) {
//			for (Coordinates coordinates : list) {
//				if (!polygon0.coordinateInPolygon(coordinates)
//						) {
//					System.out.printf("%f + %f", coordinates.getX(), coordinates.getY());
//				}	
//			}
//		} 
//		System.out.println("end");

//		Iterator<Coordinates> iter = publicMap.keySet().iterator();
//		while (iter.hasNext()) {
//			Coordinates key = iter.next();
//			if (!polygon0.coordinateInPolygon(key)
//					) {
//				System.out.println(publicMap.get(key));
//				System.out.println("not in");
//			}	
//		}
//		
//		Coordinates key = new Coordinates(1.29586013229E7, 4838131.4177, 1667);
//		if (!polygon0.coordinateInPolygon(key)
//				) {
//			System.out.println(publicMap.get(key));
//			System.out.println("not in");
//		}
		
		List<Coordinates> res = new ArrayList<Coordinates>();
		Charset charSet =  Charset.forName("UTF-8");
		String framePath = "E:\\workspace\\employee_worktime\\data\\frame.new";
		BufferedReader frameReader = new BufferedReader(new InputStreamReader(
				new FileInputStream(framePath), charSet));
		String line = "";
		while ((line = frameReader.readLine()) != null) {
			String[] arrFrame = line.split(Common.CTRL_A, -1);
			if (arrFrame.length != 5) {
				continue;
			}
			int floor = Integer.parseInt(arrFrame[0]);
			String coorList[] = arrFrame[4].split(Common.CTRL_B, -1);
			
			for (int i = 0; i < coorList.length; i++) {
				String coorArr[] = coorList[i].split(Common.CTRL_C, -1);
				if (coorArr.length != 2) {
					continue;
				}
				double x = Double.parseDouble(coorArr[0]);
				double y = Double.parseDouble(coorArr[1]);
				System.out.println((x-12950780) + "," + (y-4862320));
				
				Coordinates coordinate = new Coordinates(x, y, floor);
				res.add(coordinate);
			}
			
		}
		frameReader.close();
		
        System.out.println(res.size());
        
		
		Polygon poly = new Polygon(res);
		String macPath = "E:\\workspace\\employee_worktime\\data\\gao";
		BufferedReader macReader = new BufferedReader(new InputStreamReader(
				new FileInputStream(macPath), charSet));
		line = "";
		int total = 0;
		int inPolygon = 0;
		while ((line = macReader.readLine()) != null) {
			String[] ary = line.split("\t", -1);
			double x = Double.parseDouble(ary[0]);
			double y = Double.parseDouble(ary[1]);
			total++;
			if(poly.coordinateInPolygon(new Coordinates(x, y, 1))){
				inPolygon++;
			}
		}
		macReader.close();
		
		System.out.println("total: "+total);
		System.out.println("inPolygon: "+inPolygon);
		System.out.println("proportion: "+inPolygon*1.0/total);
		
	}

}
