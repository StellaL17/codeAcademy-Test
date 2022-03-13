package org.test.dbConn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCConfig {
	
	private static String jdbcURL = "jdbc:postgresql://localhost:5432/users";
	private static String jdbcUsername = "postgres";
	private static String jdbcPassword = "postgres";
	
	
	public static Connection getConnection() {
		Connection connection = null;
		try {
			connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return connection;
	}
	
	public static void main(String[] args) {
		
		try {
			Connection con = getConnection();
			System.out.println("Connected to db successfully");
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
		
	}

}
