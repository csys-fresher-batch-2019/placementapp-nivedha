package com.trainingproject;

import java.util.ArrayList;
import java.util.List;

import com.trainingproject.dao.impl.GradeDAOImpl;
import com.trainingproject.model.Grade;

public class TestGrade {

	public static void main(String[] args) {
		GradeDAOImpl impl=new GradeDAOImpl();
		impl.updateGrade(81, 100, "selected");
		
		List<Grade> list=new ArrayList<Grade>();
		list=impl.viewGrade();
		for(Grade g:list)
		{
		System.out.println(g);
		}
	}

}
