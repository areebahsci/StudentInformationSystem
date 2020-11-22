package com.areebahsci.gui_project.model.user.student;

import com.areebahsci.gui_project.model.Model;
import com.areebahsci.gui_project.model.course.Course;
import com.areebahsci.gui_project.model.user.User;

public class Student extends User {

	private String major;
	private double GPA;
	// the 2d array will contain the courseID in the first row and the grade of the course in the second array
	private double [][] enrolledCourses; 
	private int coursesTaken;
	
	private static final int MAX_COURSES = 5;

	public Student(String ID, String name, String username, String password,
			String major) {
		
		super(ID, name, username, password);
		this.major=major;
		this.enrolledCourses= new double [MAX_COURSES][2];
		this.coursesTaken=0;
		
	}
	
	// this is when we are adding courses to a student when reading from a file
	
	public void addCourse(int courseID, double grade) {
		enrolledCourses[coursesTaken][0]=(double)courseID;
		enrolledCourses[coursesTaken][1]=grade;
		coursesTaken++;
	}
	
	/*
	 // this is for when the student is just added into the course
	
	public void addCourse(Course course) {
		
		enrolledCourses[coursesTaken][0]=course.getCourseID();
		enrolledCourses[coursesTaken][1]=-1;
		coursesTaken++;
		course.addStudent(this);
		
	}
	*/

	public double calculateGPA() {
		
		double GPA=0;
		for (int i=0;i<coursesTaken;i++) {
			GPA+=enrolledCourses[i][1];
		}
		GPA/=100;
		return GPA;
	}

	@Override
	public void printData() {
		System.out.println("Name: "+this.name+ " ID: "+this.ID+" major: "+this.major+
				" username: "+this.username+" password: "+this.password+" GPA: "+
				this.GPA + " coursesTaken: "+this.coursesTaken);
		for (int i=0;i<this.coursesTaken;i++) {
			System.out.println("Course ID: "+ this.enrolledCourses[i][0]+
					" Grade: "+ this.enrolledCourses[i][1]);
		}
	}
	
	// GETTERS AND SETTERS

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	public double getGPA() {
		return GPA;
	}

	public void setGPA(double gPA) {
		GPA = gPA;
	}

	public double[][] getEnrolledCourses() {
		return enrolledCourses;
	}

	public void setEnrolledCourses(double[][] enrolledCourses) {
		this.enrolledCourses = enrolledCourses;
	}

	public int getCoursesTaken() {
		return coursesTaken;
	}

	public void setCoursesTaken(int coursesTaken) {
		this.coursesTaken = coursesTaken;
	}
	
}
