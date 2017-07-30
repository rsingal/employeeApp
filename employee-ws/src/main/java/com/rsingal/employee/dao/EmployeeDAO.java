package com.rsingal.employee.dao;

import java.util.List;

import com.rsingal.employee.entity.EmployeeEntity;

/**
 * Employee DAO Interface.
 * 
 * @author rsingal
 */
public interface EmployeeDAO {

	/**
	 * Creates the employee.
	 *
	 * @param empEntity the employee entity
	 * @return the employee id
	 */
	Integer create(EmployeeEntity empEntity);

	/**
	 * Updates the employee.
	 *
	 * @param empEntity the employee entity
	 */
	void update(EmployeeEntity empEntity);

	/**
	 * Deletes the employee.
	 *
	 * @param empEntity the employee entity
	 */
	void delete(EmployeeEntity empEntity);

	/**
	 * Gets the employee by id.
	 *
	 * @param id the employee id
	 * @return the employee entity
	 */
	EmployeeEntity getById(int id);

	/**
	 * Gets all employee entities.
	 *
	 * @return all employee entities
	 */
	List<EmployeeEntity> getAll();
}
