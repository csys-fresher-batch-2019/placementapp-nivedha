package com.trainingproject;

import com.trainingproject.dao.impl.LoginDAOImpl;

public class TestLogin {

	public static void main(String[] args) throws DbException {
		LoginDAOImpl impl = new LoginDAOImpl();
		String msg[] = impl.login("nivij@gmail.com", "niv12");
		System.out.println(msg);
	}
}
