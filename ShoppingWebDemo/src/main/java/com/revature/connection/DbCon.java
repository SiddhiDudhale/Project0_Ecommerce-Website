package com.revature.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbCon {
	private static Connection connection = null;
	static String url = "jdbc:mysql://localhost:3306/ecommerceweb";
	static String username="root";
	static String pwd="asdfghjkl@123";
	
	public static Connection getConnection() throws SQLException, ClassNotFoundException {
		if(connection == null) {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection(url,username,pwd);
				System.out.println("Connected !");
		}
		return connection;
	}

}
