package com.jsp.tet;

import java.util.List;

import database.connection.Developer;
import database.connection.DeveloperTest;

public class GetByAllDevelopersController {
	public static void main(String[] args) {
		DeveloperTest dev = new DeveloperTest();
		List<Developer> list = dev.getAllDevelopers();
		if (list != null) {
			for (Developer d : list) {
				System.out.println("name :" + d.getName());
				System.out.println("Id :" + d.getId());
				System.out.println("salary :" + d.getSalary());
				System.out.println("Address :" + d.getAddress());
				System.out.println("------------------------------------");

			}
		}
	}

}
