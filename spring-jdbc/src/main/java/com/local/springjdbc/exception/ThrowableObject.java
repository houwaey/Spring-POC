package com.local.springjdbc.exception;

import org.springframework.http.HttpStatus;

import lombok.Getter;

@Getter
public class ThrowableObject {

	private int code;
	private String message;
	private String developerMessage;
	private String uri;
	private String exception;
	
	public ThrowableObject(Throwable throwable, HttpStatus status, String message, String developerMessage, String uri) {
		this.exception = throwable.getClass().getName();
		this.code = status.value();
		this.message = message == null ? "System is busy." : message;
		this.developerMessage = developerMessage;
		this.uri = uri;
	}
	
}
