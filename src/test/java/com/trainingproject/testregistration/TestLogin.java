package com.trainingproject.testregistration;

import com.trainingproject.dao.impl.LoginDAOImpl;

public class TestLogin {

	public static void main(String[] args) throws Exception {
		
		LoginDAOImpl impl=new LoginDAOImpl();
		impl.login("nived", "nivi@12");
		
		
	}

}
