package com.trainingproject.dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import com.trainingproject.DbConnection;
import com.trainingproject.model.JoinCompanySchedule;
import com.trainingproject.model.JoinUserCompany;
import com.trainingproject.model.JoinUserCourse;

public class JoinDAOImpl {

	public List <JoinUserCourse> getUserCourseDetails()throws Exception
	{
		List<JoinUserCourse> list=new ArrayList<JoinUserCourse>();
		Connection con=DbConnection.getConnection();
		String sql ="select uc.user_id,c.course_name,c.course_fees,c.course_duration,uc.start_date,uc.completion_date,uc.total_amount from course c,usercourse uc where c.course_id=uc.course_id";
		System.out.println("");
		System.out.println("***Display All UserCourse Details***");
		System.out.println("");
		System.out.println(sql);
		Statement stmt=con.createStatement();
		ResultSet rs=stmt.executeQuery(sql);
		while(rs.next())
		{
			JoinUserCourse c=new JoinUserCourse();
			c.userId=rs.getInt("user_id");
			c.courseName=rs.getString("course_name");
			c.courseFees=rs.getInt("course_fees");
			c.courseDuration=rs.getInt("course_duration");
			Date d=rs.getDate("start_date");
			if(d!=null)
			{
				LocalDate ld=d.toLocalDate();
				c.startDate=ld;
			}
			Date da=rs.getDate("completion_date");
			if(da!=null)
			{
				LocalDate ldd=da.toLocalDate();
				c.completionDate=ldd;
			}
			c.totalAmount=rs.getInt("total_amount");
			list.add(c);
		}
		con.close();
		return list;
		
	}
	public List <JoinUserCompany> getUserCompanyDetails(String interStatus)throws Exception
	{
		List<JoinUserCompany> list=new ArrayList<JoinUserCompany>();
		Connection con=DbConnection.getConnection();
		String sql ="select r.user_id,r.user_name,r.qualification,r.mail_id,r.mobile_no,r.user_city,r.gender,c.client_id,c.company_name,c.company_type,c.company_address,c.ph_no,c.contact_person,c.email_id,i.inter_status,i.inter_perform from registration r,clientcmpy c,intervieww i where i.client_id = c.client_id and r.user_id=i.user_id and i.inter_status=?";
		System.out.println("");
		//System.out.println(sql);
		PreparedStatement pst=con.prepareStatement(sql);
		pst.setString(1, interStatus);
		ResultSet rs=pst.executeQuery();
		while(rs.next())
		{
			JoinUserCompany jc=new JoinUserCompany();
			jc.userId=rs.getInt("user_id");
			jc.userName=rs.getString("user_name");
			jc.qualification=rs.getString("qualification");
			jc.mailId=rs.getString("mail_id");
			jc.mobileNo=rs.getLong("mobile_no");
			jc.userCity=rs.getString("user_city");
			jc.gender=rs.getString("gender");
			jc.clientId=rs.getInt("client_id");
			jc.companyName=rs.getString("company_name");
			jc.companyType=rs.getString("company_type");
			jc.companyAddress=rs.getString("company_address");
			jc.phoneNo=rs.getLong("ph_no");
			jc.contactPerson=rs.getString("contact_person");
			jc.emailId=rs.getString("email_id");
			jc.interPerform=rs.getString("inter_perform");
			jc.interStatus=rs.getString("inter_status");
			list.add(jc);
		}
		con.close();
		return list;
		
	}
	public List <JoinCompanySchedule> getCompanySchedule(String interviewDate)throws Exception
	{
		List<JoinCompanySchedule> list=new ArrayList<JoinCompanySchedule>();
		Connection con=DbConnection.getConnection();
		String sql ="select cc.company_name,cc.company_type,cc.company_address,cc.ph_no,cc.contact_person,cc.email_id,s.job_title,s.job_requirement,s.interview_date,s.interview_time from clientcmpy cc,schedule s where \r\n" + 
				"cc.client_id=s.client_id and s.interview_date=?";
		System.out.println("");
		System.out.println("***Display All Users Selected Details***");
		System.out.println("");
		System.out.println(sql);
		PreparedStatement pst=con.prepareStatement(sql);
		pst.setDate(1, Date.valueOf(interviewDate));
		ResultSet rs=pst.executeQuery();
		while(rs.next())
		{
			JoinCompanySchedule jc=new JoinCompanySchedule();
			jc.companyName=rs.getString("company_name");
			jc.companyType=rs.getString("company_type");
			jc.companyAddress=rs.getString("company_address");
			jc.phoneNo=rs.getLong("ph_no");
			jc.contactPerson=rs.getString("contact_person");
			jc.emailId=rs.getString("email_id");
			jc.jobTitle=rs.getString("job_title");
			jc.jobRequirement=rs.getString("job_requirement");
			Date id=rs.getDate("interview_date");
		        if(id!=null)
		        {
		        	LocalDate l=id.toLocalDate();
		        	jc.interviewDate=l;
		        }
			jc.interviewTime=LocalTime.parse(rs.getString("interview_time"));
			list.add(jc);
		}
		if(rs.next())
		{
			System.out.println("display");
		}
		else
			System.out.println("error");
		
		return list;
		//con.close();
		
	}

}

