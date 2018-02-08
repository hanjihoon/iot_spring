package com.iot.spring.service;

import java.util.List;

import com.iot.spring.vo.EmployeeVo;

public interface EmployeeService {

	public List<EmployeeVo> getSelectEmployeeList();
	public EmployeeVo getEmployeeOne(int emNo);
	public int getInsertEmployee(EmployeeVo e);
	public int getDeleteEmployee(int emNo);
	public int getUpdateEmployee(EmployeeVo e);
}
