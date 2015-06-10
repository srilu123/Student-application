/**
 * 
 */
package com.parsa.student.app;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author ramesh
 *
 */
public class DatabaseUtility {
	
	static Connection con =null;

	static Connection getDatabaseConnection() throws SQLException {
		if(con == null)
		{
		  return DriverManager.getConnection(Constants.JDBC_MYSQL_URL, Constants.USER_NAME, Constants.PASSWORD);	
		}
		return con;
	}

}
