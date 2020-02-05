package com.trainingproject.model;

public class Trainer {

	public int trainerId;
	public String trainerName;
	public String trainerQualification;
	public String trainerSpecialist;
	public int trainerExperience;
	public String emailId;
	public Long contactNumber;
	@Override
	public String toString() {
		return "Trainer [trainerId=" + trainerId + ", trainerName=" + trainerName + ", trainerQualification="
				+ trainerQualification + ", trainerSpecialist=" + trainerSpecialist + ", trainerExperience="
				+ trainerExperience + ", emailId=" + emailId + ", contactNumber=" + contactNumber + "]";
	}
}
