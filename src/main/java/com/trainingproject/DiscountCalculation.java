package com.trainingproject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class DiscountCalculation {
	
public int getNoOfUser(int userId) throws Exception {
		
		Connection con=DbConnection.getConnection();
		String sql="select count(user_id) from usercourse where user_id=?";
		System.out.println("");
		System.out.println("***Display "+userId+" count***");
		System.out.println(sql);
        PreparedStatement pst=con.prepareStatement(sql);
        pst.setInt(1, userId);
        ResultSet rs=pst.executeQuery();
        int a=0;
		if(rs.next())
		{
			a=rs.getInt("count(user_id)");
		}
		return a;
	}
public int getCourseFees(int courseId) throws Exception {
	
	Connection con=DbConnection.getConnection();
	String sql="select course_fees from course where course_id=?";
	System.out.println("");
	System.out.println("***Display "+courseId+" Fees Details***");
	System.out.println(sql);
	PreparedStatement pst=con.prepareStatement(sql);
	pst.setInt(1,courseId);
	ResultSet rs=pst.executeQuery();
	int a=0;
	if(rs.next())
	{
		a=rs.getInt("course_fees");
	}
	return a;
}

}

