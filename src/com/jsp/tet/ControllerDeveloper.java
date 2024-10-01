package com.jsp.tet;

import database.connection.DeveloperTest;

public class ControllerDeveloper {
public static void main(String[] args) {
	DeveloperTest test = new DeveloperTest();
	test.createTable();
	System.out.println("table is created");
	
}
}
