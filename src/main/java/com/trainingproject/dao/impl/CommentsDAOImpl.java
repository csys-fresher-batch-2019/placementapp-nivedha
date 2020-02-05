package com.trainingproject.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import com.trainingproject.DbConnection;
import com.trainingproject.dao.CommentsDAO;
import com.trainingproject.model.Comments;

public class CommentsDAOImpl implements CommentsDAO {

	public void addComments(Comments c) throws Exception {
		Connection con=DbConnection.getConnection();
		String sql = "insert into comments(comments_id,user_id,user_name,course_name,trainer_id,trainer_name,trainer_comments,institution_rating,trainer_rating)" + 
				"values(comments_id_sqn.nextval,?,?,?,?,?,?,?,?)";
		System.out.println("");
		//System.out.println(sql);
	    PreparedStatement pst = con.prepareStatement(sql);
		pst.setInt(1, c.userId);
		pst.setString(2,c.userName);
		pst.setString(3,c.courseName);
		pst.setInt(4,c.trainerId);
		pst.setString(5,c.trainerName);
		pst.setString(6,c.trainerComments);
		pst.setInt(7,c.institutionRating);
		pst.setInt(8,c.trainerRating);
		int row=pst.executeUpdate();
		System.out.println("***Comments Added successfully***");
	    con.close();
	}

}
