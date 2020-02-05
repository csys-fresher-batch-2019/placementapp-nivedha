package com.trainingproject;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.trainingproject.dao.impl.ClientCompanyDAOImpl;
import com.trainingproject.dao.impl.RegistrationDAOImpl;
import com.trainingproject.model.ClientCompany;
import com.trainingproject.model.Registration;

public class TestClientCompany {

	public static void testCompanyDetails() throws Exception
	{
		ClientCompanyDAOImpl impl=new ClientCompanyDAOImpl();
		List<ClientCompany> list1=new ArrayList<ClientCompany>();
		System.out.println("");
		list1=impl.listCompanyDetails();
		for(ClientCompany client:list1)
		{

			System.out.println(client);
		}
	}
	public static void testSearchByCompany() throws Exception
	{
		ClientCompanyDAOImpl impl=new ClientCompanyDAOImpl();
		List<ClientCompany> list1=new ArrayList<ClientCompany>();
		ClientCompany cc=new ClientCompany();
		Scanner sc=new Scanner(System.in);
		System.out.println("");
	    System.out.println("***Display Company Details***");
		System.out.println("Enter Company Name:");
		cc.companyName=sc.nextLine();
		cc.companyName+=sc.nextLine();
		list1=impl.searchByCompany(cc.companyName);
		for(ClientCompany client:list1)
		{
			System.out.println(client);
		}
	}
	
	public static void testCompanyNames() throws Exception
	{
		ClientCompanyDAOImpl impl=new ClientCompanyDAOImpl();
		List<ClientCompany> list1=new ArrayList<ClientCompany>();
		System.out.println("");
		list1=impl.getCompanyNames();
		for(ClientCompany client:list1)
		{

			System.out.println(client);
		}
	}
	public static void testCompanyCount() throws Exception
	{
		ClientCompanyDAOImpl impl=new ClientCompanyDAOImpl();
		System.out.println("");
		System.out.println("***No Of Companies***");
		int count=impl.getNoOfCompanies();
		System.out.println(count);
	}
	public static void testInsert() throws Exception
	{
		
		Scanner sc=new Scanner(System.in);
		
		ArrayList<ClientCompany> list=new ArrayList<ClientCompany>();
		
		
		System.out.println("Enter Company details:");
				
		ClientCompany cc=new ClientCompany();
		System.out.println("Enter Company Name:");
		cc.companyName=sc.nextLine();
		cc.companyName+=sc.nextLine();
		System.out.println("Enter Company Type:");
		cc.companyType=sc.next();
		System.out.println("Enter Company Address:");
		cc.companyAddress=sc.nextLine();
		cc.companyAddress+=sc.nextLine();
		System.out.println("Enter Mobile Number:");
		cc.phoneNo=sc.nextLong();
		System.out.println("Enter Contact Person:");
		cc.contactPerson=sc.nextLine();
		cc.contactPerson+=sc.nextLine();
		System.out.println("Enter Mail Id:");
		cc.emailId=sc.next();
		
		list.add(cc);
		System.out.println("Company details is added");
		
		ClientCompanyDAOImpl impl=new ClientCompanyDAOImpl();
		for (ClientCompany company: list)
		{
		impl.addCompanyDetails(company);
		System.out.println(company);
		}

		sc.close();
	}
	
	public static void testDelete() throws Exception
	{
		Scanner sc=new Scanner(System.in);
		ClientCompany cc=new ClientCompany();
		ClientCompanyDAOImpl impl=new ClientCompanyDAOImpl();

		System.out.println("");
		System.out.println("***Delete Company Details***");
		System.out.println("Enter Client Id:");
		cc.clientId=sc.nextInt();
		impl.deleteCompanyDetails(cc.clientId);
		sc.close();
	}
	
	public static void testUpdate() throws Exception
	{
		Scanner sc=new Scanner(System.in);
		ClientCompany cc=new ClientCompany();
		ClientCompanyDAOImpl impl=new ClientCompanyDAOImpl();
		
		System.out.println("");
		System.out.println("***Update Company Details***");
		System.out.println("Enter Company Name:");
		cc.companyName=sc.nextLine();
		cc.companyName+=sc.nextLine();
		System.out.println("Enter Contact Person:");
		cc.contactPerson=sc.nextLine();
		cc.contactPerson+=sc.nextLine();
		impl.updateCompanyDetails(cc.contactPerson,cc.companyName);
	}

}
