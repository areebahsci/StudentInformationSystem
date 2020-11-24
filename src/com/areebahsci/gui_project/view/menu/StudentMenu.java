package com.areebahsci.gui_project.view.menu;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;

import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableCellRenderer;

import com.areebahsci.gui_project.controller.Controller;
import com.areebahsci.gui_project.view.menu.altered_menu_gui.InnerPanel;
import com.areebahsci.gui_project.view.menu.altered_menu_gui.MenuLabel;
import com.areebahsci.gui_project.view.menu.altered_menu_gui.MenuTable;

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
		
		// PERSONAL PANEL GUI
		
		personalLabel = new MenuLabel("Student Personal Data");
		personalPanel = new InnerPanel();
		personalPanel.add(personalLabel, BorderLayout.NORTH);
		
		// COURSE PANEL GUI
		
		courseLabel = new MenuLabel("Student Course Data");
		coursePanel = new InnerPanel();
		coursePanel.add(courseLabel, BorderLayout.NORTH);
		
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
	
	@Override
	protected void createPersonalPanel() {
		
		// data of the table
		String[][]data=Controller.displayStudentData();   
		String column[]= {"ID","NAME","MAJOR"}; 
					
		// table being set
		personalTable = new MenuTable(data, column);
		
		// table being added to the inner panel
		personalPanel.add(new JScrollPane(personalTable), BorderLayout.CENTER);
	}
	
	@Override
	protected void createCoursePanel() {
		
		// data of the table
		String[][]data=Controller.displayStudentCourses();
		String column[]= {"Courses", "Name", "ID", "Credits", "Grade"};
		
		// table being set
		courseTable = new MenuTable (data, column);
		
		// table being added to the inner panel
		coursePanel.add(new JScrollPane(courseTable), BorderLayout.CENTER);

	}
}

