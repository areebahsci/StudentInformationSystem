package com.areebahsci.gui_project.view.menu.altered_menu_gui;

import java.awt.BorderLayout;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.border.Border;

public class InnerPanel extends JPanel {
	
	/* i created this class because all my inner panels, which are the panels that will exist in the
	 * main panel, are constucted the same way and have the same border so as to not constantly repeat
	 * the two lines of code in 4 menu java files, this will substitute as a single line of code
	 * where i basically constuct InnerPanel objects
	 * This also ensures i dont forget to set the border or layout whenever creating a new panel */
	
	protected BorderLayout innerPanelLayout;
	protected Border border;
	
	private static final long serialVersionUID = 1L;

	public InnerPanel() {
		
		innerPanelLayout = new BorderLayout();
		innerPanelLayout.setVgap(15);
		
		border = BorderFactory.createEmptyBorder(5,0,0,0);
		
		this.setLayout(innerPanelLayout);
		this.setBorder(border);
	}
}
