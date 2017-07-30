package com.rsingal.employee.exception;

import org.springframework.http.HttpStatus;

/**
 * Employee Exception, it is thrown if there is any error regarding any employee operation.
 * 
 * @author rsingal
 */
public class EmployeeException extends Exception {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	/** The Constant DEFAULT_ERROR_MSG. */
	private static final String DEFAULT_ERROR_MSG = "Internal Server Error";
	/** The http status. */
	private final HttpStatus httpStatus;

	/**
	 * Instantiates a new employee exception.
	 */
	public EmployeeException() {
		super(DEFAULT_ERROR_MSG);
		this.httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
	}

	/**
	 * Instantiates a new employee exception.
	 *
	 * @param httpStatus the http status
	 */
	public EmployeeException(HttpStatus httpStatus) {
		super(DEFAULT_ERROR_MSG);
		this.httpStatus = httpStatus;
	}

	/**
	 * Instantiates a new employee exception.
	 *
	 * @param errorMessage the error message
	 * @param httpStatus the http status
	 */
	public EmployeeException(String errorMessage, HttpStatus httpStatus) {
		super(errorMessage);
		this.httpStatus = httpStatus;
	}

	/**
	 * Gets the http status.
	 *
	 * @return the http status
	 */
	public HttpStatus getHttpStatus() {
		return httpStatus;
	}
}
