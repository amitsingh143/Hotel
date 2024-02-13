package com.hotel.bookings.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hotel.bookings.entity.Customer;
import com.hotel.bookings.service.CustomerService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/customers")
public class CustomerController {

	@Autowired
	private CustomerService customerService;

	@PostMapping("/add")
	public ResponseEntity<Customer> addCustomer(@Valid @RequestBody Customer customer) {
		Customer savedCustomer = customerService.addCustomer(customer);
		return ResponseEntity.ok(savedCustomer);
	}

	@PostMapping("/edit/{customerId}")
	public ResponseEntity<Customer> editCustomer(@Valid @PathVariable int customerId, @RequestBody Customer customer) {
		Customer editedCustomer = customerService.editCustomer(customerId, customer);
		return ResponseEntity.ok(editedCustomer);
	}
	
//	@PostMapping("/add")
//	public String addCustomer(@RequestBody Customer c) {
//		return cms.addCustomer(c);
//	}
//	
	@PutMapping("/edit")
	public String editCustomer( @Valid @RequestBody Customer c) {
		return customerService.editCustomer(c);
	}
}
