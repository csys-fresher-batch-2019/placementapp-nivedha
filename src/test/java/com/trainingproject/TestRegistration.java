package com.trainingproject;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.trainingproject.dao.impl.InterviewPerformanceDAOImpl;
import com.trainingproject.dao.impl.RegistrationDAOImpl;
import com.trainingproject.model.Registration;

public class TestRegistration {

	
	public static void testAllUserDetails() throws Exception
	{
        List<Registration> list1=new ArrayList<Registration>();
		RegistrationDAOImpl impl=new RegistrationDAOImpl();
		list1=impl.allUserDetails();
		for(Registration register:list1)
		{
			System.out.println(register);
		}
	}
	public static void testUserDegree() throws Exception
	{
		RegistrationDAOImpl impl=new RegistrationDAOImpl();
		List<Registration> list1=new ArrayList<Registration>();
		list1=impl.getDegreeWiseNoOfUsers();
		for(Registration register:list1)
		{
			System.out.println(register.qualification+"="+register.userId);
		}	
	}
	public static void testUserCount() throws Exception
	{
		RegistrationDAOImpl impl=new RegistrationDAOImpl();
		int usersCount=impl.getNoOfUsers();
		System.out.println("No.of users Registered:"+usersCount);
	}

	public static void testInsert() throws Exception
	{
		Scanner sc=new Scanner(System.in);
		//System.out.println("Enter no of Users:");
		//int n=sc.nextInt();
		ArrayList<Registration> list=new ArrayList<Registration>();
	
		System.out.println("Enter User details:");
				
		Registration reg1=new Registration();
		System.out.println("Enter userName:");
		reg1.userName=sc.nextLine();
		reg1.userName+=sc.nextLine();
		System.out.println("Enter Password:");
		reg1.userPassword=sc.next();
		System.out.println("Enter userCity:");
		reg1.userCity=sc.nextLine();
		reg1.userCity+=sc.nextLine();
		System.out.println("Enter MobileNo:");
		reg1.mobileNo=sc.nextLong();
		System.out.println("Enter MailId:");
		reg1.mailId=sc.next();
		System.out.println("Enter user Qualification:");
		reg1.qualification=sc.next();
		System.out.println("Enter Gender:");
		reg1.gender=sc.next();
		list.add(reg1);
		System.out.println("Successfully Registered");
		
		RegistrationDAOImpl impl=new RegistrationDAOImpl();
		for (Registration register : list)
		{
		impl.addUserDetails(register);
		System.out.println(register);
		}
		sc.close();
}
		
	public static void testUpdate() throws Exception
		{
			System.out.println("");
			System.out.println("***Update User Details***");
			Scanner sc=new Scanner(System.in);
			System.out.println("Enter userId:");
			int userId=sc.nextInt();
			System.out.println("Enter Mobile Number:");
			Long mobileNo=sc.nextLong();
			
			RegistrationDAOImpl impl=new RegistrationDAOImpl();
            impl.updateUserDetails(userId, mobileNo);
	        sc.close();
		}
	public static void testDelete() throws Exception
		{
			System.out.println("");
			System.out.println("***Delete User Details***");
			Scanner sc=new Scanner(System.in);
			System.out.println("Enter userId:");
			int userId=sc.nextInt();
			
			RegistrationDAOImpl impl=new RegistrationDAOImpl();
            impl.deleteUserDetails(userId);
	        sc.close();
		}

	

}
