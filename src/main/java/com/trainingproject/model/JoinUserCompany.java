package com.trainingproject.model;

public class JoinUserCompany {

	public int userId;
	public String userName;
	public String qualification;
	public String mailId;
	public long mobileNo;
	public String userCity;
	public String gender;
	public  int clientId;
	public  String companyName;
	public  String companyType;
	public  String companyAddress;
	public  long phoneNo;
	public  String contactPerson;
	public  String emailId;
	public String interPerform;
	public String interStatus;
	@Override
	public String toString() {
		return " *************************************\n USER DETAILS: \n userId: " + userId + "\n"
				+ " userName: " + userName + "\n qualification: " + qualification
				+ "\n mailId: " + mailId + "\n mobileNo: " + mobileNo + "\n userCity: " + userCity + "\n gender: " + gender
				+ "\n\n CLIENT DETAILS:\n clientId: " + clientId + "\n companyName: " + companyName + "\n companyType: " + companyType
				+ "\n companyAddress: " + companyAddress + "\n phoneNo: " + phoneNo + "\n contactPerson: " + contactPerson
				+ "\n emailId: " + emailId + "\n interPerform: " + interPerform + "\n interStatus: " + interStatus + "\n *************************************\n";
	}
	
	
}
