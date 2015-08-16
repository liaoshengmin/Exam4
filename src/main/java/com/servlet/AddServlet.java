package com.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.film.Film;
import com.service.JDBCService;

public class AddServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		Film fm = new Film();
		fm.setTitle(req.getParameter("title")); 
		fm.setDescription(req.getParameter("description"));
//		fm.setLanguage_name(language_name);
//		System.out.println(id);
		JDBCService js = new JDBCService();
		int id=js.langid(req.getParameter("language_name"));
		js.add(fm, id);
		
		
		RequestDispatcher rd = null;
		rd = req.getRequestDispatcher("/show.jsp");
		rd.forward(req, resp);
	}
	

}
