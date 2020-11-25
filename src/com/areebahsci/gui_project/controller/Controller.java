package com.areebahsci.gui_project.controller;

import org.graalvm.compiler.asm.aarch64.AArch64Assembler.DataCacheOperationType;

import com.areebahsci.gui_project.model.Model;
import com.areebahsci.gui_project.model.course.Course;
import com.areebahsci.gui_project.model.user.Professor;
import com.areebahsci.gui_project.model.user.Student;
import com.areebahsci.gui_project.view.View;

public class Controller {
	
	// this count is used keeping track of login attempts 
	private static int loginAttempts=3;
	
	/* the type variable will be used to store whether the system is being used by a student, a professor
	 * or the admin. this is needed to show them their appropriate windows.
	 * type=1 --> means student 
	 * type=2 --> means professor
	 * type=3 --> admin */
	private static int type = 0; 
	
	// we have to create an instance of the model and the view 
	private static  Model model = new Model();
	private static View view = new View();
	
	/* these variables save which student/professor has logged into the system so it is 
	easier to retreive their information when needed */
	private static Student studentLoggedIn = model.getStudentsArray().get(0);
	private static Professor professorLoggedIn = model.getProfessorsArray().get(0);
	
	// this is the method called by the view when the user attempts to login 
	public static int login(String username, String password) {
		
		// this if statement deals with if any text fields were empty when we tried logging in
		if (username.isBlank()||password.isBlank()) {
			
			// it returns -1 if any text fields are empty when logging in
			return -1;
			
		}
		
		// if they werent empty, then we decrement our login count 
		loginAttempts--;
					
		// if the type variable is set to 1 that means that a student is logging in
		if (type==1) { 
						
			// this if statement checks whether the credentials entered matched with any records
			if (!Controller.loginStudent(username, password)) {
				
				// if the credentials didnt match with any records then..
				if(loginAttempts!=0) {
					
					/* if the credentials are incorrect but we still have login attempts remaining
					 * it will return -2 */
					return -2;
					
				}
				else {
					
					// incase all login attempts were used up, it will return -3
					return -3;
				}
			}
			
			/* if the credentials for the student did hit a match, the method will return 1 which 
			 * indicates a student has successfully logged in so it will switch to the menu for 
			 * students */
			else return 1;
		}
		
		else if (type==2) {
			
			// this if statement checks whether the credentials entered matched with any records
			if (!Controller.loginProfessor(username, password)) {
				
				// if the credentials didnt match with any records then..
				if(loginAttempts!=0) {
					
					/* if the credentials are incorrect but we still have login attempts remaining
					 * it will return -2 */
					return -2;
				}
				
				else {
					
					// incase all login attempts were used up, it will return -3
					return -3;
				}
			}
			
			/* if the credentials for the professor did hit a match, the method will return 2 which 
			 * indicates a professor has successfully logged in so it will switch to the menu for 
			 * professors */
			else return 2;
		}
		
		else {
			
			// this if statement checks whether the credentials entered matched with any records
			if (!Controller.loginAdmin(username, password)) {
				
				// if the credentials didnt match with any records then..
				if(loginAttempts!=0) {
					
					/* if the credentials are incorrect but we still have login attempts remaining
					 * it will return -2 */
					return -2;
				}
				
				else {
					
					// incase all login attempts were used up, it will return -3
					return -3;
				}
			}
			
			/* if the credentials for the admin did hit a match, the method will return 3 which 
			 * indicates the admin has successfully logged in so it will switch to the menu for 
			 * the admin */
			else return 3;
		}
	}

	/* this is the method called by the login method in the controller when the login button is pressed
	 * in the view and a student is logging in. it checks whether the credentials entered are 
	 * accurate or not */
	public static boolean loginStudent(String username, String password) {
		for (int i=0;i<model.getStudentCount();i++) {
			if (model.getStudentsArray().get(i).getUsername().equals(username)) {
				if (model.getStudentsArray().get(i).getPassword().equals(password)) {
					studentLoggedIn=model.getStudentsArray().get(i);
					return true;
				}
				/* if the username hits a match but the password doesnt, that means 
				 * only the password was entered wrong and therefore we dont need to
				 * check the rest of the students since there will be no other username
				 * match made so we set it false here rather than outside the for loop */
				return false; 
			}
		} return false;
	}
	
