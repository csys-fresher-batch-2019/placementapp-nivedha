package com.trainingproject.model;

import java.time.LocalDate;
import java.time.LocalTime;

public class JoinCompanySchedule {

	@Override
	public String toString() {
		return "JoinCompanySchedule [companyName=" + companyName + ", companyType=" + companyType + ", companyAddress="
				+ companyAddress + ", phoneNo=" + phoneNo + ", contactPerson=" + contactPerson + ", emailId=" + emailId
				+ ", jobTitle=" + jobTitle + ", jobRequirement=" + jobRequirement + ", interviewDate=" + interviewDate
				+ ", interviewTime=" + interviewTime + "]";
	}
	public  String companyName;
	public  String companyType;
	public  String companyAddress;
	public  long phoneNo;
	public  String contactPerson;
	public  String emailId; 
	public String jobTitle;
	public String jobRequirement;
	public LocalDate interviewDate;
	public LocalTime interviewTime;
}
