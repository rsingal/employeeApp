package com.rsingal.employee.v1_0.getemployee;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.rsingal.employee.v1_0.constants.NSConstants;

@XmlRootElement(namespace = NSConstants.NS_EMPLOYEE_GET, name = "employees")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(namespace = NSConstants.NS_EMPLOYEE_GET, name = "", propOrder = { "employees" })
public class EmployeeList implements Serializable {

	private static final long serialVersionUID = 129274750633987462L;
	/**
	 * List of employee's.
	 */
	@XmlElement(name = "employee", type = Employee.class, required = false)
	private List<Employee> employees = new ArrayList<Employee>();

	public EmployeeList() {
		super();
	}

	public EmployeeList(List<Employee> employee) {
		super();
		this.employees = employee;
	}

	public List<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}

	@Override
	@JsonIgnore
	public String toString() {
		return "EmployeeList [employees=" + employees + "]";
	}
}
