package com.trainingproject.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.trainingproject.DbConnection;
import com.trainingproject.DbException;
import com.trainingproject.dao.InterviewPerformanceDAO;
import com.trainingproject.logger.Logger;
import com.trainingproject.model.InterviewPerformance;


public class InterviewPerformanceDAOImpl implements InterviewPerformanceDAO{

	private static final Logger log=Logger.getInstance();
	public void addPerformanceDetails(int clientId,int userId,String interPerform,String interStatus,int marks) throws DbException {
		
		String sql = "insert into intervieww(sl_no,client_id,user_id,inter_perform,inter_status,marks)values(sl_no_sqn.nextval,?,?,?,?,?)";	
		log.getInput("");
		log.getInput("***Add Interview Performance Details***");
		log.getInput(sql);
		try(Connection con=DbConnection.getConnection();PreparedStatement pst = con.prepareStatement(sql);)
		{
		pst.setInt(1, clientId);
		pst.setInt(2, userId);
		pst.setString(3,interPerform);
		pst.setString(4,interStatus);
		pst.setInt(5,marks);
	    int row=pst.executeUpdate();
	    log.getInput(row);
		}
		catch(SQLException e)
		{
	log.error(e);	
		}
		
	}

	public List<InterviewPerformance> viewPerformanceStatus() throws DbException {
		
        List<InterviewPerformance> list=new ArrayList<InterviewPerformance>();
		
		String sql ="select client_id,user_id,marks,INTERVIEW_PERFORMANCE(marks) as interviewperformance,interiew_status(marks)as interiewstatus from intervieww";
		log.getInput("***Display Interview Performance Details***");
		log.getInput("");
		log.getInput(sql);
		try(Connection con=DbConnection.getConnection();PreparedStatement stmt=con.prepareStatement(sql);)
		{
		try(ResultSet rs=stmt.executeQuery();)
		{
		while(rs.next())
		{
			InterviewPerformance ip=new InterviewPerformance();
			ip.setClientId(rs.getInt("client_id"));
			ip.setUserId(rs.getInt("user_id"));
			ip.setMarks(rs.getInt("marks"));
			ip.setInterPerform(rs.getString("interviewperformance"));
			ip.setInterStatus(rs.getString("interiewstatus"));
			list.add(ip);
		}
		}
		}
		catch(SQLException e)
		{
	log.error(e);	
		}
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
