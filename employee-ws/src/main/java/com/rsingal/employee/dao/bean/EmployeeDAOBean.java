package com.rsingal.employee.dao.bean;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.rsingal.employee.dao.EmployeeDAO;
import com.rsingal.employee.entity.EmployeeEntity;

/**
 * Employee DAO implementation.
 * 
 * @author rsingal
 */
@Repository("employeeDAO")
@Transactional(propagation = Propagation.REQUIRED, readOnly = false, isolation = Isolation.DEFAULT)
public class EmployeeDAOBean implements EmployeeDAO {

	/** The hibernate template. */
	private HibernateTemplate hibernateTemplate;

	/**
	 * Sets the hibernate template.
	 *
	 * @param hibernateTemplate the new hibernate template
	 */
	@Autowired
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.rsingal.employee.dao.EmployeeDAO#create(com.rsingal.employee.entity.EmployeeEntity)
	 */
	// method to create employee
	@Override
	public Integer create(EmployeeEntity empEntity) {
		return (Integer) hibernateTemplate.save(empEntity);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.rsingal.employee.dao.EmployeeDAO#update(com.rsingal.employee.entity.EmployeeEntity)
	 */
	// method to update employee
	@Override
	public void update(EmployeeEntity empEntity) {
		hibernateTemplate.update(empEntity);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.rsingal.employee.dao.EmployeeDAO#delete(com.rsingal.employee.entity.EmployeeEntity)
	 */
	// method to delete employee
	@Override
	public void delete(EmployeeEntity empEntity) {
		hibernateTemplate.delete(empEntity);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.rsingal.employee.dao.EmployeeDAO#getById(int)
	 */
	// method to return one employee of given id
	@Override
	public EmployeeEntity getById(int id) {
		return hibernateTemplate.get(EmployeeEntity.class, id);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.rsingal.employee.dao.EmployeeDAO#getAll()
	 */
	// method to return all employees
	@Override
	public List<EmployeeEntity> getAll() {
		return hibernateTemplate.loadAll(EmployeeEntity.class);
	}
}
