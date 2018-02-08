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
	public EmployeeVo selectEmployeeOne(int emNo) {
		EmployeeVo em = new EmployeeVo();
		em = sst.selectOne("em.selectEmployee", emNo);
		return em;
	}

	@Override
	public int insertEmployee(EmployeeVo e) {
		int result = 0;
		result = sst.insert("em.insertEmployee", e);
		return result;
	}

	@Override
	public int deleteEmployee(int emNo) {
		int result = 0;
		result = sst.delete("em.deleteEmployee", emNo);
		return result;
	}

	@Override
	public int updateEmployee(EmployeeVo e) {
		int result = 0;
		result = sst.update("em.updateEmployee", e);
		return result;
	}

}
