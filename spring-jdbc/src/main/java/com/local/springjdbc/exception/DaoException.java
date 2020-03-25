package com.local.springjdbc.exception;

import org.springframework.http.HttpStatus;

import com.local.springjdbc.util.Message;

public class DaoException extends RootException {

	public DaoException() {
		super();
	}

	public DaoException(HttpStatus httpStatus, Message message, String developerMessage) {
		super(httpStatus, message, developerMessage);
	}

	public DaoException(HttpStatus httpStatus, Message message) {
		super(httpStatus, message);
	}

	public DaoException(Message message, String developerMessage) {
		super(message, developerMessage);
	}

	public DaoException(Message message) {
		super(message);
	}

	public DaoException(String message, Throwable cause) {
		super(message, cause);
	}

	public DaoException(String message) {
		super(message);
	}

	public DaoException(Throwable cause) {
		super(cause);
	}
	
}
