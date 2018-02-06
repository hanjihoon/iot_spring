package com.iot.spring.service;

import java.util.List;

import com.iot.spring.vo.User;

public interface UserService {

	public List<User> getSelectUserList();
	public User getUserOne();
	public int getInsertUser(User u);
	public int getDeleteUser(int userNo);
	public int getUpdateUser(User u);
}
