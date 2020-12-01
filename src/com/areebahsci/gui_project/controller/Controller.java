package com.areebahsci.gui_project.controller;

import com.areebahsci.gui_project.model.Model;
import com.areebahsci.gui_project.model.course.Course;
import com.areebahsci.gui_project.model.user.Professor;
import com.areebahsci.gui_project.model.user.Student;
import com.areebahsci.gui_project.view.View;

/* this class will contain all the variables needed for the controllers and any common functions between
 * the controllers for the different users */

public class Controller {
	
	// this count is used keeping track of login attempts 
	protected static int loginAttempts=3;
	
	/* the type variable will be used to store whether the system is being used by a student, a professor
	 * or the admin. this is needed to show them their appropriate windows.
	 * type=1 --> means student 
	 * type=2 --> means professor
	 * type=3 --> admin */
	protected static int type = 0; 
	
	// we have to create an instance of the model and the view 
	protected static  Model model = new Model();
	protected static View view = new View();
	
    // these int values save the index of the student or professors position in the arraylist 
	protected static int studentLoggedInIndex = 0;
	protected static int professorLoggedInIndex= 0;
	
	/* these variables save which student/professor has logged into the system so it is 
	easier to retreive their information when needed */
	protected static Student studentLoggedIn = model.getStudentsArray().get(0);
	protected static Professor professorLoggedIn = model.getProfessorsArray().get(0);
	
	/* this method is used to show all the courses to the student when they want to add a course
	 * or when the admin wants to view all the courses offered */
	public static String[][] getAllCourses(){
		
		int courseCount = model.getCourseCount();
		String[][]data=new String[courseCount][4];
		for (int i=0;i<courseCount;i++) {
			Course course = model.getCoursesArray().get(i);
			data[i][0]=(i+1)+"";
			data[i][1]=course.getCourseID()+"";
			data[i][2]=course.getCourseName();
			data[i][3]=course.getCredits()+"";
		}
		return data;
	}

	// GENERIC GETTERS AND SETTERS
	
	public static void setLoginAttempts(int number) {
		loginAttempts=number;
	}
	
	public static int getStudentLoggedInIndex() {
		return studentLoggedInIndex;
	}

	public static void setStudentLoggedInIndex(int studentLoggedInIndex) {
		Controller.studentLoggedInIndex = studentLoggedInIndex;
	}

	public static int getProfessorLoggedInIndex() {
		return professorLoggedInIndex;
	}

	public static void setProfessorLoggedInIndex(int professorLoggedInIndex) {
		Controller.professorLoggedInIndex = professorLoggedInIndex;
	}

	public static int getLoginAttempts() {
		return loginAttempts;
	}
	
	public static void setType(int number) {
		type=number;
	}
		
	public static int getType() {
		return type;
	}

	public static Student getStudentLoggedIn() {
		return studentLoggedIn;
	}

	public static void setStudentLoggedIn(Student studentLoggedIn) {
		Controller.studentLoggedIn = studentLoggedIn;
	}

	public static Professor getProfessorLoggedIn() {
		return professorLoggedIn;
	}

	public static void setProfessorLoggedIn(Professor professorLoggedIn) {
		Controller.professorLoggedIn = professorLoggedIn;
	}

	public static Model getModel() {
		return model;
	}

	public static void setModel(Model model) {
		Controller.model = model;
	}

	public static View getView() {
		return view;
	}

	public static void setView(View view) {
		Controller.view = view;
	}
	
}
