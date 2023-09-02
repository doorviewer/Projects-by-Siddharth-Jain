package com.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import com.dao.UserDao;
import com.entities.Message;
import com.entities.User;
import com.helper.ConnectionProvider;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@SuppressWarnings("serial")
public class LogoutServlet extends HttpServlet{
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException {
		
		response.setContentType("text/html;charset=UTF-8");
		
		try(PrintWriter out = response.getWriter()){
			
			System.out.println("Profile servlet executed.");
			
			out.println("<!DOCTYPE html>");
			out.println("<html>");
			out.println("<head>");
			out.println("<body>");
			
			//logout process:
			
			HttpSession s = request.getSession();
			s.removeAttribute("currentUser");
			Message m = new Message("Log out successfully","sucess","alert-success");
			s.setAttribute("msg", m);
			response.sendRedirect("login_page.jsp");
			
			out.println("</body>");
			out.println("</head>");
			out.println("</html>");
		}
	}
}
