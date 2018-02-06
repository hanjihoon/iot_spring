package com.iot.spring.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.iot.spring.service.CustomerService;
import com.iot.spring.vo.User;

@Service("cutomer.service")
public class CustomerServiceImpl implements CustomerService {

	@Override
	public List<User> getCustomerList() {
		List<User> CustomerList = new ArrayList<User>();
		return CustomerList;
	}
}
