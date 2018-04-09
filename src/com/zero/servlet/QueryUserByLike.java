package com.zero.servlet;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.zero.service.UserService;

/**
 * Servlet implementation class QueryUserByLike
 */
@WebServlet(urlPatterns="/QueryUserByLike")
public class QueryUserByLike extends HttpServlet {
	private static final long serialVersionUID = 1L;
	UserService user = new UserService();
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	  List<Map<String, Object>> list = user.querylikeUser(request, response);
	  request.setAttribute("list", list);
	  request.getRequestDispatcher("module_user/userlist.jsp").forward(request, response);
	}
}
