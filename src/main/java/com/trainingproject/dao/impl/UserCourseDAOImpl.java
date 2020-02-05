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
import com.trainingproject.model.Course;
import com.trainingproject.model.Registration;
import com.trainingproject.model.UserCourse;

public class UserCourseDAOImpl implements UserCourseDAO {


	public void addCourseDurationDate(UserCourse uc) throws Exception {
		
		Connection con=DbConnection.getConnection();
		String sql = "insert into usercourse" + 
				"(user_course_id,user_id,course_id,start_date,completion_date,total_amount)" + 
				"values (user_course_id_seq.nextval,?,?,?,?,?)";
		System.out.println("");
		System.out.println("***Add Course Duration Details***");
		System.out.println(sql);
		PreparedStatement pst = con.prepareStatement(sql);
		pst.setInt(1, uc.userId);
		pst.setInt(2, uc.courseId);
		pst.setDate(3, Date.valueOf(uc.startDate));
		pst.setDate(4, Date.valueOf(uc.completionDate));
		pst.setDouble(5, uc.totalAmount);
	    int row=pst.executeUpdate();
	    System.out.println(row);	
	    con.close();
		
	}
	
	public int getDuration(int courseId)throws Exception
	{
		
		Connection con=DbConnection.getConnection();
		String sql ="select course_duration from course where course_id =?";
		System.out.println("");
		System.out.println("***Display Course Duration Details***");
		System.out.println(sql);
		PreparedStatement pst=con.prepareStatement(sql);
		pst.setInt(1,courseId);
		ResultSet rs=pst.executeQuery();
		int a=0;
		if(rs.next())
		{
			a=rs.getInt("course_duration");
			
		}
		con.close();
		return a;
		
	}

	public List<UserCourse> getUserCourseDetails(int userId) throws Exception {
		
	
		List<UserCourse> list1=new ArrayList<UserCourse>();
		Connection con=DbConnection.getConnection();
		String sql ="select * from usercourse where user_id=?";
		System.out.println("");
		System.out.println("***Display UserCourse Details***");
		//System.out.println(sql);
		PreparedStatement pst=con.prepareStatement(sql);
		pst.setInt(1, userId);
		ResultSet rs=pst.executeQuery();
		while(rs.next())
		{
			UserCourse ucc=new UserCourse();
			ucc.userCourseId=rs.getInt("user_course_id");
			ucc.userId=rs.getInt("user_id");
			ucc.courseId=rs.getInt("course_id");
			Date d=rs.getDate("start_date");
			if(d!=null)
			{
				LocalDate ld=d.toLocalDate();
				ucc.startDate=ld;
			}
			Date d1=rs.getDate("completion_date");
			if(d1!=null)
			{
				LocalDate ld1=d1.toLocalDate();
				ucc.completionDate=ld1;
			}
			ucc.totalAmount=rs.getDouble("total_amount");
			
			list1.add(ucc);
		}
		return list1;
	}

}
