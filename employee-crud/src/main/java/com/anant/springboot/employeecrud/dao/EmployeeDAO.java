package com.anant.springboot.employeecrud.dao;

import java.util.List;

import com.anant.springboot.employeecrud.entity.Employee;

public interface EmployeeDAO {

	public List<Employee> findAll();
	
	public Employee getSingleEmployee(int id);
	
	public Employee save(Employee theEmp);
	
	public void deleteByID(int theID);
}
