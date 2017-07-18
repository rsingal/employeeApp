package com.rsingal.employee.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "EMPLOYEE")
public class EmployeeEntity {

	private Integer employeeId;
	private String name;
	private Integer age;

	public EmployeeEntity() {
		super();
	}

	public EmployeeEntity(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}

	@Id
	@GenericGenerator(name = "mygen1", strategy = "increment")
	@GeneratedValue(generator = "mygen1")
	@Column(name = "ID_EMPLOYEE", unique = true, nullable = false)
	public Integer getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
	}

	@Column(name = "NAME", nullable = false, length = 32)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "AGE", nullable = false)
	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "EmployeeEntity [employeeId=" + employeeId + ", name=" + name + ", age=" + age + "]";
	}
}
