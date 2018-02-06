package com.iot.spring.dao;

import java.util.List;

import com.iot.spring.vo.Emp;

public interface EmpDAO {
	public List<Emp> selectEmpList();
	public Emp selectEmpOne(int empNo);
	public int insertEmp(Emp e);
	public int deleteEmp(int empNo);
	public int updateEmp(Emp e);
}
