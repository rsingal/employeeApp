package com.rsingal.employee.v1_0.updateemployee;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.rsingal.employee.v1_0.constants.NSConstants;

@XmlRootElement(namespace = NSConstants.NS_EMPLOYEE_UPDATE, name = "updateEmployeeResponse")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(namespace = NSConstants.NS_EMPLOYEE_UPDATE, name = "", propOrder = {})
@JsonPropertyOrder({})
public class UpdateEmployeeResponse implements Serializable {

	private static final long serialVersionUID = -2347244843773544879L;

	public UpdateEmployeeResponse() {
		super();
	}
}
