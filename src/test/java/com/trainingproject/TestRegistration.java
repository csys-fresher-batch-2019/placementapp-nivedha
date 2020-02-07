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
			log.getInput(register);
		}
	}
	public static void testUserDegree() throws Exception
	{
		RegistrationDAOImpl impl=new RegistrationDAOImpl();
		List<Registration> list1=new ArrayList<Registration>();
		list1=impl.getDegreeWiseNoOfUsers();
		for(Registration register:list1)
		{
			log.getInput(register.getQualification()+"="+register.getUserId());
		}	
	}
	public static void testUserCount() throws Exception
	{
		RegistrationDAOImpl impl=new RegistrationDAOImpl();
		int usersCount=impl.getNoOfUsers();
		log.getInput("No.of users Registered:"+usersCount);
	}

	public static void testInsert() throws Exception
	{
		Scanner sc=new Scanner(System.in);
		//log.getInput("Enter no of Users:");
		//int n=sc.nextInt();
		ArrayList<Registration> list=new ArrayList<Registration>();
	
		log.getInput("Enter User details:");
				
		Registration reg1=new Registration();
		log.getInput("Enter userName:");
		reg1.setUserName(sc.nextLine());
		reg1.setUserName(reg1.getUserName() + sc.nextLine());
		log.getInput("Enter Password:");
		reg1.setUserPassword(sc.next());
		log.getInput("Enter userCity:");
		reg1.setUserCity(sc.nextLine());
		reg1.setUserCity(reg1.getUserCity() + sc.nextLine());
		log.getInput("Enter MobileNo:");
		reg1.setMobileNo(sc.nextLong());
		log.getInput("Enter MailId:");
		reg1.setMailId(sc.next());
		log.getInput("Enter user Qualification:");
		reg1.setQualification(sc.next());
		log.getInput("Enter Gender:");
		reg1.setGender(sc.next());
		list.add(reg1);
		log.getInput("Successfully Registered");
		
		RegistrationDAOImpl impl=new RegistrationDAOImpl();
		for (Registration register : list)
		{
		impl.addUserDetails(register);
		log.getInput(register);
		}
		sc.close();
}
		
	public static void testUpdate() throws Exception
		{
			log.getInput("");
			log.getInput("***Update User Details***");
			Scanner sc=new Scanner(System.in);
			log.getInput("Enter userId:");
			int userId=sc.nextInt();
			log.getInput("Enter Mobile Number:");
			Long mobileNo=sc.nextLong();
			
			RegistrationDAOImpl impl=new RegistrationDAOImpl();
            impl.updateUserDetails(userId, mobileNo);
	        sc.close();
		}
	public static void testDelete() throws Exception
		{
			log.getInput("");
			log.getInput("***Delete User Details***");
			Scanner sc=new Scanner(System.in);
			log.getInput("Enter userId:");
			int userId=sc.nextInt();
			
			RegistrationDAOImpl impl=new RegistrationDAOImpl();
            impl.deleteUserDetails(userId);
	        sc.close();
		}

	

}
