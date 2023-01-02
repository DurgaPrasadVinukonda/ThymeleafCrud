package com.prasad.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prasad.model.Employee;
import com.prasad.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl  implements EmployeeService{
	
	@Autowired
	EmployeeRepository empRepository;

	
	public List<Employee> getAllEmployees() {
		empRepository.findAll().stream().forEach(d -> System.out.println(d.getId()+" "+d.getEmail()+" "+d.getLastName()+" "+d.getFirstName()));
		return empRepository.findAll();
	}


   // add employee object
	public void saveEmployee(Employee emp) {
		empRepository.save(emp);
		
		
	}


	@Override
	public Employee getEmployeeById(Long id) {
		Optional<Employee> optional=empRepository.findById(id);
		Employee employee=null;
		if(optional.isPresent()) {
			employee= optional.get();
			
		}else {
			throw new RuntimeException("Employee not for found:"+id);
		}
		
		return employee;
	}


	@Override
	public void deleteEmployeeById(Long id) {
		Optional<Employee> op=empRepository.findById(id);
		Employee emp =null;
		if(op.isPresent()) {
		empRepository.deleteById(id);
		}else {
			throw new RuntimeException("Employee id can't be deleted "+id);
		}
		
		
	}
	
	
	
	 

}
