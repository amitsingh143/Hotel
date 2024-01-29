package com.example.sb.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.sb.entities.Employee;
import com.example.sb.repositories.Repositories;

@Service
public class EmpServiceImplementation implements EmpService {
	
	Repositories repo;

	public EmpServiceImplementation(Repositories repo) {
		super();
		this.repo = repo;
	}

	@Override
	public String addEmployee( Employee e) {
		repo.save(e);
		return "Employee is created and saved";
	}

	

	@Override
	public List<Employee> getAllEmpInfo() {
		List<Employee> emplist=repo.findAll();
		return emplist;
	}

	

	@Override
	public String updateEmp(Employee e) {
		repo.save(e);
		return "Employee object is updated";
	}

	@Override
	public String deleteEmp(String empId) {
		repo.deleteById(empId);
		return "Employee object is deleted";
	}

	@Override
	public Employee getEmpInfo(String empId) {
		Employee e= repo.findById(empId).get();
		return e;
	}
	

}
