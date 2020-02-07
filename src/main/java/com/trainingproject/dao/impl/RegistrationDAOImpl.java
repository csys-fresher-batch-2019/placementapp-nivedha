package com.trainingproject.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.trainingproject.DbConnection;
import com.trainingproject.dao.RegistrationDAO;
import com.trainingproject.model.Course;
import com.trainingproject.model.Registration;

public class RegistrationDAOImpl implements RegistrationDAO{

	public void addUserDetails(Registration reg) throws Exception {
		
		String sql = "insert into registration(user_id,user_name,user_password,user_city,mobile_no,mail_id,qualification,gender) values(user_id_seq.nextval,?,?,?,?,?,?,?)";
		System.out.println("");
		System.out.println(sql);
	   try(Connection con=DbConnection.getConnection();
 PreparedStatement stmt=con.prepareStatement(sql);)
	   {
	    stmt.setString(1, reg.getUserName());
	    stmt.setString(2, reg.getUserPassword());
	    stmt.setString(3, reg.getUserCity());
	    stmt.setLong(4, reg.getMobileNo());
	    stmt.setString(5, reg.getMailId());
	    stmt.setString(6, reg.getQualification());
	    stmt.setString(7, reg.getGender());
	    int row=stmt.executeUpdate();
	    System.out.println(row);
	   }
	   catch(SQLException e)
		{
	e.printStackTrace();	
		}
		
	}
	
	public void updateUserDetails(int userId, long mobileNo) throws Exception {
		 
		 String sql="update registration set mobile_no=? where user_id=?";
		 System.out.println("");
		 System.out.println(sql);
	     try(Connection con=DbConnection.getConnection();PreparedStatement pst=con.prepareStatement(sql);)
	     {
	     pst.setLong(1, mobileNo);
	     pst.setInt(2, userId);
	     int row=pst.executeUpdate();
	     System.out.println(row);
	     }
	     catch(SQLException e)
			{
		e.printStackTrace();	
			}
		
	}


	public List<Registration> allUserDetails() throws Exception {
		
		List<Registration> list1=new ArrayList<Registration>();
		
		String sql ="select * from registration";
		System.out.println("");
		System.out.println("***Display User Details***");
		System.out.println(sql);
		try(Connection con=DbConnection.getConnection();PreparedStatement stmt=con.prepareStatement(sql);)
		{
			try(ResultSet rs=stmt.executeQuery();)
		{
		while(rs.next())
		{
			Registration reg=new Registration();
			reg.setUserId(rs.getInt("user_id"));
			reg.setUserName(rs.getString("user_name"));
			reg.setUserPassword(rs.getString("user_password"));
			reg.setUserCity(rs.getString("user_city"));
			reg.setMobileNo(rs.getLong("mobile_no"));
			reg.setMailId(rs.getString("mail_id"));
			reg.setQualification(rs.getString("qualification"));
			reg.setGender(rs.getString("gender"));
			list1.add(reg);
		}
		}
		}
		catch(SQLException e)
		{
	e.printStackTrace();	
		}
		return list1;
	}

	public void deleteUserDetails(int userId) throws Exception {
		
		String sql="delete from registration where user_id=?";
		System.out.println("");
		System.out.println(sql);
		try(Connection con=DbConnection.getConnection();PreparedStatement pst=con.prepareStatement(sql);)
		{
		pst.setInt(1, userId);
        int row=pst.executeUpdate();
        System.out.println(row);
		}
		catch(SQLException e)
		{
	    e.printStackTrace();	
		}
		
	}

	public int getNoOfUsers() throws Exception {
		
		String sql="select count(user_id) from registration";
		System.out.println("");
		System.out.println("***Display the No of Users***");
		System.out.println(sql);
		int a=0;
        try(Connection con=DbConnection.getConnection();PreparedStatement stmt=con.prepareStatement(sql);)
        {
        try(ResultSet rs=stmt.executeQuery();)
        
        {
       
		while(rs.next())
		{
			a=rs.getInt("count(user_id)");
		}
       }
        }
       catch(SQLException e)
		{
	    e.printStackTrace();	
		}
		return a;
	}

	public List<Registration> getDegreeWiseNoOfUsers() throws Exception {
		
		List<Registration> list1=new ArrayList<Registration>();
		String sql="select qualification as qualification,count(user_id) from registration group by qualification";
		System.out.println("");
		System.out.println("***Display No Of Users Based on Qualification***");
		System.out.println(sql);
        try(Connection con=DbConnection.getConnection();PreparedStatement stmt=con.prepareStatement(sql);)
        {
        	try(ResultSet rs=stmt.executeQuery();)
        
        {
		while(rs.next())
		{
			Registration reg=new Registration();
			reg.setUserId(rs.getInt("count(user_id)"));
			reg.setQualification(rs.getString("qualification"));
			list1.add(reg);
		}
        }
        }
        catch(SQLException e)
		{
	    e.printStackTrace();	
		}
		return list1;
	}

	
}
