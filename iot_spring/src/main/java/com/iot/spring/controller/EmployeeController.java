package com.iot.spring.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.codehaus.jackson.map.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.iot.spring.service.EmployeeService;
import com.iot.spring.vo.EmployeeVo;

@Controller
@RequestMapping("/employee")
public class EmployeeController {
	private static final Logger log = LoggerFactory.getLogger(UrlController.class);

	@Autowired
	EmployeeService es;

	@Autowired
	ObjectMapper om;

	@RequestMapping(value = "/getlist", method = RequestMethod.GET)
	@ResponseBody
	public List<EmployeeVo> getEmployeeList() {
		List<EmployeeVo> emList = es.getSelectEmployeeList();
		return emList;
	}

	@RequestMapping(value = "/view", method = RequestMethod.GET)
	@ResponseBody
	public EmployeeVo getEmployeeOne(@RequestParam("emNo") int emNo) {
		EmployeeVo em = es.getEmployeeOne(emNo);
		return em;
	}

	@RequestMapping(value = "/insert", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, String> getInsertEmployee(@RequestParam Map<String, Object> map) {
		EmployeeVo em = om.convertValue(map, EmployeeVo.class);
		int result = 0;
		result = es.getInsertEmployee(em);
		Map<String,String> resultMsg = new HashMap<String,String>();
		if(result==1) {
			resultMsg.put("msg", "추가 성공!");
		}else {
			resultMsg.put("msg", "실패!");
		}
		return resultMsg;
	}

	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, String> getDeleteEmployee(@RequestParam("emNo") int emNo) {
		int result = 0;
		result = es.getDeleteEmployee(emNo);
		Map<String,String> resultMsg = new HashMap<String,String>();
		if(result==1) {
			resultMsg.put("msg", "추가 성공!");
		}else {
			resultMsg.put("msg", "실패!");
		}
		return resultMsg;
	}

	@RequestMapping(value = "/update", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, String> getUpdateEmployee(@RequestParam Map<String, Object> map) {
		EmployeeVo em = om.convertValue(map, EmployeeVo.class);
		int result = 0;
		result = es.getUpdateEmployee(em);
		Map<String,String> resultMsg = new HashMap<String,String>();
		if(result==1) {
			resultMsg.put("msg", "추가 성공!");
		}else {
			resultMsg.put("msg", "실패!");
		}
		return resultMsg;
	}
}
