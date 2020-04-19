package com.anant.springboot.thymeleaf.crudemployee.crudemployeethymeleaf.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.anant.springboot.thymeleaf.crudemployee.crudemployeethymeleaf.entity.Employee;

public interface EmployeeJPA extends JpaRepository<Employee, Integer> {

	public List<Employee> findAllByOrderByLastnameAsc();
}
