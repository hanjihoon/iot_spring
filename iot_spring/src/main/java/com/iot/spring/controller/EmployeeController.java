package com.iot.spring.controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.iot.spring.service.EmployeeService;
import com.iot.spring.vo.EmployeeVo;

@Controller
@RequestMapping("/employee")
public class EmployeeController {
	private static final Logger log = LoggerFactory.getLogger(UrlController.class);
	
	@Autowired
	EmployeeService es;
	
	@RequestMapping(value = "/getlist", method = RequestMethod.GET)
	@ResponseBody
	public List<EmployeeVo> getEmployeeList(Model m,HttpServletResponse res) {
		return es.getSelectEmployeeList();
	}
}
