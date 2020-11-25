package com.areebahsci.gui_project.view.menu;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import com.areebahsci.gui_project.controller.Controller;
import com.areebahsci.gui_project.view.View;
import com.areebahsci.gui_project.view.menu.altered_menu_gui.InnerPanel;
import com.areebahsci.gui_project.view.menu.altered_menu_gui.MenuLabel;
import com.areebahsci.gui_project.view.menu.altered_menu_gui.MenuTable;

/* professormenu is a menu which is a panel so adminmenu is also a panel
 * also since menu implements actionlistener, so does professormenu */
public class ProfessorMenu extends Menu {
	
	private static final long serialVersionUID = 1L;
	
	private JMenuItem changePassword, changeUsername;
	private InnerPanel changePasswordPanel, changeUsernamePanel;
	private MenuLabel changePasswordLabel, changeUsernameLabel;
	private JTextField changeUsernameInput;
	private JPasswordField changePasswordInput;
	private JButton changeButton, returnButton, viewPassword;
	private JPanel usernameButtonPanel, passwordButtonPanel;
	
	// constructor 
	public ProfessorMenu() {
		
		changeButton = new JButton("Submit");
		returnButton = new JButton("Go back");
		
		// CHANGE USERNAME PANEL GUI
		
		changeUsernamePanel = new InnerPanel();
		
		changeUsername = new JMenuItem("Change your username");
		changeUsernameInput = new JTextField(32);
		changeUsernameLabel = new MenuLabel("Enter your new username");
		
		usernameButtonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 5, 3));
		usernameButtonPanel.add(returnButton);
		usernameButtonPanel.add(changeButton);
		
		changeUsernamePanel.add(changeUsernameLabel, BorderLayout.NORTH);
		changeUsernamePanel.add(changeUsernameInput, BorderLayout.CENTER);
		changeUsernamePanel.add(usernameButtonPanel);
		
		// CHANGE PASSWORD PANEL GUI
		
		changePasswordPanel = new InnerPanel();
		
		changePassword = new JMenuItem("Change your password");
		changePasswordInput = new JPasswordField(32);
		viewPassword = new JButton("Show password");
		changePasswordLabel = new MenuLabel("Enter your new password");
		
		passwordButtonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 5, 3));
		passwordButtonPanel.add(returnButton);
		passwordButtonPanel.add(changeButton);
		passwordButtonPanel.add(viewPassword);
		
		changePasswordPanel.add(changePasswordLabel, BorderLayout.NORTH);
		changePasswordPanel.add(changePasswordInput, BorderLayout.CENTER);
		changePasswordPanel.add(passwordButtonPanel);
		
		// PERSONAL PANEL GUI
		
		personalLabel = new MenuLabel("Professor's Personal Data for " + View.semester);
		personalPanel = new InnerPanel();
		personalPanel.add(personalLabel, BorderLayout.NORTH);
		
		// COURSE PANEL GUI
		
		courseLabel = new MenuLabel("Professor Courses Teaching Data for " + View.semester);
		coursePanel = new InnerPanel();
		coursePanel.add(courseLabel, BorderLayout.NORTH);
		
		// GENERAL GUI 
		
		// GENERAL GUI OF MENU 
		
	    addCourse.setText("Register to teach courses");
		removeCourse.setText("Drop courses");
				
		mainPanel.setBorder(new TitledBorder("Professor Data"));
				
		view.add(allInfo);
		edit.add(changeUsername);
		edit.addSeparator();
		edit.add(changePassword);
			
		addActionListener(this);
		changeUsername.addActionListener(this);
		changePassword.addActionListener(this);
		changeButton.addActionListener(this);
		returnButton.addActionListener(this);
		viewPassword.addActionListener(this);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		/* if the personalInfo menu item is selected itll create a table with all the student personal 
		 * information and display it */
		if (e.getSource()==personalInfo) { 
			
            /* the createPersonalPanel creates the panel for personal info to be displayed and is done
			 * in a function as the same code will be used when we want to display all info */
			createPersonalPanel();
            changeMainPanel(personalPanel);
           
		}
		
		else if (e.getSource()==courseInfo) {
			
			/* the createCoursePanel creates the panel for personal info to be displayed and is done
			 * in a function as the same code will be used when we want to display all info */
			createCoursePanel();
			changeMainPanel(coursePanel);
			
		}
		
		else if (e.getSource()==allInfo) {
			createAllInfoPanel();
			changeMainPanel(allInfoPanel);
		}
		
		/* if the help menu item is selected it will display information about what each menu item
		 * is responsible for in attempts to explain and help */
		else if(e.getSource()==help) {
			helpLabel = new MenuLabel("<html>In the view menu section, you can view your details.<br/>In the edit menu section, you can either add a course, where the max number of courses you can teach is 3.<br/> You can also stop teaching a course and drop it.<br/>Finally, in the more menu section, you can use it to view for more information about the program as you are doing so now.<html>");
			actionPerformedHelp();
		}
		
		// if the about menu item is selected
		else if(e.getSource()==about) {
			actionPerformedAbout();
		}
		
		// if the default menu item is selected 
		else if (e.getSource()==defaultScreen) {
			actionPerformedDefaultScreen();
		}
		
	}
	
	@Override
	protected void createPersonalPanel() {
		
		// data of the table
		String[][]data=Controller.displayProfessorData();   
		String column[]= {"ID","NAME","DEPARTMENT"}; 
					
		// table being set
		personalTable = new MenuTable(data, column);
		
		// table being added to the inner panel
		personalPanel.add(personalTable.createJScrollPane());
	}
	
	@Override
	protected void createCoursePanel() {
		
		// data of the table
		String[][]data=Controller.displayProfessorCourses();
		String column[]= {"Courses", "Name", "ID", "Credits", "Student Number"};
		
		// table being set
		courseTable = new MenuTable (data, column);
		
		// table being added to the inner panel
		coursePanel.add(courseTable.createJScrollPane());

	}

	
	@Override
	protected void createAllInfoPanel() {
		allInfoPanel = new JPanel(); 
		createPersonalPanel();
		createCoursePanel();
		allInfoPanel.add(personalPanel);
		allInfoPanel.add(coursePanel);
		allInfoPanel.setLayout((new BoxLayout(allInfoPanel, BoxLayout.Y_AXIS)));
		
	}
}
