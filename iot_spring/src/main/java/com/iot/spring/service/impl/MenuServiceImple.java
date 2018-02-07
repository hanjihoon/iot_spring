package com.iot.spring.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iot.spring.dao.MenuDAO;
import com.iot.spring.service.MenuService;
import com.iot.spring.vo.Menu;

@Service("menu.service")
public class MenuServiceImple implements MenuService {
	@Autowired
	MenuDAO mdao;
	
	@Override
	public List<Menu> getSelectMenuList() {
		List<Menu> menuList = mdao.selectMenuList();
		return menuList;
	}

}
