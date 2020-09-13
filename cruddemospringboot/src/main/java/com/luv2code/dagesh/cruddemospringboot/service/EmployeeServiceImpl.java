package com.luv2code.dagesh.cruddemospringboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.luv2code.dagesh.cruddemospringboot.dao.EmployeeDAO;
import com.luv2code.dagesh.cruddemospringboot.entity.Employees;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	private EmployeeDAO employeeDAO;
	
	@Autowired
	public EmployeeServiceImpl(EmployeeDAO theEmployeeDAO) {
		employeeDAO = theEmployeeDAO;
	}
	@Override
	@Transactional
	public List<Employees> findList() {
		return employeeDAO.findAll();
	}

	@Override
	@Transactional
	public Employees findById(int theId) {
		return employeeDAO.findById(theId);
	}

	@Override
	@Transactional
	public void save(Employees theEmployees) {
		employeeDAO.save(theEmployees);

	}

	@Override
	@Transactional
	public void deleteById(int theId) {
		employeeDAO.deleteById(theId);
	}

}
