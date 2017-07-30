package com.rsingal.employee.exception;

import org.springframework.validation.BindingResult;

/**
 * Binding Exception, it is thrown if XML/JSON request has binding errors.
 * 
 * @author rsingal
 */
public class BindingException extends Exception {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	/** The Constant DEFAULT_ERROR_MSG. */
	private static final String DEFAULT_ERROR_MSG = "Binding Error";
	/** The binding result. */
	private final transient BindingResult bindingResult;

	/**
	 * Instantiates a new binding exception.
	 */
	public BindingException() {
		super(DEFAULT_ERROR_MSG);
		bindingResult = null;
	}

	/**
	 * Instantiates a new binding exception.
	 *
	 * @param bindingResult the binding result
	 */
	public BindingException(BindingResult bindingResult) {
		super(DEFAULT_ERROR_MSG);
		this.bindingResult = bindingResult;
	}

	/**
	 * Gets the binding result.
	 *
	 * @return the binding result
	 */
	public BindingResult getBindingResult() {
		return bindingResult;
	}
}
