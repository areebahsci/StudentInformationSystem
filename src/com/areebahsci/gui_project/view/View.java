package com.areebahsci.gui_project.view;

import javax.swing.JFrame;
import javax.swing.JPanel;

import com.areebahsci.gui_project.view.login.Login;
import com.areebahsci.gui_project.view.login.UserType;
import com.areebahsci.gui_project.view.menu.AdminMenu;
import com.areebahsci.gui_project.view.menu.Menu;
import com.areebahsci.gui_project.view.menu.ProfessorMenu;
import com.areebahsci.gui_project.view.menu.StudentMenu;

/* this class holds the main frame shown to the users and is responsible for switching between the panels
 * dependant on what we want to show the user next */
public class View { 
	
	/*   I am not extending this as a frame just incase I need my view to adapt the program to being an
	applet or dialog or anything */
	
	/* frames need variables for their width and height but since the width and height 
	 * of the frame is dependant on the width and height of the panel they are currently 
	 * holding, i havent made any variables to hold these figures.  */
	
	private static JFrame frame; // used to create a window on the screen
	private static Menu menu;
	private static Login login;
	private static UserType userType;
	private static Menu studentMenu, professorMenu, adminMenu;
	
	/* the type variable will be used to store whether the system is being used by a student, a professor
	 * or the admin. this is needed to show them their appropriate windows */
	public static int type = 0; 
	
	// this variable stores which semester we are currently in
	public static String semester = "Spring 2020";
	
	// constructor 
	public View() {
		
	    frame = new JFrame("Student Information System");
		menu = new Menu();
		login = new Login();
		userType = new UserType();
		studentMenu = new StudentMenu();
		professorMenu = new ProfessorMenu();
		adminMenu = new AdminMenu();

		// important for closing games to ensure they dont run in the bg
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// by default it is false  so we need to set it to true so we can see it
		frame.setVisible(true);
		
		// initial panel that should be displayed on the frame
		// frame.setSize(userType.getWidth(), userType.getHeight());
		// frame.add(userType);
		
		frame.setSize(studentMenu.getWidth(), studentMenu.getHeight());
		frame.add(studentMenu);
		
		/* it resizes the frame so that all its contents are at or above their 
		 * preferred sizes so its for a good fit to ensure everything is visible*/
		frame.pack();
		
		// this centers the window to the center of your screen
		frame.setLocationRelativeTo(null);
		
		// we don't want the user to resize the window
		frame.setResizable(false);

	}
	
	/* this method is used to switch panels depending on what we want to show the user, and this
	 * will also in turn affect the width and height of the frame as we want it to match its width and 
	 * height with the panel its holding */
	public static void switchPanel(JPanel panelBefore, JPanel panelAfter) {
		
		frame.remove(panelBefore);
		frame.add(panelAfter);
		frame.setSize(panelAfter.getWidth(), panelAfter.getHeight());
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
	}
	
	// GENERIC GETTERS AND SETTERS

	public static JFrame getFrame() {
		return frame;
	}

	public static void setFrame(JFrame frame) {
		View.frame = frame;
	}

	public static Menu getMenu() {
		return menu;
	}

	public static void setMenu(Menu menu) {
		View.menu = menu;
	}

	public static Login getLogin() {
		return login;
	}

	public static void setLogin(Login login) {
		View.login = login;
	}

	public static UserType getUserType() {
		return userType;
	}

	public static void setUserType(UserType userType) {
		View.userType = userType;
	}

	public static Menu getStudentMenu() {
		return studentMenu;
	}

	public static void setStudentMenu(Menu studentMenu) {
		View.studentMenu = studentMenu;
	}

	public static Menu getProfessorMenu() {
		return professorMenu;
	}

	public static void setProfessorMenu(Menu professorMenu) {
		View.professorMenu = professorMenu;
	}

	public static Menu getAdminMenu() {
		return adminMenu;
	}

	public static void setAdminMenu(Menu adminMenu) {
		View.adminMenu = adminMenu;
	}
	
}
