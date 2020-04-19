package com.anant.springboot.thymeleaf.crudemployee.crudemployeethymeleaf.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.anant.springboot.thymeleaf.crudemployee.crudemployeethymeleaf.dao.EmployeeJPA;
import com.anant.springboot.thymeleaf.crudemployee.crudemployeethymeleaf.entity.Employee;

@Controller
@RequestMapping("/api")
public class EmployeeController {

	@Autowired
	private EmployeeJPA employeeDAO;
	
	List<Employee> theList; 
	
	@GetMapping("/employees")
	public String getEmployee(Model theModel) {
		
		theList=new ArrayList<Employee>();
		theList=employeeDAO.findAllByOrderByLastnameAsc();
		theModel.addAttribute("employees", theList);
		return "employees/employees-list";
	}
	
	@GetMapping("/showFormToAddEmp(employeeId)")
	public String showFormToAddEmp(Model theModel) {
		Employee theEmployee=new Employee();
		theModel.addAttribute("addEmployee", theEmployee);
		return "employees/showFormToAddEmp";
	}
	
	@PostMapping("/save")
	public String saveEmployee(@ModelAttribute("addEmployee") Employee theEmployee) {
		
		employeeDAO.save(theEmployee);
		
		return "redirect:/api/employees";
	}
	
	@GetMapping("/showFormToUpdateEmp")
	public String showFormToUpdate(@RequestParam("employeeId") int theId,Model theModel) {
		
		System.out.println("~~~~~~~~~~~~~~~~hello from update");
		Optional<Employee> theEmp=employeeDAO.findById(theId);
		
		Employee theEmployee=null;
		if(theEmp.isPresent()) {
			System.out.println("~~~~~~~~~~Employee found");
			theEmployee=theEmp.get();
			theModel.addAttribute("addEmployee", theEmployee);
		}
		else
		{
			throw new RuntimeException("Invalid Id: "+theId);
		}
		return "employees/showFormToAddEmp";
	}
	
	@GetMapping("/delete")
	public String deleteEmployee(@RequestParam("employeeId") int theId) {
		employeeDAO.deleteById(theId);
		return "redirect:/api/employees";
	}
	
}
