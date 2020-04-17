package com.anant.springboot.employeecrud.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.anant.springboot.employeecrud.dao.EmployeeDAO;
import com.anant.springboot.employeecrud.entity.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	@Qualifier("employeeDAOJpaImpl")
	private EmployeeDAO employeeDAO;
	
	
	@Override
	@Transactional
	public List<Employee> findAll() {
		// TODO Auto-generated method stub
		return employeeDAO.findAll();
	}

	@Override
	@Transactional
	public Employee getSingleEmployee(int id) {
		// TODO Auto-generated method stub
		return employeeDAO.getSingleEmployee(id);
	}

	@Override
	@Transactional
	public Employee save(Employee theEmp) {
		return employeeDAO.save(theEmp);

	}

	@Override
	@Transactional
	public void deleteById(int theID) {
		employeeDAO.deleteByID(theID);

	}

}
