package com.iot.spring.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.codehaus.jackson.map.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.iot.spring.service.ConnectionService;
import com.iot.spring.vo.ConnectionInfoVo;

@Controller
@RequestMapping("/connection")
public class ConnectionController {
	private static final Logger log = LoggerFactory.getLogger(ConnectionController.class);
	@Autowired
	ConnectionService cs;
	
	@Autowired
	ObjectMapper om;

	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public @ResponseBody Map<String,Object> insertConnectionInfo(@RequestParam Map<String,Object> map, HttpServletRequest res) {
		ConnectionInfoVo ci = om.convertValue(map, ConnectionInfoVo.class);
		log.info("ConneciontInfoVo=>{}", ci);
		cs.getInsertConnectionInfo(map,ci);
		return map;
	}
}
