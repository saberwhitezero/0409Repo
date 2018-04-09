package com.zero.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zero.service.idleService;
/**
 * Servlet implementation class AddIdle
 */
@WebServlet(urlPatterns="/AddIdle")
@MultipartConfig
public class AddIdle extends HttpServlet {
	private static final long serialVersionUID = 1L;
	idleService idle = new idleService();
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int n = idle.add(request, response);
		if(n>0){
			System.out.println("添加成功");
			request.getRequestDispatcher("QueryIdle").forward(request, response);
		} else {
			System.out.println("添加失败");
		}
	}
}
