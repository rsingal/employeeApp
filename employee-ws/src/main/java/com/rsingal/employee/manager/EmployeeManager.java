package com.rsingal.employee.manager;

import java.util.List;

import com.rsingal.employee.entity.EmployeeEntity;
import com.rsingal.employee.exception.EmployeeException;

/**
 * Employee manager interface, Interfaces between EmployeeController and EmployeeDAO
 * 
 * @author rsingal
 */
public interface EmployeeManager {

	/**
	 * Creates the employee.
	 *
	 * @param empEntity the employee entity
	 * @return the integer
	 */
	Integer createEmployee(EmployeeEntity empEntity);

	/**
	 * Update employee.
	 *
	 * @param empEntity the employee entity
	 */
	void updateEmployee(EmployeeEntity empEntity);

	/**
	 * Delete employee.
	 *
	 * @param empEntity the employee entity
	 */
	void deleteEmployee(EmployeeEntity empEntity);

	/**
	 * Gets the employee by id.
	 *
	 * @param empId the employee id
	 * @return the employee entity
	 * @throws EmployeeException the employee exception
	 */
	EmployeeEntity getEmployeeById(int empId)
			throws EmployeeException;

	/**
	 * Gets all employees.
	 *
	 * @return the list of employee entities
	 */
	List<EmployeeEntity> getAllEmployees();
}
