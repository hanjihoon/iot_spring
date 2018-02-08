package com.iot.spring.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iot.spring.dao.ConnectionDAO;
import com.iot.spring.service.ConnectionService;
import com.iot.spring.vo.ColumnInfoVo;
import com.iot.spring.vo.ConnectionInfoVo;
import com.iot.spring.vo.TableVo;

@Service("connection.service")
public class ConnectionServiceImpl implements ConnectionService {

	@Autowired
	ConnectionDAO cdao;


	@Override
	public List<ConnectionInfoVo> getConnectionInfoList() {
		List<ConnectionInfoVo> conList = cdao.selectConnectionInfoList();
		return conList;
	}

	@Override
	public List<ConnectionInfoVo> getConnectionInfoOne(String searchStr, String selectType) {
		
		return null;
	}

	@Override
	public void getInsertConnectionInfo(Map<String, Object> rMap, ConnectionInfoVo ci) {
		int result = 0;
		result  = cdao.insertConnectionInfo(ci);
		if(result==1) {
			rMap.put("msg", "추가 성공!");
		}else {
			rMap.put("msg","추가 실패!");
		}
	}

	@Override
	public void getUpdateConnectionInfo(ConnectionInfoVo ci) {
		
	}

	@Override
	public void getDeleteConnectionInfo(int ciNo) {
	}

	@Override
	public List<Map<String, Object>> getDatabaseList() {
		List<Map<String, Object>> dbList = cdao.selectBatabaseList();
		int idx = 0;
		for(Map<String,Object> mDb : dbList) {
			mDb.put("id", ++idx);
			mDb.put("text", mDb.get("Database"));
			mDb.put("items", new Object[] {});
			
		}
		return dbList;
	}

	@Override
	public List<TableVo> getTableList(String dbName) {
		
		return cdao.selectTableList(dbName);
	}

	@Override
	public List<ColumnInfoVo> getColumnList(Map dTName) {
		
		return cdao.selectColumnList(dTName);
	}

}
