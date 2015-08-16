package com.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.film.Film;
import com.film.Language;
import com.service.JDBCService;

public class ShowOneServlet extends HttpServlet {

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
		Film fm = js.showOne(film_id);
		req.getSession().setAttribute("fm", fm);
		List<Language> list =js.lang();
		req.getSession().setAttribute("lanlist", list);
		
		
		RequestDispatcher rd = null;
		rd = req.getRequestDispatcher("/update.jsp");
		rd.forward(req, resp);
	}
	

}