package com.prasad.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.prasad.model.Employee;
import com.prasad.service.EmployeeService;

@Controller
public class EmployeeController {
	
	@Autowired
	private EmployeeService empService;
	
	@GetMapping(value="/")
	public String viewHomePage(Model model) {
		List<Employee>emp =empService.getAllEmployees();
		model.addAttribute("listEmployees", emp);
		return "index";
		
		
	}
	
	@GetMapping("/showNewEmployeeForm")
	public String showNewEmployee(Model model) {
		Employee emp = new Employee();
		model.addAttribute("employee", emp);
		return "new_employee";
		
	}
	
	@PostMapping("/saveEmployee")
	public String saveEmployee(@ModelAttribute("employee")Employee emp) {
		//save employee to database
		empService.saveEmployee(emp);
		return "redirect:/";
		
		
	}
    
	
	@GetMapping("/showFormForUpdate/{id}")
	public String showFromUpdate(@PathVariable(value = "id") long id, Model model) {
		 // get employee from the service
        Employee employee = empService.getEmployeeById(id);

        // set employee as a model attribute to pre-populate the form
        model.addAttribute("employee", employee);
        return "update_employee";
		
		
	}
	
	@GetMapping("/deleteEmployee/{id}")
	public String deleteFromUpdate(@PathVariable(value = "id") long id) {
		empService.deleteEmployeeById(id);
		return "redirect:/";
		
		
	}
}
