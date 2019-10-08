package com.gojek.parkingLot.exceptions;

public class commandExecutionFailed extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2760419586469365911L;

	public commandExecutionFailed(String message) {
		super(message);
	}

	public commandExecutionFailed() {
		super();
	}

	public commandExecutionFailed(String mess, Throwable cause) {
		super(mess, cause);
	}

}
