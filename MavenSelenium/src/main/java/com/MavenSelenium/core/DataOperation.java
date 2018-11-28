package com.MavenSelenium.core;

public class DataOperation {
	public static String[] splitData(String sValueList, String sDelimiter) {
		sValueList = sValueList.trim();
		String data[] = sValueList.split(sDelimiter);
		return data;
	}

}
