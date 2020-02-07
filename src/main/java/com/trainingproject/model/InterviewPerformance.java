package com.trainingproject.model;

public class InterviewPerformance {

	private int performId;
	private int clientId;
	private int userId;
	private String interPerform;
	private String interStatus;
	private int marks;
	public int getPerformId() {
		return performId;
	}
	public void setPerformId(int performId) {
		this.performId = performId;
	}
	public int getClientId() {
		return clientId;
	}
	public void setClientId(int clientId) {
		this.clientId = clientId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getInterPerform() {
		return interPerform;
	}
	public void setInterPerform(String interPerform) {
		this.interPerform = interPerform;
	}
	public String getInterStatus() {
		return interStatus;
	}
	public void setInterStatus(String interStatus) {
		this.interStatus = interStatus;
	}
	public int getMarks() {
		return marks;
	}
	public void setMarks(int marks) {
		this.marks = marks;
	}
	@Override
	public String toString() {
		return "InterviewPerformance [performId=" + performId + ", clientId=" + clientId + ", userId=" + userId
				+ ", interPerform=" + interPerform + ", interStatus=" + interStatus + ", marks=" + marks + "]";
	}
	
	}

