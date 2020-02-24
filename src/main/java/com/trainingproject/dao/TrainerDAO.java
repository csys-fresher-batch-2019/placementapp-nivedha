package com.trainingproject.dao;

import java.util.List;

import com.trainingproject.DbException;
import com.trainingproject.model.Trainer;

public interface TrainerDAO {

	public void addTrainerDetails(Trainer t) throws DbException;

	List<Trainer> listTrainerDetails() throws DbException;
}
