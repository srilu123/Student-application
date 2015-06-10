/**
 * 
 */
package com.parsa.student.app;

/**
 * @author ramesh
 *
 */
public class Student {

	/**
	 * @return the rollno
	 */
	
	private int rollno;
	private String name;
	private String department;
	private String college;
	private int collegeid;
	public int getRollno() {
		return rollno;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @return the department
	 */
	public String getDepartment() {
		return department;
	}
	/**
	 * @return the college
	 */
	public String getCollege() {
		return college;
	}
	/**
	 * @return the collegeid
	 */
	public int getCollegeid() {
		return collegeid;
	}
	/**
	 * @param rollno the rollno to set
	 */
	public void setRollno(int rollno) {
		this.rollno = rollno;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @param department the department to set
	 */
	public void setDepartment(String department) {
		this.department = department;
	}
	/**
	 * @param college the college to set
	 */
	public void setCollege(String college) {
		this.college = college;
	}
	/**
	 * @param collegeid the collegeid to set
	 */
	public void setCollegeid(int collegeid) {
		this.collegeid = collegeid;
	}
}
