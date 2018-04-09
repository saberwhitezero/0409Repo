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
 * Servlet implementation class Perfect_front
 */
@WebServlet(urlPatterns="/Perfect_front")
public class Perfect_front extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Map<String,Object> map = (Map<String, Object>) request.getSession().getAttribute("list");
		String id = map.get("u_id")+"";
		String sql = "SELECT * FROM u_idle_user where u_id = "+id;
		Map<String, Object> map2 = new BaseDao().executeQuery(sql).get(0);
		request.getSession().setAttribute("map", map2);
		request.getRequestDispatcher("front/Perfect.jsp").forward(request, response);
	}
}
