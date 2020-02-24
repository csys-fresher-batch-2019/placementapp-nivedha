package com.trainingproject.dao;

import com.trainingproject.DbException;
import com.trainingproject.model.Comments;

public interface CommentsDAO {

	void addComments(Comments c) throws DbException;

	String getUserName(int userCourseId) throws DbException;

	String getCourseName(int userCourseId) throws DbException;

	String getTrainerName(int trainerId) throws DbException;
}
