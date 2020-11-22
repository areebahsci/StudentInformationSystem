package com.areebahsci.gui_project.view.menu;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.TitledBorder;

import com.areebahsci.gui_project.controller.Controller;
import com.areebahsci.gui_project.view.View;

public class StudentMenu extends Menu {
	
	private static final long serialVersionUID = 1L;
	
	private JTable gpaTable;
	
	public StudentMenu() {
		
		panel.setBorder(new TitledBorder("Student Data"));
		addCourse.setText("Register courses");
		removeCourse.setText("Drop courses");
	
		gpaTable= new JTable();
		
		addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if (e.getSource()==personalInfo) {  
			String[][]data=Controller.displayStudentData();   
			String column[]= {"ID","NAME","MAJOR"};    
			
			personalTable = new JTable(data, column); 
			label.setVisible(false);
			panel.add(new JScrollPane(personalTable));
			
		}
		else if(e.getSource()==help) {
			
		}
		else if(e.getSource()==about) {
			actionPerformedAbout();
		}
		
	}
}
