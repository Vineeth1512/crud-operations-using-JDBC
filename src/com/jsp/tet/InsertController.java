package com.jsp.tet;

import database.connection.Developer;
import database.connection.DeveloperTest;

public class InsertController {
	public static void main(String[] args) {
		Developer dev = new Developer();
		dev.setName("Manoj");
		dev.setId(121);
		dev.setSalary(6100.6);
		dev.setAddress("Karimanagr");
		
		DeveloperTest test = new DeveloperTest();
		int result = test.insertTable(dev);
		if (result > 0) {
			System.out.println("Insertion is successfull");
		} else {
			System.err.println("You got Error");
		}
		
	}

}
