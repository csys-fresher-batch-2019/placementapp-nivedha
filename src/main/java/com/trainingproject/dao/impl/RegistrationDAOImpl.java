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
		
		Connection con=DbConnection.getConnection();
		String sql = "insert into registration(user_id,user_name,user_password,user_city,mobile_no,mail_id,qualification,gender) values(user_id_seq.nextval,'"+reg.userName+"','"+reg.userPassword+"','"+reg.userCity+"',"+reg.mobileNo+",'"+reg.mailId+"','"+reg.qualification+"','"+reg.gender+"')";
		System.out.println("");
		System.out.println(sql);
	    Statement stmt=con.createStatement();
	    int row=stmt.executeUpdate(sql);
	    System.out.println(row);
		
	}
	
	public void updateUserDetails(int userId, long mobileNo) throws Exception {
		 
		 Connection con=DbConnection.getConnection();
		 String sql="update registration set mobile_no=? where user_id=?";
		 System.out.println("");
		 System.out.println(sql);
	     PreparedStatement pst=con.prepareStatement(sql);
	     pst.setLong(1, mobileNo);
	     pst.setInt(2, userId);
	     int row=pst.executeUpdate();
	     System.out.println(row);	
		
	}


	public List<Registration> allUserDetails() throws Exception {
		
		List<Registration> list1=new ArrayList<Registration>();
		Connection con=DbConnection.getConnection();
		String sql ="select * from registration";
		System.out.println("");
		System.out.println("***Display User Details***");
		System.out.println(sql);
		Statement stmt=con.createStatement();
		ResultSet rs=stmt.executeQuery(sql);
		while(rs.next())
		{
			Registration reg=new Registration();
			reg.userId=rs.getInt("user_id");
			reg.userName=rs.getString("user_name");
			reg.userPassword=rs.getString("user_password");
			reg.userCity=rs.getString("user_city");
			reg.mobileNo=rs.getLong("mobile_no");
			reg.mailId=rs.getString("mail_id");
			reg.qualification=rs.getString("qualification");
			reg.gender=rs.getString("gender");
			list1.add(reg);
		}
		return list1;
	}

	public void deleteUserDetails(int userId) throws Exception {
		
		Connection con=DbConnection.getConnection();
		String sql="delete from registration where user_id=?";
		System.out.println("");
		System.out.println(sql);
		PreparedStatement pst=con.prepareStatement(sql);
		pst.setInt(1, userId);
        int row=pst.executeUpdate();
        System.out.println(row);
		
	}

	public int getNoOfUsers() throws Exception {
		
		Connection con=DbConnection.getConnection();
		String sql="select count(user_id) from registration";
		System.out.println("");
		System.out.println("***Display the No of Users***");
		System.out.println(sql);
        Statement stmt=con.createStatement();
        ResultSet rs=stmt.executeQuery(sql);
        int a=0;
		while(rs.next())
		{
			a=rs.getInt("count(user_id)");
		}
		return a;
	}

	public List<Registration> getDegreeWiseNoOfUsers() throws Exception {
		
		List<Registration> list1=new ArrayList<Registration>();
		Connection con=DbConnection.getConnection();
		String sql="select qualification as qualification,count(user_id) from registration group by qualification";
		System.out.println("");
		System.out.println("***Display No Of Users Based on Qualification***");
		System.out.println(sql);
        Statement stmt=con.createStatement();
        ResultSet rs=stmt.executeQuery(sql);
		while(rs.next())
		{
			Registration reg=new Registration();
			reg.userId=rs.getInt("count(user_id)");
			reg.qualification=rs.getString("qualification");
			list1.add(reg);
		}
		return list1;
	}

	
}
