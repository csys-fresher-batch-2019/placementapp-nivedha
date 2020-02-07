package com.trainingproject;

import java.time.LocalDate;
import java.util.*;

import com.trainingproject.dao.impl.CourseDAOImpl;
import com.trainingproject.dao.impl.RegistrationDAOImpl;
import com.trainingproject.dao.impl.UserCourseDAOImpl;
import com.trainingproject.model.Course;
import com.trainingproject.model.Registration;
import com.trainingproject.model.UserCourse;

public class TestUserCourse {

	public static void userCourseDetails()throws Exception
	{
		//List all course details
				CourseDAOImpl obj=new CourseDAOImpl();
				List<Course> list=new ArrayList<Course>();
				
				list=obj.allCourseDetails(".net");
				for(Course courseList:list)
				{
					System.out.println(courseList.toString());
				}
				
	    //List all user details
				RegistrationDAOImpl impl=new RegistrationDAOImpl();
		        List<Registration> list1=new ArrayList<Registration>();
				
				list1=impl.allUserDetails();
				for(Registration register:list1)
				{
					System.out.println(register);
				}
	
	}
	public static void testInsert() throws Exception
	{
		LocalDate currentDate = LocalDate.now();
		Scanner sc=new Scanner(System.in);
		System.out.println("");
		//System.out.println("Enter no of UserCourse details to add");
		//int n=sc.nextInt();
		ArrayList<UserCourse> list2=new ArrayList<UserCourse>();
		
		
			
		System.out.println("Enter UserCourse details:");
		
		UserCourse uc1=new UserCourse();
		System.out.println("Enter User Id:");
		uc1.setUserId(sc.nextInt());
		System.out.println("Enter Course Id:");
		uc1.setCourseId(sc.nextInt());
		uc1.setStartDate(currentDate);
		list2.add(uc1);
		
		System.out.println("UserCourse detail is added");
		
        UserCourseDAOImpl impl1=new UserCourseDAOImpl();
		
		for (UserCourse userCourse : list2) 
		{
			int duration=impl1.getDuration(uc1.getCourseId());
			System.out.println(duration);
			userCourse.setCompletionDate(userCourse.getStartDate().plusMonths(duration));
			System.out.println(userCourse);
			userCourse.setTotalAmount(discount());
			impl1.addCourseDurationDate(userCourse);
			System.out.println(userCourse);
		}
				
}
	public static void testgetUserCourseDetails() throws Exception
	{
		Scanner sc=new Scanner(System.in);
		UserCourse uc1=new UserCourse();
		System.out.println("Enter User Id:");
		uc1.setUserId(sc.nextInt());
		 UserCourseDAOImpl impl1=new UserCourseDAOImpl();
		 List<UserCourse> list1=new ArrayList<UserCourse>();
		 list1=impl1.getUserCourseDetails(uc1.getUserId());
			for (UserCourse userCourse : list1) 
			{
			System.out.println(userCourse);
			}
		
	}
	public static double discount()throws Exception
	{
		Scanner sc=new Scanner(System.in);
        DiscountCalculation dis=new DiscountCalculation();
    	UserCourse uc=new UserCourse();
    	Course c=new Course();
    	System.out.println("");
    	System.out.println("To Display the Discount Details of the User");
    	System.out.println("Enter User Id:");
		uc.setUserId(sc.nextInt());
		System.out.println("Enter Course Id:");
		c.setCourseId(sc.nextInt());
		
    	int courseCount=dis.getNoOfUser(uc.getUserId());
    	System.out.println(courseCount);
    	int courseFees=dis.getCourseFees(c.getCourseId());
    	System.out.println(courseFees);
    	
    	double discountAmount;
		switch(courseCount)
		{
		case 2:
			discountAmount=courseFees*.05;
			break;
		case 3:
			discountAmount=courseFees*.10;
			break;
		case 4:
			discountAmount=courseFees*.15;
			break;
		case 5:
			discountAmount=courseFees*.20;
			break;
		default:
			discountAmount=0;
		}
		System.out.println("");
		System.out.println("DiscountAmount: " +discountAmount);
		double totalAmount=courseFees-discountAmount;
		System.out.println("TotalAmount:" +totalAmount);
		sc.close();
		return totalAmount;
    
	}

}
