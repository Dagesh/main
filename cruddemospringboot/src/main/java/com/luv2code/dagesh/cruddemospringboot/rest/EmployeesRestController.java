package com.luv2code.dagesh.cruddemospringboot.rest;

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

import com.luv2code.dagesh.cruddemospringboot.dao.EmployeeDAO;
import com.luv2code.dagesh.cruddemospringboot.entity.Employees;
import com.luv2code.dagesh.cruddemospringboot.service.EmployeeService;

@RestController
@RequestMapping("/dagesh")
public class EmployeesRestController {

//	private EmployeeDAO employeeDAO;
	
	private EmployeeService  theEmployeeService;
	
	// define and dirty: inject employee dao
	
//	@Autowired
//	public EmployeesRestController(EmployeeDAO theEmployeeDAO)
//	{
//		employeeDAO = theEmployeeDAO;
//	}
	@Autowired
	public EmployeesRestController(EmployeeService employeeService)
	{
		theEmployeeService = employeeService;
	}
	
	// expose "/employees" and return list of employees
	@GetMapping("/employee-list")
	public List<Employees> findAll(){
		return theEmployeeService.findList();
	}
	
	// add mapping for GET / employees/{employeeId}
	@GetMapping("/employee/{employeeId}")
	public Employees getEmployee(@PathVariable int employeeId)
	{
		Employees theEmployees = theEmployeeService.findById(employeeId);
		if(theEmployees == null) {
			throw new RuntimeException("Employee id not found - "+employeeId);
		}
		return theEmployees;
	}
	
	// add mapping for POST /employees -add new employee
	@PostMapping("/employees")
	public Employees addEmployee(@RequestBody Employees theEmployees)
	{
		// also just in case they pas an id in JSON /// set id to 0
		// this is to force a save of new item .. instead of update
		
//		theEmployees.setId(0);
		theEmployeeService.save(theEmployees);
		return theEmployees;
	
	}
	
	// add mapping for PUT /employees a update existing employee
	@PutMapping("/employees")
	public Employees updateEmployee(@RequestBody Employees theEmployees)
	{
		
		theEmployeeService.save(theEmployees);
		return theEmployees;
	}
	
	//add mapping for DELETE /employees/{employeeId} - delete employee
	@DeleteMapping("/employees")
	public String deleteEmployee(@PathVariable int employeeId) {
		
		Employees theEmployees = theEmployeeService.findById(employeeId);
		
		// throw exception if null 
		
		if(theEmployees == null)
		{
			throw new RuntimeException("Employee id not found - "+employeeId);
		}
		System.out.println(theEmployees);
		theEmployeeService.deleteById(employeeId);
		
		return "Deleted employee id - "+employeeId;
	}
	
	
}
