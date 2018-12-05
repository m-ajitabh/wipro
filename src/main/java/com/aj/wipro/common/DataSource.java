package com.aj.wipro.common;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class DataSource {
	
public static List<String> productName = new ArrayList<String>();
	
	public static final Map<String,String> testData = new HashMap<String, String>();
	
	public static void saveToTestData(String key,String value){
		testData.put(key, value);
	}
	
	public static String getFromTestData(String key){
		return testData.get(key).toString();
	}
	
	public static void saveToProductList(String value){
		productName.add(value);
	}
	
	public static String getFromProductList(int pos){
		Set<String> set = new HashSet<String>(productName);
		productName = new ArrayList<String>(set);
		return productName.get(pos).toString();
	}

}
