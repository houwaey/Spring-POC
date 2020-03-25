package com.local.springjdbc.exception;

import org.springframework.http.HttpStatus;

import com.local.springjdbc.util.Message;

public class NoAffectedRowsException extends DaoException {

	public NoAffectedRowsException() {
		super();
	}

	public NoAffectedRowsException(HttpStatus httpStatus, Message message, String developerMessage) {
		super(httpStatus, message, developerMessage);
	}

	public NoAffectedRowsException(HttpStatus httpStatus, Message message) {
		super(httpStatus, message);
	}

	public NoAffectedRowsException(Message message, String developerMessage) {
		super(message, developerMessage);
	}

	public NoAffectedRowsException(Message message) {
		super(message);
	}

	public NoAffectedRowsException(String message, Throwable cause) {
		super(message, cause);
	}

	public NoAffectedRowsException(String message) {
		super(message);
	}

	public NoAffectedRowsException(Throwable cause) {
		super(cause);
	}
	
	
	
}
