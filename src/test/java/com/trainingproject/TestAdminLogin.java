package com.trainingproject;

import com.trainingproject.dao.impl.AdminLoginDAOImpl;

public class TestAdminLogin {

	public static void main(String[] args) throws DbException {

		AdminLoginDAOImpl impl=new AdminLoginDAOImpl();
		String msg=impl.adminLogin("passionadmin@gmail.com", "passion");
		if(msg.equals("success"))
			System.out.println(msg);
		else
			System.out.println(msg);
	}

}
