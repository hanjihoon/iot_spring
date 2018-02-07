package com.iot.spring.service;

import java.util.List;
import java.util.Map;

import com.iot.spring.vo.ConnectionInfoVo;

public interface ConnectionService {
	public List<ConnectionInfoVo> getConnectionInfoList();
	public List<ConnectionInfoVo> getConnectionInfoOne(String searchStr, String selectType);
	public void getInsertConnectionInfo(Map<String,Object> rMap,ConnectionInfoVo ci);
	public void getUpdateConnectionInfo(ConnectionInfoVo ci);
	public void getDeleteConnectionInfo(int ciNo);
}
