package com.luv2code.dagesh.cruddemospringboot.dao;

import java.util.List;

import com.luv2code.dagesh.cruddemospringboot.entity.Employees;

public interface EmployeeDAO {

	public List<Employees> findAll(); 
	
	public Employees findById(int theId);
	
	public void save(Employees theEmployees);
	
	public void deleteById(int theId);
	
}
