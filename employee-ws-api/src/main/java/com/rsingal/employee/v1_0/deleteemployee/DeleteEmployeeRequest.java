package com.rsingal.employee.v1_0.deleteemployee;

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

@XmlRootElement(namespace = NSConstants.NS_EMPLOYEE_DELETE, name = "deleteEmployeeRequest")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(namespace = NSConstants.NS_EMPLOYEE_DELETE, name = "", propOrder = { "employeeId" })
@JsonPropertyOrder({ "employeeId" })
public class DeleteEmployeeRequest implements Serializable {

	private static final long serialVersionUID = -7416181637154411948L;
	/**
	 * Id of the employee.
	 */
	@NotNull
	@Range(min = 1, max = Integer.MAX_VALUE)
	@XmlElement(name = "employeeId", type = Integer.class, required = true)
	private Integer employeeId;

	public DeleteEmployeeRequest() {
		super();
	}

	public DeleteEmployeeRequest(Integer id) {
		super();
		this.employeeId = id;
	}

	public Integer getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Integer id) {
		this.employeeId = id;
	}

	@Override
	@JsonIgnore
	public String toString() {
		return "DeleteEmployeeRequest [employeeId=" + employeeId + "]";
	}
}
