package com.areebahsci.gui_project.view.menu;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

// menu is a panel and implements actionlistener 
public class Menu extends JPanel implements ActionListener {

	private static final long serialVersionUID = 1L;
	
	// these are the dimensions of the login panel
	private static final int WIDTH = 700, HEIGHT = 400;
	
	protected JMenuBar menuBar;
	protected JMenu view, edit, more;
	protected JMenuItem about, help, courseInfo, personalInfo, allInfo, addCourse, removeCourse,
	                    defaultScreen;
	protected JTable personalTable, courseTable;
	protected JPanel defaultPanel, aboutPanel, mainPanel;
	protected JLabel defaultLabel, aboutLabel;
	
	// constructor 
	public Menu() {
		
		menuBar = new JMenuBar();
		
		defaultPanel = new JPanel(new BorderLayout());
		aboutPanel = new JPanel(new BorderLayout());
		mainPanel = new JPanel(new BorderLayout());
		
		personalTable = new JTable();
		courseTable = new JTable();
		
		view = new JMenu("View Information");
		edit = new JMenu("Courses");
		more = new JMenu("Help");
		
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
		view.add(allInfo);
		
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
				
		aboutLabel = new JLabel("This was created as an end-of-course project for my GUI class in my university.");
		aboutLabel.setHorizontalAlignment(JLabel.CENTER);
		
		defaultLabel = new JLabel("<html>Welcome! Please select what actions you want to perform<br/>from the menu options<html>");
		defaultLabel.setHorizontalAlignment(JLabel.CENTER);
		defaultPanel.add(defaultLabel, BorderLayout.CENTER);
		
		aboutPanel.add(aboutLabel, BorderLayout.CENTER);
		
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
		
	}
	
	/* this method will be called when the about menu item is selected. we created the method here
	 * so that it could be called in all 3 menus without rewriting the entire code as the about 
	 * menu option will work the same across all three */
	protected void actionPerformedAbout() {
		
		// it will explain in a line what this project is about 
		clearMainPanel();
        mainPanel.add(aboutPanel, BorderLayout.CENTER);
	}
	
	/* this method will be called when the default menu item is selected. we created the method here
	 * so that it could be called in all 3 menus without rewriting the entire code as the defaultscreen 
	 * menu option will work the same across all three */
	protected void actionPerformedDefaultScreen() {
		
		// it will show the screen that was showed when the window first popped open
		clearMainPanel();
		mainPanel.add(defaultPanel, BorderLayout.CENTER);
		
	}
	
	/* this method clears the main panel and is made so when we want to clear the panel whenever a 
	 * button is pressed, we dont have to call 3 different methods but rather one function to make it 
	 * more convenient */
	protected void clearMainPanel() {
		mainPanel.removeAll();
		mainPanel.revalidate();
        mainPanel.repaint();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
	}
	
	// returns the width of this panel
	public int getWidth() {
		return WIDTH;
	}
	
	// returns the height of this panel
	public int getHeight() {
		return HEIGHT;
	}
	
	// GENERIC GETTERS AND SETTERS

	public JMenuBar getMenuBar() {
		return menuBar;
	}

	public void setMenuBar(JMenuBar menuBar) {
		this.menuBar = menuBar;
	}

	public JMenu getView() {
		return view;
	}

	public void setView(JMenu view) {
		this.view = view;
	}

	public JMenu getEdit() {
		return edit;
	}

	public void setEdit(JMenu edit) {
		this.edit = edit;
	}

	public JMenu getMore() {
		return more;
	}

	public void setMore(JMenu more) {
		this.more = more;
	}

	public JMenuItem getAbout() {
		return about;
	}

	public void setAbout(JMenuItem about) {
		this.about = about;
	}

	public JMenuItem getHelp() {
		return help;
	}

	public void setHelp(JMenuItem help) {
		this.help = help;
	}

	public JMenuItem getCourseInfo() {
		return courseInfo;
	}

	public void setCourseInfo(JMenuItem courseInfo) {
		this.courseInfo = courseInfo;
	}

	public JMenuItem getPersonalInfo() {
		return personalInfo;
	}

	public void setPersonalInfo(JMenuItem personalInfo) {
		this.personalInfo = personalInfo;
	}

	public JMenuItem getAddCourse() {
		return addCourse;
	}

	public void setAddCourse(JMenuItem addCourse) {
		this.addCourse = addCourse;
	}

	public JMenuItem getRemoveCourse() {
		return removeCourse;
	}

	public void setRemoveCourse(JMenuItem removeCourse) {
		this.removeCourse = removeCourse;
	}

	public JLabel getLabel() {
		return defaultLabel;
	}

	public void setLabel(JLabel label) {
		this.defaultLabel = label;
	}
	
}
