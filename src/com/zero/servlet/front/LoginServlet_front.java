package com.zero.servlet.front;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zero.demo.BaseDao;

/**
 * Servlet implementation class LoginServlet_front
 */
@WebServlet(urlPatterns="/LoginServlet_front")
public class LoginServlet_front extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String phonenum = request.getParameter("phonenum");
		String password = request.getParameter("password");
		String sql = "SELECT * FROM u_idle_user WHERE (u_phonenum = '"+phonenum+"' and u_password = '"+password+"') or (u_account = '"+phonenum+"' and u_password = '"+password+"')";
	 	List<Map<String, Object>> list = (List<Map<String, Object>>) new BaseDao().executeQuery(sql);
	 	if(list!=null && list.size()>0){
		 	request.getSession().setAttribute("list", list.get(0));
	 		request.getRequestDispatcher("front/index.jsp").forward(request, response);
	 	} else {
	 		request.getRequestDispatcher("front/login.jsp").forward(request, response);
	 	}
	}
}
