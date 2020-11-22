package com.areebahsci.gui_project.model;

import java.util.ArrayList;

import com.areebahsci.gui_project.model.course.Course;
import com.areebahsci.gui_project.model.user.administrator.Administrator;
import com.areebahsci.gui_project.model.user.professor.Professor;
import com.areebahsci.gui_project.model.user.student.Student;
import com.areebahsci.gui_project.model.utilities.File;

public class Model {

	private ArrayList<Professor>professors;
	private ArrayList<Student>students;
	private ArrayList<Course>courses;
	private Administrator admin;
	
	public Model() {
		
		professors = new ArrayList<Professor>();
		students = new ArrayList<Student>();
		courses = new ArrayList<Course>();
		
		File.loadProfessorsIntoArray(this, "resources/Professor_info");
		File.loadStudentsIntoArray(this, "resources/Student_info");
		File.loadCoursesIntoFile(this, "resources/Course_info");
		
		admin = new Administrator("0000", "Admin", "Admin", "Password");
		
	}
	
	// this method returns the course based on the ID passed
	
	public Course getCourse(int ID) {
		Course course;
		for (int i=0;i<getCourseCount();i++) {
			if ((course=courses.get(i)).getCourseID()==ID) {
				return course;
			}
		}
		return null;
	}
	
	// PRINT METHODS
	
	public void printProfessorArray() {
		for (int i=0;i<getProfessorCount();i++) {
			professors.get(i).printData();
		}
	}
	
	public void printStudentArray() {
		for(int i=0;i<getStudentCount();i++) {
			students.get(i).printData();
		}
	}
	
	public void printCoursesArray() {
		for(int i=0;i<getCourseCount();i++) {
			courses.get(i).printData();
		}
	}
	
	// SIZE METHODS 

	public int getStudentCount() {
		return students.size();
	}
	
	public int getProfessorCount() {
		return professors.size();
	}
	
	public int getCourseCount() {
		return courses.size();
	}	
	
	// GETTER AND SETTERS 

	public ArrayList<Professor> getProfessorsArray() {
		return professors;
	}

	public void setProfessorsArray(ArrayList<Professor> professors) {
		this.professors = professors;
	}

	public ArrayList<Student> getStudentsArray() {
		return students;
	}

	public void setStudentsArray(ArrayList<Student> students) {
		this.students = students;
	}

	public ArrayList<Course> getCoursesArray() {
		return courses;
	}

	public void setCoursesArray(ArrayList<Course> courses) {
		this.courses = courses;
	}

	public Administrator getAdmin() {
		return admin;
	}

	public void setAdmin(Administrator admin) {
		this.admin = admin;
	}
	
}
