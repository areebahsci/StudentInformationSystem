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

public class Login extends JPanel implements ActionListener {
	
	private static final long serialVersionUID = 1L;
	
	private JLabel usernameLabel, passwordLabel, status, statusMarker;
	private JTextField usernameInput;
	private JPasswordField passwordInput;
	private JButton loginButton, resetButton, backButton;
	private JPanel buttonPanel, inputPanelLabels, inputPanelFields, inputPanel, mainPanel;
	
	private static final int HEIGHT = 180, 
			                WIDTH = 480;
	
	private int count=3;
	
	public Login() {
		
		usernameLabel = new JLabel("Username:");
		passwordLabel = new JLabel("Password:");
		status = new JLabel("3");
		statusMarker = new JLabel("Attempts remaining:");
		
		usernameInput = new JTextField(20);
		passwordInput = new JPasswordField(20);
		
		loginButton = new JButton("Login");
		resetButton = new JButton("Reset text fields");
		backButton = new JButton("Go back");
		
		loginButton.addActionListener(this);
		resetButton.addActionListener(this);
		backButton.addActionListener(this);
		
		buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 5, 2));
		buttonPanel.add(loginButton);
		buttonPanel.add(resetButton);
		buttonPanel.add(backButton);
		
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
		
		if (e.getSource() == loginButton) {
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
			count--;
			String username = this.usernameInput.getText();
			String password = this.passwordInput.getText();
			if (View.type==1) { 
				// since the type is set to 1, that means that a student is logging in
				if (!Controller.loginStudent(username, password)) {
					if(count!=0) {
						status.setText(count+". Try again.");
					}
					else {
						status.setText("Maximum login attempts reached!");
						JOptionPane.showMessageDialog(View.getFrame(), "Maximum login attempts reached", "ERROR", JOptionPane.ERROR_MESSAGE);
		                loginButton.setEnabled(false);
					}
				}
				else {
					View.switchPanel(this, View.getStudentMenu());
				}
			}
			else if (View.type==2) { 
				// if its 2, then its a professor logging in
				// since the type is set to 1, that means that a student is logging in
				if (!Controller.loginProfessor(username, password)) {
					if(count!=0) {
						status.setText(count+". Try again.");
					}
					else {
						status.setText("Maximum login attempts reached!");
						JOptionPane.showMessageDialog(View.getFrame(), "Maximum login attempts reached", "ERROR", JOptionPane.ERROR_MESSAGE);
		                loginButton.setEnabled(false);
					}
				}
				else {
					View.switchPanel(this, View.getProfessorMenu());
				}
			}
			else {
				// since the type is set to 1, that means that a student is logging in
				if (!Controller.loginAdmin(username, password)) {
					if(count!=0) {
						status.setText(count+". Try again.");
					}
					else {
						status.setText("Maximum login attempts reached!");
						JOptionPane.showMessageDialog(View.getFrame(), "Maximum login attempts reached", "ERROR", JOptionPane.ERROR_MESSAGE);
		                loginButton.setEnabled(false);
					}
				}
				else {
					View.switchPanel(this, View.getAdminMenu());
				}
			}
		}
		else if (e.getSource() == resetButton) {
			usernameInput.setText("");
			passwordInput.setText("");
		}
		else if (e.getSource() == backButton) {
			count=3;
			loginButton.setEnabled(true);
			status.setText("3");
			View.switchPanel(this, View.getUserType());
		}
		
	}

	public int getHeight() {
		return HEIGHT;
	}

	public int getWidth() {
		return WIDTH;
	}

	
}
