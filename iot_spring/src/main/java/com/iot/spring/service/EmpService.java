package com.iot.spring.service;

import java.util.List;

import com.iot.spring.vo.Emp;

public interface EmpService {
	public List<Emp> getSelectEmpList();
	public Emp getEmpOne(int empNo);
	public int getInsertEmp(Emp e);
	public int getDeleteEmp(int empNo);
	public int getUpdateEmp(Emp e);

}
