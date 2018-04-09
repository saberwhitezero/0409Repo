package com.zero.servlet;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zero.service.AdminService;
import com.zero.demo.BaseDao;

/**
 * Servlet implementation class UpdateAdmin
 */
@WebServlet(urlPatterns="/UpdateAdmin")
public class UpdateAdmin extends HttpServlet {
	private static final long serialVersionUID = 1L;
	AdminService admin = new AdminService();
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int n = admin.updateAdmin(request, response);
		if(n>0){
			String account = request.getParameter("account");
			String sql = "SELECT * FROM u_sys_admin where account = '"+account+"'";
			Map<String, Object> map = new BaseDao().executeQuery(sql).get(0);
			request.getSession().setAttribute("map", map);
			request.getRequestDispatcher("module_geren/gerenxinxi.jsp").forward(request, response);
		}
	}
}
