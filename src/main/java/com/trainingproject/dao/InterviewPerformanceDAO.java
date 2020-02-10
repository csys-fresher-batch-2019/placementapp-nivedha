package com.trainingproject.dao;

import java.util.List;

import com.trainingproject.model.InterviewPerformance;

public interface InterviewPerformanceDAO {
	
	void addPerformanceDetails(int clientId,int userId,String interPerform,String interStatus,int marks) throws DbException;
	
	List <InterviewPerformance> viewPerformanceStatus() throws DbException;

}
