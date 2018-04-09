package com.zero.servlet.front;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.zero.demo.BaseDao;

import com.zero.service.idleService;

/**
 * Servlet implementation class ReleaseIdle
 */
@WebServlet(urlPatterns="/ReleaseIdle")
@MultipartConfig
public class ReleaseIdle extends HttpServlet {
	private static final long serialVersionUID = 1L;
	idleService idle = new idleService();
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String name = request.getParameter("name");
		String idleimg = idle.saveImg(request, response);
		String presentation = request.getParameter("presentation");
		String location = request.getParameter("location");
		String transfer_price = request.getParameter("transfer_price");
		String percentage = request.getParameter("percentage");
		String sql = "INSERT INTO u_idle_info(NAME,idleimg,presentation,location,transfer_price,percentage,create_date) "
				+ "VALUES ('"+name+"','"+idleimg+"','"+presentation+"','"+location+"','"+transfer_price+"','"+percentage+"',CURDATE())";
		int n = new BaseDao().executeUpdate(sql);
		if(n>0){
			System.out.println("添加成功");
			request.getRequestDispatcher("front/publish_success.jsp").forward(request, response);
		}else {
			System.out.println("添加失败");
		}
	}
}
