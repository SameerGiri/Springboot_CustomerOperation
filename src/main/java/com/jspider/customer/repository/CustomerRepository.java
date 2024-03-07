package com.jspider.customer.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jspider.customer.pojo.CustomerPojo;

public interface CustomerRepository extends JpaRepository<CustomerPojo, Integer> {

	CustomerPojo findByName(String name);

	CustomerPojo findByAddress(String address);
  
	
	
}
