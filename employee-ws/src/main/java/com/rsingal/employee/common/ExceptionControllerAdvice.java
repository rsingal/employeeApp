package com.rsingal.employee.common;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.rsingal.employee.exception.BindingException;

@ControllerAdvice
public class ExceptionControllerAdvice {

	@ExceptionHandler(BindingException.class)
	public ResponseEntity<ErrorResponse> bindingExceptionHandler(BindingException ex) {
		BindingResult bindingResult = ex.getBindingResult();
		List<FieldError> fieldErrors = bindingResult.getFieldErrors();
		List<String> errorDetails = new ArrayList<>();
		fieldErrors.forEach(fieldError -> errorDetails.add(fieldError.getField() + " - " + fieldError.getDefaultMessage()));
		ErrorResponse errorResp = new ErrorResponse();
		errorResp.setErrorCode(HttpStatus.BAD_REQUEST.value());
		errorResp.setErrorMessage(ex.getMessage());
		errorResp.setErrorDetails(errorDetails);
		return new ResponseEntity<ErrorResponse>(errorResp, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorResponse> exceptionHandler(Exception ex) {
		ErrorResponse errorResp = new ErrorResponse();
		errorResp.setErrorCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
		errorResp.setErrorMessage(ex.getMessage());
		return new ResponseEntity<ErrorResponse>(errorResp, HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
