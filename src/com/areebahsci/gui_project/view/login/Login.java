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
import com.areebahsci.gui_project.controller.LoginController;
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
			                WIDTH = 520;
	
	// constructor 
	public Login() {
		
		usernameLabel = new JLabel("Username:");
		passwordLabel = new JLabel("Password:");
		status = new JLabel(Controller.getLoginAttempts()+"");
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
		
		buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 3, 2));
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

	@SuppressWarnings({ "deprecation", "static-access" })
	@Override
	public void actionPerformed(ActionEvent e) {
		
		// if the login button is clicked 
		if (e.getSource() == loginButton) {
			
			// we get the text entered into the fields 
			String username = usernameInput.getText();
		    String password = passwordInput.getText();
		    
		    switch(LoginController.login(username, password)) {
		    
		    case 1:
		    	/* if the credentials did hit a match, the method will return 1 which indicates a 
		    	 * student has successfully logged in so it will switch to the menu for students */
				View.switchPanel(this, View.getStudentMenu());
		    	break;
		    	
		    case 2:
		    	/* if the credentials did hit a match, the method will return 2 which indicates a 
		    	 * professor has successfully logged in so it will switch to the menu for professor */
				View.switchPanel(this, View.getProfessorMenu());
		    	break;
		    	
		    case 3:
		    	/* if the credentials did hit a match, the method will return 3 which indicates the 
		    	 * admin has successfully logged in so it will switch to the menu for student */
		    	View.switchPanel(this, View.getAdminMenu());
		    	break;
		    	
		    case -1:
		    	// if the text fields are empty, it will return -1 
		    	status.setText(Controller.getLoginAttempts()+". (ERROR: Do not leave text fields empty!)");
		    	break;
		    	
		    case -2:
		    	/* if the credentials did not hit a match but there are login attempts remaining,
		    	 * the method will return -2 */
		    	status.setText(Controller.getLoginAttempts()+". Try again.");
		    	break;
		    	
		    case -3:
		    	/* if the credentials did not hit a match and there aren't any login attempts remaining,
		    	 * the method will return -3 */
		    	status.setText("Maximum login attempts reached!");
				JOptionPane.showMessageDialog(Controller.getView().getFrame(), "Maximum login attempts reached", "ERROR", JOptionPane.ERROR_MESSAGE);
                loginButton.setEnabled(false);
		    	break;
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
			Controller.setLoginAttempts(3);
			loginButton.setEnabled(true);
			status.setText(Controller.getLoginAttempts()+"");
			
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
