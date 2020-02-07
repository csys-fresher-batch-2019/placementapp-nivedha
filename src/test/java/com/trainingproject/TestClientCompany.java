package com.trainingproject;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.trainingproject.dao.impl.ClientCompanyDAOImpl;
import com.trainingproject.dao.impl.RegistrationDAOImpl;
import com.trainingproject.logger.Logger;
import com.trainingproject.model.ClientCompany;
import com.trainingproject.model.Registration;

public class TestClientCompany {
	
	private static final Logger log=Logger.getInstance();
	public static void testCompanyDetails() throws Exception
	{
		ClientCompanyDAOImpl impl=new ClientCompanyDAOImpl();
		List<ClientCompany> list1=new ArrayList<ClientCompany>();
		log.getInput("");
		list1=impl.listCompanyDetails();
		for(ClientCompany client:list1)
		{

			log.getInput(client);
		}
	}
	public static void testSearchByCompany() throws Exception
	{
		ClientCompanyDAOImpl impl=new ClientCompanyDAOImpl();
		List<ClientCompany> list1=new ArrayList<ClientCompany>();
		ClientCompany cc=new ClientCompany();
		Scanner sc=new Scanner(System.in);
		log.getInput("");
	    log.getInput("***Display Company Details***");
		log.getInput("Enter Company Name:");
		cc.setCompanyName(sc.nextLine());
		cc.setCompanyName(cc.getCompanyName() + sc.nextLine());
		list1=impl.searchByCompany(cc.getCompanyName());
		for(ClientCompany client:list1)
		{
			log.getInput(client);
		}
	}
	
	public static void testCompanyNames() throws Exception
	{
		ClientCompanyDAOImpl impl=new ClientCompanyDAOImpl();
		List<ClientCompany> list1=new ArrayList<ClientCompany>();
		log.getInput("");
		list1=impl.getCompanyNames();
		for(ClientCompany client:list1)
		{

			log.getInput(client);
		}
	}
	public static void testCompanyCount() throws Exception
	{
		ClientCompanyDAOImpl impl=new ClientCompanyDAOImpl();
		log.getInput("");
		log.getInput("***No Of Companies***");
		int count=impl.getNoOfCompanies();
		log.getInput(count);
	}
	public static void testInsert() throws Exception
	{
		
		Scanner sc=new Scanner(System.in);
		
		ArrayList<ClientCompany> list=new ArrayList<ClientCompany>();
		
		
		log.getInput("Enter Company details:");
				
		ClientCompany cc=new ClientCompany();
		log.getInput("Enter Company Name:");
		cc.setCompanyName(sc.nextLine());
		cc.setCompanyName(cc.getCompanyName() + sc.nextLine());
		log.getInput("Enter Company Type:");
		cc.setCompanyType(sc.next());
		log.getInput("Enter Company Address:");
		cc.setCompanyAddress(sc.nextLine());
		cc.setCompanyAddress(cc.getCompanyAddress() + sc.nextLine());
		log.getInput("Enter Mobile Number:");
		cc.setPhoneNo(sc.nextLong());
		log.getInput("Enter Contact Person:");
		cc.setContactPerson(sc.nextLine());
		cc.setContactPerson(cc.getContactPerson() + sc.nextLine());
		log.getInput("Enter Mail Id:");
		cc.setEmailId(sc.next());
		
		list.add(cc);
		log.getInput("Company details is added");
		
		ClientCompanyDAOImpl impl=new ClientCompanyDAOImpl();
		for (ClientCompany company: list)
		{
		impl.addCompanyDetails(company);
		log.getInput(company);
		}

		sc.close();
	}
	
	public static void testDelete() throws Exception
	{
		Scanner sc=new Scanner(System.in);
		ClientCompany cc=new ClientCompany();
		ClientCompanyDAOImpl impl=new ClientCompanyDAOImpl();

		log.getInput("");
		log.getInput("***Delete Company Details***");
		log.getInput("Enter Client Id:");
		cc.setClientId(sc.nextInt());
		impl.deleteCompanyDetails(cc.getClientId());
		sc.close();
	}
	
	public static void testUpdate() throws Exception
	{
		Scanner sc=new Scanner(System.in);
		ClientCompany cc=new ClientCompany();
		ClientCompanyDAOImpl impl=new ClientCompanyDAOImpl();
		
		log.getInput("");
		log.getInput("***Update Company Details***");
		log.getInput("Enter Company Name:");
		cc.setCompanyName(sc.nextLine());
		cc.setCompanyName(cc.getCompanyName() + sc.nextLine());
		log.getInput("Enter Contact Person:");
		cc.setContactPerson(sc.nextLine());
		cc.setContactPerson(cc.getContactPerson() + sc.nextLine());
		impl.updateCompanyDetails(cc.getContactPerson(),cc.getCompanyName());
	}

}
