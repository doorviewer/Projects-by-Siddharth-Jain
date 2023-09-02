package com.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import com.dao.UserDao;
import com.entities.User;
import com.helper.ConnectionProvider;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class RegisterServlet extends HttpServlet{
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException {
		
		response.setContentType("text/html;charset=UTF-8");
		
		try(PrintWriter out = response.getWriter()){
			
			System.out.println("Profile servlet executed.");
			
			out.println("<!DOCTYPE html>");
			out.println("<html>");
			out.println("<head>");
			out.println("<body>");
			
			//fetch all form data
			String check = request.getParameter("check");
			out.println(check);
			
			if(check==null) {
				out.println("To proceed accept terms and conditions. Please try again.");
			}else {
				
				System.out.println("line 39");
				
				String name = request.getParameter("user_name");
				String email = request.getParameter("user_email");
				String password = request.getParameter("user_password");
				String gender = request.getParameter("gender");
				String about = request.getParameter("about");
				
				System.out.println("line 44");
				
				//creating user:
				User user = new User(name,email,password,gender,about);
				
				// creating user dao object:
				UserDao dao = new UserDao(ConnectionProvider.getConnection());
				if(dao.saveUser(user)) {
					out.println("Added successfully");
				} else {
					out.println("Something went wrong, please try again later.");
				}
			}
			
			
			out.println("</body>");
			out.println("</head>");
			out.println("</html>");
		}
	}
}
