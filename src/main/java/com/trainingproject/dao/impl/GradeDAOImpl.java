package com.trainingproject.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.trainingproject.DbConnection;
import com.trainingproject.dao.GradeDAO;
import com.trainingproject.logger.Logger;

public class GradeDAOImpl implements GradeDAO
{
	private static final Logger log=Logger.getInstance();


	@Override
	public void updateStatus() {
		 String sql="update intervieww set inter_status=(select g.status from grade g where marks between g.min_marks and g.max_marks)";
		 log.getInput("");
		
	   try( Connection con=DbConnection.getConnection(); PreparedStatement pst=con.prepareStatement(sql);)
	   {	     
	     int row=pst.executeUpdate();
	   }
	     catch(SQLException e)
		   {
	    	 log.error(e);	
		   }
	}

}
