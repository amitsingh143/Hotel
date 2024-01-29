package com.example.sb.Controller;

import java.util.List;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.sb.entities.Employee;
import com.example.sb.services.EmpService;

@RestController
@RequestMapping("emp")
public class Controller {
	
	EmpService empService;

	public Controller(EmpService empService) {
		super();
		this.empService = empService;
	}
	@PostMapping
	public String addEmployee(@RequestBody Employee e) {
		String msg=empService.addEmployee(e);
		return msg;
	}
	
	@GetMapping(value="{empId}")
	public Employee getEmpInfo(@PathVariable String empId) {
		Employee e=empService.getEmpInfo(empId);
		return e;
		
	}
	@GetMapping
	public List<Employee> getAllEmpInfo() {
		List<Employee> empListObj= empService.getAllEmpInfo()
;		return empListObj;
		
	}
	@PutMapping
	public String updateEmp(@RequestBody Employee e) {
		String msg=empService.updateEmp(e);
		return msg;
	}
	@DeleteMapping(value="{empId}")
	public String deleteEmp(@PathVariable String empId) {
		String msg=empService.deleteEmp(empId);
		return msg;
	}

}
