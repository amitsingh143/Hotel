package com.example.sb.Controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.event.Level;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.sb.entities.Employee;
import com.example.sb.entities.SearchRequest;
import com.example.sb.exception.EmployeeNotFoundException;
import com.example.sb.exception.EmployeeServiceException;
import com.example.sb.services.EmpService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("emp")
public class Controller {
	
	private static final Logger logger = LoggerFactory.getLogger(Controller.class);

	@Autowired
	EmpService empService;
//
//    public Controller(EmpService empService) {
//        super();
//        this.empService = empService;
//    }

	@PostMapping("/add")
	public ResponseEntity<String> addEmployee(@Valid @RequestBody Employee e) {
	    try {
	        Employee addedEmployee = empService.addEmployee(e);
	        String message = "Employee added successfully with ID: " + addedEmployee.getEmpId();
	        return ResponseEntity.status(HttpStatus.CREATED).body(message);
	    } catch (Exception ex) {
	        logger.error("Error occurred while adding employee.", ex);
	        throw new EmployeeServiceException("Error adding employee.", ex);
	    }
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

	@PostMapping("/search")
	public ResponseEntity<Employee> searchEmployee(@RequestBody SearchRequest searchRequest) {
		// logger.log(Level.INFO, "API hitting from controller to searchFlights");

		ResponseEntity<Employee> result = empService.searchEmployee(searchRequest);
		return result;

	}

	// Controller.java
	@PostMapping("/getById")
	public Employee getEmpInfoById(@RequestBody Employee e) {
		Employee result = empService.getEmpInfo(e);
		return result;
	}

	@GetMapping("/getAll")
	public List<Employee> getAllEmpInfo() {
		List<Employee> empListObj = empService.getAllEmpInfo();
		return empListObj;
	}

	@PostMapping("/update")
	public String updateEmp( @Valid @RequestBody Employee e) {
		String msg = empService.updateEmp(e);
		return msg;
	}

	@PostMapping("/delete")
	public String deleteEmp(@RequestBody Employee e) {
		String msg = empService.deleteEmp(e.getEmpId());
		return msg;
	}
}
