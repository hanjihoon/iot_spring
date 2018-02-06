package com.iot.spring.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iot.spring.dao.UserDAO;
import com.iot.spring.service.UserService;
import com.iot.spring.vo.User;

@Service("user.service")
public class UserServiceImpl implements UserService {
	@Autowired
	UserDAO udao;

	@Override
	public List<User> getSelectUserList() {
		List<User> userList = new ArrayList<User>();
		userList = udao.selectUserList();
		return userList;
	}

	@Override
	public User getUserOne() {
		return null;
	}

	@Override
	public int getInsertUser(User u) {
		return 0;
	}

	@Override
	public int getDeleteUser(int userNo) {
		return 0;
	}

	@Override
	public int getUpdateUser(User u) {
		return 0;
	}

}
