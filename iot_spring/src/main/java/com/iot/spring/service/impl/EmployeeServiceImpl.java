package com.iot.spring.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iot.spring.dao.EmployeeDAO;
import com.iot.spring.service.EmployeeService;
import com.iot.spring.vo.EmployeeVo;

@Service("employee.service")
public class EmployeeServiceImpl implements EmployeeService {
	@Autowired
	EmployeeDAO edao;

	@Override
	public List<EmployeeVo> getSelectEmployeeList() {
		List<EmployeeVo> employeeList = edao.selectEmployeeList();
		return employeeList;
	}

	@Override
	public EmployeeVo getEmployeeOne(int emNo) {
		EmployeeVo em = edao.selectEmployeeOne(emNo);
		return em;
	}

	@Override
	public int getInsertEmployee(EmployeeVo u) {
		int result = 0;
		result = edao.insertEmployee(u);
		return result;
	}

	@Override
	public int getDeleteEmployee(int emNo) {
		int result = 0;
		result = edao.deleteEmployee(emNo);
		return result;
	}

	@Override
	public int getUpdateEmployee(EmployeeVo u) {
		int result = 0;
		result = edao.updateEmployee(u);
		return result;
	}

}
