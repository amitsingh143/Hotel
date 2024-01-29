package com.example.sb.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


import com.example.sb.entities.Employee;

public interface Repositories extends JpaRepository<Employee, String>{

    List<Employee> findByEmpId(String empId);
    List<Employee> findByName(String name);
    List<Employee> findBySalary(Double salary);

}

