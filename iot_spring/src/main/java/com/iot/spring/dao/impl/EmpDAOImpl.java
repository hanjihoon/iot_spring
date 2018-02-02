package com.iot.spring.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.iot.spring.dao.EmpDAO;
import com.iot.spring.vo.Emp;

@Repository
public class EmpDAOImpl implements EmpDAO {
	@Autowired
	private SqlSessionTemplate sst;

	@Override
	public List<Emp> selectEmpList() {
		List<Emp> empList = new ArrayList<Emp>();
		empList = sst.selectList("emp.selectEmpList");
		return empList;
	}

	@Override
	public Emp selectEmpOne() {

		return null;
	}

	@Override
	public int insertEmp(Emp e) {
		int result = sst.insert("emp.insertEmp", e);
		return result;
	}

	@Override
	public int deleteEmp(int empNo) {

		return 0;
	}

	@Override
	public int updateEmp(Emp e) {

		return 0;
	}

}
