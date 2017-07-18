package com.rsingal.employee.controller.v1_0;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.rsingal.employee.common.ErrorResponse;
import com.rsingal.employee.entity.EmployeeEntity;
import com.rsingal.employee.exception.BindingException;
import com.rsingal.employee.exception.EmployeeException;
import com.rsingal.employee.manager.EmployeeManager;
import com.rsingal.employee.v1_0.createemployee.CreateEmployeeRequest;
import com.rsingal.employee.v1_0.createemployee.CreateEmployeeResponse;
import com.rsingal.employee.v1_0.deleteemployee.DeleteEmployeeRequest;
import com.rsingal.employee.v1_0.deleteemployee.DeleteEmployeeResponse;
import com.rsingal.employee.v1_0.getemployee.Employee;
import com.rsingal.employee.v1_0.getemployee.EmployeeList;
import com.rsingal.employee.v1_0.updateemployee.UpdateEmployeeRequest;
import com.rsingal.employee.v1_0.updateemployee.UpdateEmployeeResponse;

// Spring 4 introduced @RestController which is combination of @Controller + @ResponseBody. 
// So when using @RestController, you do not need to use @ResponseBody. It’s optional.
@RestController
@RequestMapping(value = "/employee")
public class EmployeeController {

	private EmployeeManager employeeManager;

	@Autowired
	public void setEmployeeManager(EmployeeManager employeeManager) {
		this.employeeManager = employeeManager;
	}

	@RequestMapping(value = "/createEmployee", method = RequestMethod.POST)
	public CreateEmployeeResponse createEmployee(@Valid @RequestBody final CreateEmployeeRequest request, BindingResult bindingResult)
			throws Exception {
		validateBinding(bindingResult);
		EmployeeEntity employeeEntity = new EmployeeEntity(request.getName().trim(), request.getAge());
		Integer employeeId = employeeManager.createEmployee(employeeEntity);
		CreateEmployeeResponse response = new CreateEmployeeResponse(employeeId);
		return response;
	}

	@RequestMapping(value = "/getEmployees", method = RequestMethod.GET)
	public EmployeeList getAllEmployees() {
		final EmployeeList employees = new EmployeeList();
		List<EmployeeEntity> allEmpEntities = employeeManager.getAllEmployees();
		allEmpEntities.forEach(empEntity -> employees.getEmployees().add(convert(empEntity)));
		return employees;
	}

	@RequestMapping(value = "/getEmployees/{id}", method = RequestMethod.GET)
	public Employee getEmployeeById(@PathVariable("id") int id)
			throws EmployeeException {
		EmployeeEntity empEntity = employeeManager.getEmployeeById(id);
		return convert(empEntity);
	}

	@RequestMapping(value = "/updateEmployee", method = RequestMethod.POST)
	public UpdateEmployeeResponse updateEmployee(@Valid @RequestBody final UpdateEmployeeRequest request, BindingResult bindingResult)
			throws Exception {
		validateBinding(bindingResult);
		EmployeeEntity empEntity = employeeManager.getEmployeeById(request.getEmployeeId());
		if (request.getName() != null) {
			validateEmployeeName(request.getName());
			empEntity.setName(request.getName().trim());
		}
		if (request.getAge() != null) {
			empEntity.setAge(request.getAge());
		}
		employeeManager.updateEmployee(empEntity);
		return new UpdateEmployeeResponse();
	}

	@RequestMapping(value = "/deleteEmployee", method = RequestMethod.POST)
	public DeleteEmployeeResponse deleteEmployee(@Valid @RequestBody final DeleteEmployeeRequest request, BindingResult bindingResult)
			throws Exception {
		validateBinding(bindingResult);
		EmployeeEntity empEntity = employeeManager.getEmployeeById(request.getEmployeeId());
		employeeManager.deleteEmployee(empEntity);
		return new DeleteEmployeeResponse();
	}

	@ExceptionHandler(EmployeeException.class)
	public ResponseEntity<ErrorResponse> exceptionHandler(EmployeeException ex) {
		ErrorResponse errorResponse = new ErrorResponse();
		errorResponse.setErrorCode(ex.getHttpStatus().value());
		errorResponse.setErrorMessage(ex.getMessage());
		// ResponseEntity is a class in Spring MVC that acts as a wrapper for an object
		// to be used as the body of the result together with a HTTP status code.
		// This provides greater control over what you are returning to client in various use cases.
		// e.g. returning a 404 error if no employee is found for given employee id.
		return new ResponseEntity<ErrorResponse>(errorResponse, ex.getHttpStatus());
	}

	private void validateBinding(BindingResult bindingResult)
			throws BindingException {
		if (bindingResult.hasErrors()) {
			throw new BindingException(bindingResult);
		}
	}

	private void validateEmployeeName(String name)
			throws EmployeeException {
		if (name.trim().isEmpty()) {
			// TODO: Needs a custom validator for validating String:
			// 1. if null, no error
			// 2. if non-null, check for not empty and not blank and throw error
			throw new EmployeeException("name can not have only spaces", HttpStatus.BAD_REQUEST);
		}
	}

	private Employee convert(EmployeeEntity empEntity) {
		Employee employee = new Employee();
		employee.setEmployeeId(empEntity.getEmployeeId());
		employee.setName(empEntity.getName());
		employee.setAge(empEntity.getAge());
		return employee;
	}
}
