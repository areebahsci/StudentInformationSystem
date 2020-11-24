package com.areebahsci.gui_project.view.menu.altered_menu_gui;

import java.awt.Font;

import javax.swing.JLabel;

public class MenuLabel extends JLabel {

	private static final long serialVersionUID = 1L;
	
	/* i created this altered label so i would only have to write one line of code rather than three when
	 * creating my labels since they are all made the same in the menu guis, with the same font and 
	 * alignement and method of construction. this ensures i dont forget aligning or setting the 
	 * font and having to change it and keep checking */
	
	protected Font labelFont;
	
	public MenuLabel(String text) {
		labelFont = new Font("", Font.BOLD, 15);
		this.setText(text);
		this.setHorizontalAlignment(JLabel.CENTER);
		this.setFont(labelFont);
	}

}
