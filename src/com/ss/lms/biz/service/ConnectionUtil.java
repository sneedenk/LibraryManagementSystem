/**
 * 
 */
package com.ss.lms.biz.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author Kyle Sneeden
 *
 */
public class ConnectionUtil {
	
	private String driver = "com.mysql.cj.jdbc.Driver";
	private String url = "jdbc:mysql://localhost:3306/library?useSSL=false";
	private String username = "root";
	private String password = "root";

	protected Connection getConnection() throws ClassNotFoundException, SQLException {
		Class.forName(driver);
		Connection conn = DriverManager.getConnection(url, username, password);
		conn.setAutoCommit(Boolean.FALSE);
		return conn;
	}
}
