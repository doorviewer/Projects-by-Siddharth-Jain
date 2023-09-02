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
public class LoginServlet extends HttpServlet{
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException {
		
		response.setContentType("text/html;charset=UTF-8");
		
		try(PrintWriter out = response.getWriter()){
			
			System.out.println("Profile servlet executed.");
			
			out.println("<!DOCTYPE html>");
			out.println("<html>");
			out.println("<head>");
			out.println("<body>");
			
			//login process:
			String userEmail = request.getParameter("email");
			String userPassword = request.getParameter("password");
			
			UserDao dao = new UserDao(ConnectionProvider.getConnection());
			User u = dao.getUserByEmailAndPassword(userEmail, userPassword);
			
			if (u == null) {
				//error
//				out.println("Invalid credentials, please try again.");
				Message msg = new Message("Invalid credentials. Please try again.","error","alert-danger");
				HttpSession s = request.getSession();
				s.setAttribute("msg", msg);
				response.sendRedirect("login_page.jsp");
				
			} else {
				// go ahead
				HttpSession s = request.getSession();
				s.setAttribute("currentUser", u);
				response.sendRedirect("profile.jsp");
			}
			
			out.println("</body>");
			out.println("</head>");
			out.println("</html>");
		}
	}
}
