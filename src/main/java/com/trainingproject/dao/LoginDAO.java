package com.trainingproject.dao;

import com.trainingproject.DbException;

public interface LoginDAO {

	public void login(String userName,String userPassword) throws DbException;
 }
