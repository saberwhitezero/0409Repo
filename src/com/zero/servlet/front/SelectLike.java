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
 * Servlet implementation class SelectLike
 */
@WebServlet("/SelectLike")
public class SelectLike extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String val = request.getParameter("val");
		String sql = "SELECT * FROM u_idle_info where name like '%"+val+"%'";
		List<Map<String, Object>> list = new BaseDao().executeQuery(sql);
		request.setAttribute("list", list);
		request.getRequestDispatcher("front/selectlike.jsp").forward(request, response);
	}
}
