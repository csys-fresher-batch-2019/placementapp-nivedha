package com.trainingproject.model;

public class InterviewPerformance {

	public int performId;
	public int clientId;
	public int userId;
	public String interPerform;
	public String interStatus;
	public int marks;
	@Override
	public String toString() {
		return "InterviewPerformance [performId=" + performId + ", clientId=" + clientId + ", userId=" + userId
				+ ", interPerform=" + interPerform + ", interStatus=" + interStatus + ", marks=" + marks + "]";
	}
	
	}

