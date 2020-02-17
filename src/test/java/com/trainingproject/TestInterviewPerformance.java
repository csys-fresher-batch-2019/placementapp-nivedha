package com.trainingproject;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.trainingproject.dao.impl.GradeDAOImpl;
import com.trainingproject.dao.impl.InterviewPerformanceDAOImpl;
import com.trainingproject.logger.Logger;
import com.trainingproject.model.InterviewPerformance;

public class TestInterviewPerformance {

	private static final Logger log=Logger.getInstance();
	public static void testInsert() throws DbException
	{
		 InterviewPerformanceDAOImpl impl=new InterviewPerformanceDAOImpl();
	        
	        Scanner sc=new Scanner(System.in);
	        log.getInput("Enter the Client Id:");
	        int clientId=sc.nextInt();
	        
	        log.getInput("Enter the User Id:");
	        int userId=sc.nextInt();
	        
	        log.getInput("Enter the Interview Marks:");
	        int marks=sc.nextInt();
	        
	        GradeDAOImpl grade=new GradeDAOImpl();
	        	        
            impl.addPerformanceDetails(clientId, userId, marks); 
            grade.updateStatus();
            		
            sc.close();
	}
	public static void testPerform() throws DbException
	{
	        
	        InterviewPerformanceDAOImpl impl=new InterviewPerformanceDAOImpl();
	        List<InterviewPerformance> list=new ArrayList<InterviewPerformance>();
	        list=impl.viewPerformanceStatus();
	        log.getInput("");
	        for(InterviewPerformance in:list)
	        {
	        	log.getInput(in);
	        }
           
	       
	       
	}
	

}
