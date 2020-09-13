package com.luv2code.dagesh.cruddemospringboot.service;

import java.util.List;

import com.luv2code.dagesh.cruddemospringboot.entity.Employees;

public interface EmployeeService {

	public List<Employees> findList();

	public Employees findById(int theId);

	public void save(Employees theEmployees);

	public void deleteById(int theId);
}
