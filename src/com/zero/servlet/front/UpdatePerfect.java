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
 * Servlet implementation class UpdatePerfect
 */
@WebServlet("/UpdatePerfect")
public class UpdatePerfect extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		Map<String,Object> map = (Map<String, Object>) request.getSession().getAttribute("list");
		String id = map.get("u_id")+"";
		String u_nickname = request.getParameter("u_nickname");
		String u_phonenum = request.getParameter("u_phonenum");
		String u_birthday = request.getParameter("u_birthday");
		String u_province = request.getParameter("u_province");
		String u_city = request.getParameter("u_city");
		String u_district = request.getParameter("u_district");
		String sql = "UPDATE u_idle_user set u_nickname='"+u_nickname+"',u_phonenum='"+u_phonenum+"',u_birthday='"+u_birthday+"',u_province='"+u_province+"',u_city='"+u_city+"',u_district='"+u_district+"' "
				+ "where u_id = "+ id;
		int n = new BaseDao().executeUpdate(sql);
		if(n>0){
			request.getRequestDispatcher("Perfect_front").forward(request, response);
		}
	}
}
