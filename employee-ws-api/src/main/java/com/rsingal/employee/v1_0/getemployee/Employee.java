package com.rsingal.employee.v1_0.getemployee;

import java.io.Serializable;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.Range;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.rsingal.employee.v1_0.constants.NSConstants;

@XmlRootElement(namespace = NSConstants.NS_EMPLOYEE_GET, name = "employee")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(namespace = NSConstants.NS_EMPLOYEE_GET, name = "", propOrder = { "employeeId", "name", "age" })
@JsonPropertyOrder({ "employeeId", "name", "age" })
public class Employee implements Serializable {

	private static final long serialVersionUID = 3472716268487390235L;
	/**
	 * Id of the employee.
	 */
	@NotNull
	@Range(min = 1, max = Integer.MAX_VALUE)
	@XmlElement(name = "employeeId", type = Integer.class, required = true)
	private Integer employeeId;
	/**
	 * Name of the employee.
	 */
	@NotBlank(message = "can not be null or blank")
	@Size(min = 1, max = 32)
	@XmlElement(name = "name", type = String.class, required = true)
	private String name;
	/**
	 * Age of the employee.
	 */
	@NotNull(message = "can not be null")
	@Range(min = 1, max = 100)
	@XmlElement(name = "age", type = Integer.class, required = true)
	private Integer age;

	public Employee() {
		super();
	}

	public Employee(Integer id, String name, Integer age) {
		super();
		this.employeeId = id;
		this.name = name;
		this.age = age;
	}

	public Integer getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Integer id) {
		this.employeeId = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	@Override
	@JsonIgnore
	public String toString() {
		return "Employee [employeeId=" + employeeId + ", name=" + name + ", age=" + age + "]";
	}
}
