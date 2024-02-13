package com.hotel.bookings.service;

import com.hotel.bookings.entity.Customer;

public interface CustomerService {

	Customer addCustomer(Customer customer);

	Customer editCustomer(int customerId, Customer customer);

	void validateCustomerExists(Customer customer);

	Customer getCustomer(Customer customer);

	String editCustomer(Customer c);
}
