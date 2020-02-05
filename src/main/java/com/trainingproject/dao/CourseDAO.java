package com.trainingproject.dao;
import java.util.ArrayList;
import java.util.List;

import com.trainingproject.model.Course;

public interface CourseDAO {
	
	// insert into course ( id,name,duration,fees) values ( ?, ?, ?, ?);
    void addCourses(Course list) throws Exception;
	
	//select * from course;
	List<Course> allCourseDetails() throws Exception;
	
	//update course set courseFees = ? where courseName = ?; 
    void updateCourse(String courseName, int courseFees) throws Exception;

   //select fees from course where name = ?
    int getFees(String courseName) throws Exception;
    
  //delete from course where coursename = ?
    void deleteCourse(int courseId) throws Exception;
    
  //select coursename from course
    List<Course> getCourseNames() throws Exception;
    
    List<Course> getNamesByfeesRange(int fees1,int fees2) throws Exception;
    
    List<Course> getMinFeesCourses() throws Exception;
    
   
 	
    
     
}
