package com.anant.springboot.employeecrud.service;

import java.util.List;

import com.anant.springboot.employeecrud.entity.Employee;

public interface EmployeeService {

	public List<Employee> findAll();
	
	public Employee getSingleEmployee(int theID);
	
	public Employee save(Employee theEmployee);
	
	public void deleteById(int theId);
}
 