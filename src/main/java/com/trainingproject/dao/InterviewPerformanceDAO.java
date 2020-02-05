package com.trainingproject.dao;

import java.util.List;

import com.trainingproject.model.InterviewPerformance;

public interface InterviewPerformanceDAO {
	
	void addPerformanceDetails(int clientId,int userId,String interPerform,String interStatus,int marks) throws Exception;
	
	List <InterviewPerformance> viewPerformanceStatus() throws Exception;

}
