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
 * Servlet implementation class KeyWordServlet
 */
@WebServlet(urlPatterns="/KeyWordServlet")
public class KeyWordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		String sql = "SELECT * FROM u_keywords";
		List<Map<String, Object>> list = new BaseDao().executeQuery(sql);
		String str = JSONArray.fromObject(list).toString();
		response.getWriter().write(str);
	}

}
