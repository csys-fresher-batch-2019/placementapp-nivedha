package com.trainingproject.dao;

import java.sql.SQLException;
import java.util.List;

import com.trainingproject.DbException;
import com.trainingproject.model.UserCourse;

public interface UserCourseDAO 
{
	void addCourseDurationDate(UserCourse list) throws DbException;
	
	int getDuration(int Duration) throws DbException;
	
	List<UserCourse> getUserCourseDetails(int userId) throws DbException;
}
