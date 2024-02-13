package com.example.sb.repositories;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;


import com.example.sb.entities.Employee;

public interface Repositories extends JpaRepository<Employee, Integer>{

	List<Employee> findByEmpId(int empId);

    
    List<Employee> findBySalary(BigDecimal salary);
    List<Employee> findByFirstName(String firstName);
    List<Employee> findByEmail(String email);


	List<Employee> findByLastName(String lastName);


	List<Employee> findByHireDate(Date hireDate);

}

