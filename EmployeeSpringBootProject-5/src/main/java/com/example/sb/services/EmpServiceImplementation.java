// EmpServiceImplementation.java
package com.example.sb.services;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import com.example.sb.entities.Employee;
import com.example.sb.exception.EmployeeNotFoundException;
import com.example.sb.exception.EmployeeServiceException;
import com.example.sb.repositories.Repositories;

@Service
public class EmpServiceImplementation implements EmpService {
	
    private static final Logger logger = LoggerFactory.getLogger(EmpServiceImplementation.class);

    
    Repositories repo;

    public EmpServiceImplementation(Repositories repo) {
        super();
        this.repo = repo;
    }

    @Override
    public String addEmployee(Employee e) {
        repo.save(e);
        return "Employee is created and saved";
    }

    @Override
    public List<Employee> getAllEmpInfo() {
        List<Employee> empList = repo.findAll();
        return empList;
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
    public List<Employee> searchEmployees(String empId, String name, Double salary) {
        // Customize this method based on your requirements to search by empId, name, and salary
        // Example: Searching by empId
        if (empId != null) {
            return repo.findByEmpId(empId);
        }
        // Example: Searching by name
        else if (name != null) {
            return repo.findByName(name);
        }
        // Example: Searching by salary
        else if (salary != null) {
            return repo.findBySalary(salary);
        }

        // If none of the parameters are provided, return all employees
        return repo.findAll();
    }

    @Override
    public Employee getEmpInfoById(Employee e) {
        // Adjust the implementation based on your requirements
        List<Employee> employees = repo.findByEmpId(e.getEmpId());

        // Assuming there should be only one result, you may need to handle multiple results differently
        if (!employees.isEmpty()) {
            return employees.get(0);
        } else {
            return null; // Handle case when no matching employee is found
        }
    }
    
    
//    @Override
//    public Employee getEmpInfo(Employee e) {
//        // Assuming you want to search by other attributes of Employee (e.g., name, salary)
//        // Adjust this part based on your actual requirements
//        // This example searches by name, you can modify it accordingly
//        List<Employee> employees = repo.findByName(e.getName());
//
//        // Assuming there should be only one result, you may need to handle multiple results differently
//        if (!employees.isEmpty()) {
//            return employees.get(0);
//        } else {
//            return null; // Handle case when no matching employee is found
//        }
//    }
    
    
    @Override
    public Employee getEmpInfo(Employee e) {
        try {
            List<Employee> employees = repo.findByEmpId(e.getEmpId());

            if (!employees.isEmpty()) {
                return employees.get(0);
            } else {
                throw new EmployeeNotFoundException("Employee not found with ID: " + e.getEmpId());
            }
        } catch (Exception ex) {
            logger.error("Error occurred while getting employee information.", ex);
            throw new EmployeeServiceException("Error getting employee information.", ex);
        }
    }
}



