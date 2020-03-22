package com.local.springjdbc.exception;

public class NoAffectedRowsException extends DaoException {

	public NoAffectedRowsException() {
		super();
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
