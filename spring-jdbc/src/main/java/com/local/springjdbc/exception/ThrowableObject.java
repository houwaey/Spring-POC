package com.local.springjdbc.exception;

import org.springframework.http.HttpStatus;

import lombok.Getter;

@Getter
public class ThrowableObject {

	private int code;
	private String message;
	private String developerMessage;
	private String uri;
	
	public ThrowableObject(HttpStatus status, String message, String developerMessage, String uri) {
		this.code = status.value();
		this.message = message == null ? "System is busy." : message;
		this.developerMessage = developerMessage;
		this.uri = uri;
	}
	
}
