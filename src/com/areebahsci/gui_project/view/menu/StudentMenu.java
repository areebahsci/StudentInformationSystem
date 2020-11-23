package com.areebahsci.gui_project.view.menu;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.TitledBorder;

import com.areebahsci.gui_project.controller.Controller;
import com.areebahsci.gui_project.view.View;

public class StudentMenu extends Menu {
	
	private static final long serialVersionUID = 1L;
	
	private JPanel personalPanel;
	private JLabel personalLabel;
	
	public StudentMenu() {
		
		mainPanel.setBorder(new TitledBorder("Student Data"));
		
		personalPanel = new JPanel(new BorderLayout());
		personalLabel = new JLabel("Student Personal Data");
		personalPanel.add(personalLabel, BorderLayout.NORTH);
		
		addCourse.setText("Register courses");
		removeCourse.setText("Drop courses");
		
		addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if (e.getSource()==personalInfo) { 
			
			// data of the table
			String[][]data=Controller.displayStudentData();   
			String column[]= {"ID","NAME","MAJOR"}; 
			
			// table beign set
			personalTable = new JTable(data, column); 
			personalTable.setRowHeight(0, 50);
			
            personalPanel.add(new JScrollPane(personalTable), BorderLayout.CENTER);
            
            mainPanel.removeAll();
            mainPanel.add(personalPanel, BorderLayout.CENTER);
           
		}
		
		else if(e.getSource()==help) {
			
		}
		else if(e.getSource()==about) {
			actionPerformedAbout();
		}
		
	}
}