	/* this is the method called by the login method in the controller when the login button is pressed
	 * in the view and a professor is logging in. it checks whether the credentials entered are 
	 * accurate or not */
	public static boolean loginProfessor(String username, String password) {
		for (int i=0;i<model.getProfessorCount();i++) {
			if (model.getProfessorsArray().get(i).getUsername().equals(username)) {
				if (model.getProfessorsArray().get(i).getPassword().equals(password)) {
					professorLoggedIn=model.getProfessorsArray().get(i);
					return true;
				}
				/* if the username hits a match but the password doesnt, that means 
				 * only the password was entered wrong and therefore we dont need to
				 * check the rest of the students since there will be no other username
				 * match made so we set it false here rather than outside the for loop */
				return false;
			}
		} return false;
	}
	
	/* this is the method called by the login method in the controller when the login button is pressed
	 * in the view and the admin is logging in. it checks whether the credentials entered are 
	 * accurate or not */
	public static boolean loginAdmin(String username, String password) {
		if (model.getAdmin().getUsername().equals(username) &&
				model.getAdmin().getPassword().equals(password)) {
			return true;
		}
		return false;
	}
	
	/* this is the method called within the view when it wants to display the students personal
	 * information to the user */
	public static String[][] displayStudentData(){
		
		String[][]data = {{studentLoggedIn.getID(),studentLoggedIn.getName(),studentLoggedIn.getMajor()}};
		return data;
	}
	
	/* this is the method called within the view when it wants to display the students course
	 * information to the user */
	public static String[][] displayStudentCourses(){
		
		String [][] data = new String[3][5];
		for(int i=0;i<studentLoggedIn.getCoursesTaken();i++) {
			Course course = model.getCourse(studentLoggedIn.getEnrolledCourses()[i][0]);
			
			data[i][0]=((i+1)+"");
			data[i][1]=(course.getCourseID()+"");
			data[i][2]=course.getCourseName();
			data[i][3]=(course.getCredits()+"");
			data[i][4]=(studentLoggedIn.getGradeOfCourse(course)+"");
		}
		return data;
		
	}
	
	/* this is the method called within the view when it wants to display the students GPA
	 * information to the user */
	public static String[][] displayGPACalculations() {
		
		int courseCount= studentLoggedIn.getCoursesTaken();
		String [][] data = new String[courseCount+1][2];
		for(int i=0;i<courseCount;i++) {
			Course course = model.getCourse(studentLoggedIn.getEnrolledCourses()[i][0]);
			data[i][0]=course.getCourseName();
			data[i][1]=(studentLoggedIn.getGradeOfCourse(course)+"");
		}
		data[courseCount][0]="Your calculated GPA";
		data[courseCount][1]=(""+studentLoggedIn.calculateGPA());
		return data;
	}
	
	/* this is the method called within the view when it wants to display the students personal
	 * information to the user */
	public static String[][] displayProfessorData(){
		
		String[][]data = {{professorLoggedIn.getID(),professorLoggedIn.getName(),professorLoggedIn.getDepartment()}};
		return data;
	}
	
	/* this is the method called within the view when it wants to display the students course
	 * information to the user */
	public static String[][] displayProfessorCourses(){
		
		String [][] data = new String[3][5];
		for(int i=0;i<professorLoggedIn.getNumberOfCourses();i++) {
			Course course = professorLoggedIn.getCoursesTeachingArray()[i];
			
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
			courses[i]=professorLoggedIn.getCoursesTeachingArray()[i];
		}
		return courses;
	}
	
	/* this is the method called within the view when it wants to display all grades in a course
	 * to the professor */
	public static String[][]getAllGradesInCourse(Course course){
		int numberOfStudents = course.getStudentCount();
		String[][]data = new String [numberOfStudents][3];
		for (int i=0;i<numberOfStudents;i++) {
			data[i][0]=course.getStudentsEnrolled()[i].getID();
			data[i][1]=course.getStudentsEnrolled()[i].getName();
			data[i][2]=""+course.getStudentsEnrolled()[i].getGradeOfCourse(course);
		}
		return data;
	}
	
	// GENERIC GETTERS AND SETTERS
	
	// this method sets the login attempts 
	public static void setLoginAttempts(int number) {
		loginAttempts=number;
	}
		
	// this method returns loginAttempts 
	public static int getLoginAttempts() {
		return loginAttempts;
	}
	
	// this method sets the type
	public static void setType(int number) {
		type=number;
	}
		
	// this method returns the type
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
