package com.areebahsci.gui_project.view.menu;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Menu extends JPanel implements ActionListener {

	private static final long serialVersionUID = 1L;
	
	private static final int WIDTH = 700, HEIGHT = 400;
	
	protected JMenuBar menuBar;
	protected JMenu view, edit, more;
	protected JMenuItem about, help, courseInfo, personalInfo, allInfo, addCourse, removeCourse;
	protected JTable personalTable, courseTable;
	
	protected JPanel panel;
	
	protected JLabel label;
	
	public Menu() {
		
		menuBar = new JMenuBar();
		
		panel = new JPanel(new BorderLayout());
		
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
		
		menuBar.add(view);
		menuBar.add(edit);
		menuBar.add(more);
				
		label = new JLabel("<html>Welcome! Please select what actions you want to perform<br/>from the menu options<html>");
		label.setHorizontalAlignment(JLabel.CENTER);
		panel.add(label);
		this.setLayout(new BorderLayout());
		this.add(menuBar, BorderLayout.NORTH);
		this.add(panel, BorderLayout.CENTER);
		
		this.setSize(new Dimension(WIDTH, HEIGHT));
		this.setPreferredSize(new Dimension(WIDTH, HEIGHT));
		this.setMaximumSize(new Dimension(WIDTH, HEIGHT));
		this.setMinimumSize(new Dimension(WIDTH, HEIGHT));
		
	}	
	
	protected void addActionListener(Menu menu) {
		
		courseInfo.addActionListener(menu);
		personalInfo.addActionListener(menu);
		allInfo.addActionListener(menu);
		addCourse.addActionListener(menu);
		removeCourse.addActionListener(menu);
		about.addActionListener(menu);
		help.addActionListener(menu);
		
	}
	
	protected void actionPerformedAbout() {
		panel.removeAll();
		panel.add(label, BorderLayout.CENTER);
		label.setText("Made by Areebah Iqbal as an end of course project for GUI.");
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
	}
	
	public int getWidth() {
		return WIDTH;
	}
	
	public int getHeight() {
		return HEIGHT;
	}
	
	// GETTERS AND SETTERS

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
		return label;
	}

	public void setLabel(JLabel label) {
		this.label = label;
	}
	
}
