package com.local.springjdbc.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.local.springjdbc.util.Message;

@ControllerAdvice
@RestController
public class ExceptionResponseHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler({ Error.class })
	public final ResponseEntity<Object> handleAllError(Throwable error, WebRequest request) {
		return new ResponseEntity<Object>(
					new ThrowableObject(
							error
							, HttpStatus.SERVICE_UNAVAILABLE
							, Message.SERVICE_UNAVAILABLE.value()
							, error.getMessage()
							, request.getDescription(true))
					, HttpStatus.SERVICE_UNAVAILABLE
				);
	}
	
	@ExceptionHandler({ InternalServerException.class, Exception.class })
	public final ResponseEntity<Object> handleAllException(Exception exception, WebRequest request) {
		return new ResponseEntity<Object>(
					new ThrowableObject(
							exception
							, HttpStatus.INTERNAL_SERVER_ERROR
							, Message.INTERNAL_SERVER_ERROR.value()
							, exception.getMessage()
							, request.getDescription(true))
					, HttpStatus.INTERNAL_SERVER_ERROR
				);
	}
	
	@ExceptionHandler({ NoAffectedRowsException.class, DaoException.class })
	public final ResponseEntity<Object> handleDaoException(DaoException exception, WebRequest request) {
		return new ResponseEntity<Object>(
					new ThrowableObject(
							exception
							, HttpStatus.BAD_REQUEST
							, exception.getMessage()
							, exception.getDeveloperMessage()
							, request.getDescription(true))
					, HttpStatus.BAD_REQUEST
				);
	}
	
	@ExceptionHandler({ NoRecordFoundException.class, NotFoundException.class, RootException.class })
	public final ResponseEntity<Object> handleRootException(RootException exception, WebRequest request) {
		return new ResponseEntity<Object>(
					new ThrowableObject(
							exception
							, exception.getHttpStatus()
							, exception.getMessage()
							, exception.getDeveloperMessage()
							, request.getDescription(true))
					, exception.getHttpStatus()
				);
	}
	
}
