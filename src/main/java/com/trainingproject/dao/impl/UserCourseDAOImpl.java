package com.trainingproject.dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.trainingproject.DbConnection;
import com.trainingproject.dao.UserCourseDAO;
import com.trainingproject.logger.Logger;
import com.trainingproject.model.Course;
import com.trainingproject.model.Registration;
import com.trainingproject.model.UserCourse;

public class UserCourseDAOImpl implements UserCourseDAO {
	private static final Logger log=Logger.getInstance();


	public void addCourseDurationDate(UserCourse uc) throws Exception {
		
		
		String sql = "insert into usercourse" + 
				"(user_course_id,user_id,course_id,start_date,completion_date,total_amount)" + 
				"values (user_course_id_seq.nextval,?,?,?,?,?)";
		log.getInput("");
		log.getInput("***Add Course Duration Details***");
		log.getInput(sql);
		try(Connection con=DbConnection.getConnection();PreparedStatement pst = con.prepareStatement(sql);)
		{
		pst.setInt(1, uc.getUserId());
		pst.setInt(2, uc.getCourseId());
		pst.setDate(3, Date.valueOf(uc.getStartDate()));
		pst.setDate(4, Date.valueOf(uc.getCompletionDate()));
		pst.setDouble(5, uc.getTotalAmount());
	    int row=pst.executeUpdate();
	    log.getInput(row);
		}
		catch(SQLException e)
		{
	log.error(e);	
		}
		
	}
	
	public int getDuration(int courseId)throws Exception
	{
		String sql ="select course_duration from course where course_id =?";
		log.getInput("");
		log.getInput("***Display Course Duration Details***");
		
		int a=0;
		try(Connection con=DbConnection.getConnection();PreparedStatement pst=con.prepareStatement(sql);)
		{
			try(ResultSet rs=pst.executeQuery();)
			{
		pst.setInt(1,courseId);
		if(rs.next())
		{
			a=rs.getInt("course_duration");
			
		}
		}
		}
		catch(SQLException e)
		{
	log.error(e);	
		}
		return a;
		
	}

	public List<UserCourse> getUserCourseDetails(int userId) throws Exception {
		
		List<UserCourse> list1=new ArrayList<UserCourse>();
		
		String sql ="select * from usercourse where user_id=?";
		log.getInput("");
		log.getInput("***Display UserCourse Details***");
		//log.getInput(sql);
		try(Connection con=DbConnection.getConnection();PreparedStatement pst=con.prepareStatement(sql);)
		{
		pst.setInt(1, userId);
		try(ResultSet rs=pst.executeQuery();)
		{
		while(rs.next())
		{
			UserCourse ucc=new UserCourse();
			ucc.setUserCourseId(rs.getInt("user_course_id"));
			ucc.setUserId(rs.getInt("user_id"));
			ucc.setCourseId(rs.getInt("course_id"));
			Date d=rs.getDate("start_date");
			if(d!=null)
			{
				LocalDate ld=d.toLocalDate();
				ucc.setStartDate(ld);
			}
			Date d1=rs.getDate("completion_date");
			if(d1!=null)
			{
				LocalDate ld1=d1.toLocalDate();
				ucc.setCompletionDate(ld1);
			}
			ucc.setTotalAmount(rs.getDouble("total_amount"));
			
			list1.add(ucc);
		}
		}
		}
		catch(SQLException e)
		{
	    log.error(e);	
		}
		return list1;
	}

}
