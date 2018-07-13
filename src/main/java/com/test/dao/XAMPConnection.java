package com.test.dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class XAMPConnection implements IConnection {

	
	public Connection getConnection() {

		final String user = "root";
		final String password = "";

		Connection connection = null;

		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost/test", user, password);

			if (connection == null)
				System.out.println("No funciono la conexion");

		} catch (Exception error) {
			System.out.println("El error esta en el try and catch");
			error.printStackTrace();
			System.out.println(error.getMessage());
		}
		return connection;
	}

	public boolean insert(Object element) {
		return false;
	}


	
}
