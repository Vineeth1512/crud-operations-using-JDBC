package com.jsp.tet;

import database.connection.Developer;
import database.connection.DeveloperTest;

public class DeleteController {
	public static void main(String[] args) {
		Developer dev = new Developer();
		dev.setId(23);
		DeveloperTest test = new DeveloperTest();
		int result = test.deleteTable(dev);
		if (result > 0) {
			System.out.println("Row deleted successfull");
		} else {
			System.err.println("Id is not there");
		}
	}

}
