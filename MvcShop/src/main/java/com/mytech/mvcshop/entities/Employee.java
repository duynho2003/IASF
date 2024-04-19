package com.mytech.mvcshop.entities;

import java.math.BigDecimal;
import java.time.LocalDate;

import com.mytech.mvcshop.enums.Gender;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;

@Entity
@Table(name = "Employees")
@NamedQuery(name = Employee.FIND_BY_ID, query = "select e from Employee e where e.id = :id")
@NamedQuery(name = Employee.FIND_BY_NAME, query = "select e from Employee e where e.fullName = :name")
@NamedQuery(name = Employee.LIST_EMPLOYEES, query = "select  e from Employee e order by e.fullName")
public class Employee extends AbstractEntity {

	private static final long serialVersionUID = -4726237944088534092L;

	public static final String FIND_BY_ID = "Employee.findById";
	public static final String FIND_BY_NAME = "Employee.findByName";
	public static final String LIST_EMPLOYEES = "Employee.listEmployees";

	@NotNull
	private String fullName;

	@Past(message = "Date of birth must be in the past")
	private LocalDate dateOfBirth; // yyyy-MM-dd

	@NotNull(message = "Basic salary must be set")
	private BigDecimal basicSalary;

	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "dept_id")
	private Department department;

	@Min(value = 18, message = "Employee must be at least 18")
	@Max(value = 60, message = "Employee age must cannot exceed 60")
	private int age;
	
	@Email(message = "Email must be correct format")
	private String email;
	
	@Enumerated(EnumType.STRING)
	private Gender gender;
	
	@Embedded
    private Address address;
	
	@Transient
	private Long departmentId;

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public BigDecimal getBasicSalary() {
		return basicSalary;
	}

	public void setBasicSalary(BigDecimal basicSalary) {
		this.basicSalary = basicSalary;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
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

	public Long getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(Long departmentId) {
		this.departmentId = departmentId;
	}
	
}