package com.areebahsci.gui_project.model.user.professor;

import com.areebahsci.gui_project.model.course.Course;
import com.areebahsci.gui_project.model.user.User;
import com.areebahsci.gui_project.model.user.student.Student;

public class Professor extends User {

	private String department;
	private Course[]coursesTeachingArray;
	private int numberOfCourses;
	
	private static final int MAX_COURSES=3;
	
	public Professor(String ID, String name, String username, String password,
			String department) {
		
		super(ID, name, username, password);
		this.department=department;
		this.coursesTeachingArray=new Course[MAX_COURSES];
	}
	
	public void setGrade(Student student, Course course, int grade) {
		
		double[][]temp=student.getEnrolledCourses();
		for (int i=0;i<student.getCoursesTaken();i++) {
			if (temp[i][0]==course.getCourseID()) {
				temp[i][1]=grade;
			}
		}
	}
	
	public void changePassword(String password) {
		this.setPassword(password);
	}
	
	public void changeUsername(String username) {
		this.setUsername(username);
	}
	
	public void addCourse(Course course) {
		coursesTeachingArray[numberOfCourses]=course;
		numberOfCourses++;
	}
	
	@Override
	public void printData() {
		System.out.println("Name: "+this.name+ " ID: "+this.ID+" department: "+this.department+
				" username: "+this.username+" password: "+this.password+" numberofCourses: "+
				this.numberOfCourses);
		for (int i=0;i<this.numberOfCourses;i++) {
			System.out.println("Course ID: "+ this.coursesTeachingArray[i].getCourseID()+
					" Course Name: "+ this.coursesTeachingArray[i].getCourseName()+
					" Credits: "+this.coursesTeachingArray[i].getCredits());
		}
	}
	
	// GETTERS AND SETTERS

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public Course[] getCoursesTeachingArray() {
		return coursesTeachingArray;
	}

	public void setCoursesTeachingArray(Course[] coursesTeachingArray) {
		this.coursesTeachingArray = coursesTeachingArray;
	}

	public int getNumberOfCourses() {
		return numberOfCourses;
	}

	public void setNumberOfCourses(int numberOfCourses) {
		this.numberOfCourses = numberOfCourses;
	}

}
