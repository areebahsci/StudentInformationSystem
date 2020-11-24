package com.areebahsci.gui_project.view.menu.altered_menu_gui;

import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public class MenuTable extends JTable {
	
	/* I created this class so that whenever we have to create a table, which will be quite a few times
	 * across the menu gui classes, we can just write one peice of code which is the MenuTable 
	 * constructor rather than 5 more lines each time. This ensures I dont forget to center or set
	 * row height or make a DefaultTableCellRenderer object to center my data in the table. */

	private static final long serialVersionUID = 1L;
	
	DefaultTableCellRenderer centerRenderer;
	
	public MenuTable(String[][]data, String[]column) {
		
		super(data, column);
	    this.setRowHeight(0, 50);
	    centerRenderer= new DefaultTableCellRenderer();
	    centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
		 for(int i=0; i < 3; i++){
	         this.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
		 }		
	}

}
