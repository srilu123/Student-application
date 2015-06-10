/**
 * 
 */
package com.parsa.student.app;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.PropertyConfigurator;

/**
 * @author ramesh
 *
 */
public class ApplicationTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Application app=new Application();
		Student s=new Student();
		BasicConfigurator.configure();
	
		s.setRollno(6);
		s.setName("Sri");
		s.setDepartment("IIT");
		s.setCollege("jntuH");
		s.setCollegeid(4001);
		app.addStudent(s);
		s.setRollno(9);
		app.deleteStudent(s);
		s.setRollno(22);
		app.displayStudent(s);
		s.setRollno(20);
		app.updateStudent(s);
		
		

	}

}
