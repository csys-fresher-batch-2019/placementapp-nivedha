package com.trainingproject.dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.trainingproject.DbConnection;
import com.trainingproject.dao.InterviewPerformanceDAO;
import com.trainingproject.model.InterviewPerformance;


public class InterviewPerformanceDAOImpl implements InterviewPerformanceDAO{

	public void addPerformanceDetails(int clientId,int userId,String interPerform,String interStatus,int marks) throws Exception {
		Connection con=DbConnection.getConnection();
		String sql = "insert into intervieww(sl_no,client_id,user_id,inter_perform,inter_status,marks)values(sl_no_sqn.nextval,?,?,?,?,?)";	
		System.out.println("");
		System.out.println("***Add Interview Performance Details***");
		System.out.println(sql);
		PreparedStatement pst = con.prepareStatement(sql);
		pst.setInt(1, clientId);
		pst.setInt(2, userId);
		pst.setString(3,interPerform);
		pst.setString(4,interStatus);
		pst.setInt(5,marks);
	    int row=pst.executeUpdate();
	    System.out.println(row);
	    con.close();
		
	}

	public List<InterviewPerformance> viewPerformanceStatus() throws Exception {
		
        List<InterviewPerformance> list=new ArrayList<InterviewPerformance>();
		Connection con=DbConnection.getConnection();
		String sql ="select client_id,user_id,marks,INTERVIEW_PERFORMANCE(marks) as interviewperformance,interiew_status(marks)as interiewstatus from intervieww";
		
		System.out.println("***Display Interview Performance Details***");
		System.out.println("");
		System.out.println(sql);
		Statement stmt=con.createStatement();
		ResultSet rs=stmt.executeQuery(sql);
		
		while(rs.next())
		{
			InterviewPerformance ip=new InterviewPerformance();
			ip.clientId=rs.getInt("client_id");
			ip.userId=rs.getInt("user_id");
			ip.marks=rs.getInt("marks");
			ip.interPerform=rs.getString("interviewperformance");
			ip.interStatus=rs.getString("interiewstatus");
			list.add(ip);
		}
		con.close();
		return list;
	}

	public String getStatus(int marks) {
		String status = null;
		if (marks < 5) {
			status = "rejected";
		}
		else if(marks<8)
			status="waiting";
		else
			status="selected";
		return status;
	}	
	
	public String getPerformance(int marks) {
		String Performance = null;
		if (marks < 5) {
			Performance = "bad";
		}
		else if(marks<8)
			Performance="better";
		else
			Performance="good";
		return Performance;
	}	
}
