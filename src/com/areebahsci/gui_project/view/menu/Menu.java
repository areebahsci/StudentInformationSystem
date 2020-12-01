package com.areebahsci.gui_project.view.menu;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import com.areebahsci.gui_project.controller.Controller;
import com.areebahsci.gui_project.view.View;
import com.areebahsci.gui_project.view.menu.altered_menu_gui.InnerPanel;
import com.areebahsci.gui_project.view.menu.altered_menu_gui.MenuLabel;
import com.areebahsci.gui_project.view.menu.altered_menu_gui.MenuTable;

// menu is a panel and implements actionlistener 
public abstract class Menu extends JPanel implements ActionListener {

	private static final long serialVersionUID = 1L;
	
	// these are the dimensions of the login panel
	private static final int WIDTH = 800, HEIGHT = 620;
	
	protected JMenuBar menuBar;
	protected JMenu view, edit, more;
	protected JMenuItem about, help, courseInfo, personalInfo, allInfo, addCourse, removeCourse,
	                    defaultScreen;
	protected InnerPanel personalPanel, coursePanel, defaultPanel, aboutPanel, helpPanel;
	protected JPanel allInfoPanel, mainPanel;
	protected MenuLabel personalLabel, courseLabel, defaultLabel, aboutLabel, helpLabel;
	protected MenuTable personalTable, courseTable;
	
	// used only by admin and professor 
	protected JMenuItem changePassword, changeUsername;
	protected InnerPanel changePasswordPanel, changeUsernamePanel, passwordInputPanel, usernameInputPanel;
	protected MenuLabel changePasswordLabel, changeUsernameLabel;
	protected JTextField changeUsernameInput;
	protected JPasswordField changePasswordInput;
	protected JButton changeButton_1, returnButton_1, viewPassword, changeButton_2, returnButton_2;
	protected JPanel usernameButtonPanel, passwordButtonPanel; 
	
	// used only by student and admin
	
	protected InnerPanel allCoursesPanel;
	protected MenuTable allCoursesTable;
	protected MenuLabel allCoursesLabel;
	
