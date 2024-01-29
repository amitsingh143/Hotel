package com.example.sb.services;

import java.util.List;

import com.example.sb.entities.Employee;

public interface EmpService {
	
	public String addEmployee(Employee e);
	public Employee getEmpInfo(String empId);
	public List<Employee> getAllEmpInfo();
	public String updateEmp(Employee e);
	public String deleteEmp(String empId);
	

}
