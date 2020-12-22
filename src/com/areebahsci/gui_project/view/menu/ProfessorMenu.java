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
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import com.areebahsci.gui_project.controller.Controller;
import com.areebahsci.gui_project.controller.ProfessorMenuController;
import com.areebahsci.gui_project.view.View;
import com.areebahsci.gui_project.view.menu.altered_menu_gui.InnerPanel;
import com.areebahsci.gui_project.view.menu.altered_menu_gui.MenuLabel;
import com.areebahsci.gui_project.view.menu.altered_menu_gui.MenuTable;

/* professormenu is a menu which is a panel so adminmenu is also a panel
 * also since menu implements actionlistener, so does professormenu */
public class ProfessorMenu extends Menu {
	
	private static final long serialVersionUID = 1L;
	
	// for username and password panels
	protected JMenuItem changePassword, changeUsername;
	protected InnerPanel changePasswordPanel, changeUsernamePanel, passwordInputPanel, usernameInputPanel;
	protected MenuLabel changePasswordLabel, changeUsernameLabel,previousUsernameLabel_1,
	 previousPasswordLabel_1;
	protected JTextField changeUsernameInput,previousUsernameLabel_2,previousPasswordLabel_2;
	protected JPasswordField changePasswordInput;
	protected JButton changeButton_u, returnButton_u, viewPassword, changeButton_p, returnButton_p, generateRandomPass;
	protected JPanel usernameButtonPanel, passwordButtonPanel, inputPanelLabels_u, inputPanelFields_u,
	inputPanelLabels_p, inputPanelFields_p;
	
	// for changeGrade panel 
	private JMenuItem changeGrade;
	private InnerPanel changeGradePanel_1,changeGradePanel_2;
	private JTextField studentIDInput, studentGradeInput, changeGradeInput_1;
	private MenuLabel studentIDLabel, gradeLabel, changeGradeLabel_1, changeGradeLabel_2;
	private JButton changeGradeButton, returnButton_change1, showGradesButton, returnButton_change2;
	private JPanel changeGradeButtonPanel_2, changeGradeButtonPanel_1, inputPanelLabels_change, 
	inputPanelFields_change, inputPanel_change;
	
	// for adding courses panel 
	private InnerPanel addCoursePanel, tablePanel;
	private JPanel inputPanelLabels, inputPanelFields, buttonPanel, inputPanel;
	private JButton backButton_add, resetButton, addCourseButton;
	private MenuLabel courseNameLabel, courseIDLabel, courseCreditsLabel,addCourseLabel;
	private JTextField courseNameInput, courseIDInput, courseCreditsInput;
	
	// for removing courses panel
	private JPanel removeCoursesFlowPanel;
    private JButton removeCourseButton, backButton_remove;
    private JTextField removeCourseInput;
    private MenuLabel removeCoursesLabel;
    private InnerPanel removeCoursePanel;
	
