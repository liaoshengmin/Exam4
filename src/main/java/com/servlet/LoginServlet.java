package com.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.service.JDBCService;

public class LoginServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String fname = req.getParameter("fname");
		JDBCService js = new JDBCService();
		boolean bool = js.login(fname);
		RequestDispatcher rd = null;
		if(bool){
			req.getSession().setAttribute("flag", "login_success");
			rd = req.getRequestDispatcher("/success.jsp");
			rd.forward(req, resp);
		}
		else{
			req.getSession().setAttribute("flag", "login_error");
			rd = req.getRequestDispatcher("/success.jsp");
			rd.forward(req, resp);
		}
		
	}

}
