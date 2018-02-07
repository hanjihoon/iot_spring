package com.iot.spring.dao;

import java.util.List;
import java.util.Map;

import com.iot.spring.vo.ConnectionInfoVo;

public interface ConnectionDAO {
	public List<ConnectionInfoVo> selectConnectionInfoList();
	public List<ConnectionInfoVo> selectConnectionInfoOne(String searchStr, String selectType);
	public int insertConnectionInfo(ConnectionInfoVo ci);
	public int updateConnectionInfo(ConnectionInfoVo ci);
	public int deleteConnectionInfo(int ciNo);
}
