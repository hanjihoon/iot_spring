package com.iot.spring.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.codehaus.jackson.map.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.iot.spring.service.ConnectionService;
import com.iot.spring.vo.ColumnInfoVo;
import com.iot.spring.vo.ConnectionInfoVo;
import com.iot.spring.vo.TableVo;

@Controller
@RequestMapping("/connection")
public class ConnectionController {
	private static final Logger log = LoggerFactory.getLogger(ConnectionController.class);
	@Autowired
	ConnectionService cs;

	@Autowired
	ObjectMapper om;

	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public @ResponseBody Map<String, Object> insertConnectionInfo(@RequestParam Map<String, Object> map,
			HttpServletRequest res) {
		ConnectionInfoVo ci = om.convertValue(map, ConnectionInfoVo.class);
		log.info("ConneciontInfoVo=>{}", ci);
		cs.getInsertConnectionInfo(map, ci);
		return map;
	}

	@RequestMapping(value = "/db_list", method = RequestMethod.GET)
	public @ResponseBody Map<String, Object> getDatabaseList(@RequestParam Map<String, Object> map,
			HttpServletRequest res) {
		List<Map<String, Object>> dbList = cs.getDatabaseList();
		map.put("dbList", dbList);
		return map;
	}

	@RequestMapping(value = "/tables/{dbName}", method = RequestMethod.GET)
	public @ResponseBody Map<String, Object> getTableList(@PathVariable("dbName") String dbName,
			@RequestParam Map<String, Object> map, HttpServletRequest res) {
		List<TableVo> tableList = cs.getTableList(dbName);
		map.put("tableList", tableList);
		return map;
	}

	@RequestMapping(value = "/columns/{dbName}/{tbName}", method = RequestMethod.GET)
	public @ResponseBody Map<String, Object> getColumnList(@PathVariable("dbName") String dbName,
			@PathVariable("tbName") String tbName, @RequestParam Map<String, Object> map, HttpServletRequest res) {
		Map<String,String> dTName = new HashMap<String,String>();
		dTName.put("dbName",dbName);
		dTName.put("tbName",tbName);
		List<ColumnInfoVo> colList = cs.getColumnList(dTName);
		map.put("colList", colList);
		return map;
	}
}
