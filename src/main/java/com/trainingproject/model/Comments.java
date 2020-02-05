package com.trainingproject.model;

import java.time.LocalDateTime;

public class Comments {

	public int commentsId;
	public int userId;
	public String userName;
	public String courseName;
	public int trainerId;
	public String trainerName;
	public String trainerComments;
	public int institutionRating;
	public int trainerRating;
	public LocalDateTime currentDate;
	@Override
	public String toString() {
		return "Comments [commentsId=" + commentsId + ", userId=" + userId + ", userName=" + userName + ", courseName="
				+ courseName + ", trainerId=" + trainerId + ", trainerName=" + trainerName + ", trainerComments="
				+ trainerComments + ", institutionRating=" + institutionRating + ", trainerRating=" + trainerRating
				+ ", currentDate=" + currentDate + "]";
	}
}
