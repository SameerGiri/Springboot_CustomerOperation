package com.jspider.customer.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jspider.customer.pojo.CustomerPojo;
import com.jspider.customer.repository.CustomerRepository;

@Service
public class CustomerService {
	@Autowired
	private CustomerRepository repository;

	public CustomerPojo addCustomer(CustomerPojo pojo) {

		CustomerPojo Customer = repository.save(pojo);
		return Customer;

	}

	public CustomerPojo searchCustomer(String name) {
		CustomerPojo customer = repository.findByName(name);
		return customer;
	}

	public List<CustomerPojo> searchAll() {
		List<CustomerPojo> customers = repository.findAll();
		return customers;
	}

}
