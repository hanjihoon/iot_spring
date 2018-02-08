package com.iot.spring.service;

import java.util.List;
import java.util.Map;

import com.iot.spring.vo.ColumnInfoVo;
import com.iot.spring.vo.ConnectionInfoVo;
import com.iot.spring.vo.TableVo;

public interface ConnectionService {
	public List<ConnectionInfoVo> getConnectionInfoList();
	public List<ConnectionInfoVo> getConnectionInfoOne(String searchStr, String selectType);
	public void getInsertConnectionInfo(Map<String,Object> rMap,ConnectionInfoVo ci);
	public void getUpdateConnectionInfo(ConnectionInfoVo ci);
	public void getDeleteConnectionInfo(int ciNo);
	public List<Map<String,Object>> getDatabaseList();
	public List<TableVo> getTableList(String dbName);
	public List<ColumnInfoVo> getColumnList(Map dTName);
}
