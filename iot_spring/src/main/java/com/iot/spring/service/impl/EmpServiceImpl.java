package com.iot.spring.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iot.spring.dao.EmpDAO;
import com.iot.spring.service.EmpService;
import com.iot.spring.vo.Emp;

@Service("emp.service")
public class EmpServiceImpl implements EmpService {
	
	@Autowired
	EmpDAO edao;
	
	@Override
	public List<Emp> getSelectEmpList() {
		List<Emp> empList = new ArrayList<Emp>();
		empList = edao.selectEmpList();
		return empList;
	}

	@Override
	public Emp getEmpOne(int empNo) {
		Emp e = edao.selectEmpOne(empNo);
		return e;
	}

	@Override
	public int getInsertEmp(Emp e) {
		
		return edao.insertEmp(e);
	}

	@Override
	public int getDeleteEmp(int empNo) {
		
		return 0;
	}

	@Override
	public int getUpdateEmp(Emp e) {
		
		return 0;
	}

}
