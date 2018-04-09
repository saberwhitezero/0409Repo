package com.zero.servlet.front;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zero.demo.BaseDao;

/**
 * Servlet implementation class FinalReg
 */
@WebServlet(urlPatterns="/FinalReg")
public class FinalReg extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String password = request.getParameter("pwd");
		String phone = request.getSession().getAttribute("phone")+"";
	
		String sql = "INSERT INTO u_idle_user(u_phonenum,u_password,u_reg_datetime) VALUE ('"+phone+"','"+password+"',NOW())";
		int n = new BaseDao().executeUpdate(sql);
		if(n>0){
			//注册成功，跳转跳转到登录页面
			request.getRequestDispatcher("front/login.jsp").forward(request, response);
		}
	}
}
