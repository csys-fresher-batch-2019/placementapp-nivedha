package com.trainingproject.model;

public class ClientCompany {
	public  int clientId;
	public  String companyName;
	public  String companyType;
	public  String companyAddress;
	public  long phoneNo;
	public  String contactPerson;
	public  String emailId; 
	
	public String toString() {
	
	StringBuffer content=new StringBuffer();
	content.append("ClientId = ").append(clientId+" ");
	content.append("CompanyName = ").append(companyName+" ");
	content.append("CompanyType = ").append(companyType+" ");
	content.append("CompanyAddress = ").append(companyAddress+" ");
	content.append("PhoneNo = ").append(phoneNo+" ");
	content.append("ContactPerson = ").append(contactPerson+" ");
	content.append("EmailId = ").append(emailId+" ");
	return content.toString();
	
    }
	
}
