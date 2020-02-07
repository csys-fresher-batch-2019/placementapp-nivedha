package com.trainingproject;
import java.util.Scanner;

import com.trainingproject.dao.impl.CommentsDAOImpl;
import com.trainingproject.model.Comments;

public class TestComments {
	
	
	
	public static void testAddComments() throws Exception
	{
		CommentsDAOImpl impl=new CommentsDAOImpl();
		Comments c=new Comments();
		Scanner sc=new Scanner(System.in);
		System.out.println("***Comments details***");
		System.out.println("Enter UserCourse Id:");
		c.setUserCourseId(sc.nextInt());
		String a=impl.getUserName(c.getUserCourseId());
		System.out.println("User Name is:");
		System.out.println(a);
		String b=impl.getCourseName(c.getUserCourseId());
		System.out.println("Course Name is:");
		System.out.println(b);
		System.out.println("Enter Trainer Id:");
		c.setTrainerId(sc.nextInt());
	    String t=impl.getTrainerName(c.getTrainerId());
		System.out.println("Trainer Name is:");
		System.out.println(t);
		System.out.println("Enter Course Comments:");
		c.setCourseComments(sc.nextLine());
		c.setCourseComments(c.getCourseComments() + sc.nextLine());
		System.out.println("Enter Trainer Rating:");
		c.setTrainerRating(sc.nextInt());
		System.out.println("Enter Institution Rating:");
		c.setInstitutionRating(sc.nextInt());
		
		impl.addComments(c);
		System.out.println(c);
	}
}
