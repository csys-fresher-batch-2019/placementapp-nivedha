package com.trainingproject.testregistration;

import com.trainingproject.DbException;
import com.trainingproject.dao.impl.LoginDAOImpl;

public class TestLogin {

	public static void main(String[] args) throws DbException {

		LoginDAOImpl impl = new LoginDAOImpl();
		String[] msg = impl.login("nivij@gmail.com", "nivi@12");
		System.out.print(msg[0]);
		System.out.println(msg[1]);
	}
}
