package com.example.sb.Controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.sb.entities.Employee;
import com.example.sb.exception.EmployeeNotFoundException;
import com.example.sb.services.EmpService;

@RestController
@RequestMapping("emp")
public class Controller {
	 private static final Logger logger = LoggerFactory.getLogger(Controller.class);

    EmpService empService;

    public Controller(EmpService empService) {
        super();
        this.empService = empService;
    }

    @PostMapping("/add")
    public String addEmployee(@RequestBody Employee e) {
        String msg = empService.addEmployee(e);
        return msg;
    }

    

    @PostMapping("/get")
    public ResponseEntity<Employee> getEmpInfo(@RequestBody Employee e) {
        try {
            Employee result = empService.getEmpInfo(e);
            return ResponseEntity.ok(result);
        } catch (Exception ex) {
            logger.error("Error occurred while getting employee information.", ex);
            throw new EmployeeNotFoundException("Error getting employee information.");
        }
    }

    // Exception handling for other methods if needed
    @ExceptionHandler(EmployeeNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<String> handleEmployeeNotFoundException(EmployeeNotFoundException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }
    
    
    
    
    
    
 // Controller.java
    @PostMapping("/getById")
    public Employee getEmpInfoById(@RequestBody Employee e) {
        Employee result = empService.getEmpInfo(e);
        return result;
    }


    @PostMapping("/getAll")
    public List<Employee> getAllEmpInfo() {
        List<Employee> empListObj = empService.getAllEmpInfo();
        return empListObj;
    }

    @PostMapping("/update")
    public String updateEmp(@RequestBody Employee e) {
        String msg = empService.updateEmp(e);
        return msg;
    }

    @PostMapping("/delete")
    public String deleteEmp(@RequestBody Employee e) {
        String msg = empService.deleteEmp(e.getEmpId());
        return msg;
    }
}
