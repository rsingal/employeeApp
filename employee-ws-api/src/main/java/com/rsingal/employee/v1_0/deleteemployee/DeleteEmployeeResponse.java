package com.rsingal.employee.v1_0.deleteemployee;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.rsingal.employee.v1_0.constants.NSConstants;

@XmlRootElement(namespace = NSConstants.NS_EMPLOYEE_DELETE, name = "deleteEmployeeResponse")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(namespace = NSConstants.NS_EMPLOYEE_DELETE, name = "", propOrder = {})
@JsonPropertyOrder({})
public class DeleteEmployeeResponse implements Serializable {

	private static final long serialVersionUID = 2366060248472787744L;

	public DeleteEmployeeResponse() {
		super();
	}
}
