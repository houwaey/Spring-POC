package com.local.springjdbc.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@RestController
public class ExceptionResponseHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler({ Error.class })
	public final ResponseEntity<Object> handleAllError(Error error, WebRequest request) {
		return new ResponseEntity<Object>(
					new ThrowableObject(
							HttpStatus.SERVICE_UNAVAILABLE
							, error.getMessage()
							, error.getClass().getName()
							, request.getDescription(true))
					, HttpStatus.SERVICE_UNAVAILABLE
				);
	}
	
	@ExceptionHandler({ InternalServerException.class, Exception.class })
	public final ResponseEntity<Object> handleAllException(Exception exception, WebRequest request) {
		return new ResponseEntity<Object>(
					new ThrowableObject(
							HttpStatus.INTERNAL_SERVER_ERROR
							, exception.getMessage()
							, exception.getClass().getName()
							, request.getDescription(true))
					, HttpStatus.INTERNAL_SERVER_ERROR
				);
	}
	
	@ExceptionHandler({ DaoException.class })
	public final ResponseEntity<Object> handleDaoException(DaoException exception, WebRequest request) {
		return new ResponseEntity<Object>(
					new ThrowableObject(
							HttpStatus.BAD_REQUEST
							, exception.getMessage()
							, exception.getClass().getName()
							, request.getDescription(true))
					, HttpStatus.NOT_FOUND
				);
	}
	
}
