package com.local.springjdbc.exception;

import org.springframework.http.HttpStatus;

import com.local.springjdbc.util.Message;

import lombok.Getter;

@Getter
public class RootException extends RuntimeException {

	private String developerMessage;
	private HttpStatus httpStatus;

	public RootException() {
		super();
	}
	
	public RootException(Message message) {
		super(message.value());
		this.developerMessage = "";
	}
	
	public RootException(Message message, String developerMessage) {
		super(message.value());
		this.developerMessage = developerMessage;
	}
	
	public RootException(HttpStatus httpStatus, Message message) {
		super(message.value());
		this.httpStatus = httpStatus;
	}
	
	public RootException(HttpStatus httpStatus, Message message, String developerMessage) {
		super(message.value());
		this.developerMessage = developerMessage;
		this.httpStatus = httpStatus;
	}

	public RootException(String message, Throwable cause) {
		super(message, cause);
	}

	public RootException(String message) {
		super(message);
	}

	public RootException(Throwable cause) {
		super(cause);
	}
	
}
