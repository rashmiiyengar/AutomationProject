package com.rs.exceptions;

@SuppressWarnings("serial")
public class FramworkException extends RuntimeException {

	public FramworkException(String message) {

		super(message);

	}

	public FramworkException(String message, Throwable cause) {

		super(message,cause);

	}

}
