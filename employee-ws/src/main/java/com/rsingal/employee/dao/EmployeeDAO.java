package com.rsingal.employee.dao;

import java.util.List;

import com.rsingal.employee.entity.EmployeeEntity;

public interface EmployeeDAO {

	Integer create(EmployeeEntity empEntity);

	void update(EmployeeEntity empEntity);

	void delete(EmployeeEntity empEntity);

	EmployeeEntity getById(int id);

	List<EmployeeEntity> getAll();
}
