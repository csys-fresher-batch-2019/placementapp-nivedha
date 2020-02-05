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
		t.trainerName=sc.nextLine();
		t.trainerName+=sc.nextLine();
		System.out.println("Enter Trainer Qualification:");
		t.trainerQualification=sc.next();
		System.out.println("Enter Trainer Specialist:");
		t.trainerSpecialist=sc.nextLine();
		t.trainerSpecialist+=sc.nextLine();
		System.out.println("Enter Trainer Experience:");
		t.trainerExperience=sc.nextInt();
		System.out.println("Enter Trainer EMail Id:");
		t.emailId=sc.next();
		System.out.println("Enter Trainer Contact No:");
		t.contactNumber=sc.nextLong();
		
		TrainerDAOImpl impl=new TrainerDAOImpl();
		impl.addTrainerDetails(t);
        System.out.println(t);
	}

}
