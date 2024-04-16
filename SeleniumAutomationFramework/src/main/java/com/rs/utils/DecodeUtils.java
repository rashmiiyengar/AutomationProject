package com.rs.utils;

import java.util.Base64;


/**
 * Helps to decode the base64 encoded string.
 * 
	Apr 15, 2024
	@author rashmisoundar
 */
public final class DecodeUtils {
	/**
	 * Private constructor to avoid external instantiation
	 */
	private DecodeUtils() {
		
	}
	
	/**
	 * Accepts the base64 string and decode and return to caller
	 * @author rashmisoundar
	 * @param encodedString Base64 encoded String
	 * @return String Decoded base64 String.
	 */
	public static String getDecodedString(String encodedString) {
		
		
		return new String(Base64.getDecoder().decode(encodedString.getBytes()));
	}
	
	
}
