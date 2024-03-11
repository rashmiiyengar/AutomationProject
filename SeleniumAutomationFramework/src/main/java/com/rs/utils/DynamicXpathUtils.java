package com.rs.utils;

public final class DynamicXpathUtils {

	private DynamicXpathUtils() {

	}

	
	public static String getDynamicXpath(String xpath, String value) {
	    return String.format(xpath, value);//a[text()='%s'] 
	}
}
