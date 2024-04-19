package com.mytech.mvcshop.entities;

import com.mytech.mvcshop.enums.Gender;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import jakarta.validation.constraints.Email;

@Entity
@Table(name = "Customers")
@NamedQuery(name = Customer.FIND_BY_ID, query = "select c from Customer c where c.id = :id")
@NamedQuery(name = Customer.FIND_BY_NAME, query = "select c from Customer c where c.firstName like :name")
@NamedQuery(name = Customer.LIST_CUSTOMERS, query = "select c from Customer c")
public class Customer extends AbstractEntity {

	private static final long serialVersionUID = 7006460830532063989L;

	public static final String FIND_BY_ID = "Customer.findById";
	public static final String FIND_BY_NAME = "Customer.findByName";
	public static final String LIST_CUSTOMERS = "Customer.listCustomers";

	private String firstName;
	private String lastName;
	private int points;

	@Email(message = "Email must be correct format")
	private String email;

	@Enumerated(EnumType.STRING)
	private Gender gender;

	@Embedded
	private Address address;

	public Customer() {
	}

	public Customer(String firstName, String lastName, String email, String address) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
	}
	
	@Transient
	public String getFullName() {
		return lastName + " " + firstName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getPoints() {
		return points;
	}

	public void setPoints(int points) {
		this.points = points;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}
	
	@Transient
	public String getName() {
		return firstName + " " + lastName;
	}
}
