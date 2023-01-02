package com.prasad.service;

import java.util.List;

import com.prasad.model.Employee;

public interface EmployeeService {
	
	List<Employee> getAllEmployees();
	void saveEmployee(Employee emp);
	Employee getEmployeeById(Long id);
	void deleteEmployeeById(Long id);

}
