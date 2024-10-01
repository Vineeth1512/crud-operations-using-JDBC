package com.jsp.tet;

import database.connection.Developer;
import database.connection.DeveloperTest;

public class GetByIdController {
	public static void main(String[] args) {
		DeveloperTest test = new DeveloperTest();
		Developer dev = test.getById(121);
		if (dev != null) {
			System.out.println("Developer name : " + dev.getName());
			System.out.println("Developer id : " + dev.getId());
			System.out.println("Developer Address : " + dev.getAddress());
			System.out.println("Developer salary : " + dev.getSalary());

		}else {
			System.out.println("you got error");
		}
	}
}
