package com.zero.servlet.front;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CheckOldPwd_front
 */
@WebServlet(urlPatterns="/CheckOldPwd_front")
public class CheckOldPwd_front extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		String oldpwd = request.getParameter("oldpwd");
		Map<String,Object> map = (Map<String, Object>) request.getSession().getAttribute("list");
		String pwd = map.get("u_password")+"";
		String msg = "";
		if (oldpwd.equals(pwd)) {
			msg = "ok";
		} else {
			msg = "error";
		}
		response.getWriter().write(msg);
	}
}
