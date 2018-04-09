package com.zero.servlet;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zero.service.idleService;

/**
 * Servlet implementation class QueryIdle
 */
@WebServlet(urlPatterns="/QueryIdle")
public class QueryIdle extends HttpServlet {
	private static final long serialVersionUID = 1L;
	idleService idle = new idleService();
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	List<Map<String, Object>> list = idle.queryIdle();
	request.setAttribute("list", list);
	request.getRequestDispatcher("module_idle/idlelist.jsp").forward(request, response);
	}

}
