package com.trainingproject.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.trainingproject.DbConnection;
import com.trainingproject.dao.TrainerDAO;
import com.trainingproject.logger.Logger;
import com.trainingproject.model.Trainer;

public class TrainerDAOImpl implements TrainerDAO {
	private static final Logger log=Logger.getInstance();
	public void addTrainerDetails(Trainer t) throws Exception {
		
		
		String sql = "insert into trainer(trainer_id,trainer_name,trainer_qualfication,trainer_specialist,trainer_experience,email_id,contact_number)values(trainer_id_sqn.nextval,?,?,?,?,?,?)";
		log.getInput("");
		
	   try(Connection con=DbConnection.getConnection(); PreparedStatement pst = con.prepareStatement(sql);)
	   {
		pst.setString(1, t.getTrainerName());
		pst.setString(2,t.getTrainerQualification());
		pst.setString(3,t.getTrainerSpecialist());
		pst.setInt(4,t.getTrainerExperience());
		pst.setString(5,t.getEmailId());
		pst.setLong(6,t.getContactNumber());
	    int row=pst.executeUpdate();
		log.getInput("***Added Trainer Details successfully***");
	   }
	   catch(SQLException e)
		{
	e.printStackTrace();	
		}
	}

}
