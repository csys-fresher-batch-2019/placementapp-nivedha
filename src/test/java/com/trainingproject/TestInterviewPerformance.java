package com.trainingproject;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.trainingproject.dao.impl.GradeDAOImpl;
import com.trainingproject.dao.impl.InterviewPerformanceDAOImpl;
import com.trainingproject.logger.Logger;
import com.trainingproject.model.InterviewPerformance;

public class TestInterviewPerformance {

	private static final Logger log = Logger.getInstance();

	public static void testInsert() throws DbException {
		InterviewPerformanceDAOImpl impl = new InterviewPerformanceDAOImpl();
		Scanner sc = new Scanner(System.in);
		log.getInput("Enter the Client Id:");
		int clientId = sc.nextInt();
		log.getInput("Enter the User Id:");
		int userId = sc.nextInt();
		impl.addPerformanceDetails(clientId, userId);
		sc.close();
	}

	public static void testPerform() throws DbException {
		InterviewPerformanceDAOImpl impl = new InterviewPerformanceDAOImpl();
		List<InterviewPerformance> list = new ArrayList<InterviewPerformance>();
		list = impl.viewPerformanceStatus();
		log.getInput("");
		for (InterviewPerformance in : list) {
			log.getInput(in);
		}
	}

	public static void testUpdateMarks() throws DbException {
		InterviewPerformanceDAOImpl impl = new InterviewPerformanceDAOImpl();
		impl.updateInterviewMarks(87, 1);
		GradeDAOImpl grade = new GradeDAOImpl();
		grade.updateStatus();
	}
}