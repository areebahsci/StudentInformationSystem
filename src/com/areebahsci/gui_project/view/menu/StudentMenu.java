package com.areebahsci.gui_project.view.menu;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import com.areebahsci.gui_project.controller.Controller;
import com.areebahsci.gui_project.model.course.Course;
import com.areebahsci.gui_project.view.View;
import com.areebahsci.gui_project.view.menu.altered_menu_gui.InnerPanel;
import com.areebahsci.gui_project.view.menu.altered_menu_gui.MenuLabel;
import com.areebahsci.gui_project.view.menu.altered_menu_gui.MenuTable;

/* studentmenu is a menu which is a panel so adminmenu is also a panel
 * also since menu implements actionlistener, so does studentmenu */
public class StudentMenu extends Menu {
	
	private static final long serialVersionUID = 1L;
	
	private JMenuItem viewGPA;
	private MenuTable gpaTable, addCoursesTable;
	private InnerPanel gpaPanel, addCoursesPanel;
	private MenuLabel gpaLabel, addCoursesLabel, removeCoursesLabel;
	private JButton addCourseButton, goBackButton_1, goBackButton_2, removeCourseButton;
	private JTextField addCourseInput;
	private JPanel addCoursesFlowPanel;
	
	// constructor 
	public StudentMenu() {
		
		// ADD COURSES GUI
		
		addCoursesPanel = new InnerPanel();
		
		addCoursesFlowPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 3, 3));
		addCourseButton = new JButton("Add the course");
		addCourseInput = new JTextField();
		goBackButton_1 = new JButton("Go back");
		addCoursesFlowPanel.add(addCourseInput);
		addCoursesFlowPanel.add(addCourseButton);
		addCoursesFlowPanel.add(goBackButton_1);
		
		addCoursesLabel = new MenuLabel("<html>Details of every course offered are shown in the table below.<br/>Please enter the details of the course you want to take below that. <html>");
		
		// data of the table
		String[][]data=Controller.getAllCourses();
		String column[]= {"Course ID", "Course Name", "Credits"};
						
	    // table being set
		addCoursesTable = new MenuTable (data, column);
						
		// table being added to the inner panel
		addCoursesPanel.add(addCoursesTable.createJScrollPane(), BorderLayout.CENTER);
		addCoursesPanel.add(addCoursesLabel, BorderLayout.NORTH);
		addCoursesPanel.add(addCoursesFlowPanel, BorderLayout.SOUTH);
				
		// GPA PANEL GUI
		
		gpaPanel = new InnerPanel();
		gpaLabel = new MenuLabel("Your GPA");
		gpaPanel.add(gpaLabel, BorderLayout.NORTH);
		
		// PERSONAL PANEL GUI
		
		personalLabel = new MenuLabel("Student Personal Data for " + View.semester);
		personalPanel = new InnerPanel();
		personalPanel.add(personalLabel, BorderLayout.NORTH);
		
		// COURSE PANEL GUI
		
		courseLabel = new MenuLabel("Student Course Data for " + View.semester);
		coursePanel = new InnerPanel();
		coursePanel.add(courseLabel, BorderLayout.NORTH);
		
		// GENERAL GUI OF MENU 
		
		addCourse.setText("Register courses");
		removeCourse.setText("Drop courses");
				
		viewGPA = new JMenuItem("View GPA");
		viewGPA.addActionListener(this);
		view.add(viewGPA);
		view.addSeparator();
		view.add(allInfo);
				
		mainPanel.setBorder(new TitledBorder("Student Data"));
				
		addActionListener(this);
		
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
		
		else if (e.getSource()==viewGPA) {
			createGPAPanel();
			changeMainPanel(gpaPanel);
		}
		
		else if (e.getSource()==addCourse) {
			
			changeMainPanel(addCoursesPanel);
		}
		
		else if (e.getSource()==allInfo) {
			createAllInfoPanel();
			changeMainPanel(allInfoPanel);
		}
		
		/* if the help menu item is selected it will display information about what each menu item
		 * is responsible for in attempts to explain and help */
		else if(e.getSource()==help) {
			helpLabel = new MenuLabel("<html>In the view menu section, you can view your details.<br/>In the edit menu section, you can either add a course, where the max number of courses you can take is 5.<br/> You can also withdraw and drop courses.<br/>Finally, in the more menu section, you can use it to view for more information about the program as you are doing so now.<html>");
			actionPerformedHelp();
		}
		
		else actionPerformedCommon(e);
		
	}
	
	@Override
	protected void createPersonalPanel() {
		
		// data of the table
		String[][]data=Controller.displayStudentData();   
		String column[]= {"ID","NAME","MAJOR"}; 
					
		// table being set
		personalTable = new MenuTable(data, column);
		
		// table being added to the inner panel
		personalPanel.add(personalTable.createJScrollPane());
	}
	
	@Override
	protected void createCoursePanel() {
		
		// data of the table
		String[][]data=Controller.displayStudentCourses();
		String column[]= {"Courses", "Name", "ID", "Credits", "Grade"};
		
		// table being set
		courseTable = new MenuTable (data, column);
		
		// table being added to the inner panel
		coursePanel.add(courseTable.createJScrollPane());

	}
	
	protected void createGPAPanel() {
		
		String[][]data=Controller.displayGPACalculations();
		String column[]= {"Courses", "Grades"};
		
		gpaTable = new MenuTable(data, column);
		gpaPanel.add(gpaTable.createJScrollPane());
		
	}
	
	@Override
	protected void createAllInfoPanel() {
		allInfoPanel = new JPanel(); 
		createPersonalPanel();
		createGPAPanel();
		createCoursePanel();
		allInfoPanel.add(personalPanel);
		allInfoPanel.add(coursePanel);
		allInfoPanel.add(gpaPanel);
		allInfoPanel.setLayout((new BoxLayout(allInfoPanel, BoxLayout.Y_AXIS)));
		
	}
	
}

