package com.example.sb.services;

import java.util.List;


import com.example.sb.entities.Employee;

public interface EmpService {
	
	public String addEmployee(Employee e);
	//public Employee getEmpInfo(String empId);
	public Employee getEmpInfoById(Employee e);
	public List<Employee> getAllEmpInfo();
	public String updateEmp(Employee e);
	public String deleteEmp(String empId);
	 public List<Employee> searchEmployees(String empId, String name, Double salary);
	public Employee getEmpInfo(Employee e);
	

}
