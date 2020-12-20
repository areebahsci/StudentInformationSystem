package com.areebahsci.gui_project.view.menu;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import com.areebahsci.gui_project.controller.Controller;
import com.areebahsci.gui_project.controller.StudentMenuController;
import com.areebahsci.gui_project.view.View;
import com.areebahsci.gui_project.view.menu.altered_menu_gui.InnerPanel;
import com.areebahsci.gui_project.view.menu.altered_menu_gui.MenuLabel;
import com.areebahsci.gui_project.view.menu.altered_menu_gui.MenuTable;

/* studentmenu is a menu which is a panel so adminmenu is also a panel
 * also since menu implements actionlistener, so does studentmenu */
public class StudentMenu extends Menu {
	
	private static final long serialVersionUID = 1L;
	
	private JMenuItem viewGPA;
	private InnerPanel gpaPanel, addCoursesPanel, removeCoursesPanel;
	private MenuLabel gpaLabel, addCoursesLabel, removeCoursesLabel;
	private JButton addCourseButton, goBackButton_1, goBackButton_2, removeCourseButton;
	private JTextField addCourseInput, removeCoursesInput;
	private JPanel addCoursesFlowPanel, removeCoursesFlowPanel;
	
	// constructor  
	public StudentMenu() {
		
		// ADD COURSES GUI
		
		addCoursesPanel = new InnerPanel();
		
		addCoursesFlowPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 3, 3));
		addCourseButton = new JButton("Add the course");
		addCourseInput = new JTextField(16);
		addCourseInput.setPreferredSize(new Dimension(200, 25));
		goBackButton_1 = new JButton("Go back");
		addCoursesFlowPanel.add(addCourseInput);
		addCoursesFlowPanel.add(addCourseButton);
		addCoursesFlowPanel.add(goBackButton_1);
		
		addCoursesLabel = new MenuLabel("<html>Details of every course offered are shown in the table below.<br/>Please enter the number of the course you want to take below that. <html>");
		
		// REMOVE COURSES GUI
		
		removeCoursesPanel = new InnerPanel();
				
		removeCoursesFlowPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 3, 3));
		removeCourseButton = new JButton("Drop the course");
		removeCoursesInput = new JTextField(16);
		removeCoursesInput.setPreferredSize(new Dimension(200, 25));
		goBackButton_2 = new JButton("Go back");
		removeCoursesFlowPanel.add(removeCoursesInput);
		removeCoursesFlowPanel.add(removeCourseButton);
		removeCoursesFlowPanel.add(goBackButton_2);
				
		removeCoursesLabel = new MenuLabel("<html>Details of all the courses you are currently taking are shown in the table below.<br/>Please enter the number of the course you want to drop below that. <html>");
		
		// PANEL SETUPS
		
		gpaPanel = new InnerPanel();
		gpaLabel = new MenuLabel("Your GPA");
		
		// PERSONAL PANEL GUI
		
		personalLabel = new MenuLabel("Student Personal Data for " + View.semester);
		personalPanel = new InnerPanel();
		personalPanel.add(personalLabel, BorderLayout.NORTH);
		
		// COURSE PANEL GUI
		
		courseLabel = new MenuLabel("Student Course Data for " + View.semester);
		coursePanel = new InnerPanel();
		
		// GENERAL GUI OF MENU 
		
		addCourse.setText("Register courses");
		removeCourse.setText("Drop courses");
				
		viewGPA = new JMenuItem("View GPA");
		viewGPA.addActionListener(this);
		view.add(viewGPA);
		view.addSeparator();
		view.add(allInfo);
				
		mainPanel.setBorder(new TitledBorder("Student Data"));
				
		addCourseButton.addActionListener(this);
		removeCourseButton.addActionListener(this);
		goBackButton_1.addActionListener(this);
		goBackButton_2.addActionListener(this);
		addActionListener();
		
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
		
		else if (e.getSource()==viewGPA) {
			createGPAPanel();
			changeMainPanel(gpaPanel);
		}
		
		else if (e.getSource()==addCourse) {
			
			if (!StudentMenuController.capacityForMoreCourses()) {
				// this basically checks whether it is possible for the student to add more courses
				JOptionPane.showMessageDialog(Controller.getView().getFrame(), "You can not register for more courses! You have already been registered for the max number of courses, being "+Controller.getStudentLoggedIn().getMaxCourses()+".", "ERROR", JOptionPane.ERROR_MESSAGE);
				}
			else {
				createAddCoursesPanel();
				changeMainPanel(addCoursesPanel);
			}
		}
		
		else if (e.getSource()==removeCourse) {
			if(!StudentMenuController.takingAnyCourses()) {
				// this basically checks whether it is possible for the student to remove any courses
				JOptionPane.showMessageDialog(Controller.getView().getFrame(), "You can not remove any course as you aren't registered for any course!", "ERROR", JOptionPane.ERROR_MESSAGE);
				}
			else {
				createRemoveCoursesPanel();
				changeMainPanel(removeCoursesPanel);
			}
		}
		
		else if (e.getSource()==allInfo) {
			createAllInfoPanel();
			changeMainPanel(allInfoPanel);
		}
		
		else if (e.getSource()==addCourseButton) {
			try {
				int input = Integer.parseInt(addCourseInput.getText());
				switch (StudentMenuController.addCourseButton(input)) {
				
				case -1:
					/* if the addCourseButton method returns -1, then that means the student has already
					 * been registered for the max number of courses he can take */
					JOptionPane.showMessageDialog(Controller.getView().getFrame(), "You can not register for more courses! You have already been registered for the max number of courses, being "+Controller.getStudentLoggedIn().getMaxCourses()+".", "ERROR", JOptionPane.ERROR_MESSAGE);
					break;
					
				case -2:
					/* if the method returns -2, then that means the input entered by the user is not 
					 * a valid option */
					JOptionPane.showMessageDialog(Controller.getView().getFrame(), "Invalid Input!! Please enter the number of the course you wish to add!", "ERROR", JOptionPane.ERROR_MESSAGE);
					break;
					
				case -3:
					/* if the method returns -4, then that means the student is already taking the course
					 * which he has tried to register for again */
				    JOptionPane.showMessageDialog(Controller.getView().getFrame(), "You are already registered to this course!", "ERROR", JOptionPane.ERROR_MESSAGE);
				    break;
				    
				case -4:
					/* if the method returns -3, then that means the course is already full
					 * so you can not register for it */
				    JOptionPane.showMessageDialog(Controller.getView().getFrame(), "The course is full! You can not register to it!", "ERROR", JOptionPane.ERROR_MESSAGE);
					break;
					
				case 1:
					/* the last option is for the method to return 1 and that means that the course
					 * has been successfully added */
					JOptionPane.showMessageDialog(Controller.getView().getFrame(), "Course has been added!", "SUCCESS", JOptionPane.INFORMATION_MESSAGE);
					break;
				
				}
			}
			catch(NumberFormatException nfe) {
				JOptionPane.showMessageDialog(Controller.getView().getFrame(), "Invalid Input!! Please enter the number of the course you wish to add!", "ERROR", JOptionPane.ERROR_MESSAGE);
			}
		}
		
		else if (e.getSource()==removeCourseButton) {
			try {
				int input = Integer.parseInt(removeCoursesInput.getText());
				switch (StudentMenuController.removeCourseButton(input)) {
				
				case -1:
					/* if the addCourseButton method returns -1, then that means the student isnt taking
					 * any courses so he cant drop any */
					JOptionPane.showMessageDialog(Controller.getView().getFrame(), "You can not drop a course as you aren't taking any!!", "ERROR", JOptionPane.ERROR_MESSAGE);
				    break;
				case -2:
					/* if the method returns -2, then that means the input entered by the user is not 
					 * a valid option */
					JOptionPane.showMessageDialog(Controller.getView().getFrame(), "Invalid Input!! Please enter the number of the course you wish to remove!", "ERROR", JOptionPane.ERROR_MESSAGE);
				    break;
				case 1: 
					/* the last option is for the method to return 1 and that means that the course
					 * has been successfully removed */
					JOptionPane.showMessageDialog(Controller.getView().getFrame(), "Course has been removed!", "SUCCESS", JOptionPane.INFORMATION_MESSAGE);
					createRemoveCoursesPanel();
					changeMainPanel(removeCoursesPanel);
					break;
				
				}
			
			}
			catch(NumberFormatException nfe) {
				JOptionPane.showMessageDialog(Controller.getView().getFrame(), "Invalid Input!! Please enter the number of the course you wish to remove!", "ERROR", JOptionPane.ERROR_MESSAGE);
			}
		}
		
		else if(e.getSource()==goBackButton_1||e.getSource()==goBackButton_2) {
			changeMainPanel(defaultPanel);
		}
		
		/* if the help menu item is selected it will display information about what each menu item
		 * is responsible for in attempts to explain and help */
		else if(e.getSource()==help) {
			helpLabel = new MenuLabel("<html>In the view menu section, you can view your details.<br/>In the edit menu section, you can either add a course, where the max number of courses you can take is 5.<br/> You can also withdraw and drop courses.<br/>Finally, in the more menu section, you can use it to view for more information about the program as you are doing so now.<html>");
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
		String[][]data=StudentMenuController.displayStudentData();   
		String column[]= {"ID","NAME","MAJOR"}; 
					
		// table being set
		MenuTable personalTable = new MenuTable(data, column);
		
		// table being added to the inner panel
		personalPanel.add(personalTable.createJScrollPane());
	}
	
	// this method creates a table to show all the courses the student is currently taking
	private MenuTable createCourseTable() {
		// data of the table
		String[][]data=StudentMenuController.displayStudentCourses();
		String column[]= {"Courses", "Name", "ID", "Credits", "Grade"};
				
		// table being set
		return new MenuTable (data, column);
		
	}
	
	@Override
	protected void createCoursePanel() {
		
		coursePanel.removeAll();
		coursePanel.revalidate();
		coursePanel.repaint();
		coursePanel.add(courseLabel, BorderLayout.NORTH);
		// table being added to the inner panel
		coursePanel.add(createCourseTable().createJScrollPane());

	}
	
	private void createRemoveCoursesPanel() {
		
		removeCoursesPanel.removeAll();
		removeCoursesPanel.revalidate();
		removeCoursesPanel.repaint();
		removeCoursesPanel.add(removeCoursesLabel, BorderLayout.NORTH);
		removeCoursesPanel.add(removeCoursesFlowPanel, BorderLayout.SOUTH);
		// table being added to the inner panel
		removeCoursesPanel.add(createCourseTable().createJScrollPane(), BorderLayout.CENTER);

	}
	
	private MenuTable createGPATable() {
		String[][]data=StudentMenuController.displayGPACalculations();
		String column[]= {"Courses", "Grades"};
		
		return new MenuTable(data, column);
	}
	
	private void createGPAPanel() {
		
		gpaPanel.removeAll();
		gpaPanel.revalidate();
		gpaPanel.repaint();
		
		gpaPanel.add(gpaLabel, BorderLayout.NORTH);
		
		// table being added to the inner panel
		gpaPanel.add(createGPATable().createJScrollPane(), BorderLayout.CENTER);
		
	}
	
	private void createAddCoursesPanel() {
		
		addCoursesPanel.removeAll();
		addCoursesPanel.revalidate();
		addCoursesPanel.repaint();
		addCoursesPanel.add(createAllCoursesTable().createJScrollPane(), BorderLayout.CENTER);
		addCoursesPanel.add(addCoursesLabel, BorderLayout.NORTH);
		addCoursesPanel.add(addCoursesFlowPanel, BorderLayout.SOUTH);
	}
	
	@Override
	protected void createAllInfoPanel() {
		allInfoPanel.removeAll();
		allInfoPanel.revalidate();
		allInfoPanel.repaint();
		createPersonalPanel();
		createGPAPanel(); 
		createCoursePanel(); 
		allInfoPanel.add(personalPanel);
		allInfoPanel.add(coursePanel);
		allInfoPanel.add(gpaPanel);
		allInfoPanel.setLayout((new BoxLayout(allInfoPanel, BoxLayout.Y_AXIS)));
		
	}
	
}

