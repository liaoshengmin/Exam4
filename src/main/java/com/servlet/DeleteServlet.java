package com.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.service.JDBCService;

public class DeleteServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String id = req.getParameter("typeid");
		Integer film_id =Integer.parseInt(id); 
//		System.out.println(id);
		JDBCService js = new JDBCService();
		js.delete(film_id);
		
		RequestDispatcher rd = null;
		rd = req.getRequestDispatcher("/ShowServlet");
		rd.forward(req, resp);
	}
	

}
