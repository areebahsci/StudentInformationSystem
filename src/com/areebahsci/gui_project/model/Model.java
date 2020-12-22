package com.areebahsci.gui_project.model;

import java.util.ArrayList;

import com.areebahsci.gui_project.model.course.Course;
import com.areebahsci.gui_project.model.user.Professor;
import com.areebahsci.gui_project.model.user.Student;
import com.areebahsci.gui_project.model.utilities.File;

public class Model {

	/* an arraylist of professors, students and courses is made to save all their information in
	 *  from a file. for the admin, since there only exists one, we don't need an arraylist for it */
	private ArrayList<Professor>professors;
	private ArrayList<Student>students;
	private ArrayList<Course>courses;
	
	// constructor 
	public Model() {
		
		professors = new ArrayList<Professor>();
		students = new ArrayList<Student>();
		courses = new ArrayList<Course>();
		
		/* these two functions that are called load all the information from the files into the
		 * three arraylists */
		File.loadProfessorsIntoArray(this, "resources/Professor_info");
		File.loadStudentsIntoArray(this, "resources/Student_info");
		
		// this function that is called loads all the course information into a file 
		File.loadCoursesIntoFile(this, "resources/Course_info");
		
	}
	
	// this method returns the course based on the courseID passed
	public Course getCourse(double ID) {
		for (int i=0;i<getCourseCount();i++) {
			if ((courses.get(i).getCourseID())==ID) {
				return (courses.get(i));
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
	
	// GENERIC GETTER AND SETTERS 
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

}