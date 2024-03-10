package com.rs.utils;

public final class DynamicXpathUtils {

	private DynamicXpathUtils() {

	}

	/**
	 * Receives a wildcard string, replace the wildcard with the value and return to the caller
	 * @param xpath Xpath with wildcard string
	 * @param value value to be replaced in place of wildcard
	 * @return dynamic xpath string
	 * 
	 */
	public static String getDynamicXpath(String xpath, String value) {
	    return xpath.replace("%replaceable%", value);
	}
}
