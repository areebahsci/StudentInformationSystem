package com.areebahsci.gui_project.controller;

import com.areebahsci.gui_project.model.course.Course;
import com.areebahsci.gui_project.model.utilities.File;

/* this class has all the static methods needed for the view when a professor has logged in and is using
 * the application */

public class ProfessorMenuController extends Controller {

	/* this is the method called within the view when it wants to display the students personal
	 * information to the user */
	public static String[][] displayProfessorData(){
		
		String[][]data = {{professorLoggedIn.getID(),professorLoggedIn.getName(),professorLoggedIn.getDepartment()}};
		return data;
	}
	
	/* this is the method called within the view when it wants to display the students course
	 * information to the user */
	public static String[][] displayProfessorCourses(){
		
		int courseCount = professorLoggedIn.getNumberOfCourses();
		String [][] data = new String[courseCount][5];
		for(int i=0;i<courseCount;i++) {
			Course course = professorLoggedIn.getCoursesTeachingArray().get(i);
			
			data[i][0]=((i+1)+"");
			data[i][1]=(course.getCourseID()+"");
			data[i][2]=course.getCourseName();
			data[i][3]=(course.getCredits()+"");
			data[i][4]=course.getStudentCount()+"";
		}
		return data;
		
	}
	
	/* this method returns the courses the professor teaches, used by the professor GUI to make 
	 * radiobutton selections of which course he would like to access grades of and then change */
	public static Course[] getTeachingCourseArray() {
		
		int courseNumber = professorLoggedIn.getNumberOfCourses();
		Course[]courses= new Course[courseNumber];
		for (int i=0;i<courseNumber;i++) {
			courses[i]=professorLoggedIn.getCoursesTeachingArray().get(i);
		}
		return courses;
	}
	
	/* this is the method called within the view when it wants to display all grades in a course
	 * to the professor */
	public static String[][]getAllGradesInCourse(Course course){
		
		int numberOfStudents = course.getStudentCount();
		String[][]data = new String [numberOfStudents][3];
		for (int i=0;i<numberOfStudents;i++) {
			data[i][0]=course.getStudentsEnrolled().get(i).getID();
			data[i][1]=course.getStudentsEnrolled().get(i).getName();
			data[i][2]=""+course.getStudentsEnrolled().get(i).getGradeOfCourse(course);
		}
		return data;
	}
	
	// this method is called by the view when the professor chooses to change his username
	public static int changeProfessorUsername(String username) {
		if (username.isBlank()) {
			return -1;
		}
		professorLoggedIn.setUsername(username);
		File.updateProfessorFile(model, "resources/Professor_info");
		return 1;
	}
	
	// this method is called by the view when the professor chooses to change his password
	public static int changeProfessorPassword(String password) {
		
		if (password.isBlank()) {
			return -1;
		}
		professorLoggedIn.setPassword(password);
		File.updateProfessorFile(model, "resources/Professor_info");
		return 1;
	}
	
	public static int addCourse(String courseName, String courseID, String courseCredits) {
		
		int credits, ID; 
		
		if (!canAddCourse()) {
			return 0;
		}
		
		// this if statement deals with if any text fields were empty when we tried logging in
		if (courseName.isBlank()||courseID.isBlank()||courseCredits.isBlank()) { 
			
			// it returns -1 if any text fields are empty when logging in
			return -1;
		}
		
		// this try-catch block of code will check if the ID and credit amounts entered were numeric 
		try {
			ID = Integer.parseInt(courseID);
			credits = Integer.parseInt(courseCredits);
		}
		catch(NumberFormatException nfe) {
			// if they are not numeric, we return -2
			return -2;
		}
		
		// this checks whether the credit amounts entered were reasonable, between 0 and 5
		if (credits>5||credits<0) {
			return -3;
		}
		
		// this checks if the ID entered already belongs to a pre existing course 
		for (int i=0;i<model.getCourseCount();i++) {
			if (ID==model.getCoursesArray().get(i).getCourseID()) {
				return -4;
			}
		}
		
		// this checks if the name entered already belongs to a pre existing course
		for (int i=0;i<model.getCourseCount();i++) {
			if (courseName.equals(model.getCoursesArray().get(i).getCourseName())) {
				return -5;
			}
		}
		Course course = new Course (professorLoggedIn, ID, courseName, credits);
		model.getCoursesArray().add(course);
		professorLoggedIn.addCourse(course);
		File.updateProfessorFile(model, "resources/Professor_info");
		File.addCourse(model, "resources/Course_info");
		return 1;
	}
	
	/* this method informs us whether the professor can register to teach any more courses, which is 
	 * possible as long as he hasnt reached the limit of courses he can teach, which is 3 */
	public static boolean canAddCourse() {
		if (professorLoggedIn.getNumberOfCourses()!=3) {
			return true;
		}
		return false;
	}
	
}
