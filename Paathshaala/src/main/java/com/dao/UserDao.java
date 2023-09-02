package com.dao;
import java.sql.*;
import java.security.Timestamp;

import org.eclipse.jdt.internal.compiler.lookup.AptSourceLocalVariableBinding;

import com.entities.User;

public class UserDao {

	private Connection con;
	
	public UserDao(Connection con){
		this.con=con;
	}
	
	public boolean saveUser(User user) {
		
		boolean f = false;
		try {
			
			String query = "insert into user(name,email,password,gender,about) values(?,?,?,?,?)";
			PreparedStatement pstmt = this.con.prepareStatement(query);
			pstmt.setString(1,user.getName());
			pstmt.setString(2,user.getEmail());
			pstmt.setString(3,user.getPassword());
			pstmt.setString(4,user.getGender());
			pstmt.setString(5,user.getAbout());
			
			pstmt.executeUpdate();
			
			f=true;
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return f;
	}
	
	// for login credentials:
	
	public User getUserByEmailAndPassword(String email,String password) {
		
		User user = null;
		
		try {
			
			String query = "select * from user where email = ? and password = ?";
			PreparedStatement pstmt = con.prepareStatement(query);
			pstmt.setString(1,email);
			pstmt.setString(2,password);
			
			ResultSet set = pstmt.executeQuery();
			
			if (set.next()) {
				
				user = new User();
				
				user.setId(set.getInt("id"));
				user.setName(set.getString("name"));
				user.setEmail(set.getString("email"));
				user.setPassword(set.getString("password"));
				user.setGender(set.getString("gender"));
				user.setAbout(set.getString("about"));
				user.setDate(set.getTimestamp("rdate"));
				user.setProfile(set.getString("profile"));
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return user;
		}
}