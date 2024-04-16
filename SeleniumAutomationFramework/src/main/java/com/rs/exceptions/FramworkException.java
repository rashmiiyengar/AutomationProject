package com.rs.exceptions;


/**
 * BaseException for the framework.Extends Runtime Exception and can be thrown anywhere to terminate a program
 * 
 * 
	Apr 15, 2024
	@author rashmisoundar
 */
@SuppressWarnings("serial")
public class FramworkException extends RuntimeException {

	public FramworkException(String message) {

		super(message);

	}

	public FramworkException(String message, Throwable cause) {

		super(message,cause);

	}

}
