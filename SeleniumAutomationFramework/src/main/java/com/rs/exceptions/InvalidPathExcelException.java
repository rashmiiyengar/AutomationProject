package com.rs.exceptions;

/**
 * RuntimeException occurs when the path given for excel sheet is incorrect
	Apr 15, 2024
 */
@SuppressWarnings("serial")
public class InvalidPathExcelException extends InvalidPathForFilesException{

	/**
	 * Pass the message taht needs to be appended to the stacktrace
	 * @param message Details about the exception or custom message
	 */
	public InvalidPathExcelException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	/**
	 * 
	 * @param message Details about the exception or custom message
	 * @param cause Pass the enriched stacktrace or customised stacktrace
	 */
	public InvalidPathExcelException(String message,Throwable cause) {
		super(message,cause);
		// TODO Auto-generated constructor stub
	}
}
