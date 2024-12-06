package com.library.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
	 
	private static String url = "jdbc:mysql://localhost:3306/library_db"; 
	private static String Uname  = "root";
	private static String pwd = "12345";
	private static Connection connection = null;

	public static Connection getConnection() throws SQLException
	{
		if(connection == null || connection.isClosed())
		{
			try {
				connection = DriverManager.getConnection(url,Uname,pwd);
				System.out.println("Database connected successfull ");
			} catch (SQLException e) {
				System.out.println("Failed to connect to the database: " + e.getMessage());
				throw e;
			}
			
		}
		return connection;
	}
	 
	public static void Closeconnection()
	{
		if(connection != null)
		{
			try {
				connection.close();
				System.out.println("Database connection close");
			} catch (SQLException e) {
				System.out.println("Failed to close the database connection: " + e.getMessage());
			}
		}
	}
}
