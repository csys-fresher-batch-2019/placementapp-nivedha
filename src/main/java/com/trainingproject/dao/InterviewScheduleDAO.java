package com.trainingproject.dao;

import java.util.List;

import com.trainingproject.DbException;
import com.trainingproject.model.ClientCompany;
import com.trainingproject.model.InterviewSchedule;

public interface InterviewScheduleDAO {

	void addSchedule(InterviewSchedule list) throws DbException;

	List<InterviewSchedule> allInterviewSchedules() throws DbException;

	void deleteSchedule(int interviewId) throws DbException;

	List<ClientCompany> getCompanyDetails(String jobTitle) throws DbException;

}
