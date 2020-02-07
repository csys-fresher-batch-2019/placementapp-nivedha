package com.trainingproject;

import java.util.Scanner;

import com.trainingproject.dao.impl.TrainerDAOImpl;
import com.trainingproject.model.Trainer;

public class TestTrainer {
	
	public static void testAddTrainerDetails() throws Exception
	{
		Trainer t=new Trainer();
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter Trainer details:");
		System.out.println("Enter Trainer Name:");
		t.setTrainerName(sc.nextLine());
		t.setTrainerName(t.getTrainerName() + sc.nextLine());
		System.out.println("Enter Trainer Qualification:");
		t.setTrainerQualification(sc.next());
		System.out.println("Enter Trainer Specialist:");
		t.setTrainerSpecialist(sc.nextLine());
		t.setTrainerSpecialist(t.getTrainerSpecialist() + sc.nextLine());
		System.out.println("Enter Trainer Experience:");
		t.setTrainerExperience(sc.nextInt());
		System.out.println("Enter Trainer EMail Id:");
		t.setEmailId(sc.next());
		System.out.println("Enter Trainer Contact No:");
		t.setContactNumber(sc.nextLong());
		
		TrainerDAOImpl impl=new TrainerDAOImpl();
		impl.addTrainerDetails(t);
        System.out.println(t);
	}

}
