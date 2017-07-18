package com.rsingal.employee.v1_0.createemployee;

import java.io.Serializable;

import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import org.hibernate.validator.constraints.Range;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.rsingal.employee.v1_0.constants.NSConstants;

@XmlRootElement(namespace = NSConstants.NS_EMPLOYEE_CREATE, name = "createEmployeeResponse")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(namespace = NSConstants.NS_EMPLOYEE_CREATE, name = "", propOrder = { "employeeId" })
@JsonPropertyOrder({ "employeeId" })
public class CreateEmployeeResponse implements Serializable {

	private static final long serialVersionUID = -3810618244827186583L;
	/**
	 * Id of the employee.
	 */
	@NotNull
	@Range(min = 1, max = Integer.MAX_VALUE)
	@XmlElement(name = "employeeId", type = Integer.class, required = true)
	private Integer employeeId;

	public CreateEmployeeResponse() {
		super();
	}

	public CreateEmployeeResponse(Integer employeeId) {
		super();
		this.employeeId = employeeId;
	}

	public Integer getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
	}

	@Override
	@JsonIgnore
	public String toString() {
		return "CreateEmployeeResponse [employeeId=" + employeeId + "]";
	}
}
