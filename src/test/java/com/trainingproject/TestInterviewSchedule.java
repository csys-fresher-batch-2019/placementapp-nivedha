package com.trainingproject;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.trainingproject.dao.impl.InterviewScheduleDAOImpl;
import com.trainingproject.logger.Logger;
import com.trainingproject.model.ClientCompany;
import com.trainingproject.model.InterviewSchedule;

public class TestInterviewSchedule {

	private static final Logger log=Logger.getInstance();
	public static void testAllSchedule() throws DbException
	{
		Scanner sc=new Scanner(System.in);
		InterviewScheduleDAOImpl impl=new InterviewScheduleDAOImpl();
		InterviewSchedule inter=new InterviewSchedule();
		List<InterviewSchedule> list=new ArrayList<InterviewSchedule>();
		list=impl.allInterviewSchedules();
		for (InterviewSchedule interview : list)
		{
			log.getInput(interview);
		}
	}
	public static void testGetJobReq() throws DbException
	{
		Scanner sc=new Scanner(System.in);
		InterviewScheduleDAOImpl impl=new InterviewScheduleDAOImpl();
		InterviewSchedule inter=new InterviewSchedule();
		log.getInput("");
		log.getInput("***Display Company Details Based on JobRequirement***");
		log.getInput("Enter Job Requirement:");
		inter.setJobRequirement(sc.nextLine());
		inter.setJobRequirement(inter.getJobRequirement() + sc.nextLine());
		List<ClientCompany> list1=new ArrayList<ClientCompany>();
		
		list1=impl.getCompanyDetails(inter.getJobRequirement());
		for (ClientCompany cmpy : list1)
		{
			log.getInput(cmpy);
		}
	}
	
	
	public static void testDelete() throws DbException
	{
		Scanner sc=new Scanner(System.in);
		InterviewScheduleDAOImpl impl=new InterviewScheduleDAOImpl();
		InterviewSchedule inter=new InterviewSchedule();
		log.getInput("");
		log.getInput("Enter Interview Id:");
		inter.setInterviewId(sc.nextInt());
		impl.deleteSchedule(inter.getInterviewId());
	}
	public static void testInsert() throws DbException
	{
		LocalDate currentDate = LocalDate.now();
		Scanner sc=new Scanner(System.in);
		List<InterviewSchedule> list=new ArrayList<InterviewSchedule>();

		InterviewSchedule is1=new InterviewSchedule();
		is1.setClientId(1111);
		is1.setJobTitle("python developer");
		is1.setJobRequirement("python");
		is1.setCreatedDate(currentDate);
		is1.setInterviewDate(LocalDate.parse("2020-02-02"));
		is1.setInterviewTime(LocalTime.parse("10:00"));
		
		list.add(is1);
		
		InterviewScheduleDAOImpl impl=new InterviewScheduleDAOImpl();
		InterviewSchedule inter=new InterviewSchedule();
		for (InterviewSchedule interview : list)
		{
		impl.addSchedule(interview);
		}
	}

}
