package com.areebahsci.gui_project.view.login;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.TitledBorder;

import com.areebahsci.gui_project.controller.Controller;
import com.areebahsci.gui_project.view.View;

// login is a panel and implements actionlistener 
public class Login extends JPanel implements ActionListener {
	
	private static final long serialVersionUID = 1L;
	
	private JLabel usernameLabel, passwordLabel, status, statusMarker;
	private JTextField usernameInput;
	private JPasswordField passwordInput;
	private JButton loginButton, resetButton, backButton, showButton;
	private JPanel buttonPanel, inputPanelLabels, inputPanelFields, inputPanel, mainPanel;
	
	// these are the dimensions of the login panel 
	private static final int HEIGHT = 180, 
			                WIDTH = 480;
	
	// this count is used keeping track of login attempts 
	private int loginAttempts=3;
	
	// constructor 
	public Login() {
		
		usernameLabel = new JLabel("Username:");
		passwordLabel = new JLabel("Password:");
		status = new JLabel(loginAttempts+"");
		statusMarker = new JLabel("Attempts remaining:");
		
		usernameInput = new JTextField(20);
		passwordInput = new JPasswordField(20);
		
		loginButton = new JButton("Login");
		resetButton = new JButton("Reset text fields");
		backButton = new JButton("Go back");
		showButton = new JButton("Show password");
		
		loginButton.addActionListener(this);
		resetButton.addActionListener(this);
		backButton.addActionListener(this);
		showButton.addActionListener(this);
		
		buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 5, 2));
		buttonPanel.add(backButton);
		buttonPanel.add(resetButton);
		buttonPanel.add(loginButton);
		buttonPanel.add(showButton);
		
		inputPanelLabels = new JPanel(new GridLayout(3, 1, 3, 3));
		inputPanelLabels.add(usernameLabel);
		inputPanelLabels.add(passwordLabel);
		inputPanelLabels.add(statusMarker);
		
		inputPanelFields = new JPanel(new GridLayout(3, 1, 3, 3));
		inputPanelFields.add(usernameInput);
		inputPanelFields.add(passwordInput);
		inputPanelFields.add(status);
		
		inputPanel = new JPanel(new BorderLayout(5,0));
		inputPanel.add(inputPanelLabels, BorderLayout.WEST);
        inputPanel.add(inputPanelFields, BorderLayout.CENTER);

        mainPanel = new JPanel(new BorderLayout(0, 10));
        mainPanel.add(inputPanel, BorderLayout.CENTER);
        mainPanel.add(buttonPanel, BorderLayout.SOUTH);

        this.setLayout(new BorderLayout());
        this.setBorder(new TitledBorder("Login"));
        this.add(mainPanel, BorderLayout.CENTER);
        this.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		
		this.setSize(new Dimension(WIDTH, HEIGHT));
		this.setPreferredSize(new Dimension(WIDTH, HEIGHT));
		this.setMaximumSize(new Dimension(WIDTH, HEIGHT));
		this.setMinimumSize(new Dimension(WIDTH, HEIGHT));
		
	}

	@SuppressWarnings("deprecation")
	@Override
	public void actionPerformed(ActionEvent e) {
		
		// if the login button is clicked 
		if (e.getSource() == loginButton) {
			
			// this if statement deals with if any text fields were empty when we tried logging in
			if (usernameInput.getText().isEmpty()) {
				status.setText("3. (ERROR: Username text field is empty!)");
				return;
			}
			else if (passwordInput.getText().isEmpty()) {
				status.setText("3. (ERROR: Password text field is empty!)");
				return;
			}
			else if (usernameInput.getText().isEmpty()&&passwordInput.getText().isEmpty()) {
				status.setText("3. (ERROR: Both text fields are empty!)");
				return;
			}
			
			// if they werent empty, then we decrement our login count 
			loginAttempts--;
			
			// we get the text entered into the fields 
			String username = this.usernameInput.getText();
			String password = this.passwordInput.getText();
			
			// if the type variable is set to 1 that means that a student is logging in
			if (View.type==1) { 
				
				// this if statement checks whether the credentials entered matched with any records
				if (!Controller.loginStudent(username, password)) {
					// if the credentials didnt match with any records then..
					if(loginAttempts!=0) {
						status.setText(loginAttempts+". Try again.");
					}
					else {
						// incase all login attempts were used up
						status.setText("Maximum login attempts reached!");
						JOptionPane.showMessageDialog(View.getFrame(), "Maximum login attempts reached", "ERROR", JOptionPane.ERROR_MESSAGE);
		                loginButton.setEnabled(false);
					}
				}
				else {
					// if the credentials did hit a match, it will switch to the menu for students 
					View.switchPanel(this, View.getStudentMenu());
				}
			}
			// if the type variable is set to 2 that means that a student is logging in
			// the rest of the code checking for login validation is similar to that of the code above 
			else if (View.type==2) { 
				if (!Controller.loginProfessor(username, password)) {
					if(loginAttempts!=0) {
						status.setText(loginAttempts+". Try again.");
					}
					else {
						status.setText("Maximum login attempts reached!");
						JOptionPane.showMessageDialog(View.getFrame(), "Maximum login attempts reached", "ERROR", JOptionPane.ERROR_MESSAGE);
		                loginButton.setEnabled(false);
					}
				}
				else {
					// if the credentials did hit a match, it will switch to the menu for professors 
					View.switchPanel(this, View.getProfessorMenu());
				}
			}
			else {
				// if the type variable is set to 3 that means that a student is logging in
				// the rest of the code checking for login validation is similar to that of the code above
				if (!Controller.loginAdmin(username, password)) {
					if(loginAttempts!=0) {
						status.setText(loginAttempts+". Try again.");
					}
					else {
						status.setText("Maximum login attempts reached!");
						JOptionPane.showMessageDialog(View.getFrame(), "Maximum login attempts reached", "ERROR", JOptionPane.ERROR_MESSAGE);
		                loginButton.setEnabled(false);
					}
				}
				else {
					// if the credentials did hit a match, it will switch to the menu for admin 
					View.switchPanel(this, View.getAdminMenu());
				}
			}
		}
		
		// if the reset button was pressed 
		else if (e.getSource() == resetButton) {
			
			// it clears the textfields 
			usernameInput.setText("");
			passwordInput.setText("");
		}
		
		// if the back button was pressed 
		else if (e.getSource() == backButton) {
			
			// resets login attempts 
			loginAttempts=3;
			loginButton.setEnabled(true);
			status.setText(loginAttempts+"");
			
			// it switches back to the user type selection window panel
			View.switchPanel(this, View.getUserType());
		}
		
		// if the show button is pressed 
		else if(e.getSource()==showButton) {
			passwordInput.setEchoChar((char)0); 
		}
		
	}

	// returns the height of this panel
	public int getHeight() {
		return HEIGHT;
	}

	// returns the width of this panel
	public int getWidth() {
		return WIDTH;
	}

	
}
