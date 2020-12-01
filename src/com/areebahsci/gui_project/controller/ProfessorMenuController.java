package com.areebahsci.gui_project.controller;

import com.areebahsci.gui_project.model.course.Course;

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
	public static void changeProfessorUsername(String username) {
		professorLoggedIn.setUsername(username);
	}
	
	// this method is called by the view when the professor chooses to change his password
	public static void changeProfessorPassword(String password) {
		professorLoggedIn.setPassword(password);
	}
	
}
