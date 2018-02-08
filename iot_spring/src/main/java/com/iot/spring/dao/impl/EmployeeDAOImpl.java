package com.iot.spring.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.iot.spring.dao.EmployeeDAO;
import com.iot.spring.vo.EmployeeVo;

@Repository("employee.dao")
public class EmployeeDAOImpl implements EmployeeDAO {
	@Autowired
	private SqlSessionTemplate sst;

	@Override
	public List<EmployeeVo> selectEmployeeList() {
		List<EmployeeVo> employeeList = new ArrayList<EmployeeVo>();
		employeeList = sst.selectList("em.selectEmployeeList");
		return employeeList;
	}

	@Override
	public EmployeeVo selectEmployeeOne() {
		return null;
	}

	@Override
	public int insertEmployee(EmployeeVo e) {
		return 0;
	}

	@Override
	public int deleteEmployee(int emNo) {
		return 0;
	}

	@Override
	public int updateEmployee(EmployeeVo e) {
		return 0;
	}

}
