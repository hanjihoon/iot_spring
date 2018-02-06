package com.iot.spring.dao;

import java.util.List;

import com.iot.spring.vo.Customer;

public interface CustomerDAO {
	public List<Customer> getCustomerList(String check);
	public List<Customer> selectCustomer(String searchStr, String selectType);
	public int insertCustomer(Customer ct);
	public int updateCustomer(Customer ct);
	public int deleteCustomer(int ctNo);
}
