package com.trainingproject.model;

public class Registration {
	public int userId;
	public String userName;
	public String mailId;
	public String userPassword;
	public String userCity;
	public long mobileNo;
	public String qualification;
	public String gender;
	@Override
	public String toString() {
		return "Registration [userId=" + userId + ", userName=" + userName + ", mailId=" + mailId + ", userPassword="
				+ userPassword + ", userCity=" + userCity + ", mobileNo=" + mobileNo + ", qualification="
				+ qualification + ", gender=" + gender + "]";
	}

}
