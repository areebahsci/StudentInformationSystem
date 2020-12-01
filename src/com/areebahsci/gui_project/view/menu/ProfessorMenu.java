package com.areebahsci.gui_project.view.menu;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
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

/* professormenu is a menu which is a panel so adminmenu is also a panel
 * also since menu implements actionlistener, so does professormenu */
public class ProfessorMenu extends Menu {
	
	private static final long serialVersionUID = 1L;
	
	private JMenuItem changeGrade;
	private InnerPanel changeGradePanel;
	private MenuTable changeGradeTable;
	private JTextField studentIDInput, gradeInput;
	private MenuLabel studentIDLabel, gradeLabel;
	private JButton changeButton_2, returnButton_2, showGrades;
	private JPanel changeGradeButtonPanel, courseSelectionPanel;
	
	// constructor 
	public ProfessorMenu() {
		
		// PERSONAL PANEL GUI
		
		personalLabel = new MenuLabel("Professor's Personal Data for " + View.semester);
		personalPanel = new InnerPanel();
		personalPanel.add(personalLabel, BorderLayout.NORTH);
		
		// COURSE PANEL GUI
		
		courseLabel = new MenuLabel("Professor Courses Teaching Data for " + View.semester);
		coursePanel = new InnerPanel();
		coursePanel.add(courseLabel, BorderLayout.NORTH);
		
		// GENERAL GUI OF MENU 
		
		mainPanel.setBorder(new TitledBorder("Professor Data"));
		
	    addCourse.setText("Register to teach courses");
		removeCourse.setText("Drop courses");
		
		view.add(allInfo);
		edit.addSeparator();
		edit.add(changeUsername);
		edit.addSeparator();
		edit.add(changePassword);
		
		// CHANGE GRADE OF STUDENTS GUI 
		
		changeGrade = new JMenuItem("Change Students Grade");
		
		changeGradePanel = new InnerPanel();
		studentIDInput = new JTextField(10);
		gradeInput = new JTextField(10);
		studentIDLabel = new MenuLabel("Enter the ID of the student whose grade you wish to change: ");
		gradeLabel = new MenuLabel("Enter the new grade: ");
		changeButton_2 = new JButton("Change Grade");
		returnButton_2 = new JButton("Go back");
		showGrades = new JButton("Display All Grades");
		
		courseSelectionPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 5, 3));
		changeGradeButtonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 5, 3));
		changeGradeButtonPanel.add(returnButton_2);
		changeGradeButtonPanel.add(changeButton_2);
		
		// MORE GENERAL GUI
		
		edit.addSeparator();
		edit.add(changeGrade);
			
		addActionListener(this);
		
	}

	@SuppressWarnings("static-access")
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
			
			createAllInfoPanel();
			changeMainPanel(allInfoPanel);
		}
		
		else if (e.getSource()==changeUsername) {
			
			changeMainPanel(changeUsernamePanel);
		}
		
		else if (e.getSource()==changeButton_1) {
			String username = changeUsernameInput.getText();
			if (username.isBlank()) {
				JOptionPane.showMessageDialog(Controller.getView().getFrame(), "You have left the text field empty!!!", "ERROR", JOptionPane.ERROR_MESSAGE); 
			}
			Controller.changeProfessorUsername(username);
			
		}
		
		else if (e.getSource()==changePassword) {
			
			changeMainPanel(changePasswordPanel);
		}
		
		else if (e.getSource()==changeButton_2) {
			
			String password = changePasswordInput.getText();
			if (password.isBlank()) {
				JOptionPane.showMessageDialog(Controller.getView().getFrame(), "You have left the text field empty!!!", "ERROR", JOptionPane.ERROR_MESSAGE); 
			}
			Controller.changeProfessorUsername(password);	
			
		}
		
		else if (e.getSource()==returnButton_2||e.getSource()==returnButton_1) {
			
			changeMainPanel(defaultPanel);
		}
		
		else if (e.getSource()==changePassword) {
			
			changeMainPanel(changePasswordPanel);
		}
		
		else if (e.getSource()==changeGrade) {
			
			createChangeGradePanel();
			
		}
		
		/* if the help menu item is selected it will display information about what each menu item
		 * is responsible for in attempts to explain and help */
		else if(e.getSource()==help) {
			helpLabel = new MenuLabel("<html>In the view menu section, you can view your details.<br/>In the edit menu section, you can either add a course, where the max number of courses you can teach is 3.<br/> You can also stop teaching a course and drop it. Moreover, you can change your username and password. <br/>Finally, in the more menu section, you can use it to view for more information about the program as you are doing so now.<html>");
			actionPerformedHelp();
		}
		
		else actionPerformedCommon(e);
		
	}
	
	@Override
	protected void createPersonalPanel() {
		
		// data of the table
		String[][]data=Controller.displayProfessorData();   
		String column[]= {"ID","NAME","DEPARTMENT"}; 
					
		// table being set
		personalTable = new MenuTable(data, column);
		
		// table being added to the inner panel
		personalPanel.add(personalTable.createJScrollPane());
	}
	
	@Override
	protected void createCoursePanel() {
		
		// data of the table
		String[][]data=Controller.displayProfessorCourses();
		String column[]= {"Courses", "Name", "ID", "Credits", "Student Number"};
		
		// table being set
		courseTable = new MenuTable (data, column);
		
		// table being added to the inner panel
		coursePanel.add(courseTable.createJScrollPane());
	}

	
	@Override
	protected void createAllInfoPanel() {
		allInfoPanel = new JPanel(); 
		createPersonalPanel();
		createCoursePanel();
		allInfoPanel.add(personalPanel);
		allInfoPanel.add(coursePanel);
		allInfoPanel.setLayout((new BoxLayout(allInfoPanel, BoxLayout.Y_AXIS)));
		
	}
	
	protected void createChangeGradePanel() {
		Course[] courses = Controller.getTeachingCourseArray();
		for (int i=0;i<courses.length;i++) {
			JRadioButton radioButton = new JRadioButton(courses[i].getCourseName());
			courseSelectionPanel.add(radioButton);
		}
		courseSelectionPanel.add(showGrades);
		changeGradePanel.add(courseSelectionPanel, BorderLayout.NORTH);
		changeGradePanel.add(changeGradeButtonPanel, BorderLayout.SOUTH);
		
	}
	
	protected void createGradeTable(Course course) {
		// data of the table
		String[][]data=Controller.getAllGradesInCourse(course);
		String column[]= {"Student ID", "Student Name", "Grade"};
				
	    // table being set
		changeGradeTable = new MenuTable (data, column);
				
		// table being added to the inner panel
		changeGradePanel.add(changeGradeTable.createJScrollPane(), BorderLayout.CENTER);

	}
	
	
	
}
