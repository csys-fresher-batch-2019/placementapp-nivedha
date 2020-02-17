package com.trainingproject.dao;

import java.util.List;

import com.trainingproject.DbException;
import com.trainingproject.model.InterviewPerformance;

public interface InterviewPerformanceDAO {
	
	void addPerformanceDetails(int clientId,int userId,int marks) throws DbException;
	
	List <InterviewPerformance> viewPerformanceStatus() throws DbException;

}
