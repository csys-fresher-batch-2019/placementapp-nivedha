package com.trainingproject.dao;

import com.trainingproject.model.Comments;

public interface CommentsDAO {

	void addComments(Comments c) throws Exception;
	String getUserName(int userCourseId) throws Exception;
	String getCourseName(int userCourseId) throws Exception;
	String getTrainerName(int trainerId) throws Exception;
}
