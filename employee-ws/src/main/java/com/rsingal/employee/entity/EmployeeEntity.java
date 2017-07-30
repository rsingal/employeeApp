package com.rsingal.employee.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/**
 * Employee Entity.
 * 
 * @author rsingal
 */
@Entity
@Table(name = "EMPLOYEE")
public class EmployeeEntity {

	/** The employee id. */
	private Integer employeeId;
	/** The name. */
	private String name;
	/** The age. */
	private Integer age;

	/**
	 * Instantiates a new employee entity.
	 */
	public EmployeeEntity() {
		super();
	}

	/**
	 * Instantiates a new employee entity.
	 *
	 * @param name the name of employee
	 * @param age the age of employee
	 */
	public EmployeeEntity(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}

	/**
	 * Gets the employee id.
	 *
	 * @return the employee id
	 */
	@Id
	@GenericGenerator(name = "mygen1", strategy = "increment")
	@GeneratedValue(generator = "mygen1")
	@Column(name = "ID_EMPLOYEE", unique = true, nullable = false)
	public Integer getEmployeeId() {
		return employeeId;
	}

	/**
	 * Sets the employee id.
	 *
	 * @param employeeId the new employee id
	 */
	public void setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
	}

	/**
	 * Gets the name of employee.
	 *
	 * @return the name of employee
	 */
	@Column(name = "NAME", nullable = false, length = 32)
	public String getName() {
		return name;
	}

	/**
	 * Sets the name of employee.
	 *
	 * @param name the new name of employee
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Gets the age of employee.
	 *
	 * @return the age of employee
	 */
	@Column(name = "AGE", nullable = false)
	public Integer getAge() {
		return age;
	}

	/**
	 * Sets the age of employee.
	 *
	 * @param age the new age of employee
	 */
	public void setAge(Integer age) {
		this.age = age;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "EmployeeEntity [employeeId=" + employeeId + ", name=" + name + ", age=" + age + "]";
	}
}
