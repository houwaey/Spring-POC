package com.local.springjdbc.util;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum Message {
	  EMPTY("")
	, NOT_FOUND("Not found")
	, NO_RECORD_FOUND("No record(s) found")
	, NO_AFFECTED_ROWS("No affected row(s)")
	, SERVICE_UNAVAILABLE("Service unavailable")
	, INTERNAL_SERVER_ERROR("Internal server error")
	, DAO_EXCEPTION("Failed to process data")
	
	, STUDENT_NOT_FOUND("Student not found")
	, STUDENTS_NOT_FOUND("No student's record(s) found")
	;
	
	private String value;
	
	public String value() {
		return this.value;
	}
	
}
