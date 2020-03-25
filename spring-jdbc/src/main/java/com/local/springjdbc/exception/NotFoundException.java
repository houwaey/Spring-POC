package com.local.springjdbc.exception;

import org.springframework.http.HttpStatus;

import com.local.springjdbc.util.Message;

public class NotFoundException extends DaoException {

	public NotFoundException() {
		super();
	}

	public NotFoundException(HttpStatus httpStatus, Message message, String developerMessage) {
		super(httpStatus, message, developerMessage);
	}

	public NotFoundException(HttpStatus httpStatus, Message message) {
		super(httpStatus, message);
	}

	public NotFoundException(Message message, String developerMessage) {
		super(message, developerMessage);
	}

	public NotFoundException(Message message) {
		super(message);
	}

	public NotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

	public NotFoundException(String message) {
		super(message);
	}

	public NotFoundException(Throwable cause) {
		super(cause);
	}

}
