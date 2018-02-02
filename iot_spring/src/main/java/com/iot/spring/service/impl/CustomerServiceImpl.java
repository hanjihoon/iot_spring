package com.iot.spring.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.iot.spring.User;
import com.iot.spring.service.CustomerService;

@Service("cutomer.service")
public class CustomerServiceImpl implements CustomerService {

	@Override
	public List<User> getCustomerList() {
		List<User> list = new ArrayList<User>();
		User u1 = new User();
		u1.setName("최재열");
		u1.setAge(50);
		u1.setAddress("안산");
		list.add(u1);
		User u2 = new User();
		u2.setName("한지훈");
		u2.setAge(22);
		u2.setAddress("수원");
		list.add(u2);
		return list;
	}
}
