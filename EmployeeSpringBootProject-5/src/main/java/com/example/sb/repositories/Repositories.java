package com.example.sb.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.sb.entities.Employee;

public interface Repositories extends JpaRepository<Employee, String>{

}
