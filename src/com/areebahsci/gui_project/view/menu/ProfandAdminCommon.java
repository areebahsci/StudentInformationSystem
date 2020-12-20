package com.areebahsci.gui_project.view.menu;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.areebahsci.gui_project.view.menu.altered_menu_gui.InnerPanel;
import com.areebahsci.gui_project.view.menu.altered_menu_gui.MenuLabel;

public class ProfandAdminCommon extends Menu {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	protected JMenuItem changePassword, changeUsername;
	protected InnerPanel changePasswordPanel, changeUsernamePanel, passwordInputPanel, usernameInputPanel;
	protected MenuLabel changePasswordLabel, changeUsernameLabel;
	protected JTextField changeUsernameInput;
	protected JPasswordField changePasswordInput;
	protected JButton changeButton_u, returnButton_u, viewPassword, changeButton_p, returnButton_p, generateRandomPass;
	protected JPanel usernameButtonPanel, passwordButtonPanel;
	
	public ProfandAdminCommon(){
		
		changeButton_u = new JButton("Submit");
		returnButton_u = new JButton("Go back");
		changeButton_p = new JButton("Submit");
		returnButton_p = new JButton("Go back");
		generateRandomPass = new JButton("Generate a random password");
		
		// CHANGE USERNAME PANEL
		changeUsernamePanel = new InnerPanel();
		changeUsername = new JMenuItem("Change your username");
		
		usernameInputPanel = new InnerPanel();
		changeUsernameInput = new JTextField(16);
		changeUsernameInput.setPreferredSize(new Dimension(90, 40));
		changeUsernameLabel = new MenuLabel("Enter your new username: ");
		usernameInputPanel.add(changeUsernameLabel, BorderLayout.WEST);
		usernameInputPanel.add(changeUsernameInput, BorderLayout.CENTER);
		
		usernameButtonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 5, 3));
		usernameButtonPanel.add(returnButton_u);
		usernameButtonPanel.add(changeButton_u);
		
		changeUsernamePanel.add(usernameInputPanel, BorderLayout.NORTH);
		changeUsernamePanel.add(usernameButtonPanel, BorderLayout.CENTER);
		
		// CHANGE PASSWORD PANEL
		changePasswordPanel = new InnerPanel();
		changePassword = new JMenuItem("Change your password");
		
		passwordInputPanel = new InnerPanel();
		changePasswordInput = new JPasswordField(16);
		changePasswordInput.setPreferredSize(new Dimension(90, 40));
		changePasswordLabel = new MenuLabel("Enter your new password: ");
		passwordInputPanel.add(changePasswordLabel, BorderLayout.WEST);
		passwordInputPanel.add(changePasswordInput, BorderLayout.CENTER);
		
		viewPassword = new JButton("Show password");
		passwordButtonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 5, 3));
		passwordButtonPanel.add(returnButton_p);
		passwordButtonPanel.add(generateRandomPass);
		passwordButtonPanel.add(changeButton_p);
		passwordButtonPanel.add(viewPassword);
		
		changePasswordPanel.add(passwordInputPanel, BorderLayout.NORTH);
		changePasswordPanel.add(passwordButtonPanel, BorderLayout.CENTER);
	}
	
	protected void addActionListenerMore () {
		changeUsername.addActionListener(this);
		changePassword.addActionListener(this);
		changeButton_u.addActionListener(this);
		returnButton_u.addActionListener(this);
		changeButton_p.addActionListener(this);
		returnButton_p.addActionListener(this);
		viewPassword.addActionListener(this);
		generateRandomPass.addActionListener(this);
	}
	
	protected void actionPerformedUsernamePassword(ActionEvent e) {
		if (e.getSource()==changePassword) {
			
			changeMainPanel(changePasswordPanel);
		}
		
		else if (e.getSource()==changeUsername) {
			
			changeMainPanel(changeUsernamePanel);
		}
		
		else if (e.getSource()==changeUsername) {
			
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
		// TODO Auto-generated method stub
		
	}
	@Override
	protected void createCoursePanel() {
		// TODO Auto-generated method stub
		
	}
	@Override
	protected void createAllInfoPanel() {
		// TODO Auto-generated method stub
		
	} 
	
	
}
