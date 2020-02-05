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
        System.out.println("");
        for(JoinUserCourse join:list)
        {
        	System.out.println(join);
        }
        
	}
	public static void testJoinUserCompany()throws Exception
	{
		Scanner sc=new Scanner(System.in);
		JoinDAOImpl impl=new JoinDAOImpl();
		List<JoinUserCompany> list=new ArrayList<JoinUserCompany>();
        System.out.println("Enter Interview Status(selected/waiting/rejected):");
		String interStatus=sc.next();
		list=impl.getUserCompanyDetails(interStatus);
        System.out.println("");
        for(JoinUserCompany join:list)
        {
        	System.out.println(join);
        }
        sc.close();
	}
	public static void testJoinCompanySchedule()throws Exception
	{
		Scanner sc=new Scanner(System.in);
		JoinDAOImpl impl=new JoinDAOImpl();
		List<JoinCompanySchedule> list=new ArrayList<JoinCompanySchedule>();
		System.out.println("");
        System.out.println("Enter Interview Date:");
		String interviewDate=sc.next();
		list=impl.getCompanySchedule(interviewDate);
        System.out.println("");
        for(JoinCompanySchedule join:list)
        {
        	System.out.println(join.toString());
        }
        sc.close();
	}

}
