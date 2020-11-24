package com.areebahsci.gui_project.view.login;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.TitledBorder;

import com.areebahsci.gui_project.controller.Controller;
import com.areebahsci.gui_project.view.View;

// usertype is a panel and implements actionlistener 
public class UserType extends JPanel implements ActionListener {

	private static final long serialVersionUID = 1L;
	
	// these are the dimensions of the login panel 
	private static final int WIDTH = 500, 
			                HEIGHT = 250;
	
	private JLabel welcomeMessage, purposeMessage;
	private JButton studentButton, professorButton, adminButton;
	
	// constructor 
	public UserType() {
		
		welcomeMessage = new JLabel("Welcome!");
		welcomeMessage.setHorizontalAlignment(JLabel.CENTER);
		
		purposeMessage = new JLabel("Please select which type of user you are below!");
		purposeMessage.setHorizontalAlignment(JLabel.CENTER);
		
		studentButton = new JButton("Student");
		professorButton = new JButton("Professor");
		adminButton = new JButton("Administrator");
		
		studentButton.addActionListener(this);
		professorButton.addActionListener(this);
		adminButton.addActionListener(this);
		
		this.setLayout(new GridLayout(5,1,0,5));
		this.add(welcomeMessage);
		this.add(purposeMessage);
		this.add(studentButton);
		this.add(professorButton);
		this.add(adminButton);
		
	    this.setBorder(new TitledBorder("User"));
	    this.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
		
		this.setSize(new Dimension(WIDTH, HEIGHT));
		this.setPreferredSize(new Dimension(WIDTH, HEIGHT));
		this.setMaximumSize(new Dimension(WIDTH, HEIGHT));
		this.setMinimumSize(new Dimension(WIDTH, HEIGHT));
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		// if the user selects student, it sets the type variable to 1 
		if (e.getSource() == studentButton) {
			Controller.setType(1);
		}
		
		// if the user selects professor, it sets the type variable to 2
		else if(e.getSource()==professorButton) {
			Controller.setType(2);
		}
		
		// if the user selects admin, it sets the type variable to 3
		else if(e.getSource()==adminButton) {
			Controller.setType(3);
		}
		
		// regardless of which selection was made, the same login will be shown so it switches to that panel
		View.switchPanel(this, View.getLogin());
		
	}

	// returns the width of this panel
	public int getWidth() {
		return WIDTH;
	}

	// returns the height of this panel
	public int getHeight() {
		return HEIGHT;
	}
	
}
