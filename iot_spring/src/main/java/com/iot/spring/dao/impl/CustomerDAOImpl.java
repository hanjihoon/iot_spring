package com.iot.spring.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionException;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.iot.spring.dao.CustomerDAO;
import com.iot.spring.vo.Customer;

@Repository("customer.dao")
public class CustomerDAOImpl implements CustomerDAO{
	@Autowired
	SqlSessionFactory ssf;
	
	public void printDoc() {
		System.out.println("CustomerDAOImpl 테스트");
	}
	public CustomerDAOImpl() {}
	@Override
	public List<Customer> getCustomerList(String check) {
		List<Customer> ctList = null;
		try (SqlSession ss = ssf.openSession()) {
			Map<String, String> map = new HashMap<String, String>();
			map.put("str", check);
			ctList = ss.selectList("customer.getCustomerList", map);
		} catch (SqlSessionException e) {

		}
		return ctList;
	}

	@Override
	public List<Customer> selectCustomer(String searchStr, String selectType) {
		List<Customer> ctList = null;
		try (SqlSession ss = ssf.openSession()) {
			Map<String, String> map = new HashMap<String, String>();
			map.put("searchStr", searchStr);
			map.put("selectType", selectType);
			ctList = ss.selectList("customer.selectCustomer", map);
		} catch (SqlSessionException e) {
		}
		return ctList;
	}

	@Override
	public int insertCustomer(Customer ct) {
		int result = 0;
		System.out.println(ct.getCountry());
		try (SqlSession ss = ssf.openSession(true)) {
			result = ss.insert("customer.insertCustomer", ct);
		} catch (SqlSessionException e) {

		}
		return result;
	}

	@Override
	public int updateCustomer(Customer ct) {
		int result = 0;

		try (SqlSession ss = ssf.openSession(true)) {
			result = ss.update("customer.updateCustomer", ct);
		} catch (SqlSessionException e) {

		}
		return result;
	}

	@Override
	public int deleteCustomer(int ctNo) {

		int result = 0;

		try (SqlSession ss = ssf.openSession(true)) {
			result = ss.delete("customer.deleteCustomer", ctNo);
		} catch (SqlSessionException e) {

		}
		return result;
	}

}