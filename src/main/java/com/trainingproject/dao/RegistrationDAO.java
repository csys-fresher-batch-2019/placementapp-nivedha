package com.trainingproject.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.trainingproject.model.Registration;

public interface RegistrationDAO {

	void addUserDetails(Registration list) throws Exception;
	
	void updateUserDetails(int userId,long mobileNo) throws Exception;
	
	List<Registration> allUserDetails() throws Exception;
	
	void deleteUserDetails(int userId) throws Exception;
	
	int getNoOfUsers() throws Exception;
	
	List<Registration> getDegreeWiseNoOfUsers() throws Exception;
}
