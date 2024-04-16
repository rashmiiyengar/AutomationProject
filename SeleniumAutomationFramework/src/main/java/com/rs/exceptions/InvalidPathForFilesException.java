package com.rs.exceptions;


/**
 * Runtime Exception occurs when the path given for any of the files is incorrect
 * 
	Apr 15, 2024
	@author rashmisoundar
	@see com.rs.exceptions.InvalidPathExcepException
	@see com.rs.exceptions.InvalidPathForPropertyFileException
 */
@SuppressWarnings("serial")
public class InvalidPathForFilesException extends FramworkException{

	/**
	 * Pass the message that needs to be appended to the stacktrace
	 * @param message Details about the exception or custom message
	 */
	public InvalidPathForFilesException(String message) {
		super(message);
	}
	/**
	 * 
	 * @param message Details about the exception or custom message
	 * @param cause Pass the enriched stacktrace or customised stacktrace
	 */
	public InvalidPathForFilesException(String message,Throwable cause) {
		super(message,cause);
	}
}
