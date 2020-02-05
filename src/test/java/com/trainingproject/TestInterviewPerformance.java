package com.trainingproject;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.trainingproject.dao.impl.CourseDAOImpl;
import com.trainingproject.dao.impl.InterviewPerformanceDAOImpl;
import com.trainingproject.model.InterviewPerformance;
import com.trainingproject.model.Registration;

public class TestInterviewPerformance {

	public static void testInsert() throws Exception
	{
		 InterviewPerformanceDAOImpl impl=new InterviewPerformanceDAOImpl();
	        
	        Scanner sc=new Scanner(System.in);
	        System.out.println("Enter the Client Id:");
	        int clientId=sc.nextInt();
	        
	        System.out.println("Enter the User Id:");
	        int userId=sc.nextInt();
	        
	        System.out.println("Enter the Interview Marks:");
	        int marks=sc.nextInt();
	        
	        String interPerform=impl.getPerformance(marks);
	        String interStatus=impl.getStatus(marks);
	        
            impl.addPerformanceDetails(clientId, userId, interPerform, interStatus, marks); 
            
            		
          /*  MailUtil mail=new MailUtil();
	        
	       if(interStatus.equals("selected"))
	       {
	    	   String subject="SELECTED";
	    	   String content="Congratulations!, We are waiting for your presence";
	    	   MailUtil.sendMail(mail.email,subject,content);
	       }
	       else if(interStatus.equals("waiting"))
	       {
	    	   String subject= "WAITING";
	    	   String content="Your in Waiting List";
	    	   MailUtil.sendMail(mail.email,subject,content);
	    	   
	       }
	       else {
	    	   String subject="rejected";
	    	   String content="Your Rejected";
	    	   MailUtil.sendMail(mail.email,subject,content);
	       }*/
	       
	        sc.close();
	}
	public static void testPerform() throws Exception
	{
	        
	        InterviewPerformanceDAOImpl impl=new InterviewPerformanceDAOImpl();
	        List<InterviewPerformance> list=new ArrayList<InterviewPerformance>();
	        list=impl.viewPerformanceStatus();
	        System.out.println("");
	        for(InterviewPerformance in:list)
	        {
	        	System.out.println(in);
	        }
           
	       
	       
	}
	

}
