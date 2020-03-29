package com.local.springjdbc.exception;

import org.springframework.http.HttpStatus;

import com.local.springjdbc.util.Message;

public class NoRecordFoundException extends NotFoundException {

	public NoRecordFoundException() {
		super(Message.NO_RECORD_FOUND.value());
	}

	public NoRecordFoundException(HttpStatus httpStatus, Message message, String developerMessage) {
		super(httpStatus, message, developerMessage);
	}

	public NoRecordFoundException(HttpStatus httpStatus, Message message) {
		super(httpStatus, message);
	}

	public NoRecordFoundException(Message message, String developerMessage) {
		super(message, developerMessage);
	}

	public NoRecordFoundException(Message message) {
		super(message);
	}

	public NoRecordFoundException(String message, Throwable cause) {
		super(message, cause);
	}

	public NoRecordFoundException(String message) {
		super(message);
	}

	public NoRecordFoundException(Throwable cause) {
		super(Message.NO_RECORD_FOUND.value(), cause);
	}

}