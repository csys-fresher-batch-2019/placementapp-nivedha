package com.trainingproject.dao;

import java.util.List;

import com.trainingproject.DbException;
import com.trainingproject.model.ClientCompany;
import com.trainingproject.model.InterviewSchedule;

public interface InterviewScheduleDAO {
	
	void addSchedule(InterviewSchedule list) throws DbException;
	
	List<InterviewSchedule> allInterviewSchedules() throws DbException;
	
	void deleteSchedule(int interviewId) throws DbException;
	
	
	
	//select * from clientcmpy where client_id=(select client_id from schedule where job_title='software developer');
	List<ClientCompany> getCompanyDetails(String jobTitle) throws DbException;
    
}
