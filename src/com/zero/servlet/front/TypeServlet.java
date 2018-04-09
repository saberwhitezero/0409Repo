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

import net.sf.json.JSONArray;

/**
 * Servlet implementation class TypeServlet
 */
@WebServlet(urlPatterns="/TypeServlet")
public class TypeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		String sql = "SELECT * FROM u_idle_info WHERE fk_idletype = 1";
		List<Map<String, Object>> list = new BaseDao().executeQuery(sql);
		String str = JSONArray.fromObject(list).toString();
		response.getWriter().write(str);
	}
}
