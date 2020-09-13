package com.luv2code.dagesh.cruddemospringboot.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.luv2code.dagesh.cruddemospringboot.entity.Employees;

@Repository
public class EmployeeDAOHibernateImpl implements EmployeeDAO {

	// define fields for entity manager
	// setup constructor injection

	private EntityManager entityManager;

	@Autowired
	public EmployeeDAOHibernateImpl(EntityManager theEntityManager) {
		entityManager = theEntityManager;
	}

	@Override
	@Transactional
	public List<Employees> findAll() {

		// get the current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);

		// create a query
		Query<Employees> theQuery = currentSession.createQuery("from Employees", Employees.class);

		// execute query and get result list
		List<Employees> empList = theQuery.getResultList();

		// return the results
		return empList;
	}

	@Override
	public Employees findById(int theId) {

		// get the current hibernate session
		Session currSession = entityManager.unwrap(Session.class);

		// get the Employee
		Employees employees = currSession.get(Employees.class, theId);

		// return the result
		return employees;
	}

	@Override
	public void save(Employees theEmployees) {

		// get the current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);
		
		// save employee
		currentSession.saveOrUpdate(theEmployees);
	}

	@Override
	public void deleteById(int theId) {

		// get the current hibernate session 
		Session currentSession = entityManager.unwrap(Session.class);
		
		// delete object with primary key
		Query query = currentSession.createQuery("delete from Employees where id =:employeeId ");
		query.setParameter("employeeId", theId);
		
		query.executeUpdate();
	}

}
