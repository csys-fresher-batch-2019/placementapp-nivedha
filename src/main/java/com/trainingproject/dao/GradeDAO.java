package com.trainingproject.dao;

import java.util.List;

import com.trainingproject.model.Grade;

public interface GradeDAO {

	void updateStatus();

	List<Grade> viewGrade();

	void updateGrade(int minMarks, int maxMarks, String status);
}
