package com.rsingal.employee.manager.bean;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;

import com.rsingal.employee.dao.EmployeeDAO;
import com.rsingal.employee.entity.EmployeeEntity;
import com.rsingal.employee.exception.EmployeeException;
import com.rsingal.employee.manager.EmployeeManager;

/**
 * Employee manager implementation, interfaces between EmployeeController and EmployeeDAO.
 * 
 * @author rsingal
 */
@Repository("employeeManager")
public class EmployeeManagerBean implements EmployeeManager {

	/** The employee DAO. */
	private EmployeeDAO employeeDAO;

	/**
	 * Sets the employee DAO.
	 *
	 * @param employeeDAO the new employee DAO
	 */
	@Autowired
	public void setEmployeeDAO(EmployeeDAO employeeDAO) {
		this.employeeDAO = employeeDAO;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.rsingal.employee.manager.EmployeeManager#createEmployee(com.rsingal.employee.entity.EmployeeEntity)
	 */
	@Override
	public Integer createEmployee(EmployeeEntity empEntity) {
		return employeeDAO.create(empEntity);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.rsingal.employee.manager.EmployeeManager#updateEmployee(com.rsingal.employee.entity.EmployeeEntity)
	 */
	@Override
	public void updateEmployee(EmployeeEntity empEntity) {
		employeeDAO.update(empEntity);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.rsingal.employee.manager.EmployeeManager#deleteEmployee(com.rsingal.employee.entity.EmployeeEntity)
	 */
	@Override
	public void deleteEmployee(EmployeeEntity empEntity) {
		employeeDAO.delete(empEntity);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.rsingal.employee.manager.EmployeeManager#getEmployeeById(int)
	 */
	@Override
	public EmployeeEntity getEmployeeById(int id)
			throws EmployeeException {
		EmployeeEntity empEntity = employeeDAO.getById(id);
		if (empEntity == null) {
			throw new EmployeeException("Employee not found.", HttpStatus.NOT_FOUND);
		}
		return empEntity;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.rsingal.employee.manager.EmployeeManager#getAllEmployees()
	 */
	@Override
	public List<EmployeeEntity> getAllEmployees() {
		List<EmployeeEntity> empEntitiesList = employeeDAO.getAll();
		return empEntitiesList != null ? empEntitiesList : new ArrayList<>();
	}
}
