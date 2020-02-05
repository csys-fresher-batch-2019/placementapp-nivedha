package com.trainingproject.dao;

import java.sql.SQLException;

import com.trainingproject.model.Trainer;

public interface TrainerDAO {
	
	public void addTrainerDetails(Trainer t) throws Exception;

}
