/**
 * 
 */
package com.parsa.student.app;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

/**
 * @author ramesh
 *
 */
public class Application {
	Student student;
	/**
	 * @param args
	 */
	Connection con;
	Logger logger=Logger.getLogger(Application.class);
	

	public void init() {
		try {
			con = getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void updateStudent(Student student) {
		Statement stmt=null;
		try {
			init();
		 stmt = con.createStatement();
		  String UPDATE_STUDENT_QUERY = "update student set collegeid=1300 where rollno= "+ student.getRollno();
			int count = stmt.executeUpdate(UPDATE_STUDENT_QUERY);
			logger.info("update query: "+UPDATE_STUDENT_QUERY);
			logger.info("no of updated records: "+count);
		} catch (SQLException e) {
			close(stmt);
			logger.error("records cannot be updated:"+e.getErrorCode()+"Error message:"+e.getMessage());
		}
		

	}

	public void deleteStudent(Student student) {
		Statement stmt=null;
		try {
			init();
			 stmt = con.createStatement();
			 String DELETE_QUERY = "DELETE FROM student WHERE rollno= "+student.getRollno();
			stmt.execute(DELETE_QUERY);
			logger.info("Delete query: "+DELETE_QUERY);
		} catch (SQLException e) {
		close(stmt);
		logger.error("record already deleted:"+e.getErrorCode()+"Error message:"+e.getMessage());
		}
		

	}

	public void displayStudent(Student student) {
		Statement stmt=null;
		try {
			init();
			stmt = con.createStatement();
		 String SELECT_QUERY= "select name,college,detp from student where rollno = "+student.getRollno();
			ResultSet rs = stmt.executeQuery(SELECT_QUERY);
			while (rs.next()) {
				String name = rs.getString("name");
				String college = rs.getString("college");
				String detp = rs.getString("detp");
				logger.info("name: " + name + ", College name: " + college
						+ ", Department: " + detp);
				

			}
		} catch (SQLException e) {
			close(stmt);
		logger.error("records cannot be displayed:"+e.getErrorCode()+"Error message:"+e.getMessage());
		}

		

	}

	public void addStudent(Student student) {
		Statement stmt = null;
		try {
			init();
			stmt = con.createStatement();
			String INSERT_QUERY = "insert into student(rollno,name,detp,college,collegeid) values ("
					+ student.getRollno()
					+ ",'"
					+ student.getName()
					+ "','"
					+ student.getDepartment()
					+ "','"
					+ student.getCollege()
					+ "'," + student.getCollegeid() + ")";
		logger.info("insert query: "+INSERT_QUERY);
			stmt.execute(INSERT_QUERY);
		} catch (SQLException e) {
			close(stmt);
			logger.error("Record not inserted. Error Code : " + e.getErrorCode() + ". ErrorMessage : "+ e.getMessage());
		}

		

	}

	private void close(Statement stmt) {
		try {
			if (stmt !=null) {
				stmt.closeOnCompletion();
			}
			if (con != null) {
				con.close();
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
	}

	private Connection getConnection() throws SQLException {
		return DatabaseUtility.getDatabaseConnection();
	}
}
