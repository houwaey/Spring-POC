package com.local.springjdbc.exception;

import org.springframework.http.HttpStatus;

import com.local.springjdbc.util.Message;

public class InternalServerException extends RootException {

	public InternalServerException() {
		super(Message.INTERNAL_SERVER_ERROR.value());
	}

	public InternalServerException(HttpStatus httpStatus, Message message, String developerMessage) {
		super(httpStatus, message, developerMessage);
	}

	public InternalServerException(HttpStatus httpStatus, Message message) {
		super(httpStatus, message);
	}

	public InternalServerException(Message message, String developerMessage) {
		super(message, developerMessage);
	}

	public InternalServerException(Message message) {
		super(message);
	}

	public InternalServerException(String message, Throwable cause) {
		super(message, cause);
	}

	public InternalServerException(String message) {
		super(message);
	}

	public InternalServerException(Throwable cause) {
		super(Message.INTERNAL_SERVER_ERROR.value(), cause);
	}

}
