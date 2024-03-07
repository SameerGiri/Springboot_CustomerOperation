package com.jspider.customer.response;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.jspider.customer.pojo.CustomerPojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)

public class CustomerResponse {
	private String msg;
	private CustomerPojo pojo;
	private List<CustomerPojo> list;
}
