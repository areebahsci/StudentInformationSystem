package com.areebahsci.gui_project.view.menu;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.TitledBorder;

import com.areebahsci.gui_project.controller.Controller;

/* studentmenu is a menu which is a panel so adminmenu is also a panel
 * also since menu implements actionlistener, so does studentmenu */
public class StudentMenu extends Menu {
	
	private static final long serialVersionUID = 1L;
	
	private JPanel personalPanel;
	private JLabel personalLabel;
	BorderLayout personalLayout;
	
	// constructor 
	public StudentMenu() {
		
		// GENERAL GUI OF MENU 
		
		addCourse.setText("Register courses");
		removeCourse.setText("Drop courses");
		
		mainPanel.setBorder(new TitledBorder("Student Data"));
		
		addActionListener(this);
		
		// PERSONAL PANEL GUI
		
		personalLayout = new BorderLayout();
		personalLayout.setVgap(15);
		
		personalLabel = new JLabel("Student Personal Data");
		personalLabel.setHorizontalAlignment(JLabel.CENTER);
		
		personalPanel = new JPanel(personalLayout);
		personalPanel.setBorder(BorderFactory.createEmptyBorder(15,0,0,0));
		personalPanel.add(personalLabel, BorderLayout.NORTH);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		/* if the personalInfo menu item is selected itll create a table with all the student personal 
		 * information and display it */
		if (e.getSource()==personalInfo) { 
			
			// data of the table
			String[][]data=Controller.displayStudentData();   
			String column[]= {"ID","NAME","MAJOR"}; 
			
			// table beign set
			personalTable = new JTable(data, column); 
			personalTable.setRowHeight(0, 50);
			
            personalPanel.add(new JScrollPane(personalTable), BorderLayout.CENTER);
            
            clearMainPanel();
            mainPanel.add(personalPanel, BorderLayout.CENTER);
           
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
