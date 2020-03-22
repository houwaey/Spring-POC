package com.local.springjdbc.exception;

public class NoRecordFoundException extends NotFoundException {

	public NoRecordFoundException() {
		super();
	}

	public NoRecordFoundException(String message, Throwable cause) {
		super(message, cause);
	}

	public NoRecordFoundException(String message) {
		super(message);
	}

	public NoRecordFoundException(Throwable cause) {
		super(cause);
	}
	
}