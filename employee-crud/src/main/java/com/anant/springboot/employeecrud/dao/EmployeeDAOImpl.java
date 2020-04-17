package com.anant.springboot.employeecrud.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.anant.springboot.employeecrud.entity.Employee;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {

	//inject the EntityManager
	@Autowired
	private EntityManager entityManager;
	
	public List<Employee> findAll() {
		
		//Create the session object
		Session currentSession=entityManager.unwrap(Session.class);
		
		//Create a query
		Query query=currentSession.createQuery("from Employee",Employee.class);
		
		//execute the query
		
		List <Employee> employeeList=query.getResultList();
		
		//return result
		return employeeList;
	}


	public Employee getSingleEmployee(int theId) {
		
		//create a session object
		Session currentSession=entityManager.unwrap(Session.class);
		
		//get the employee by ID
		
		Employee emp=currentSession.get(Employee.class,theId );
		
		//return result
		return emp;
	}


	@Override
	public Employee save(Employee theEmp) {
		//create the sassion
		Session currentSession=entityManager.unwrap(Session.class);
		
		currentSession.saveOrUpdate(theEmp);//if id is 0 then it will insert if not then it will update
		return theEmp;
	}


	@Override
	public void deleteByID(int theID) {
		//get the hibernate session
		Session currentSession=entityManager.unwrap(Session.class);
		
		//delete by id
		Query query=currentSession.createQuery("delete from Employee where id=:employeeId");
		query.setParameter("employeeId", theID);
		query.executeUpdate();
	}


	

}
