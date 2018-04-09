package com.zero.service;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.zero.demo.BaseDao;

public class idleService {
	BaseDao dao = new BaseDao();

	public int add(HttpServletRequest request, HttpServletResponse response) {
		try {
			request.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String name = request.getParameter("name");
		String idleimg = saveImg(request, response);
		String presentation = request.getParameter("presentation");
		String unit = request.getParameter("unit");
		String amount = request.getParameter("amount");
		String location = request.getParameter("location");
		String purchasing_date = request.getParameter("purchasing_date");
		String original_price = request.getParameter("original_price");
		String transfer_price = request.getParameter("transfer_price");
		String transfer_mode = request.getParameter("transfer_mode");
		String percentage = request.getParameter("percentage");
		String fk_idletype = request.getParameter("fk_idletype");
		String sql = " INSERT INTO u_idle_info "
				+ "(NAME,idleimg,presentation,unit,amount,location,purchasing_date,original_price,transfer_price,transfer_mode,transfer_state,percentage,fk_idletype,uidle_state,create_date)  "
				+ " VALUES " + " ('" + name + "', '"+idleimg+"' , '" + presentation + "','" + unit + "'," + amount + ",'" + location
				+ "','" + purchasing_date + "'," + original_price + "," + transfer_price + ",'" + transfer_mode
				+ "','未交易','" + percentage + "'," + fk_idletype + ",'正常',CURRENT_DATE()) ";
		int n = dao.executeUpdate(sql);
		System.out.print(sql);
		return n;
	}

	public List<Map<String, Object>> queryIdle() {
		String sql = "SELECT * FROM u_idle_info";
		List<Map<String, Object>> list = dao.executeQuery(sql);
		return list;
	}

	public int delete(HttpServletRequest request, HttpServletResponse response) {
		try {
			request.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String id = request.getParameter("id");
		String sql = "DELETE From u_idle_info where id =" + id;
		int n = dao.executeUpdate(sql);
		return n;
	}

	public List<Map<String, Object>> querylikeIdle(HttpServletRequest request, HttpServletResponse response) {
		try {
			request.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String idlename = request.getParameter("idlename");
		String sql = "SELECT * FROM u_idle_info where name LIKE '%" + idlename + "%'";
		List<Map<String, Object>> list = dao.executeQuery(sql);
		return list;
	}

	public String saveImg(HttpServletRequest request, HttpServletResponse response) {

		Part part = null;
		try {
			part = request.getPart("idleimg");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Date date = new Date();
		SimpleDateFormat sf = new SimpleDateFormat("yyyyMMddhhmmss");
		String str = sf.format(date);
		String cd = part.getHeader("Content-Disposition");
		String houzui = cd.substring(cd.lastIndexOf("."),cd.length()-1);
		String filename = str+houzui;
		try {
			String realpath = request.getServletContext().getRealPath("/idleimg")+"\\"+filename;
			part.write(realpath);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return filename;
	}
}
