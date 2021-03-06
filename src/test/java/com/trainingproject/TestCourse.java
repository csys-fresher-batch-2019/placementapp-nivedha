package com.trainingproject;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.trainingproject.dao.impl.CourseDAOImpl;
import com.trainingproject.logger.Logger;
import com.trainingproject.model.Course;

public class TestCourse {

	private static final Logger log = Logger.getInstance();

	public static void testGetCourseFees() throws DbException {
		Scanner sc = new Scanner(System.in);
		CourseDAOImpl obj = new CourseDAOImpl();
		Course c = new Course();
		log.getInput("***Get Course Fees***");
		log.getInput("Enter Course Name:");
		c.setCourseName(sc.next());
		int fees = obj.getFees(c.getCourseName());
		log.getInput(fees);
	}

	public static void testNamesByfeesRange() throws DbException {
		Scanner sc = new Scanner(System.in);
		CourseDAOImpl obj = new CourseDAOImpl();
		Course c = new Course();
		log.getInput("***Get Course Name Based on Fees Range Between 10-25K***");
		log.getInput("Enter Course Fees1:");
		int fees1 = sc.nextInt();
		log.getInput("Enter Course Fees2:");
		int fees2 = sc.nextInt();
		List<Course> list = new ArrayList<Course>();
		list = obj.getNamesByfeesRange(fees1, fees2);
		for (Course courseList : list) {
			log.getInput(
					"[CourseName: " + courseList.getCourseName() + ", CourseFees: " + courseList.getCourseFees() + "]");
		}
	}

	public static void testAllCourses() throws DbException {
		Scanner sc = new Scanner(System.in);
		CourseDAOImpl obj = new CourseDAOImpl();
		List<Course> list = new ArrayList<Course>();
		log.getInput("Enter Course Name");
		String courseName = sc.nextLine();
		list = obj.allCourseDetails(courseName);
		for (Course courseList : list) {
			log.getInput(courseList.toString());
		}
	}

	public static void testMinFees() throws DbException {
		CourseDAOImpl obj = new CourseDAOImpl();
		List<Course> list = new ArrayList<Course>();
		list = obj.getMinFeesCourses();
		for (Course courseList : list) {
			log.getInput(courseList.getCourseName() + "-" + courseList.getCourseFees());
		}
	}

	public static void testUpdate() throws DbException {
		Scanner sc = new Scanner(System.in);
		CourseDAOImpl obj = new CourseDAOImpl();
		Course c = new Course();
		log.getInput("***Update Course Fees***");
		log.getInput("Enter Course Name:");
		c.setCourseName(sc.next());
		log.getInput("Enter Course Fees:");
		c.setCourseFees(sc.nextInt());
		obj.updateCourse(c.getCourseName(), c.getCourseFees());
	}

	public static void testDelete() throws DbException {
		Scanner sc = new Scanner(System.in);
		CourseDAOImpl obj = new CourseDAOImpl();
		Course c = new Course();
		log.getInput("***Delete Course Details***");
		log.getInput("Enter Course Id:");
		c.setCourseId(sc.nextInt());
		obj.deleteCourse(c.getCourseId());
	}

	public static void testInsert() throws DbException {
		Scanner sc = new Scanner(System.in);
		List<Course> list = new ArrayList<Course>();
		log.getInput("Enter Course details:");
		Course c1 = new Course();
		log.getInput("Enter Course Name:");
		c1.setCourseName(sc.next());
		log.getInput("Enter Course Duration:");
		c1.setCourseDuration(sc.nextInt());
		log.getInput("Enter Course Fees:");
		c1.setCourseFees(sc.nextInt());
		log.getInput("Enter Course PDF:");
		c1.setCoursePdf(sc.next());
		log.getInput("Enter Course Image:");
		c1.setCourseImage(sc.next());
		list.add(c1);
		log.getInput("Course is added successfully");
		CourseDAOImpl obj = new CourseDAOImpl();
		for (Course course : list) {
			obj.addCourses(course);
			log.getInput(course);
		}
	}

	public static void testCourseNames() throws DbException {
		CourseDAOImpl obj = new CourseDAOImpl();
		List<Course> list = new ArrayList<Course>();
		list = obj.getCourseNames();
		log.getInput("");
		for (Course courseList : list) {
			log.getInput(courseList.getCourseName());
		}
	}
}