	// constructor 
	public ProfessorMenu() {
	
		// CHANGE USERNAME PANEL
		
		changeButton_u = new JButton("Submit");
		returnButton_u = new JButton("Go back");
		changeUsernamePanel = new InnerPanel();
		changeUsername = new JMenuItem("Change your username");
		
		usernameInputPanel = new InnerPanel();
		changeUsernameInput = new JTextField(16);
		changeUsernameInput.setPreferredSize(new Dimension(90, 40));
		changeUsernameLabel = new MenuLabel("Enter your new username: ");
		
		previousUsernameLabel_1 = new MenuLabel("Your current username: ");
		previousUsernameLabel_2 = new JTextField(Controller.getProfessorLoggedIn().getUsername());
		previousUsernameLabel_2.setEditable(false);
		
		inputPanelLabels_u = new JPanel(new GridLayout(2, 1, 3, 3));
		inputPanelLabels_u.add(previousUsernameLabel_1);
		inputPanelLabels_u.add(changeUsernameLabel);
		
		inputPanelFields_u = new JPanel(new GridLayout(2, 1, 3, 3));
		inputPanelFields_u.add(previousUsernameLabel_2);
		inputPanelFields_u.add(changeUsernameInput);
		
		usernameInputPanel.add(inputPanelLabels_u, BorderLayout.WEST);
		usernameInputPanel.add(inputPanelFields_u, BorderLayout.CENTER);
		
		usernameButtonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 5, 3));
		usernameButtonPanel.add(returnButton_u);
		usernameButtonPanel.add(changeButton_u);
		
		changeUsernamePanel.add(usernameInputPanel, BorderLayout.NORTH);
		changeUsernamePanel.add(usernameButtonPanel, BorderLayout.CENTER);
		
		// CHANGE PASSWORD PANEL
		
		changeButton_p = new JButton("Submit");
		returnButton_p = new JButton("Go back");
		generateRandomPass = new JButton("Generate a random password");
		
		changePasswordPanel = new InnerPanel();
		changePassword = new JMenuItem("Change your password");
		
		passwordInputPanel = new InnerPanel();
		changePasswordInput = new JPasswordField(16);
		changePasswordInput.setPreferredSize(new Dimension(90, 40));
		changePasswordLabel = new MenuLabel("Enter your new password: ");
		
		previousPasswordLabel_1 = new MenuLabel("Your current password: ");
		previousPasswordLabel_2 = new JTextField(Controller.getProfessorLoggedIn().getPassword());
		previousPasswordLabel_2.setEditable(false);
		
		inputPanelLabels_p = new JPanel(new GridLayout(2, 1, 3, 3));
		inputPanelLabels_p.add(previousPasswordLabel_1);
		inputPanelLabels_p.add(changePasswordLabel);
		
		inputPanelFields_p = new JPanel(new GridLayout(2, 1, 3, 3));
		inputPanelFields_p.add(previousPasswordLabel_2);
		inputPanelFields_p.add(changePasswordInput);
		
		passwordInputPanel.add(inputPanelLabels_p, BorderLayout.WEST);
		passwordInputPanel.add(inputPanelFields_p, BorderLayout.CENTER);
		
		viewPassword = new JButton("Show password");
		passwordButtonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 5, 3));
		passwordButtonPanel.add(returnButton_p);
		passwordButtonPanel.add(generateRandomPass);
		passwordButtonPanel.add(changeButton_p);
		passwordButtonPanel.add(viewPassword);
		
		changePasswordPanel.add(passwordInputPanel, BorderLayout.NORTH);
		changePasswordPanel.add(passwordButtonPanel, BorderLayout.CENTER);
		
		// PERSONAL PANEL GUI
		
		personalLabel = new MenuLabel("Professor's Personal Data for " + View.semester);
		personalPanel = new InnerPanel();
		personalPanel.add(personalLabel, BorderLayout.NORTH);
		
		// COURSE PANEL GUI
		
		courseLabel = new MenuLabel("Professor Courses Teaching Data for " + View.semester);
		coursePanel = new InnerPanel();
		
		// ADD COURSE PANEL
		
        addCoursePanel = new InnerPanel();
        
        backButton_add = new JButton("Back");
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
		buttonPanel.add(backButton_add);
		buttonPanel.add(resetButton);
		buttonPanel.add(addCourseButton);
		
		inputPanel = new JPanel(new BorderLayout(5,0));
		inputPanel.add(inputPanelLabels, BorderLayout.WEST);
        inputPanel.add(inputPanelFields, BorderLayout.CENTER);
        inputPanel.setPreferredSize(new Dimension(50, 150));
        inputPanel.setMaximumSize(new Dimension(50, 150));
        inputPanel.setMinimumSize(new Dimension(50, 150));
        
        tablePanel = new InnerPanel();
	    addCourseLabel = new MenuLabel("<html>Below are the courses you are currently teaching.<br/> Enter"
	    		+ "the details below for the course you'd like to register for and teach.<html>");
		
	    addCoursePanel.add(inputPanel, BorderLayout.NORTH);
	    addCoursePanel.add(buttonPanel, BorderLayout.SOUTH);
	    
        // DROP COURSES GUI
        
        removeCoursePanel = new InnerPanel();
        
 		removeCoursesFlowPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 3, 3));
 		removeCourseButton = new JButton("Drop the course");
 		removeCourseInput = new JTextField(16);
 		removeCourseInput.setPreferredSize(new Dimension(200, 25));
 		backButton_remove = new JButton("Go back");
 		removeCoursesFlowPanel.add(removeCourseInput);
 		removeCoursesFlowPanel.add(removeCourseButton);
 		removeCoursesFlowPanel.add(backButton_remove);
 				
 		removeCoursesLabel = new MenuLabel("<html>Details of all the courses you are currently teaching are shown in the table below.<br/>Please enter the number of the course you want to drop below that. <html>");
        
		// CHANGE GRADE OF STUDENTS GUI WINDOW 1
 		
 		changeGradePanel_1 = new InnerPanel();
 		
 		changeGradeLabel_1 = new MenuLabel("Enter the course number below of which you'd like to view and change grades of students from");
 		changeGradeButtonPanel_1= new JPanel(new FlowLayout(FlowLayout.CENTER, 5, 3));
 		changeGradeInput_1 = new JTextField(16);
 		changeGradeInput_1.setPreferredSize(new Dimension(200, 25));
 		returnButton_change1 = new JButton("Go back");
 		showGradesButton = new JButton("Display All Grades");
 		changeGradeButtonPanel_1.add(changeGradeInput_1);
 		changeGradeButtonPanel_1.add(showGradesButton);
 		changeGradeButtonPanel_1.add(returnButton_change1);
 		
 		// CHANGE GRADE OF STUDENTS WINDOW 2
		
 		changeGradePanel_2=new InnerPanel(); 		
 		
		changeGradeLabel_2 = new MenuLabel("Change a student's grade");
		studentIDInput = new JTextField(16);
		studentGradeInput = new JTextField(16);
		studentIDLabel = new MenuLabel("Enter the ID of the student whose grade you wish to change: ");
		gradeLabel = new MenuLabel("Enter the new grade: ");
		changeGradeButton = new JButton("Change Grade");
		returnButton_change2 = new JButton("Go back");
		changeGradeButtonPanel_2 = new JPanel(new FlowLayout(FlowLayout.CENTER, 5, 3));
		changeGradeButtonPanel_2.add(returnButton_change2);
		changeGradeButtonPanel_2.add(changeGradeButton);
		
		inputPanelLabels_change = new JPanel(new GridLayout(2, 1, 3, 3));
		inputPanelLabels_change.add(studentIDLabel);
		inputPanelLabels_change.add(gradeLabel);
		
		inputPanelFields_change = new JPanel(new GridLayout(2, 1, 3, 3));
		inputPanelFields_change.add(studentIDInput);
		inputPanelFields_change.add(studentGradeInput);
		
		inputPanel_change = new JPanel(new BorderLayout(5,0));
		inputPanel_change.add(inputPanelLabels_change, BorderLayout.WEST);
		inputPanel_change.add(inputPanelFields_change, BorderLayout.CENTER);
		inputPanel_change.add(changeGradeButtonPanel_2, BorderLayout.SOUTH);
		inputPanel_change.setPreferredSize(new Dimension(150, 90));
		inputPanel_change.setMaximumSize(new Dimension(150, 90));
		inputPanel_change.setMinimumSize(new Dimension(150, 90));
		
		// GENERAL GUI OF MENU 
		
		mainPanel.setBorder(new TitledBorder("Professor Data"));
				
		addCourse.setText("Register to teach courses");
		removeCourse.setText("Drop courses");
		changeGrade= new JMenuItem("Change a student's grade");
		
		view.add(allInfo);
		edit.addSeparator();
		edit.add(changeUsername);
		edit.addSeparator();
		edit.add(changePassword);
		
		edit.addSeparator();
		edit.add(changeGrade);
			
		backButton_add.addActionListener(this);
		resetButton.addActionListener(this);
		addCourseButton.addActionListener(this);
		backButton_remove.addActionListener(this);
		removeCourseButton.addActionListener(this);
		changeGrade.addActionListener(this);
		changeGradeButton.addActionListener(this);
		showGradesButton.addActionListener(this);
		returnButton_change2.addActionListener(this);
		returnButton_change1.addActionListener(this);
		changeUsername.addActionListener(this);
		changePassword.addActionListener(this);
		changeButton_u.addActionListener(this);
		returnButton_u.addActionListener(this);
		changeButton_p.addActionListener(this);
		returnButton_p.addActionListener(this);
		viewPassword.addActionListener(this);
		generateRandomPass.addActionListener(this);
		addActionListener();
		
	}

	@SuppressWarnings({ "static-access", "deprecation" })
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
				previousUsernameLabel_2.setText(Controller.getProfessorLoggedIn().getUsername());
				changeUsernameInput.setText("");
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
				previousPasswordLabel_2.setText(Controller.getProfessorLoggedIn().getPassword());
				changePasswordInput.setText("");
				break;
				
			case -1:
				JOptionPane.showMessageDialog(Controller.getView().getFrame(), "ERROR: You have left the text field empty!", "ERROR", JOptionPane.ERROR_MESSAGE);
				break;
			}
		}
		
		else if (e.getSource()==changeGrade||e.getSource()==returnButton_change2) {
			
			changeGradeInput_1.setText("");
			createChangeGradePanel_1();
			changeMainPanel(changeGradePanel_1);
		}
		
		else if (e.getSource()==showGradesButton) {
			try {
				int input = Integer.parseInt(changeGradeInput_1.getText());
				if (ProfessorMenuController.changeGradeInput_1(input)) {
					ProfessorMenuController.inputCourseNumber=input;
					studentIDInput.setText("");
					studentGradeInput.setText("");
					createChangeGradePanel_2();
					changeMainPanel(changeGradePanel_2);
				}
				else {
					JOptionPane.showMessageDialog(Controller.getView().getFrame(), "Invalid Input!! Please enter the number of the course you wish to remove!", "ERROR", JOptionPane.ERROR_MESSAGE);
				}
			}
			catch(NumberFormatException nfe) {
				JOptionPane.showMessageDialog(Controller.getView().getFrame(), "Invalid Input!! Please enter the number of the course you wish to remove!", "ERROR", JOptionPane.ERROR_MESSAGE);
			}
		}
		
		else if (e.getSource()==changeGradeButton) {
			try {
				int ID = Integer.parseInt(studentIDInput.getText());
				double grade = Double.parseDouble(studentGradeInput.getText());
				switch (ProfessorMenuController.changeGradeInput_2(ID, grade)) {
				
				case 1:
					JOptionPane.showMessageDialog(Controller.getView().getFrame(), "Grade has been changed!", "SUCCESS", JOptionPane.INFORMATION_MESSAGE);
					studentIDInput.setText("");
					studentGradeInput.setText("");
					createChangeGradePanel_2();
					changeMainPanel(changeGradePanel_2);
					break;
					
				case -1:
					JOptionPane.showMessageDialog(Controller.getView().getFrame(), "Invalid Input!! Please enter an appropriate grade between 0 and 100!", "ERROR", JOptionPane.ERROR_MESSAGE);
					break;
					
				case -2:
					JOptionPane.showMessageDialog(Controller.getView().getFrame(), "Invalid Input!! Please enter a valid student ID from the table above!", "ERROR", JOptionPane.ERROR_MESSAGE);
					break;
				
				}
			}
			catch(NumberFormatException nfe) {
				JOptionPane.showMessageDialog(Controller.getView().getFrame(), "Invalid Input!! Please enter appropriate numeric values in the text fields!", "ERROR", JOptionPane.ERROR_MESSAGE);
			}
		}
		
		else if (e.getSource()==removeCourse) {
			if(!ProfessorMenuController.teachingAnyCourses()) {
				// this basically checks whether it is possible for the student to remove any courses
				JOptionPane.showMessageDialog(Controller.getView().getFrame(), "You can not remove any course as you aren't registered to teach any course!", "ERROR", JOptionPane.ERROR_MESSAGE);
				}
			else {
				removeCourseInput.setText("");
				createRemoveCoursesPanel();
				changeMainPanel(removeCoursePanel);
			}
		}
		
		else if (e.getSource()==removeCourseButton) {
			try {
				int input = Integer.parseInt(removeCourseInput.getText());
				switch (ProfessorMenuController.removeCourseButton(input)) {
				
				case -1:
					JOptionPane.showMessageDialog(Controller.getView().getFrame(), "You can not remove any course as you aren't registered to teach any course!", "ERROR", JOptionPane.ERROR_MESSAGE);
					break;
					
				case -2:
					JOptionPane.showMessageDialog(Controller.getView().getFrame(), "Invalid Input!! Please enter the number of the course you wish to remove!", "ERROR", JOptionPane.ERROR_MESSAGE);
				    break;
					
				case 1:
					JOptionPane.showMessageDialog(Controller.getView().getFrame(), "Course has been removed!", "SUCCESS", JOptionPane.INFORMATION_MESSAGE);
					createRemoveCoursesPanel();
					removeCourseInput.setText("");
					changeMainPanel(removeCoursePanel);
					break;
				}
			
			}
			catch(NumberFormatException nfe) {
				JOptionPane.showMessageDialog(Controller.getView().getFrame(), "Invalid Input!! Please enter the number of the course you wish to remove!", "ERROR", JOptionPane.ERROR_MESSAGE);
			}
		}
		
		else if (e.getSource()==addCourse) {
			if(!ProfessorMenuController.canAddCourse()) {
				// this basically checks whether it is possible for the student to remove any courses
				JOptionPane.showMessageDialog(Controller.getView().getFrame(), "You can not register to teach any more courses as you are already registered to teach 3 courses, which is the limit!", "ERROR", JOptionPane.ERROR_MESSAGE);
				}
			else {
				courseNameInput.setText("");
				courseIDInput.setText("");
				courseCreditsInput.setText("");
				createAddCoursePanel();
				changeMainPanel(addCoursePanel);
			}
		}
		
		else if (e.getSource()==backButton_remove||e.getSource()==backButton_add||
				e.getSource()==returnButton_change1) {
			changeMainPanel(defaultPanel);
		}
		
		else if (e.getSource()==addCourseButton) {
			// we get the text entered into the fields 
			String courseName = courseNameInput.getText();
		    String courseID = courseIDInput.getText();
		    String courseCredits = courseCreditsInput.getText();
		    
		    switch(ProfessorMenuController.addCourseButton(courseName, courseID, courseCredits)) {
		    
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
		    	courseNameInput.setText("");
				courseIDInput.setText("");
				courseCreditsInput.setText("");
				createAddCoursePanel();
				changeMainPanel(addCoursePanel);
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
		
		else if (e.getSource()==changePassword) {
			changePasswordInput.setText("");
			changeMainPanel(changePasswordPanel);
		}
		
		else if (e.getSource()==changeUsername) {
			changeUsernameInput.setText("");
			changeMainPanel(changeUsernamePanel);
		}
		
		else if(e.getSource()==returnButton_p||e.getSource()==returnButton_u) {
			changeMainPanel(defaultPanel);
		}
		
		else if (e.getSource()==generateRandomPass) {
			String passwordSet="ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz1234567890!@#$%^&*()";
			int passLength=15;
			//we will treat this passwordSet as an array of characters 
			char[]password=new char[passLength];
			for (int i=0;i<passLength;i++)
			{
				int x= (int) (Math.random()*passwordSet.length());
				password[i]=passwordSet.charAt(x);
			}
			changePasswordInput.setText(new String(password));
			changePasswordInput.setEchoChar((char)0); 
			
		}
		
		else if (e.getSource()==viewPassword) {
			changePasswordInput.setEchoChar((char)0); 
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
		coursePanel.add(courseLabel, BorderLayout.NORTH);
		// table being added to the inner panel
		coursePanel.add(createCourseTable().createJScrollPane(), BorderLayout.CENTER);
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
	
	protected void createChangeGradePanel_1() {
		changeGradePanel_1.removeAll();
		changeGradePanel_1.revalidate();
		changeGradePanel_1.repaint();
		changeGradePanel_1.add(changeGradeLabel_1, BorderLayout.NORTH);
		changeGradePanel_1.add(changeGradeButtonPanel_1, BorderLayout.SOUTH);
		// table being added to the inner panel
		changeGradePanel_1.add(createCourseTable().createJScrollPane(), BorderLayout.CENTER);

	}
	
	protected void createChangeGradePanel_2() {
		
		changeGradePanel_2.removeAll();
		changeGradePanel_2.revalidate();
		changeGradePanel_2.repaint();
		changeGradePanel_2.add(changeGradeLabel_2, BorderLayout.NORTH);
 		changeGradePanel_2.add(inputPanel_change, BorderLayout.SOUTH);
		// table being added to the inner panel
		changeGradePanel_2.add(createGradeTable().createJScrollPane(), BorderLayout.CENTER);

	}
	
	protected MenuTable createGradeTable() {
		// data of the table
		String[][]data=ProfessorMenuController.getAllGradesInCourse();
		String column[]= {"Student ID", "Student Name", "Grade"};
				
	    // table being set
		return new MenuTable (data, column);
	}
	
	private void createRemoveCoursesPanel() {
		
		removeCoursePanel.removeAll();
		removeCoursePanel.revalidate();
		removeCoursePanel.repaint();
		removeCoursePanel.add(removeCoursesLabel, BorderLayout.NORTH);
		removeCoursePanel.add(removeCoursesFlowPanel, BorderLayout.SOUTH);
		// table being added to the inner panel
		removeCoursePanel.add(createCourseTable().createJScrollPane(), BorderLayout.CENTER);

	}
	
	private void createAddCoursePanel() {
		tablePanel.removeAll();
		tablePanel.revalidate();
		tablePanel.repaint();
	    tablePanel.add(addCourseLabel, BorderLayout.NORTH);
		// table being added to the inner panel
	    tablePanel.add(createCourseTable().createJScrollPane(), BorderLayout.CENTER);
		addCoursePanel.add(tablePanel, BorderLayout.CENTER);

	}
	
}
