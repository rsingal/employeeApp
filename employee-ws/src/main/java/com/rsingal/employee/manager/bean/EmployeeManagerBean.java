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

@Repository("employeeManager")
public class EmployeeManagerBean implements EmployeeManager {

	private EmployeeDAO employeeDAO;

	@Autowired
	public void setEmployeeDAO(EmployeeDAO employeeDAO) {
		this.employeeDAO = employeeDAO;
	}

	@Override
	public Integer createEmployee(EmployeeEntity empEntity) {
		return employeeDAO.create(empEntity);
	}

	@Override
	public void updateEmployee(EmployeeEntity empEntity) {
		employeeDAO.update(empEntity);
	}

	@Override
	public void deleteEmployee(EmployeeEntity empEntity) {
		employeeDAO.delete(empEntity);
	}

	@Override
	public EmployeeEntity getEmployeeById(int id)
			throws EmployeeException {
		EmployeeEntity empEntity = employeeDAO.getById(id);
		if (empEntity == null) {
			throw new EmployeeException("Employee not found.", HttpStatus.NOT_FOUND);
		}
		return empEntity;
	}

	@Override
	public List<EmployeeEntity> getAllEmployees() {
		List<EmployeeEntity> empEntitiesList = employeeDAO.getAll();
		return empEntitiesList != null ? empEntitiesList : new ArrayList<EmployeeEntity>();
	}
}
