package com.test.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.List;

public class XAMPConnection extends com.test.dao.Connection {

	
	protected Connection getConnection() {

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

	public <T> List<T> getAllEntityes(Object entity) {
		// TODO Auto-generated method stub
		return null;
	}

	
}
