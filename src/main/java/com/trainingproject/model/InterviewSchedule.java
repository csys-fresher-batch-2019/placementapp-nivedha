package com.trainingproject.model;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;
import java.util.Timer;

public class InterviewSchedule {

	public int interviewId;
	public int clientId;
	public String jobTitle;
	public String jobRequirement;
	public LocalDate createdDate;
	public LocalDate interviewDate;
	public LocalTime interviewTime;
	@Override
	public String toString() {
		return "InterviewSchedule [interviewId=" + interviewId + ", clientId=" + clientId + ", jobTitle=" + jobTitle
				+ ", jobRequirement=" + jobRequirement + ", createdDate=" + createdDate + ", interviewDate="
				+ interviewDate + ", interviewTime=" + interviewTime + "]";
	}
	
}
