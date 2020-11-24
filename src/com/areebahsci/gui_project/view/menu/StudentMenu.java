package com.areebahsci.gui_project.view.menu;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

import com.areebahsci.gui_project.controller.Controller;

/* studentmenu is a menu which is a panel so adminmenu is also a panel
 * also since menu implements actionlistener, so does studentmenu */
public class StudentMenu extends Menu {
	
	private static final long serialVersionUID = 1L;
	
	// constructor 
	public StudentMenu() {
		
		// GENERAL GUI OF MENU 
		
		addCourse.setText("Register courses");
		removeCourse.setText("Drop courses");
		
		mainPanel.setBorder(new TitledBorder("Student Data"));
		
		addActionListener(this);
		
		border = BorderFactory.createEmptyBorder(15,0,0,0);
		
		// PERSONAL PANEL GUI
		
		createLabel(personalLabel, "Student Personal Data");
		
		personalPanel = new JPanel(innerPanelLayout);
		personalPanel.setBorder(border);
		personalPanel.add(personalLabel, BorderLayout.NORTH);
		
		// COURSE PANEL GUI
		
		courseLabel = new JLabel("Student Course Data");
		courseLabel.setFont(labelFont);
		courseLabel.setHorizontalAlignment(JLabel.CENTER);
		
		coursePanel = new JPanel(innerPanelLayout);
		coursePanel.setBorder(border);
		coursePanel.add(courseLabel, BorderLayout.NORTH);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		/* if the personalInfo menu item is selected itll create a table with all the student personal 
		 * information and display it */
		if (e.getSource()==personalInfo) { 
			
			// data of the table
			String[][]data=Controller.displayStudentData();   
			String column[]= {"ID","NAME","MAJOR"}; 
			
			// table being set
			personalTable = new JTable(data, column); 
			personalTable.setRowHeight(0, 50);
			
            personalPanel.add(new JScrollPane(personalTable), BorderLayout.CENTER);
            
            clearMainPanel();
            mainPanel.add(personalPanel, BorderLayout.CENTER);
           
		}
		
		else if (e.getSource()==courseInfo) {
			// similar to the way personalInfo table was made
			
			String[][]data=Controller.displayStudentCourses();
			String column[]= {"Courses", "Name", "ID", "Credits", "Grade"};
			
			courseTable = new JTable(data column);
			courseTable.setRowHeight(0, 50);
			
			coursePanel.add(new JScrollPane(courseTable), BorderLayout.CENTER);
			clearMainPanel();
			mainPanel.add(coursePanel, BorderLayout.CENTER);
			
		}
		
		/* if the help menu item is selected it will display information about what each menu item
		 * is responsible for in attempts to explain and help */
		else if(e.getSource()==help) {
			
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
}
