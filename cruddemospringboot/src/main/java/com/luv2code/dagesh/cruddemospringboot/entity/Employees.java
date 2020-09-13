package com.luv2code.dagesh.cruddemospringboot.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name ="employees")
public class Employees {
	
	// define fields
	// define constructors
	//define getter/setter
	//define toString method
	
	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	private Integer id;
//	@Column(name ="firstName")
	private String firstName;
//	@Column(name ="lastName")
	private String lastName;
//	@Column(name ="email")
	private String email;
	
	public Employees() {
		
	}
	
	/**
	 * @param firstName
	 * @param lastName
	 * @param email
	 */
	public Employees(String firstName, String lastName, String email) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFistName() {
		return firstName;
	}

	public void setFistName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Employees [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email + "]";
	}
	
	
	
	

}
