package com.iot.spring.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.iot.spring.dao.UserDAO;
import com.iot.spring.vo.User;

@Repository("user.dao")
public class UserDAOImpl implements UserDAO {
	@Autowired
	private SqlSessionTemplate sst;

	@Override
	public List<User> selectUserList() {
		List<User> userList = new ArrayList<User>();
		userList = sst.selectList("user.selectUserList");
		return userList;
	}

	@Override
	public User selectUserOne() {
		return null;
	}

	@Override
	public int insertUser(User u) {
		return 0;
	}

	@Override
	public int deleteUser(int userNo) {
		return 0;
	}

	@Override
	public int updateUser(User u) {
		return 0;
	}

}
