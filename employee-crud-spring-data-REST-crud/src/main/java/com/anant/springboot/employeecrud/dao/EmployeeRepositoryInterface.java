package com.anant.springboot.employeecrud.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.anant.springboot.employeecrud.entity.Employee;

@RepositoryRestResource(path = "members")
public interface EmployeeRepositoryInterface extends JpaRepository<Employee, Integer> {

}