	// constructor 
	public Menu() {

		mainPanel = new JPanel(new BorderLayout());
		
		changeButton_1 = new JButton("Submit");
		returnButton_1 = new JButton("Go back");
		changeButton_2 = new JButton("Submit");
		returnButton_2 = new JButton("Go back");
		
		// SETTING THE COMMON MENU UP
		
		menuBar = new JMenuBar();
		
		view = new JMenu("View Information");
		edit = new JMenu("Edit");
		more = new JMenu("More");
		
		courseInfo = new JMenuItem("Course Information");
		personalInfo = new JMenuItem("Personal Details");
		allInfo = new JMenuItem("All information");
		addCourse = new JMenuItem("");
		removeCourse = new JMenuItem("");
		about = new JMenuItem("About");
		help = new JMenuItem("Help");
		defaultScreen = new JMenuItem("Display default page");
		
		view.add(personalInfo);
		view.addSeparator();
		view.add(courseInfo);
		view.addSeparator();
		
		edit.add(addCourse);
		edit.addSeparator();
		edit.add(removeCourse);
		
		more.add(about);
		more.addSeparator();
		more.add(help);
		more.addSeparator();
		more.add(defaultScreen);
		
		menuBar.add(view);
		menuBar.add(edit);
		menuBar.add(more);
		
		// DEFAULT PANEL 
		
		defaultPanel = new InnerPanel();
	    defaultLabel= new MenuLabel("Welcome! Use the menu options to perform your desired actions.");
	    defaultPanel.add(defaultLabel, BorderLayout.CENTER);
		
		// CHANGE USERNAME PANEL
		
		changeUsernamePanel = new InnerPanel();
		changeUsername = new JMenuItem("Change your username");
		
		usernameInputPanel = new InnerPanel();
		changeUsernameInput = new JTextField(16);
		changeUsernameInput.setPreferredSize(new Dimension(90, 40));
		changeUsernameLabel = new MenuLabel("Enter your new username: ");
		usernameInputPanel.add(changeUsernameLabel, BorderLayout.WEST);
		usernameInputPanel.add(changeUsernameInput, BorderLayout.CENTER);
		
		usernameButtonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 5, 3));
		usernameButtonPanel.add(returnButton_1);
		usernameButtonPanel.add(changeButton_1);
		
		changeUsernamePanel.add(usernameInputPanel, BorderLayout.NORTH);
		changeUsernamePanel.add(usernameButtonPanel, BorderLayout.CENTER);
		
		// CHANGE PASSWORD PANEL
		
		changePasswordPanel = new InnerPanel();
		changePassword = new JMenuItem("Change your password");
		
		passwordInputPanel = new InnerPanel();
		changePasswordInput = new JPasswordField(16);
		changePasswordInput.setPreferredSize(new Dimension(90, 40));
		changePasswordLabel = new MenuLabel("Enter your new password: ");
		passwordInputPanel.add(changePasswordLabel, BorderLayout.WEST);
		passwordInputPanel.add(changePasswordInput, BorderLayout.CENTER);
		
		viewPassword = new JButton("Show password");
		passwordButtonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 5, 3));
		passwordButtonPanel.add(returnButton_2);
		passwordButtonPanel.add(changeButton_2);
		passwordButtonPanel.add(viewPassword);
		
		changePasswordPanel.add(passwordInputPanel, BorderLayout.NORTH);
		changePasswordPanel.add(passwordButtonPanel, BorderLayout.CENTER);
		
		// ABOUT PANEL 
		
		aboutPanel = new InnerPanel();
		aboutLabel= new MenuLabel("This was created as an end-of-course project for my GUI class in my university.");
        aboutPanel.add(aboutLabel, BorderLayout.CENTER);
		
        // HELP PANEL
        
        helpPanel = new InnerPanel();
        
		// the main panel will showcase the defaultPanel first
		
		mainPanel.add(defaultPanel);
	
		this.setLayout(new BorderLayout());
		this.add(menuBar, BorderLayout.NORTH);
		this.add(mainPanel, BorderLayout.CENTER);
		
		this.setSize(new Dimension(WIDTH, HEIGHT));
		this.setPreferredSize(new Dimension(WIDTH, HEIGHT));
		this.setMaximumSize(new Dimension(WIDTH, HEIGHT));
		this.setMinimumSize(new Dimension(WIDTH, HEIGHT));
		
	}	
	
	/* this method is used to add actionlistener without having to type it out 3 different types for the
	 * 3 different menues */
	protected void addActionListener(Menu menu) {
		
		courseInfo.addActionListener(menu);
		personalInfo.addActionListener(menu);
		allInfo.addActionListener(menu);
		addCourse.addActionListener(menu);
		removeCourse.addActionListener(menu);
		about.addActionListener(menu);
		help.addActionListener(menu);
		defaultScreen.addActionListener(menu);
		changeUsername.addActionListener(this);
		changePassword.addActionListener(this);
		changeButton_1.addActionListener(this);
		returnButton_1.addActionListener(this);
		changeButton_2.addActionListener(this);
		returnButton_2.addActionListener(this);
		viewPassword.addActionListener(this);
		
	}
	
	/* these methods will be used to create panels that will display personal info and course info of 
	 * students, professors and admin. These are made into their own functions so that we dont have 
	 * to rewrite the code as the same code will be needed to display all information which includes 
	 * personal and course information. These functions are made to be abstract because all
	 * three types of menus; the studentmenu, professormenu and adminmenu, should implement these
	 * functions */
	protected abstract void createPersonalPanel();
	protected abstract void createCoursePanel();
	
	// this method will combine personal info table and course info table to display everything
	protected abstract void createAllInfoPanel(); 
	
	// this method creates a panel to showcase all courses offered in a table
	protected void createAllCoursesPanel() {
		createAllCoursesTable();
		allCoursesLabel = new MenuLabel("All Courses Offerred In "+View.semester);
		allCoursesPanel.add(allCoursesLabel, BorderLayout.NORTH);
		allCoursesPanel.add(allCoursesTable.createJScrollPane(), BorderLayout.CENTER);
	}
	
	protected void createAllCoursesTable() {
		// data of the table
		String[][]data=Controller.getAllCourses();
		String column[]= {"Course Number", "Course ID", "Course Name", "Credits"};
								
		// table being set
		allCoursesTable = new MenuTable (data, column);
	}
	
	/* this method clears the main panel and adds on the panel we want to display and is made so when 
	 * we want to clear the panel whenever a button is pressed, we dont have to call 4 different methods
	 * but rather write one function call code to make it more convenient */
	protected void changeMainPanel(JPanel panel) {
		mainPanel.removeAll();
		mainPanel.revalidate();
        mainPanel.repaint();
        mainPanel.add(panel, BorderLayout.CENTER);
	}
	
	/* i wrote this function so i could just write this one line of code across the three different
	 * menu GUIs ensuring I wont forget to add the label after setting its text */
	protected void actionPerformedHelp() {
		
		helpPanel.add(helpLabel, BorderLayout.CENTER);
		changeMainPanel(helpPanel);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// if the about menu item is selected
		if(e.getSource()==about) {
			changeMainPanel(aboutPanel);
		}
				
		// if the default menu item is selected 
		else if (e.getSource()==defaultScreen) {
			changeMainPanel(defaultPanel);
		}
	}
	
	public void actionPerformedCommon(ActionEvent e) {
		// if the about menu item is selected
		if(e.getSource()==about) {
			changeMainPanel(aboutPanel);
		}
				
		// if the default menu item is selected 
		else if (e.getSource()==defaultScreen) {
			changeMainPanel(defaultPanel);
		}
	}
	
	// returns the width of this panel
	public int getWidth() {
		return WIDTH;
	}
	
	// returns the height of this panel
	public int getHeight() {
		return HEIGHT;
	}
	
}
