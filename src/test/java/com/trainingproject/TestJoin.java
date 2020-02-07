package com.trainingproject;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.trainingproject.dao.impl.JoinDAOImpl;
import com.trainingproject.model.JoinCompanySchedule;
import com.trainingproject.model.JoinUserCompany;
import com.trainingproject.model.JoinUserCourse;

public class TestJoin {
	
	public static void testJoinUserCourse()throws Exception
	{
		JoinDAOImpl impl=new JoinDAOImpl();
		List<JoinUserCourse> list=new ArrayList<JoinUserCourse>();
        list=impl.getUserCourseDetails();
        log.getInput("");
        for(JoinUserCourse join:list)
        {
        	log.getInput(join);
        }
        
	}
	public static void testJoinUserCompany()throws Exception
	{
		Scanner sc=new Scanner(System.in);
		JoinDAOImpl impl=new JoinDAOImpl();
		List<JoinUserCompany> list=new ArrayList<JoinUserCompany>();
        log.getInput("Enter Interview Status(selected/waiting/rejected):");
		String interStatus=sc.next();
		list=impl.getUserCompanyDetails(interStatus);
        log.getInput("");
        for(JoinUserCompany join:list)
        {
        	log.getInput(join);
        }
        sc.close();
	}
	public static void testJoinCompanySchedule()throws Exception
	{
		Scanner sc=new Scanner(System.in);
		JoinDAOImpl impl=new JoinDAOImpl();
		List<JoinCompanySchedule> list=new ArrayList<JoinCompanySchedule>();
		log.getInput("");
        log.getInput("Enter Interview Date:");
		String interviewDate=sc.next();
		list=impl.getCompanySchedule(interviewDate);
        log.getInput("");
        for(JoinCompanySchedule join:list)
        {
        	log.getInput(join.toString());
        }
        sc.close();
	}

}
