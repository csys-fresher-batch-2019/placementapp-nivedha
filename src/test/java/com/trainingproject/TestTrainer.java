package com.trainingproject;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.trainingproject.dao.impl.TrainerDAOImpl;
import com.trainingproject.logger.Logger;
import com.trainingproject.model.Trainer;

public class TestTrainer {

	private static final Logger log = Logger.getInstance();

	public static void testAddTrainerDetails() throws DbException {
		Trainer t = new Trainer();
		Scanner sc = new Scanner(System.in);
		log.getInput("Enter Trainer details:");
		log.getInput("Enter Trainer Name:");
		t.setTrainerName(sc.nextLine());
		t.setTrainerName(t.getTrainerName() + sc.nextLine());
		log.getInput("Enter Trainer Qualification:");
		t.setTrainerQualification(sc.next());
		log.getInput("Enter Trainer Specialist:");
		t.setTrainerSpecialist(sc.nextLine());
		t.setTrainerSpecialist(t.getTrainerSpecialist() + sc.nextLine());
		log.getInput("Enter Trainer Experience:");
		t.setTrainerExperience(sc.nextInt());
		log.getInput("Enter Trainer EMail Id:");
		t.setEmailId(sc.next());
		log.getInput("Enter Trainer Contact No:");
		t.setContactNumber(sc.nextLong());
		TrainerDAOImpl impl = new TrainerDAOImpl();
		impl.addTrainerDetails(t);
		log.getInput(t);
	}

	public static void testListTrainerDetails() throws DbException {
		Trainer t = new Trainer();
		List<Trainer> list = new ArrayList<Trainer>();
		TrainerDAOImpl impl1 = new TrainerDAOImpl();
		list = impl1.listTrainerDetails();
		for (Trainer trainer : list) {
			log.getInput(trainer);
		}
	}
}