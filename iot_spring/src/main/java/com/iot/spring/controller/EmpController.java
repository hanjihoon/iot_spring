package com.iot.spring.controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.iot.spring.service.EmpService;
import com.iot.spring.vo.Emp;

@Controller
@RequestMapping("/emp")
public class EmpController {
	private static final Logger log = LoggerFactory.getLogger(UrlController.class);
	@Autowired
	EmpService es;

	@RequestMapping(value = "/emp_list", method = RequestMethod.GET)
	public String goEmpList(Model m) {
		m.addAttribute("empList", es.getSelectEmpList());
		return "emp/emp_list";
	}

	@RequestMapping(value = "/getlist", method = RequestMethod.GET)
	@ResponseBody
	public List<Emp> getEmpList(Model m, HttpServletResponse res) {

		return es.getSelectEmpList();
	}

	@RequestMapping(value = "/insert", method = RequestMethod.GET)
	public String insertEmp(@Valid Emp empDTO, Errors e, Model m) {
		int result = es.getInsertEmp(empDTO);
		if (result == 1) {
			m.addAttribute("msg", "추가 성공!!");
		}
		if (e.hasErrors()) {
			log.info("error =>{}", e);
			m.addAttribute("errorMsg", e.getAllErrors());
			return "error/error";
		}

		log.info("insert result =>{}", empDTO);
		return "emp/write";
	}
}
