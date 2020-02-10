package com.trainingproject.dao;
import java.util.ArrayList;
import java.util.List;

import com.trainingproject.model.Course;

public interface CourseDAO {
	
	// insert into course ( id,name,duration,fees) values ( ?, ?, ?, ?);
    void addCourses(Course list) throws DbException;
	
	//select * from course;
	List<Course> allCourseDetails(String courseName) throws DbException;
	
	//update course set courseFees = ? where courseName = ?; 
    void updateCourse(String courseName, int courseFees) throws DbException;

   //select fees from course where name = ?
    int getFees(String courseName) throws DbException;
    
  //delete from course where coursename = ?
    void deleteCourse(int courseId) throws DbException;
    
  //select coursename from course
    List<Course> getCourseNames() throws DbException;
    
    List<Course> getNamesByfeesRange(int fees1,int fees2) throws DbException;
    
    List<Course> getMinFeesCourses() throws DbException;
    
  
    
   
 	
    
     
}
