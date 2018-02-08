package com.iot.spring.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.iot.spring.service.CustomerService;
import com.iot.spring.vo.EmployeeVo;

@Service("cutomer.service")
public class CustomerServiceImpl implements CustomerService {

	@Override
	public List<EmployeeVo> getCustomerList() {
		List<EmployeeVo> CustomerList = new ArrayList<EmployeeVo>();
		return CustomerList;
	}
}
