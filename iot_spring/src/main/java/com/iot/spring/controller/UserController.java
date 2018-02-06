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

import com.iot.spring.service.UserService;
import com.iot.spring.vo.User;

@Controller
@RequestMapping("/user")
public class UserController {
	private static final Logger log = LoggerFactory.getLogger(UrlController.class);
	
	@Autowired
	UserService us;
	
	@RequestMapping(value = "/getlist", method = RequestMethod.GET)
	@ResponseBody
	public List<User> getUserList(Model m,HttpServletResponse res) {
		return us.getSelectUserList();
	}
}
