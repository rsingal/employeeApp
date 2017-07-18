package com.rsingal.employee.v1_0.createemployee;

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

@XmlRootElement(namespace = NSConstants.NS_EMPLOYEE_CREATE, name = "createEmployeeRequest")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(namespace = NSConstants.NS_EMPLOYEE_CREATE, name = "", propOrder = { "name", "age" })
@JsonPropertyOrder({ "name", "age" })
public class CreateEmployeeRequest implements Serializable {

	private static final long serialVersionUID = -596888880535706942L;
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

	public CreateEmployeeRequest() {
		super();
	}

	public CreateEmployeeRequest(String name, Integer age) {
		super();
		this.name = name;
		this.age = age;
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
		return "CreateEmployeeRequest [name=" + name + ", age=" + age + "]";
	}
}
