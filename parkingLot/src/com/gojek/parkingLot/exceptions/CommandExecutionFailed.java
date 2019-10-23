package com.gojek.parkingLot.exceptions;

public class CommandExecutionFailed extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2760419586469365911L;

	public CommandExecutionFailed(String message) {
		super(message);
	}

	public CommandExecutionFailed() {
		super();
	}

	public CommandExecutionFailed(String mess, Throwable cause) {
		super(mess, cause);
	}

}
