package com.rsingal.employee.exception;

import org.springframework.http.HttpStatus;

public class EmployeeException extends Exception {

	private static final long serialVersionUID = 1L;
	private static final String DEFAULT_ERROR_MSG = "Internal Server Error";
	private HttpStatus httpStatus;

	public EmployeeException() {
		super(DEFAULT_ERROR_MSG);
		this.httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
	}

	public EmployeeException(HttpStatus httpStatus) {
		super(DEFAULT_ERROR_MSG);
		this.httpStatus = httpStatus;
	}

	public EmployeeException(String errorMessage, HttpStatus httpStatus) {
		super(errorMessage);
		this.httpStatus = httpStatus;
	}

	public HttpStatus getHttpStatus() {
		return httpStatus;
	}

	public void setHttpStatus(HttpStatus httpStatus) {
		this.httpStatus = httpStatus;
	}
}
