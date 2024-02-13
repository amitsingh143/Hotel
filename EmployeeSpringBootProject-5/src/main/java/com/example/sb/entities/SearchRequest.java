package com.example.sb.entities;

import java.math.BigDecimal;
import java.util.Date;

public class SearchRequest {
	
	String firstName;
    String lastName;
    String email;
    Date hireDate;
    public SearchRequest() {
		super();
		// TODO Auto-generated constructor stub
	}
	BigDecimal salary;
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public SearchRequest(String firstName, String lastName, String email, Date hireDate, BigDecimal salary) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.hireDate = hireDate;
		this.salary = salary;
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
	public Date getHireDate() {
		return hireDate;
	}
	public void setHireDate(Date hireDate) {
		this.hireDate = hireDate;
	}
	public BigDecimal getSalary() {
		return salary;
	}
	public void setSalary(BigDecimal salary) {
		this.salary = salary;
	}

}
