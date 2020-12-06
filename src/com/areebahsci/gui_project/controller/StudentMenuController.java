package com.areebahsci.gui_project.controller;

import com.areebahsci.gui_project.model.course.Course;
import com.areebahsci.gui_project.model.utilities.File;

/* this class has all the static methods needed for the view when a student has logged in and is using the
 * application */

public class StudentMenuController extends Controller {

	/* this is the method called within the view when it wants to display the students personal
	 * information to the user */
	public static String[][] displayStudentData(){
		
		String[][]data = {{studentLoggedIn.getID(),studentLoggedIn.getName(),studentLoggedIn.getMajor()}};
		return data;
	} 
	
	/* this is the method called within the view when it wants to display the students course
	 * information to the user */
	public static String[][] displayStudentCourses(){
		
		int courseCount = studentLoggedIn.getCoursesTaken();
		String [][] data = new String[courseCount][5];
		for(int i=0;i<courseCount;i++) {
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
		data[courseCount][1]=(""+studentLoggedIn.getGPA());
		return data;
	}
	
	// this method is called when the student wants to add a course 
	public static int addCourseButton(int input) {
		
		/* this if statement checks if the student has the capacity to take more courses while the add
		 * courses window is open and if not, it will return -1 */
		if (!capacityForMoreCourses()) {
			return -1;
		}
		
		int courseCount = model.getCourseCount();
		
		/* this if statement checks if the input entered by the user is a valid option and if not it will
		 *return -2 */
		
		if (!(input>0 && input<=courseCount)) {
			return -2;
		}
		
		Course course = model.getCoursesArray().get(input-1);
		
		/* this for loop checks if the course the student wishes to add is already being taken by the 
		 * student, and if it is, then the method will return -3 */
		for (int i=0;i<studentLoggedIn.getCoursesTaken();i++) {
			if (course.getCourseID()==studentLoggedIn.getEnrolledCourses()[i][0]) {
				return -3;
			}
		}
		
		/* this for loop checks if the course the student wishes to add is full or not, and if it is,
		 *  then the method will return -4 */
		if (!(course.getStudentCount()<20)) {
			return -4;
		}
		
		/* if the method has reached this point, then that means that the student is able to add more
		 * courses as he hasnt reached his limit, and that the input was valid and it belonged to 
		 * a course the student isnt currently taking already so we can finally add the course to the
		 * student */
		
		studentLoggedIn.addCourse(course);
		/* when the course is added successfully, the methid updates the student file and returns 1.
		 * also we do not update the GPA as you havent recieved a grade for the course you have JUST 
		 * added */
		File.updateStudentFile(model, "resources/Student_info");
		return 1;
	}
	
	// this is the method called when the student wishes to withdraw from a course 
	public static int removeCourseButton(int input) {
		
		int courseCount = studentLoggedIn.getCoursesTaken();
		if (!takingAnyCourses()) {
			// if there are no courses for the student to drop, it will return -1
			return -1;
		}
		if (!(input>0 && input<=courseCount)) {
			// if the input is invalid, it will return -2
			return -2;
		}
		else {
			/* otherwise it is valid for the student to remove the course and it will do so and return
			 * 1 to indicate success */
			Course course = model.getCourse(studentLoggedIn.getEnrolledCourses()[input-1][0]);
			studentLoggedIn.removeCourse(input-1);
			course.removeStudent(studentLoggedIn);
			 // we also have to update the GPA and the student file
			studentLoggedIn.calculateGPA();
			File.updateStudentFile(model, "resources/Student_info");
			return 1;
		}
	}
	
	// this method checks if the student has the capacity to take more courses
	public static boolean capacityForMoreCourses() {
		
		if (studentLoggedIn.getCoursesTaken()<5) {
			return true;
		}
		return false;
	}
	
	// this method checks if the student is taking any courses at all
		public static boolean takingAnyCourses() {
			
			if (studentLoggedIn.getCoursesTaken()>0) {
				return true;
			}
			return false;
		}
	
}
