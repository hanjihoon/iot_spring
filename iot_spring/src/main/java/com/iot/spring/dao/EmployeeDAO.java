package com.iot.spring.dao;

import java.util.List;

import com.iot.spring.vo.EmployeeVo;

public interface EmployeeDAO {
	public List<EmployeeVo> selectEmployeeList();
	public EmployeeVo selectEmployeeOne();
	public int insertEmployee(EmployeeVo e);
	public int deleteEmployee(int emNo);
	public int updateEmployee(EmployeeVo e);
}
