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
		log.getInput("***Comments details***");
		log.getInput("Enter UserCourse Id:");
		c.setUserCourseId(sc.nextInt());
		String a=impl.getUserName(c.getUserCourseId());
		log.getInput("User Name is:");
		log.getInput(a);
		String b=impl.getCourseName(c.getUserCourseId());
		log.getInput("Course Name is:");
		log.getInput(b);
		log.getInput("Enter Trainer Id:");
		c.setTrainerId(sc.nextInt());
	    String t=impl.getTrainerName(c.getTrainerId());
		log.getInput("Trainer Name is:");
		log.getInput(t);
		log.getInput("Enter Course Comments:");
		c.setCourseComments(sc.nextLine());
		c.setCourseComments(c.getCourseComments() + sc.nextLine());
		log.getInput("Enter Trainer Rating:");
		c.setTrainerRating(sc.nextInt());
		log.getInput("Enter Institution Rating:");
		c.setInstitutionRating(sc.nextInt());
		
		impl.addComments(c);
		log.getInput(c);
	}
}
