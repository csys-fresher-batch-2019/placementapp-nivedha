package com.trainingproject;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.trainingproject.dao.impl.CourseDAOImpl;
import com.trainingproject.dao.impl.RegistrationDAOImpl;
import com.trainingproject.dao.impl.UserCourseDAOImpl;
import com.trainingproject.logger.Logger;
import com.trainingproject.model.Course;
import com.trainingproject.model.Registration;
import com.trainingproject.model.UserCourse;

public class TestUserCourse {

	private static final Logger log = Logger.getInstance();

	public static void userCourseDetails() throws DbException {
		// List all course details
		CourseDAOImpl obj = new CourseDAOImpl();
		List<Course> list = new ArrayList<Course>();

		list = obj.allCourseDetails(".net");
		for (Course courseList : list) {
			log.getInput(courseList.toString());
		}

		// List all user details
		RegistrationDAOImpl impl = new RegistrationDAOImpl();
		List<Registration> list1 = new ArrayList<Registration>();

		list1 = impl.allUserDetails();
		for (Registration register : list1) {
			log.getInput(register);
		}

	}

	public static void testInsert() throws DbException {
		LocalDate currentDate = LocalDate.now();
		Scanner sc = new Scanner(System.in);
		ArrayList<UserCourse> list2 = new ArrayList<UserCourse>();
		log.getInput("Enter UserCourse details:");
		UserCourse uc1 = new UserCourse();
		log.getInput("Enter User Id:");
		uc1.setUserId(sc.nextInt());
		log.getInput("Enter Course Id:");
		uc1.setCourseId(sc.nextInt());
		uc1.setStartDate(currentDate);
		list2.add(uc1);
		log.getInput("UserCourse detail is added");
		UserCourseDAOImpl impl1 = new UserCourseDAOImpl();
		for (UserCourse userCourse : list2) {
			int duration = impl1.getDuration(uc1.getCourseId());
			log.getInput(duration);
			userCourse.setCompletionDate(userCourse.getStartDate().plusMonths(duration));
			log.getInput(userCourse);
			userCourse.setTotalAmount(discount());
			impl1.addCourseDurationDate(userCourse);
			log.getInput(userCourse);
		}
	}

	public static void testgetUserCourseDetails() throws DbException {
		Scanner sc = new Scanner(System.in);
		UserCourse uc1 = new UserCourse();
		log.getInput("Enter User Id:");
		uc1.setUserId(sc.nextInt());
		UserCourseDAOImpl impl1 = new UserCourseDAOImpl();
		List<UserCourse> list1 = new ArrayList<UserCourse>();
		list1 = impl1.getUserCourseDetails(uc1.getUserId());
		for (UserCourse userCourse : list1) {
			log.getInput(userCourse);
		}
	}

	public static double discount() throws DbException {
		Scanner sc = new Scanner(System.in);
		DiscountCalculation dis = new DiscountCalculation();
		UserCourse uc = new UserCourse();
		Course c = new Course();
		log.getInput("");
		log.getInput("To Display the Discount Details of the User");
		log.getInput("Enter User Id:");
		uc.setUserId(sc.nextInt());
		log.getInput("Enter Course Id:");
		c.setCourseId(sc.nextInt());
		int courseCount = dis.getNoOfUser(uc.getUserId());
		log.getInput(courseCount);
		int courseFees = dis.getCourseFees(c.getCourseId());
		log.getInput(courseFees);
		double discountAmount;
		switch (courseCount) {
		case 2:
			discountAmount = courseFees * .05;
			break;
		case 3:
			discountAmount = courseFees * .10;
			break;
		case 4:
			discountAmount = courseFees * .15;
			break;
		case 5:
			discountAmount = courseFees * .20;
			break;
		default:
			discountAmount = 0;
		}
		log.getInput("");
		log.getInput("DiscountAmount: " + discountAmount);
		double totalAmount = courseFees - discountAmount;
		log.getInput("TotalAmount:" + totalAmount);
		sc.close();
		return totalAmount;
	}
}