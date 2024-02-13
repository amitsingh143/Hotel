package com.example.sb.services;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.springframework.http.ResponseEntity;

import com.example.sb.entities.Employee;
import com.example.sb.entities.SearchRequest;

public interface EmpService {
	
	public String addEmployee(Employee e);
	//public Employee getEmpInfo(String empId);
	public Employee getEmpInfoById(Employee e);
	public List<Employee> getAllEmpInfo();
	public String updateEmp(Employee e);
	public String deleteEmp(int empId);
	public List<Employee> searchRequest(int empId, String FirstName,
			String LastName, BigDecimal salary, Date hireDate,String email);
	public Employee getEmpInfo(Employee e);
	//List<Employee> searchRequest(int empId, String name, BigDecimal salary);
	public ResponseEntity<Employee> searchEmployee(SearchRequest searchRequest);
	

}
