package com.trainingproject.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import com.trainingproject.DbConnection;
import com.trainingproject.dao.TrainerDAO;
import com.trainingproject.model.Trainer;

public class TrainerDAOImpl implements TrainerDAO {

	public void addTrainerDetails(Trainer t) throws Exception {
		
		Connection con=DbConnection.getConnection();
		String sql = "insert into trainer(trainer_id,trainer_name,trainer_qualfication,trainer_specialist,trainer_experience,email_id,contact_number)values(trainer_id_sqn.nextval,?,?,?,?,?,?)";
		System.out.println("");
		//System.out.println(sql);
	    PreparedStatement pst = con.prepareStatement(sql);
		pst.setString(1, t.trainerName);
		pst.setString(2,t.trainerQualification);
		pst.setString(3,t.trainerSpecialist);
		pst.setInt(4,t.trainerExperience);
		pst.setString(5,t.emailId);
		pst.setLong(6,t.contactNumber);
	    int row=pst.executeUpdate();
		System.out.println("***Added Trainer Details successfully***");
	    con.close();
	}

}
