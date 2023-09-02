package com.helper;
import java.sql.*;

public class ConnectionProvider {
	
	private static Connection con;
	
	public static Connection getConnection() {
		
		try {
			
			if (con==null) {
			
			Class.forName("com.mysql.jdbc.Driver");
			//create a connection
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/learnCoding","root","root");
			
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return con;
	}

}
