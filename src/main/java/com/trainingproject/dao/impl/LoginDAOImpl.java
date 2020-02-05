package com.trainingproject.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;

import com.trainingproject.DbConnection;
import com.trainingproject.dao.LoginDAO;

public class LoginDAOImpl implements LoginDAO {

	public void login(String userName,String userPassword) throws Exception {
		
			Connection con=DbConnection.getConnection();
			String sql = "select user_name,user_password from registration where user_name= '" + userName + "' and user_password = '"+ userPassword + "'";
			ResultSet row = con.createStatement().executeQuery(sql);
			if (row.next()) {
			
				System.out.println("LOGGED IN");
			}
			else 
		
			System.out.println("INVALID USERNAME OR PASSWORD");
	}

	}
	


