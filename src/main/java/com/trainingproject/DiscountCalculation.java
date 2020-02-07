package com.trainingproject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DiscountCalculation {
	
public int getNoOfUser(int userId) throws Exception {
		
		
		String sql="select count(user_id) from usercourse where user_id=?";
		System.out.println("");
		System.out.println("***Display "+userId+" count***");
		System.out.println(sql);
		int a=0;
        try(Connection con=DbConnection.getConnection();PreparedStatement pst=con.prepareStatement(sql);ResultSet rs=pst.executeQuery();)
        {
        pst.setInt(1, userId);
		if(rs.next())
		{
			a=rs.getInt("count(user_id)");
		}
        }
        catch(SQLException e)
		{
	e.printStackTrace();	
		}
		return a;
	}
public int getCourseFees(int courseId) throws Exception {
	
	
	String sql="select course_fees from course where course_id=?";
	System.out.println("");
	System.out.println("***Display "+courseId+" Fees Details***");
	System.out.println(sql);
	int a=0;
	try(Connection con=DbConnection.getConnection();PreparedStatement pst=con.prepareStatement(sql);ResultSet rs=pst.executeQuery();)
	{
	pst.setInt(1,courseId);
	
	
	if(rs.next())
	{
		a=rs.getInt("course_fees");
	}
	}
	catch(SQLException e)
	{
e.printStackTrace();	
	}
	return a;
}

}

