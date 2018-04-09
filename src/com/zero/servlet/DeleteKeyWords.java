package com.zero.servlet;

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
 * Servlet implementation class DeleteKeyWords
 */
@WebServlet(urlPatterns = "/DeleteKeyWords")
public class DeleteKeyWords extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		String id = request.getParameter("id");
		String sql = "DELETE FROM u_keywords WHERE id = " + id;
		int n = new BaseDao().executeUpdate(sql);
		if (n > 0) {
			String sqlquery = "SELECT * FROM u_keywords";
			List<Map<String, Object>> list = new BaseDao().executeQuery(sqlquery);
			String str = JSONArray.fromObject(list).toString();
			response.getWriter().write(str);
		}

	}
}
