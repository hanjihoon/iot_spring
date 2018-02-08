package com.iot.spring.dao;

import java.util.List;
import java.util.Map;

import com.iot.spring.vo.ColumnInfoVo;
import com.iot.spring.vo.ConnectionInfoVo;
import com.iot.spring.vo.TableVo;

public interface ConnectionDAO {
	public List<ConnectionInfoVo> selectConnectionInfoList();
	public List<ConnectionInfoVo> selectConnectionInfoOne(String searchStr, String selectType);
	public int insertConnectionInfo(ConnectionInfoVo ci);
	public int updateConnectionInfo(ConnectionInfoVo ci);
	public int deleteConnectionInfo(int ciNo);
	public List<Map<String,Object>> selectBatabaseList();
	public List<TableVo> selectTableList(String dbName);
	public List<ColumnInfoVo> selectColumnList(Map dTName);
}
