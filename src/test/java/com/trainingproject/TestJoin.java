package com.trainingproject;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.trainingproject.dao.impl.JoinDAOImpl;
import com.trainingproject.logger.Logger;
import com.trainingproject.model.JoinCompanySchedule;
import com.trainingproject.model.JoinUserCompany;
import com.trainingproject.model.JoinUserCourse;

public class TestJoin {

	private static final Logger log = Logger.getInstance();

	public static void testJoinUserCourse() throws DbException {
		Scanner sc = new Scanner(System.in);
		JoinDAOImpl impl = new JoinDAOImpl();
		JoinUserCourse j = new JoinUserCourse();
		List<JoinUserCourse> list = new ArrayList<JoinUserCourse>();
		log.getInput("Enter UserId:");
		j.setUserId(sc.nextInt());
		list.add(j);
		list = impl.getUserCourseDetails(j);
		log.getInput("");
		for (JoinUserCourse join : list) {
			log.getInput(join);
		}
	}

	public static void testJoinUserCompany() throws DbException {
		Scanner sc = new Scanner(System.in);
		JoinDAOImpl impl = new JoinDAOImpl();
		List<JoinUserCompany> list = new ArrayList<JoinUserCompany>();
		JoinUserCompany c = new JoinUserCompany();
		log.getInput("Enter Interview Status(selected/rejected):");
		c.setInterStatus(sc.next());
		list.add(c);
		list = impl.getUserCompanyDetails(c);
		for (JoinUserCompany join : list) {
			log.getInput(join);
		}
		sc.close();
	}

	public static void testStatusByUserId() throws DbException {
		Scanner sc = new Scanner(System.in);
		JoinDAOImpl impl = new JoinDAOImpl();
		List<JoinUserCompany> list = new ArrayList<JoinUserCompany>();
		JoinUserCompany c = new JoinUserCompany();
		log.getInput("Enter user id:");
		c.setUserId(sc.nextInt());
		list.add(c);
		list = impl.getStatusByUserId(c);
		log.getInput("");
		for (JoinUserCompany join : list) {
			log.getInput(join);
		}
		sc.close();
	}

	public static void testJoinUserCompanyByMarks() throws DbException {
		Scanner sc = new Scanner(System.in);
		JoinDAOImpl impl = new JoinDAOImpl();
		List<JoinUserCompany> list = new ArrayList<JoinUserCompany>();
		JoinUserCompany c = new JoinUserCompany();
		log.getInput("Enter Interview Marks(0-100):");
		c.setMarks(sc.nextInt());
		list.add(c);
		list = impl.getUserCompanyDetailsByMarks(c);
		log.getInput("");
		for (JoinUserCompany join : list) {
			log.getInput(join);
		}
		sc.close();
	}

	public static void testJoinCompanySchedule() throws DbException {
		Scanner sc = new Scanner(System.in);
		JoinDAOImpl impl = new JoinDAOImpl();
		List<JoinCompanySchedule> list = new ArrayList<JoinCompanySchedule>();
		log.getInput("Enter Interview Date:");
		String interviewDate = sc.next();
		list = impl.getCompanySchedule(interviewDate);
		for (JoinCompanySchedule join : list) {
			log.getInput(join.toString());
		}
		sc.close();
	}

	public static void testSearchByJob() throws DbException {
		Scanner sc = new Scanner(System.in);
		JoinDAOImpl impl = new JoinDAOImpl();
		List<JoinCompanySchedule> list = new ArrayList<JoinCompanySchedule>();
		JoinCompanySchedule i = new JoinCompanySchedule();
		log.getInput("Enter Job Requirement or Job Title:");
		i.setJobRequirement(sc.next());
		list.add(i);
		list = impl.searchByJob(i);
		for (JoinCompanySchedule join : list) {
			log.getInput(join);
		}
		sc.close();
	}
}
