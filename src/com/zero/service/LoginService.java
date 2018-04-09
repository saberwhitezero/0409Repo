package com.zero.service;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.zero.demo.BaseDao;

public class LoginService {
	BaseDao dao = new BaseDao();

	public Map<String, Object> login(HttpServletRequest request, HttpServletResponse response) {
		try {
			request.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String account = request.getParameter("account");
		String password = request.getParameter("password");
		String sql = "SELECT * FROM u_sys_admin where account = '" + account + "' and password = '" + password + "'";
		List<Map<String, Object>> list = dao.executeQuery(sql);
		if (list != null && list.size()>0) {
			return list.get(0);
		} else{
			return null;
		}
	}
	public void exitLogin(HttpServletRequest request, HttpServletResponse response){
		HttpSession session= request.getSession();
		session.invalidate();
		try {
			response.sendRedirect("login.jsp");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
