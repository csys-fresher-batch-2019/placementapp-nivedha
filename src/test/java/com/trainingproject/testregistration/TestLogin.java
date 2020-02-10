package com.trainingproject.testregistration;

import com.trainingproject.DbException;
import com.trainingproject.dao.impl.LoginDAOImpl;

public class TestLogin {

	public static void main(String[] args) throws DbException {
		
		LoginDAOImpl impl=new LoginDAOImpl();
		impl.login("nived", "nivi@12");
		
		
	}

}
