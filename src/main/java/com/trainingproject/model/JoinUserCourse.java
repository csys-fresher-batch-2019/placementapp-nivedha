package com.trainingproject.model;

import java.time.LocalDate;

public class JoinUserCourse {

	public  int courseId; 
	public  String courseName;
	public  int courseDuration;
	public  int courseFees;
	public  int userId;
	public  LocalDate startDate;
	public  LocalDate completionDate;
	public double totalAmount;
	@Override
	public String toString() {
		return "JoinUserCourse [courseId=" + courseId + ", courseName=" + courseName + ", courseDuration="
				+ courseDuration + ", courseFees=" + courseFees + ", userId=" + userId + ", startDate=" + startDate + ", completionDate="
				+ completionDate + ", totalAmount=" + totalAmount + "]";
	}
	
}
