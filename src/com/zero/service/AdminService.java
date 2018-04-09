package com.zero.service;

import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zero.demo.BaseDao;

public class AdminService {
	BaseDao dao = new BaseDao();
	public int updateAdmin(HttpServletRequest request, HttpServletResponse response){
		try {
			request.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String account = request.getParameter("account");
		String phonenum = request.getParameter("phonenum");
		String address = request.getParameter("address");
		String mailbox = request.getParameter("mailbox");
		String sql = "UPDATE u_sys_admin SET phonenum='"+phonenum+"',address='"+address+"',mailbox='"+mailbox+"' where account = '"+account+"'";
	    int n = dao.executeUpdate(sql);
	    return n;
	}
}
