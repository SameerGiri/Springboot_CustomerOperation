package com.jspider.customer.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jspider.customer.pojo.CustomerPojo;
import com.jspider.customer.response.CustomerResponse;
import com.jspider.customer.service.CustomerService;

@Controller
public class CustomerController {
	@Autowired

	private CustomerService service;

	@PostMapping("/add")
	public ResponseEntity<CustomerResponse> addCustomer(@RequestBody CustomerPojo pojo) {
		CustomerPojo customer = service.addCustomer(pojo);
		if (customer != null) {
			return new ResponseEntity<CustomerResponse>(new CustomerResponse("Customer is added", pojo, null),
					HttpStatus.ACCEPTED);
		}
		return new ResponseEntity<CustomerResponse>(new CustomerResponse(" Customer is not added", null, null),
				HttpStatus.NOT_ACCEPTABLE);
	}

	@GetMapping("/searchByName/{name}")
	public ResponseEntity<CustomerResponse> searchCustomer(@PathVariable String name) {
		CustomerPojo customer = service.searchCustomer(name);
		if (customer != null) {
			return new ResponseEntity<CustomerResponse>(new CustomerResponse("Customer Data is found", customer, null),
					HttpStatus.FOUND);
		}
		return new ResponseEntity<CustomerResponse>(new CustomerResponse(" Customer Data is not found", null, null),
				HttpStatus.NOT_FOUND);
	}

//	@GetMapping("/search/{id}")
//	public ResponseEntity<CustomerResponse> searchCustomerid(@PathVariable int id) {
//		CustomerPojo customer = service.searchCustomer(id);
//		if (customer != null) {
//			return new ResponseEntity<CustomerResponse>(
//					new CustomerResponse("Customer data is found at id no", customer, null), HttpStatus.FOUND);
//		}
//		return new ResponseEntity<CustomerResponse>(new CustomerResponse("Data is not present in table", null, null),
//				HttpStatus.NOT_FOUND);
//	}
	@GetMapping("/searchAll")
	public ResponseEntity<CustomerResponse> searchAll() {
		List<CustomerPojo> customers = service.searchAll();
		if (customers != null) {
			return new ResponseEntity<CustomerResponse>(new CustomerResponse(" Data is found", null, customers),
					HttpStatus.FOUND);
		}
		return new ResponseEntity<CustomerResponse>(new CustomerResponse(" List not present in table", null, null),
				HttpStatus.NOT_FOUND);
	}

}
