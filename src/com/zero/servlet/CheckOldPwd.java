package com.zero.servlet;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CheckOldPwd
 */
@WebServlet(urlPatterns = "/CheckOldPwd")
public class CheckOldPwd extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		String oldpwd = request.getParameter("oldpwd");
		Map<String, Object> map = (Map<String,Object>) request.getSession().getAttribute("map");
		String pwd = map.get("password") + "";
		String msg = "";
		if (oldpwd.equals(pwd)) {
			msg = "ok";
		} else {
			msg = "error";
		}
		response.getWriter().write(msg);
	}
}
