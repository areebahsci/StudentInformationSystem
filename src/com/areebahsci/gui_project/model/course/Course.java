package com.areebahsci.gui_project.model.course;

import com.areebahsci.gui_project.model.user.professor.Professor;
import com.areebahsci.gui_project.model.user.student.Student;

public class Course {
	
	private static final int MAX_STUDENTS = 20;
	
	private Professor professor;
	private String courseName;
	private int courseID;
	private int credits;
	//this array below stores the IDs of students taking the course 
	private Student[]studentsEnrolled;
	private int studentCount;
	
	public Course(Professor professor, int courseID, String courseName, int credits) {
		
		this.professor=professor;
		this.courseID=courseID;
		this.courseName=courseName;
		this.credits=credits;
		this.studentsEnrolled=new Student[MAX_STUDENTS];
		this.studentCount=0;
	}
	
	public void printData() {
		System.out.println("Name: "+this.courseName+ " ID: "+this.courseID+" credits: "+
	this.credits+ " professor: "+this.professor+" studentCount: "+
				this.studentCount);
		for (int i=0;i<this.studentCount;i++) {
			System.out.print("Student"+i+" ID: "+this.studentsEnrolled[i].getID() +" ");
		}
	}
	
	public void addStudent(Student student) {
		studentsEnrolled[studentCount]=student;
		studentCount++;
	}
	
	// GETTERS AND SETTERS
	
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

	public int getStudentCount() {
		return studentCount;
	}

	public void setStudentCount(int studentCount) {
		this.studentCount = studentCount;
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
