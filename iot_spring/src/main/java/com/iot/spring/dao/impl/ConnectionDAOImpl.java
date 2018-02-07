package com.iot.spring.dao.impl;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.iot.spring.dao.ConnectionDAO;
import com.iot.spring.vo.ConnectionInfoVo;

@Repository("connection.dao")
public class ConnectionDAOImpl implements ConnectionDAO {
	
	@Autowired
	SqlSessionTemplate sst;
	
	@Override
	public List<ConnectionInfoVo> selectConnectionInfoList() {
		List<ConnectionInfoVo> conList = sst.selectList("con.selectConnectionInfo");
		return conList;
	}

	@Override
	public List<ConnectionInfoVo> selectConnectionInfoOne(String searchStr, String selectType) {
		
		return null;
	}

	@Override
	public int insertConnectionInfo(ConnectionInfoVo ci) {
		int result = 0;
		result = sst.insert("con.insertConnectionInfo", ci);
		return result;
	}

	@Override
	public int updateConnectionInfo(ConnectionInfoVo ci) {
		
		return 0;
	}

	@Override
	public int deleteConnectionInfo(int ciNo) {
		
		return 0;
	}

}
