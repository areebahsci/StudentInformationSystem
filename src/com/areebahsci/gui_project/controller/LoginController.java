package com.areebahsci.gui_project.controller;

// this class has all the static methods needed for the view when users log in

public class LoginController extends Controller {

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
			if (!LoginController.loginStudent(username, password)) {
				
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
			if (!LoginController.loginProfessor(username, password)) {
				
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
			if (!LoginController.loginAdmin(username, password)) {
				
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

	/* this is the method called by the login method in the LoginController when the login button is 
	 * pressed in the view and a student is logging in. it checks whether the credentials entered are 
	 * accurate or not */
	public static boolean loginStudent(String username, String password) {
		for (int i=0;i<model.getStudentCount();i++) {
			if (model.getStudentsArray().get(i).getUsername().equals(username)) {
				if (model.getStudentsArray().get(i).getPassword().equals(password)) {
					studentLoggedIn=model.getStudentsArray().get(i);
					Controller.userLoggedIn=studentLoggedIn;
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
	
	/* this is the method called by the login method in the LoginController when the login button is 
	 * pressed in the view and a professor is logging in. it checks whether the credentials entered are 
	 * accurate or not */
	public static boolean loginProfessor(String username, String password) {
		for (int i=0;i<model.getProfessorCount();i++) {
			if (model.getProfessorsArray().get(i).getUsername().equals(username)) {
				if (model.getProfessorsArray().get(i).getPassword().equals(password)) {
					professorLoggedIn=model.getProfessorsArray().get(i);
					Controller.userLoggedIn=professorLoggedIn;
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
	
	/* this is the method called by the login method in the LoginController when the login button is 
	 * pressed in the view and the admin is logging in. it checks whether the credentials entered are 
	 * accurate or not */
	public static boolean loginAdmin(String username, String password) {
		if (model.getAdmin().getUsername().equals(username) &&
				model.getAdmin().getPassword().equals(password)) {
			Controller.userLoggedIn=model.getAdmin();
			return true;
		}
		return false;
	}
	
}
