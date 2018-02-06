package com.iot.spring.dao;

import java.util.List;

import com.iot.spring.vo.User;

public interface UserDAO {
	public List<User> selectUserList();
	public User selectUserOne();
	public int insertUser(User e);
	public int deleteUser(int userNo);
	public int updateUser(User e);
}
