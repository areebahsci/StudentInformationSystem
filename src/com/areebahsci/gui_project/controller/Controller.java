package com.areebahsci.gui_project.controller;

import com.areebahsci.gui_project.model.Model;
import com.areebahsci.gui_project.model.user.Professor;
import com.areebahsci.gui_project.model.user.Student;
import com.areebahsci.gui_project.view.View;

public class Controller {
	
	// we have to create an instance of the model and the view 
	private static  Model model = new Model();
	private static View view = new View();
	
	/* these variables save which student/professor has logged into the system so it is 
	easier to retreive their information when needed */
	private static Student studentLoggedIn = model.getStudentsArray().get(0);
	private static Professor professorLoggedIn = null;

	/* this is the method called within the view when the login button is pressed and a 
	 * student is logging in and it checks whether the credentials entered are accurate or not */
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
	
	/* this is the method called within the view when the login button is pressed and a 
	 * professor is logging in and it checks whether the credentials entered are accurate or not */
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
	
	/* this is the method called within the view when the login button is pressed and the
	 * admin is logging in and it checks whether the credentials entered are accurate or not */
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
	
}
