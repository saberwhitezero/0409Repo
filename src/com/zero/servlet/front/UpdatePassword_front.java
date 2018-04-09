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
 * Servlet implementation class UpdatePassword_front
 */
@WebServlet(urlPatterns="/UpdatePassword_front")
public class UpdatePassword_front extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pwd = request.getParameter("npwd");
		Map<String,Object> map = (Map<String, Object>) request.getSession().getAttribute("list");
		String id = map.get("u_id")+"";
		String sql = "UPDATE u_idle_user set u_password = '"+pwd+"' where u_id = '"+id+"'";
		int n = new BaseDao().executeUpdate(sql);
		if(n>0){
			response.getWriter().write("ok");
		} else {
			response.getWriter().write("error");
		}
	}
}
