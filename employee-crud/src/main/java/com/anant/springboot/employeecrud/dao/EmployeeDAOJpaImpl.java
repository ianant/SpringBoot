package com.anant.springboot.employeecrud.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.anant.springboot.employeecrud.entity.Employee;

@Repository
public class EmployeeDAOJpaImpl implements EmployeeDAO {

	@Autowired
	private EntityManager entityManager;
	
	@Override
		public List<Employee> findAll() {
			
			//create a query
			
			Query theQuery=entityManager.createQuery("from Employee");
			
			//execute query and get a result list
			
			List<Employee> theEmployees=theQuery.getResultList();
			
			//return the results
			
			return theEmployees;
	
	
		}

	@Override
	public Employee getSingleEmployee(int id) {
		//get the employee
		Employee theEmployee=entityManager.find(Employee.class, id);
		
		//return the employee
		return theEmployee;
	}

	@Override
	public Employee save(Employee theEmp) {
		//save and update the employee
		Employee dbEmployee=entityManager.merge(theEmp);
		
		//update with id from db ....so we can get generetaed id to save and update
		theEmp.setId(dbEmployee.getId());
		
		return theEmp;
	}

	@Override
	public void deleteByID(int theID) {
		
		//create query to delete object with primary key
		
		Query newQuery=entityManager.createQuery("delete from Employee where id=:employeeID");
		
		newQuery.setParameter("employeeID", theID);
		//execute query
		
		newQuery.executeUpdate();
		
		

	}

}
