package com.trainingproject.dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import com.trainingproject.DbConnection;
import com.trainingproject.dao.InterviewScheduleDAO;
import com.trainingproject.model.ClientCompany;
import com.trainingproject.model.InterviewSchedule;
import com.trainingproject.model.Registration;

public class InterviewScheduleDAOImpl implements InterviewScheduleDAO {

	public void addSchedule(InterviewSchedule schedule) throws Exception {
		
		Connection con=DbConnection.getConnection();
		String sql = "insert into schedule(interview_id,client_id,job_title,job_requirement,created_date,interview_date,interview_time)"
				+ "values(interview_id_seq.nextval,?,?,?,?,?,?)";
		System.out.println("");
		System.out.println("***Add Interview Schedule Details***");
		System.out.println(sql);
		PreparedStatement pst = con.prepareStatement(sql);
		pst.setInt(1, schedule.clientId);
		pst.setString(2, schedule.jobTitle);
		pst.setString(3, schedule.jobRequirement);
		pst.setDate(4, Date.valueOf(schedule.createdDate));
		pst.setDate(5, Date.valueOf(schedule.interviewDate));
		pst.setString(6, schedule.interviewTime.toString());
	    int row=pst.executeUpdate();
	    System.out.println(row);
		con.close();
	}

	public List<InterviewSchedule> allInterviewSchedules() throws Exception {
		
		List<InterviewSchedule> list=new ArrayList<InterviewSchedule>();
		Connection con=DbConnection.getConnection();
		String sql ="select * from schedule";
		System.out.println("");
		System.out.println("***Display Interview Schedule Details***");
		System.out.println(sql);
		Statement stmt=con.createStatement();
		ResultSet rs=stmt.executeQuery(sql);
		while(rs.next())
		{
			InterviewSchedule in=new InterviewSchedule();
			in.interviewId=rs.getInt("interview_id");
			in.clientId=rs.getInt("client_id");
			in.jobTitle=rs.getString("job_title");
			in.jobRequirement=rs.getString("job_requirement");
			Date d=rs.getDate("created_date");
			if(d!=null)
			{
				LocalDate ld=d.toLocalDate();
				in.createdDate=ld;
			}
	        Date id=rs.getDate("interview_date");
	        if(id!=null)
	        {
	        	LocalDate l=id.toLocalDate();
	        	in.interviewDate=l;
	        }
			in.interviewTime=LocalTime.parse(rs.getString("interview_time"));
			list.add(in);
			}
		con.close();
		return list;
	
	}

	public void deleteSchedule(int interviewId) throws Exception {
		
		Connection con=DbConnection.getConnection();
		String sql="delete from schedule where interview_id=?";
		System.out.println("");
		System.out.println("***Delete Interview Schedule Details***");
		System.out.println(sql);
		PreparedStatement pst=con.prepareStatement(sql);
		pst.setInt(1, interviewId);
        int row=pst.executeUpdate();
        System.out.println(row);
		con.close();
	}

	public int getNoOfCompanies(String jobRequirement) throws Exception {
		
		Connection con=DbConnection.getConnection();
		String sql="select count(interview_id) from schedule where job_requirement like ?";
		System.out.println("");
		System.out.println("***Display the count based on job Requirement***");
		System.out.println(sql);
        PreparedStatement pst=con.prepareStatement(sql);
        pst.setString(1, "%"+jobRequirement+"%");
        ResultSet rs=pst.executeQuery();
        int a=0;
		if(rs.next())
		{
			a=rs.getInt("count(interview_id)");
		}
		con.close();
		return a;
	}

	public List<ClientCompany> getCompanyDetails(String jobRequirement) throws Exception {
		
		List<ClientCompany> list1=new ArrayList<ClientCompany>();
		Connection con=DbConnection.getConnection();
		String sql="select client_id,company_name,company_type,company_address,ph_no,contact_person,email_id from clientcmpy where client_id in (select client_id from schedule where job_requirement=?)";
		System.out.println("");
		System.out.println("***Display the company details based on the job title***");
		System.out.println(sql);
        PreparedStatement pst=con.prepareStatement(sql);
        pst.setString(1, jobRequirement);
        ResultSet rs=pst.executeQuery();
		while(rs.next())
		{
			ClientCompany cc=new ClientCompany();
		    cc.clientId=rs.getInt("client_id");
			cc.companyName=rs.getString("company_name");
			cc.companyType=rs.getString("company_type");
			cc.companyAddress=rs.getString("company_address");
			cc.phoneNo=rs.getLong("ph_no");
			cc.contactPerson=rs.getString("contact_person");
			cc.emailId=rs.getString("email_id");
            list1.add(cc);
		}
		con.close();
		return list1;
	}

}
