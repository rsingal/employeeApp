package com.rsingal.employee.manager;

import java.util.List;

import com.rsingal.employee.entity.EmployeeEntity;
import com.rsingal.employee.exception.EmployeeException;

public interface EmployeeManager {

	Integer createEmployee(EmployeeEntity empEntity);

	void updateEmployee(EmployeeEntity empEntity);

	void deleteEmployee(EmployeeEntity empEntity);

	EmployeeEntity getEmployeeById(int empId)
			throws EmployeeException;

	List<EmployeeEntity> getAllEmployees();
}
