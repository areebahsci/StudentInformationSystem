package com.areebahsci.gui_project.model.course;

import com.areebahsci.gui_project.model.user.Professor;
import com.areebahsci.gui_project.model.user.Student;

public class Course {
	
	// max number of students that can take the course 
	private static final int MAX_STUDENTS = 20;
	
	// this professor variable holds the professor that teaches the course
	private Professor professor;
	
	// the name of the course 
	private String courseName;
	
	// the ID of the course 
	private int courseID;
	
	// the credits the course is worth
	private int credits;
	
	//this array below stores the IDs of students taking the course 
	private Student[]studentsEnrolled;
	
	// the count of students taking the course 
	private int studentCount;
	
	// constructor 
	public Course(Professor professor, int courseID, String courseName, int credits) {
		
		this.professor=professor;
		this.courseID=courseID;
		this.courseName=courseName;
		this.credits=credits;
		
		// setting the size of the array of the students to the max number of students 
		this.studentsEnrolled=new Student[MAX_STUDENTS];
		
		/* when a course is first instantaited in the controller, the students still havent been 
		 * added into the course so we set it to 0 so that when this value is being set later by
		 * another method, it can be incremented without any errors */
		this.studentCount=0;
	}
	
	/* function used to print the data just for validation purposes that the methods are functioning
	 * the way they are supposed to */
	public void printData() {
		System.out.println("Name: "+this.courseName+ " ID: "+this.courseID+" credits: "+
	this.credits+ " professor: "+this.professor+" studentCount: "+
				this.studentCount);
		for (int i=0;i<this.studentCount;i++) {
			System.out.print("Student"+i+" ID: "+this.studentsEnrolled[i].getID() +" ");
		}
	}
	
	/* this function adds the student taking the course to the array of students taking the course */
	public void addStudent(Student student) {
		studentsEnrolled[studentCount]=student;
		studentCount++;
	}
	
	/* this ensures we get the length of the student array incase theres an error and the 
	 * the number of students isnt updated when we add a student */
	public int getStudentCount() {
		return(studentCount=studentsEnrolled.length);
	}

	/* we will never need to set this value as it should always be equal to the length of the student
	 * array so this function will just set it to the length of the student array */
	public void setNumberOfCourses() {
		studentCount = studentsEnrolled.length;
	}
	
	// GENERIC GETTERS AND SETTERS
	
	public Professor getProfessor() {
		return professor;
	}

	public void setProfessor(Professor professor) {
		this.professor = professor;
	}

	public Student[] getStudentsEnrolled() {
		return studentsEnrolled;
	}

	public void setStudentsEnrolled(Student[] studentsEnrolled) {
		this.studentsEnrolled = studentsEnrolled;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public int getCourseID() {
		return courseID;
	}

	public void setCourseID(int courseID) {
		this.courseID = courseID;
	}
	
	public int getCredits() {
		return credits;
	}

	public void setCredits(int credits) {
		this.credits =credits;
	}

	
}
