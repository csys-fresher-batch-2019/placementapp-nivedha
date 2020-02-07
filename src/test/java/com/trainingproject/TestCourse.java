package com.trainingproject;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.trainingproject.TestCourse;
import com.trainingproject.dao.impl.CourseDAOImpl;
import com.trainingproject.model.Course;
import com.trainingproject.model.UserCourse;

public class TestCourse {
	
	
	
	public static void testGetCourseFees() throws Exception
	{
		Scanner sc=new Scanner(System.in);
		CourseDAOImpl obj=new CourseDAOImpl();
		Course c=new Course();
		System.out.println("");
		System.out.println("***Get Course Fees***");
		System.out.println("Enter Course Name:");
		c.setCourseName(sc.next());	
		int fees=obj.getFees(c.getCourseName());
		System.out.println(fees);
	}
	public static void testNamesByfeesRange() throws Exception
	{
		Scanner sc=new Scanner(System.in);
		CourseDAOImpl obj=new CourseDAOImpl();
		Course c=new Course();
		System.out.println("");
		System.out.println("***Get Course Name Based on Fees Range Between 10-25K***");
		System.out.println("Enter Course Fees1:");
		int fees1=sc.nextInt();
		System.out.println("Enter Course Fees2:");
		int fees2=sc.nextInt();
		List<Course> list=new ArrayList<Course>();
		list=obj.getNamesByfeesRange(fees1, fees2);
		for(Course courseList:list)
		{
			System.out.println("[CourseName: "+courseList.getCourseName()+", CourseFees: "+courseList.getCourseFees()+"]");
		}
	
	}
	public static void testAllCourses() throws Exception
	{
		CourseDAOImpl obj=new CourseDAOImpl();
		List<Course> list=new ArrayList<Course>();
		list=obj.allCourseDetails(".net");
		System.out.println("");
		for(Course courseList:list)
		{
			System.out.println(courseList.toString());
		}
	}
	
	
	public static void testMinFees() throws Exception
	{
		
		CourseDAOImpl obj=new CourseDAOImpl();
		List<Course> list=new ArrayList<Course>();
		list=obj.getMinFeesCourses();
		System.out.println("");
		for(Course courseList:list)
		{
			System.out.println(courseList.getCourseName()+"-"+courseList.getCourseFees());
			
		}

	}
	
	public static void testUpdate() throws Exception
	{
		Scanner sc=new Scanner(System.in);
		CourseDAOImpl obj=new CourseDAOImpl();
		Course c=new Course();
		System.out.println("");
		System.out.println("***Update Course Fees***");
		System.out.println("Enter Course Name:");
		c.setCourseName(sc.next());	
		System.out.println("Enter Course Fees:");
		c.setCourseFees(sc.nextInt());	
		obj.updateCourse(c.getCourseName(),c.getCourseFees());
	}
	
	public static void testDelete() throws Exception 
	{
		//delete course details
		Scanner sc=new Scanner(System.in);
		CourseDAOImpl obj=new CourseDAOImpl();
		Course c=new Course();
		System.out.println("");
		System.out.println("***Delete Course Details***");
		System.out.println("Enter Course Id:");
		c.setCourseId(sc.nextInt());	
		obj.deleteCourse(c.getCourseId());
	}
	
	public static void testInsert() throws Exception 
	{
		Scanner sc=new Scanner(System.in);
		//System.out.println("Enter no of courses to add");
		//int n=sc.nextInt();
		
		List<Course> list=new ArrayList<Course>();
		
			System.out.println("Enter Course details:");
					
				Course c1=new Course();
				System.out.println("Enter Course Name:");
				c1.setCourseName(sc.next());
				System.out.println("Enter Course Duration:");
				c1.setCourseDuration(sc.nextInt());
				System.out.println("Enter Course Fees:");
				c1.setCourseFees(sc.nextInt());
						
				list.add(c1);
				System.out.println("Course is added successfully");
				
				CourseDAOImpl obj=new CourseDAOImpl();
				for (Course course : list) 
				{
				obj.addCourses(course);	
				System.out.println(course);
				}
		
					
		
	}
	public static void testCourseNames() throws Exception
	{
		CourseDAOImpl obj=new CourseDAOImpl();
		List<Course> list=new ArrayList<Course>();
		list=obj.getCourseNames();
		System.out.println("");
		for(Course courseList:list)
		{
			System.out.println(courseList.getCourseName());
		}
	}
}
