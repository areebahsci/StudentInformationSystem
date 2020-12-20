package com.areebahsci.gui_project.view.menu;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
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
import com.areebahsci.gui_project.controller.LoginController;
import com.areebahsci.gui_project.controller.ProfessorMenuController;
import com.areebahsci.gui_project.controller.StudentMenuController;
import com.areebahsci.gui_project.model.course.Course;
import com.areebahsci.gui_project.view.View;
import com.areebahsci.gui_project.view.menu.altered_menu_gui.InnerPanel;
import com.areebahsci.gui_project.view.menu.altered_menu_gui.MenuLabel;
import com.areebahsci.gui_project.view.menu.altered_menu_gui.MenuTable;

/* professormenu is a menu which is a panel so adminmenu is also a panel
 * also since menu implements actionlistener, so does professormenu */
public class ProfessorMenu extends ProfandAdminCommon {
	
	private static final long serialVersionUID = 1L;
	
	private JMenuItem changeGrade;
	private InnerPanel changeGradePanel;
	private MenuTable changeGradeTable;
	private JTextField studentIDInput, gradeInput;
	private MenuLabel studentIDLabel, gradeLabel;
	private JButton changeButton_2, returnButton_2, showGrades;
	private JPanel changeGradeButtonPanel, courseSelectionPanel;
	
	private InnerPanel addCoursePanel;
	private JPanel inputPanelLabels, inputPanelFields, buttonPanel, inputPanel;
	private JButton backButton_1, resetButton, addCourseButton;
	private MenuLabel courseNameLabel, courseIDLabel, courseCreditsLabel;
	private JTextField courseNameInput, courseIDInput, courseCreditsInput;
	
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
		
		// ADD COURSE PANEL
		
        addCoursePanel = new InnerPanel();
        
        backButton_1 = new JButton("Back");
        resetButton = new JButton("Reset text fields");
        addCourseButton = new JButton("Add course");
        
        courseNameLabel = new MenuLabel("Course Name:");
        courseIDLabel = new MenuLabel("Course ID:");
        courseCreditsLabel = new MenuLabel("Course Credits:");
        
        courseNameInput = new JTextField(16);
        courseIDInput = new JTextField(16);
        courseCreditsInput = new JTextField(16);
        
        inputPanelLabels = new JPanel(new GridLayout(3, 1, 3, 3));
		inputPanelLabels.add(courseNameLabel);
		inputPanelLabels.add(courseIDLabel);
		inputPanelLabels.add(courseCreditsLabel);
		
		inputPanelFields = new JPanel(new GridLayout(3, 1, 3, 3));
		inputPanelFields.add(courseNameInput);
		inputPanelFields.add(courseIDInput);
		inputPanelFields.add(courseCreditsInput);
		
		buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 3, 2));
		buttonPanel.add(backButton_1);
		buttonPanel.add(resetButton);
		buttonPanel.add(addCourseButton);
		
		inputPanel = new JPanel(new BorderLayout(5,0));
		inputPanel.add(inputPanelLabels, BorderLayout.WEST);
        inputPanel.add(inputPanelFields, BorderLayout.CENTER);
        inputPanel.setPreferredSize(new Dimension(150, 150));
        inputPanel.setMaximumSize(new Dimension(150, 150));
        inputPanel.setMinimumSize(new Dimension(150, 150));

        addCoursePanel.add(inputPanel, BorderLayout.NORTH);
        addCoursePanel.add(buttonPanel, BorderLayout.CENTER);
		
		// CHANGE GRADE OF STUDENTS GUI 
		
		changeGrade = new JMenuItem("Change a student's grade");
		
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
		
		// GENERAL GUI OF MENU 
		
		mainPanel.setBorder(new TitledBorder("Professor Data"));
				
		addCourse.setText("Register to teach courses");
		removeCourse.setText("Drop courses");
		
		view.add(allInfo);
		edit.addSeparator();
		edit.add(changeUsername);
		edit.addSeparator();
		edit.add(changePassword);
		
		edit.addSeparator();
		edit.add(changeGrade);
			
		backButton_1.addActionListener(this);
		resetButton.addActionListener(this);
		addCourseButton.addActionListener(this);
		addActionListener();
		addActionListenerMore();
		
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
		
		else if (e.getSource()==changeButton_u) {
			switch(ProfessorMenuController.changeProfessorUsername(changeUsernameInput.getText())) {
			
			case 1:
				JOptionPane.showMessageDialog(Controller.getView().getFrame(), "Your username has been successfully changed!", "SUCCESS", JOptionPane.INFORMATION_MESSAGE);
				break;
				
			case -1:
				JOptionPane.showMessageDialog(Controller.getView().getFrame(), "ERROR: You have left the text field empty!", "ERROR", JOptionPane.ERROR_MESSAGE);
				break;
			
			}
		}
		
		else if (e.getSource()==changeButton_p) {
			switch(ProfessorMenuController.changeProfessorPassword(changePasswordInput.getText())) {
			case 1:
				JOptionPane.showMessageDialog(Controller.getView().getFrame(), "Your password has been successfully changed!", "SUCCESS", JOptionPane.INFORMATION_MESSAGE);
				break;
				
			case -1:
				JOptionPane.showMessageDialog(Controller.getView().getFrame(), "ERROR: You have left the text field empty!", "ERROR", JOptionPane.ERROR_MESSAGE);
				break;
			}
		}
		
		else if (e.getSource()==changeGrade) {
			
			createChangeGradePanel();
			
		}
		
		else if (e.getSource()==addCourse) {
			if(!ProfessorMenuController.canAddCourse()) {
				// this basically checks whether it is possible for the student to remove any courses
				JOptionPane.showMessageDialog(Controller.getView().getFrame(), "You can not register to teach any more courses as you are already registered to teach 3 courses, which is the limit!", "ERROR", JOptionPane.ERROR_MESSAGE);
				}
			else {
				changeMainPanel(addCoursePanel);
			}
		}
		
		else if (e.getSource()==addCourseButton) {
			// we get the text entered into the fields 
			String courseName = courseNameInput.getText();
		    String courseID = courseIDInput.getText();
		    String courseCredits = courseCreditsInput.getText();
		    
		    switch(ProfessorMenuController.addCourse(courseName, courseID, courseCredits)) {
		    
		    case -1:
		    	// if the text fields are empty, it will return -1 
		    	JOptionPane.showMessageDialog(Controller.getView().getFrame(), "ERROR: Do not leave text fields empty!", "ERROR", JOptionPane.ERROR_MESSAGE);
				break;
		    
		    case -2:
		    	JOptionPane.showMessageDialog(Controller.getView().getFrame(), "ERROR: Ensure the CourseID and CourseCredit fields are numeric!", "ERROR", JOptionPane.ERROR_MESSAGE);
		    	break;
		    
		    case -3:
		    	JOptionPane.showMessageDialog(Controller.getView().getFrame(), "ERROR: Course Credits should be between 0 and 5", "ERROR", JOptionPane.ERROR_MESSAGE);
		    	break;
		    	
		    case -4:
		    	JOptionPane.showMessageDialog(Controller.getView().getFrame(), "ERROR: The course ID you have entered already belongs to a pre-existing course!", "ERROR", JOptionPane.ERROR_MESSAGE);
		    	break;
		    	
		    case -5:
		    	JOptionPane.showMessageDialog(Controller.getView().getFrame(), "ERROR: The course Name you have entered already belongs to a pre-existing course!", "ERROR", JOptionPane.ERROR_MESSAGE);
		    	break;
		    	
		    case 0:
		    	JOptionPane.showMessageDialog(Controller.getView().getFrame(), "ERROR: You are already registered to teach the max number of courses you can teach, which is 3!", "ERROR", JOptionPane.ERROR_MESSAGE);
		    	break;
		    	
		    case 1:
		    	JOptionPane.showMessageDialog(Controller.getView().getFrame(), "The course has been successfully registered!", "SUCCESS", JOptionPane.INFORMATION_MESSAGE);
				break;
		    }
		}
		
		else if (e.getSource()==resetButton) {
			courseNameInput.setText("");
			courseIDInput.setText("");
			courseCreditsInput.setText("");
		}
		
		/* if the help menu item is selected it will display information about what each menu item
		 * is responsible for in attempts to explain and help */
		else if(e.getSource()==help) {
			helpLabel = new MenuLabel("<html>In the view menu section, you can view your details.<br/>In the edit menu section, you can either add a course, where the max number of courses you can teach is 3.<br/> You can also stop teaching a course and drop it. Moreover, you can change your username and password. <br/>Finally, in the more menu section, you can use it to view for more information about the program as you are doing so now.<html>");
			actionPerformedHelp();
		}
		
		else if(e.getSource()==about) {
			changeMainPanel(aboutPanel);
		}
				
		// if the default menu item is selected 
		else if (e.getSource()==defaultScreen) {
			changeMainPanel(defaultPanel);
		}
	}
	
	@Override
	protected void createPersonalPanel() {
		
		// data of the table
		String[][]data=ProfessorMenuController.displayProfessorData();   
		String column[]= {"ID","NAME","DEPARTMENT"}; 
					
		// table being set
		MenuTable personalTable = new MenuTable(data, column);
		
		// table being added to the inner panel
		personalPanel.add(personalTable.createJScrollPane());
	}
	
	@Override
	protected void createCoursePanel() {
		coursePanel.removeAll();
		coursePanel.revalidate();
		coursePanel.repaint();
		// table being added to the inner panel
		coursePanel.add(createCourseTable().createJScrollPane());
	}
	
	private MenuTable createCourseTable() {
		
		// data of the table
		String[][]data=ProfessorMenuController.displayProfessorCourses();
		String column[]= {"Courses", "Name", "ID", "Credits", "Student Number"};
		
		// table being set
		return new MenuTable (data, column);
	}

	
	@Override
	protected void createAllInfoPanel() {
		
		allInfoPanel.removeAll();
		allInfoPanel.revalidate();
		allInfoPanel.repaint();
		createPersonalPanel();
		createCoursePanel(); 
		allInfoPanel.add(personalPanel);
		allInfoPanel.add(coursePanel);
		allInfoPanel.setLayout((new BoxLayout(allInfoPanel, BoxLayout.Y_AXIS)));
	}
	
	protected void createChangeGradePanel() {
		Course[] courses = ProfessorMenuController.getTeachingCourseArray();
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
		String[][]data=ProfessorMenuController.getAllGradesInCourse(course);
		String column[]= {"Student ID", "Student Name", "Grade"};
				
	    // table being set
		changeGradeTable = new MenuTable (data, column);
				
		// table being added to the inner panel
		changeGradePanel.add(changeGradeTable.createJScrollPane(), BorderLayout.CENTER);

	}
	
}
