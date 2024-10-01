package com.jsp.tet;

import database.connection.DeveloperTest;

public class CallableController {
	public static void main(String[] args) {
		DeveloperTest test = new DeveloperTest();
		test.collableStatement();
		System.out.println("Execution successfull..");
	}

}
