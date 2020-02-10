package com.trainingproject.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.trainingproject.DbConnection;
import com.trainingproject.dao.LoginDAO;
import com.trainingproject.logger.Logger;

public class LoginDAOImpl implements LoginDAO {
	private static final Logger log=Logger.getInstance();
	public void login(String userName,String userPassword) throws DbException {
		
			
			String sql = "select user_name,user_password from registration where user_name= '" + userName + "' and user_password = '"+ userPassword + "'";
			try(Connection con=DbConnection.getConnection();PreparedStatement stmt=con.prepareStatement(sql);)
			{
				try(ResultSet rs=stmt.executeQuery();)
				{
			if (rs.next()) {
			
				log.getInput("LOGGED IN");
			}
			else 
		
			log.getInput("INVALID USERNAME OR PASSWORD");
	}
			}
			catch(SQLException e)
			{
		log.error(e);	
			}
	}
	

	}
	


