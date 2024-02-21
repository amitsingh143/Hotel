package com.hotel.bookings.service;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.hotel.bookings.entity.Customer;
import com.hotel.bookings.exception.CustomerNotFoundException;
import com.hotel.bookings.repository.CustomerRepository;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerRepository customerRepository;

	@Override
	public Customer addCustomer(Customer customer) {
		// Add any validation or business logic here
		System.out.println("customer data is saved");
		return customerRepository.save(customer);
	}


	@Override
	public Customer editCustomer(int customerId, Customer customer) {
		// Add validation and update logic here
		Customer existingCustomer = customerRepository.findById(customerId)
				.orElseThrow(() -> new CustomerNotFoundException("Customer not found"));
		// Update existingCustomer with customerDetails
		existingCustomer.setFirstName(customer.getFirstName());
		existingCustomer.setLastName(customer.getLastName());
		// Update other fields as needed
		return customerRepository.save(existingCustomer);
	}
	
//	@Override
//	public String addCustomer(Customer c) {
//		cmr.save(c);
//		return "Customer is added";
//	}

	@Override
	public String editCustomer(Customer c) {
		customerRepository.save(c);
		return "Customer details are edited";
	}
	
	@Override
	public void validateCustomerExists(Customer customer) {
	    if (customer == null || !customerRepository.existsById(customer.getCustomerId())) {
	        throw new CustomerNotFoundException("Customer not found");
	    }
	}

	@Override
	public Customer getCustomer(Customer customer) {
	    // Assuming the provided customer object has the ID of the customer you want to retrieve
	    int customerId = customer.getCustomerId();

	    // Retrieve the customer from the repository using its ID
	    return customerRepository.findById(customerId)
	            .orElseThrow(() -> new CustomerNotFoundException("Customer not found with ID: " + customerId));
	}



	
}
