package com.trainingproject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

import com.trainingproject.dao.impl.CommentsDAOImpl;
import com.trainingproject.model.Comments;

public class TestComments {
	
	private static String getUserName(int userId) throws Exception 
	{
		Connection con=DbConnection.getConnection();
		String sql="select user_name from registration where user_id=?";
        PreparedStatement stmt=con.prepareStatement(sql);
        stmt.setInt(1, userId);
        ResultSet rs=stmt.executeQuery();
        String a=null;
		while(rs.next())
		{
			a=rs.getString("user_name");
		}
		return a;
	}
	private static String getTrainerName(int trainerId) throws Exception 
	{
		Connection con=DbConnection.getConnection();
		String sql="select trainer_name from trainer where trainer_id=?";
        PreparedStatement stmt=con.prepareStatement(sql);
        stmt.setInt(1, trainerId);
        ResultSet rs=stmt.executeQuery();
        String b=null;
		while(rs.next())
		{
			b=rs.getString("trainer_name");
		}
		return b;
	}

	public static void testAddComments() throws Exception
	{
		Comments c=new Comments();
		Scanner sc=new Scanner(System.in);
		System.out.println("***Comments details***");
		System.out.println("Enter User Id:");
		c.userId=sc.nextInt();
		c.userName=getUserName(c.userId);
		System.out.println("User Name is:");
		System.out.println(c.userName);
		System.out.println("Enter Course Name:");
		c.courseName=sc.next();
		System.out.println("Enter Trainer Id:");
		c.trainerId=sc.nextInt();
		c.trainerName=getTrainerName(c.trainerId);
		System.out.println("Trainer Name is:");
		System.out.println(c.trainerName);
		System.out.println("Enter Trainer Comments:");
		/*while(sc.hasNextLine())
		{
			String[] trainerComments=sc.nextLine().split("\\s");
			
		}*/
		c.trainerComments=sc.nextLine();
		c.trainerComments+=sc.nextLine();
		System.out.println("Enter Trainer Rating:");
		c.trainerRating=sc.nextInt();
		System.out.println("Enter Institution Rating:");
		c.institutionRating=sc.nextInt();
		
		CommentsDAOImpl impl=new CommentsDAOImpl();
		impl.addComments(c);
		System.out.println(c);
	}
}
