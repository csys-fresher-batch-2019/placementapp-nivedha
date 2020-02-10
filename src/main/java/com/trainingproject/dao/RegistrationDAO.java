package com.trainingproject.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.trainingproject.DbException;
import com.trainingproject.model.Registration;

public interface RegistrationDAO {

	void addUserDetails(Registration list) throws DbException;
	
	void updateUserDetails(int userId,long mobileNo) throws DbException;
	
	List<Registration> allUserDetails() throws DbException;
	
	void deleteUserDetails(int userId) throws DbException;
	
	int getNoOfUsers() throws DbException;
	
	List<Registration> getDegreeWiseNoOfUsers() throws DbException;
}
