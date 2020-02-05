package com.trainingproject.dao;

import java.sql.SQLException;
import java.util.List;

import com.trainingproject.model.UserCourse;

public interface UserCourseDAO 
{
	void addCourseDurationDate(UserCourse list) throws Exception;
	
	int getDuration(int Duration) throws Exception;
	
	List<UserCourse> getUserCourseDetails(int userId) throws Exception;
}
