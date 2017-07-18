package com.rsingal.employee.common;

import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.rsingal.employee.v1_0.constants.NSConstants;

@XmlRootElement(namespace = NSConstants.NS_EMPLOYEE_COMMON, name = "errorResponse")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(namespace = NSConstants.NS_EMPLOYEE_COMMON, name = "", propOrder = { "errorCode", "errorMessage", "errorDetails" })
@JsonPropertyOrder({ "errorCode", "errorMessage", "errorDetails" })
public class ErrorResponse {

	/**
	 * HTTP status code.
	 */
	@NotNull(message = "can not be null")
	@XmlElement(name = "errorCode", type = Integer.class, required = true)
	private Integer errorCode;
	/**
	 * Error message.
	 */
	@XmlElement(name = "errorMessage", type = String.class, required = false)
	private String errorMessage;
	/**
	 * Details of the error.
	 */
	@XmlElementWrapper(name = "errorDetails")
	@XmlElement(name = "errorDetail", type = String.class, required = false)
	private List<String> errorDetails = new ArrayList<String>();

	public ErrorResponse() {
		super();
	}

	public ErrorResponse(Integer errorCode, String errorMessage) {
		super();
		this.errorCode = errorCode;
		this.errorMessage = errorMessage;
	}

	public Integer getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(Integer errorCode) {
		this.errorCode = errorCode;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String message) {
		this.errorMessage = message;
	}

	public List<String> getErrorDetails() {
		return errorDetails;
	}

	public void setErrorDetails(List<String> errorDetails) {
		this.errorDetails = errorDetails;
	}
}
