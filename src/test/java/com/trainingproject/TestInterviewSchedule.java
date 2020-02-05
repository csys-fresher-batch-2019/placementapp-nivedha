package com.trainingproject;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.trainingproject.dao.impl.InterviewScheduleDAOImpl;
import com.trainingproject.model.ClientCompany;
import com.trainingproject.model.InterviewSchedule;

public class TestInterviewSchedule {

	public static void testAllSchedule() throws Exception
	{
		Scanner sc=new Scanner(System.in);
		InterviewScheduleDAOImpl impl=new InterviewScheduleDAOImpl();
		InterviewSchedule inter=new InterviewSchedule();
		List<InterviewSchedule> list=new ArrayList<InterviewSchedule>();
		list=impl.allInterviewSchedules();
		for (InterviewSchedule interview : list)
		{
			System.out.println(interview);
		}
	}
	public static void testGetJobReq() throws Exception
	{
		Scanner sc=new Scanner(System.in);
		InterviewScheduleDAOImpl impl=new InterviewScheduleDAOImpl();
		InterviewSchedule inter=new InterviewSchedule();
		System.out.println("");
		System.out.println("***Display Company Details Based on JobRequirement***");
		System.out.println("Enter Job Requirement:");
		inter.jobRequirement=sc.nextLine();
		inter.jobRequirement+=sc.nextLine();
		List<ClientCompany> list1=new ArrayList<ClientCompany>();
		
		list1=impl.getCompanyDetails(inter.jobRequirement);
		for (ClientCompany cmpy : list1)
		{
			System.out.println(cmpy);
		}
	}
	
	public static void testNoOfCompanies() throws Exception
	{
		Scanner sc=new Scanner(System.in);
		InterviewScheduleDAOImpl impl=new InterviewScheduleDAOImpl();
		InterviewSchedule inter=new InterviewSchedule();
		System.out.println("");
		System.out.println("***Display Company Count Based on JobRequirement***");
		System.out.println("Enter Job Requirement:");
		inter.jobRequirement=sc.nextLine();
		inter.jobRequirement+=sc.nextLine();
		int jobCount=impl.getNoOfCompanies(inter.jobRequirement);
		System.out.println(jobCount);
		
	}
	public static void testDelete() throws Exception
	{
		Scanner sc=new Scanner(System.in);
		InterviewScheduleDAOImpl impl=new InterviewScheduleDAOImpl();
		InterviewSchedule inter=new InterviewSchedule();
		System.out.println("");
		System.out.println("Enter Interview Id:");
		inter.interviewId=sc.nextInt();
		impl.deleteSchedule(inter.interviewId);
	}
	public static void testInsert() throws Exception
	{
		LocalDate currentDate = LocalDate.now();
		Scanner sc=new Scanner(System.in);
		List<InterviewSchedule> list=new ArrayList<InterviewSchedule>();

		InterviewSchedule is1=new InterviewSchedule();
		is1.clientId=1111;
		is1.jobTitle="python developer";
		is1.jobRequirement="python";
		is1.createdDate=currentDate;
		is1.interviewDate=LocalDate.parse("2020-02-02");
		is1.interviewTime= LocalTime.parse("10:00");
		
		list.add(is1);
		
		InterviewScheduleDAOImpl impl=new InterviewScheduleDAOImpl();
		InterviewSchedule inter=new InterviewSchedule();
		for (InterviewSchedule interview : list)
		{
		impl.addSchedule(interview);
		}
	}

}
