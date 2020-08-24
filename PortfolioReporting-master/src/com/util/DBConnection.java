package com.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	public static Connection createConnection() {
		Connection con = null;
		String url = "jdbc:oracle:thin:@localhost:1521:xe"; // MySQL URL and followed by the database name
		String username = "project"; // MySQL username
		String password = "1234"; // MySQL password
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection(url, username, password); // attempting to connect to MySQL database
			System.out.println("Printing connection object " + con);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;
	}
}
