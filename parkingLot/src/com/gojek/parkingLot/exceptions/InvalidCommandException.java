package com.gojek.parkingLot.exceptions;

public class InvalidCommandException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1473824445518851337L;

	public InvalidCommandException(String message) {
		super(message);
	}
	
	public InvalidCommandException() {
		super();
	}
	
	public InvalidCommandException(String mess , Throwable cause) {
		super(mess, cause);
	}
}
