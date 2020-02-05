package com.trainingproject.model;

import java.time.LocalDate;
import java.util.Date;

public class UserCourse {

	public  int userCourseId;
	public  int userId;
	public  int courseId;
	public  LocalDate startDate;
	public  LocalDate completionDate;
	public double totalAmount;
	
	@Override
	public String toString() {
		return "UserCourse [userCourseId=" + userCourseId + ", userId=" + userId + ", courseId=" + courseId
				+ ", startDate=" + startDate + ", completionDate=" + completionDate + ", totalAmount=" + totalAmount + "]";
	} 
}
