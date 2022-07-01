package com.qa.dayfour.main.petshop;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConfig {
	
	final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
	final String DB_URL = "jdbc:mysql://localhost:3306/petShop";
	final String UNAME = "root";
	final String PASSWORD = "root";
	
	//Root - Please if your password isnt root 
	
	//Singleton, hence we need to check if null or not
	// Create an instance if null
	// Otherwise return this (the instance we have already created)
	
	//Connection 
	Connection conn;
	
	public Connection connect() {
		try {
			Class.forName(JDBC_DRIVER);
			conn = DriverManager.getConnection(DB_URL, UNAME, PASSWORD);
			System.out.println("Well Done you have connected to your db");
		} catch (Exception e) {
			System.out.println("No connection sorry boss");
		}
		
		return conn;
	}

}
