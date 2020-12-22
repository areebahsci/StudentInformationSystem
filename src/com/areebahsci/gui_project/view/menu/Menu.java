package com.areebahsci.gui_project.view.menu;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import com.areebahsci.gui_project.view.menu.altered_menu_gui.InnerPanel;
import com.areebahsci.gui_project.view.menu.altered_menu_gui.MenuLabel;

// menu is a panel and implements actionlistener 
public abstract class Menu extends JPanel implements ActionListener {

	private static final long serialVersionUID = 1L;
	
	// these are the dimensions of the login panel
	private static final int WIDTH = 900, HEIGHT = 620;
	
	protected JMenuBar menuBar;
	protected JMenu view, edit, more;
	protected JMenuItem about, help, courseInfo, personalInfo, allInfo, addCourse, removeCourse,
	                    defaultScreen;
	protected InnerPanel personalPanel, coursePanel, defaultPanel, aboutPanel, helpPanel;
	protected JPanel allInfoPanel, mainPanel;
	protected MenuLabel personalLabel, courseLabel, defaultLabel, aboutLabel, helpLabel;

	// constructor 
	public Menu() {

		mainPanel = new JPanel(new BorderLayout());
		
		// SETTING THE COMMON MENU UP
		
		menuBar = new JMenuBar();
		
		view = new JMenu("View Your Information");
		edit = new JMenu();
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
		
		// ABOUT PANEL 
		
		aboutPanel = new InnerPanel();
		aboutLabel= new MenuLabel("This was created as an end-of-course project for my GUI class in my university.");
        aboutPanel.add(aboutLabel, BorderLayout.CENTER);
		
        // HELP PANEL
        
        helpPanel = new InnerPanel();
        
        // ALLINFO PANEL
        
        allInfoPanel = new JPanel();
        
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
	protected void addActionListener() {
		
		courseInfo.addActionListener(this);
		personalInfo.addActionListener(this);
		allInfo.addActionListener(this);
		addCourse.addActionListener(this);
		removeCourse.addActionListener(this);
		about.addActionListener(this);
		help.addActionListener(this);
		defaultScreen.addActionListener(this);
		
	}
	
	/* these methods will be used to create panels that will display personal info and course info of 
	 * students, professors and admin. These are made into their own functions so that we dont have 
	 * to rewrite the code as the same code will be needed to display all information which includes 
	 * personal and course information. These functions are made to be abstract because all
	 * two types of menus; the studentmenu and professormenu should implement these
	 * functions */
	protected abstract void createPersonalPanel();
	protected abstract void createCoursePanel();
	
	// this method will combine personal info table and course info table to display everything
	protected abstract void createAllInfoPanel(); 
	
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

	// returns the width of this panel
	public int getWidth() {
		return WIDTH;
	}
	
	// returns the height of this panel
	public int getHeight() {
		return HEIGHT;
	}
	
}
