package com.zero.service;

import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zero.demo.BaseDao;

public class UserService{
	BaseDao dao = new BaseDao();
	public List<Map<String, Object>> queryUser(){
		String sql = "SELECT * FROM u_idle_user";
		List<Map<String, Object>> list = dao.executeQuery(sql);
		return list;
	}
	public List<Map<String,Object>> querylikeUser(HttpServletRequest request, HttpServletResponse response){
		try {
			request.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String select = request.getParameter("select");
		String sql = "SELECT * FROM u_idle_user WHERE u_state LIKE '%"+select+"%' OR u_province LIKE '%"+select+"%'";
		List<Map<String, Object>> list = dao.executeQuery(sql);
		return list;
	}
	public List<Map<String,Object>> querytotal(){
		String sql = "SELECT u_province,COUNT(u_province) as statistics FROM u_idle_user GROUP BY u_province";
		List<Map<String, Object>> list = dao.executeQuery(sql);
		return list;
	}
}
