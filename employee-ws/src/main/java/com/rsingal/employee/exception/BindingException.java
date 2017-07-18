package com.rsingal.employee.exception;

import org.springframework.validation.BindingResult;

public class BindingException extends Exception {

	private static final long serialVersionUID = 1L;
	private static final String DEFAULT_ERROR_MSG = "Binding Error";
	private BindingResult bindingResult;

	public BindingException() {
		super(DEFAULT_ERROR_MSG);
	}

	public BindingException(BindingResult bindingResult) {
		super(DEFAULT_ERROR_MSG);
		this.bindingResult = bindingResult;
	}

	public BindingResult getBindingResult() {
		return bindingResult;
	}

	public void setBindingResult(BindingResult bindingResult) {
		this.bindingResult = bindingResult;
	}
}
