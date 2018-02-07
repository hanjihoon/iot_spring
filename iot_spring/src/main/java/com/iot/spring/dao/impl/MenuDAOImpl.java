package com.iot.spring.dao.impl;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.iot.spring.dao.MenuDAO;
import com.iot.spring.vo.Menu;
@Repository("menu.dao")
public class MenuDAOImpl implements MenuDAO {
	
	@Autowired
	SqlSessionTemplate sst;

	@Override
	public List<Menu> selectMenuList() {
		List<Menu> menuList = sst.selectList("menu.selectMenuList");
		return menuList;
	}
	

}
