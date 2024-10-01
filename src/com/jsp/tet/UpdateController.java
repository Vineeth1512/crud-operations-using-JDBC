package com.jsp.tet;

import database.connection.Developer;
import database.connection.DeveloperTest;

public class UpdateController {
	public static void main(String[] args) {
		Developer dev = new Developer();
		dev.setId(121);
		dev.setName("mudham");
		dev.setAddress("Telangana");

		DeveloperTest test = new DeveloperTest();
		int result = test.updateTable(dev);
		
		if (result > 0) {
			System.out.println("Update is successfull");
		} else {
			System.err.println("You got Error");
		}
	}
}
