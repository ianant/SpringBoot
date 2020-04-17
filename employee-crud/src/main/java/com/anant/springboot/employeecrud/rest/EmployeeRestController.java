package com.anant.springboot.employeecrud.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.anant.springboot.employeecrud.dao.EmployeeDAO;
import com.anant.springboot.employeecrud.entity.Employee;
import com.anant.springboot.employeecrud.service.EmployeeService;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

	@Autowired
	private EmployeeService employeeService;
	
	@GetMapping("/employees")
	public List<Employee> findAll(){
		
		return employeeService.findAll();
	}
	@GetMapping("/employees/{empID}")
	public Employee getSingleEmployee(@PathVariable int empID) {
		Employee emp=employeeService.getSingleEmployee(empID);
		return emp;
	}
	
	@PostMapping("/employees")
	public Employee addEmployee(@RequestBody Employee theEmployee) {
		theEmployee.setId(0);
		
		employeeService.save(theEmployee);
		return theEmployee;
	}
	@PutMapping("/employees")
	public Employee updateEmployee(@RequestBody Employee theEmployee) {
		
		employeeService.save(theEmployee);
		return theEmployee;
	}
	
	@DeleteMapping("/employees/{empID}")
	public String deleteEmployee(@PathVariable int empID) {
		
		Employee theEmployee=employeeService.getSingleEmployee(empID);
		
		if(theEmployee==null) {
			throw new RuntimeException("Invalid employee id passed : "+empID);
		}
		
		employeeService.deleteById(empID);
		
		return "Employee deleted succesfully with the ID: "+empID;
		
	}
	
	
}
