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
		List<EmployeeVo> employeeList = new ArrayList<EmployeeVo>();
		employeeList = edao.selectEmployeeList();
		return employeeList;
	}

	@Override
	public EmployeeVo getEmployeeOne() {
		return null;
	}

	@Override
	public int getInsertEmployee(EmployeeVo u) {
		return 0;
	}

	@Override
	public int getDeleteEmployee(int emNo) {
		return 0;
	}

	@Override
	public int getUpdateEmployee(EmployeeVo u) {
		return 0;
	}

}
