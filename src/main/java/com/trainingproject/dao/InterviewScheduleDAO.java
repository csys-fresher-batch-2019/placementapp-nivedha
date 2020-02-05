package com.trainingproject.dao;

import java.util.List;

import com.trainingproject.model.ClientCompany;
import com.trainingproject.model.InterviewSchedule;

public interface InterviewScheduleDAO {
	
	void addSchedule(InterviewSchedule list) throws Exception;
	
	List<InterviewSchedule> allInterviewSchedules() throws Exception;
	
	void deleteSchedule(int interviewId) throws Exception;
	
	
	int getNoOfCompanies(String jobRequirement) throws Exception;
	
	//select * from clientcmpy where client_id=(select client_id from schedule where job_title='software developer');
	List<ClientCompany> getCompanyDetails(String jobTitle) throws Exception;
    
}
