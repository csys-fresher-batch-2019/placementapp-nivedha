package com.trainingproject.dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.trainingproject.DbConnection;
import com.trainingproject.dao.CourseDAO;
import com.trainingproject.model.Course;
import com.trainingproject.model.UserCourse;

public class CourseDAOImpl implements CourseDAO{
	
	public List<Course> allCourseDetails(String courseName)throws Exception {
		List<Course> list=new ArrayList<Course>();
		String sql ="select course_id,course_name,course_duration,course_fees from course where course_name=?";
		System.out.println("");
		System.out.println("***Display All Course Details***");
		try(Connection con=DbConnection.getConnection();PreparedStatement stmt=con.prepareStatement(sql);)
		{
		stmt.setString(1, courseName);
		try(ResultSet rs=stmt.executeQuery();)
		{
		while(rs.next())
		{
			Course c=new Course();
			c.setCourseId(rs.getInt("course_id"));
			c.setCourseName(rs.getString("course_name"));
			c.setCourseDuration(rs.getInt("course_duration"));
			c.setCourseFees(rs.getInt("course_fees"));
			list.add(c);
		}
		}
		}
		catch(SQLException e)
		{
	e.printStackTrace();	
		}
		
		return list;
	}
	
	
	public void updateCourse(String courseName, int courseFees) throws Exception {
		 
		
		 String sql="update course set course_fees=? where course_name=?";
		 System.out.println("");
		
	   try( Connection con=DbConnection.getConnection(); PreparedStatement pst=con.prepareStatement(sql);)
	   {	     
		 pst.setInt(1,courseFees);
	     pst.setString(2,courseName);
	     int row=pst.executeUpdate();
	   }
	     catch(SQLException e)
		   {
	    	 e.printStackTrace();	
		   }
	    
	}

	public int getFees(String courseName) throws Exception {
		
		String sql="select course_fees from course where course_name=?";
		System.out.println("***Display "+courseName+" Fees Details***");
		
		int a=0;
		try(Connection con=DbConnection.getConnection();
          PreparedStatement pst=con.prepareStatement(sql);)
		{
		pst.setString(1,courseName);
		try(ResultSet rs=pst.executeQuery();)
		{
		while(rs.next())
		{
			a=rs.getInt("course_fees");
		}
		}
	}
		catch(SQLException e)
		   {
	    	 e.printStackTrace();	
		   }
		return a;
	}

	public List<Course> getCourseNames() throws Exception {
		
		List<Course> list=new ArrayList<Course>();
		//Connection con=DbConnection.getConnection();
		String sql="select course_name from course";
		System.out.println("");
		System.out.println("***Display All Course Names***");
		try(Connection con=DbConnection.getConnection();PreparedStatement stmt=con.prepareStatement(sql);)
		{
			try(ResultSet rs=stmt.executeQuery();)
			{
		
		while(rs.next())
		{
			Course c=new Course();
			c.setCourseName(rs.getString("course_name"));
			list.add(c);
		}
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
			}
		
		return list;
	}

	public void deleteCourse(int courseId) throws Exception {
		
		String sql="delete from course where course_id=?";
		System.out.println("");
		System.out.println("***Delete "+courseId+" Details***");
try(Connection con=DbConnection.getConnection();
		PreparedStatement pst=con.prepareStatement(sql);)
{
		pst.setInt(1, courseId);
        int row=pst.executeUpdate();
        //System.out.println(row);
	}
catch(SQLException e) {
	e.printStackTrace();
	}
	}
	
	
	public void addCourses(Course cl) throws Exception {
	
	String sql = "insert into course(course_id,course_name,course_duration,course_fees)values(course_id_seq.nextval,?,?,?)";
	System.out.println("");
	System.out.println("***Add Course Details***");
	//System.out.println(sql);
   try(	Connection con=DbConnection.getConnection(); PreparedStatement pst = con.prepareStatement(sql);)
	{
    pst.setString(1, cl.getCourseName());
	pst.setInt(2,cl.getCourseDuration());
	pst.setInt(3,cl.getCourseFees());
    int row=pst.executeUpdate();
	}
   catch(SQLException e) {
		e.printStackTrace();
		}
  	
}


	public  List<Course> getNamesByfeesRange(int fees1,int fees2) throws Exception {
		List<Course> list=new ArrayList<Course>();
		
		String sql="select course_name,course_fees from course where course_fees between ? and ?";
		
		try(Connection con=DbConnection.getConnection();PreparedStatement pst=con.prepareStatement(sql);){
        
       
			pst.setInt(1, fees1);
	        pst.setInt(2, fees2);
        try(ResultSet rs=pst.executeQuery();)
        {
		while(rs.next())
		{
			
			Course c=new Course();
			c.setCourseName(rs.getString("course_name"));
			c.setCourseFees(rs.getInt("course_fees"));
			 list.add(c);
		}
        }
		}
	
	catch(SQLException e) {
		e.printStackTrace();
		}
		
		return list;
	}


	public List<Course> getMinFeesCourses() throws Exception {
		
		List<Course> list=new ArrayList<Course>();
		String sql = "select course_name,course_fees from course where course_fees=(select min(course_fees) from course)";
		System.out.println("");
		System.out.println("***Display the Minimum Course Fees Names***");
		
		try(Connection con=DbConnection.getConnection();PreparedStatement stmt=con.prepareStatement(sql);){
		try(ResultSet rs=stmt.executeQuery();)
		{
		while(rs.next())
		{
			Course c=new Course();
			c.setCourseName(rs.getString("course_name"));
			c.setCourseFees(rs.getInt("course_fees"));
	        list.add(c);
		}
		}
		}
	
	catch(SQLException e) {
		e.printStackTrace();
		}
		
		return list;
	}

	}

