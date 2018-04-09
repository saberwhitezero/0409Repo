package com.zero.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zero.service.idleService;

/**
 * Servlet implementation class DeleteIdle
 */
@WebServlet(urlPatterns="/DeleteIdle")
public class DeleteIdle extends HttpServlet {
	private static final long serialVersionUID = 1L;
	idleService idle = new idleService();
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int n = idle.delete(request, response);
		if(n>0){
			request.getRequestDispatcher("QueryIdle").forward(request, response);
		}
	}

}
