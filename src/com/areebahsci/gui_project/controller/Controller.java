package com.areebahsci.gui_project.controller;

import com.areebahsci.gui_project.model.Model;
import com.areebahsci.gui_project.model.user.professor.Professor;
import com.areebahsci.gui_project.model.user.student.Student;
import com.areebahsci.gui_project.view.View;

public class Controller {
	
	private static  Model model = new Model();
	private static View view = new View();
	private static Student studentLoggedIn = model.getStudentsArray().get(0);
	private static Professor professorLoggedIn = null;

	public static boolean loginStudent(String username, String password) {
		for (int i=0;i<model.getStudentCount();i++) {
			if (model.getStudentsArray().get(i).getUsername().equals(username)) {
				if (model.getStudentsArray().get(i).getPassword().equals(password)) {
					studentLoggedIn=model.getStudentsArray().get(i);
					return true;
				}
				return false; // if the username hits a match but the password doesnt, that means 
				// only the password was entered wrong and therefore it is false and we dont need to
				// check the rest of the students so we set it false here rather than outside the for loop
			}
		} return false;
	}
	
	public static boolean loginProfessor(String username, String password) {
		for (int i=0;i<model.getProfessorCount();i++) {
			if (model.getProfessorsArray().get(i).getUsername().equals(username)) {
				if (model.getProfessorsArray().get(i).getPassword().equals(password)) {
					professorLoggedIn=model.getProfessorsArray().get(i);
					return true;
				}
				return false; // if the username hits a match but the password doesnt, that means 
				// only the password was entered wrong and therefore it is false and we dont need to
				// check the rest of the students so we set it false here rather than outside the for loop
			}
		} return false;
	}
	
	public static boolean loginAdmin(String username, String password) {
		if (model.getAdmin().getUsername().equals(username) &&
				model.getAdmin().getPassword().equals(password)) {
			return true;
		}
		return false;
	}
	
	public static String[][] displayStudentData(){
		
		String[][]data = {{studentLoggedIn.getID(),studentLoggedIn.getName(),studentLoggedIn.getMajor()}};
		return data;
	}
	
}
