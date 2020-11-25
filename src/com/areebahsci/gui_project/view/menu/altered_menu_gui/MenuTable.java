package com.areebahsci.gui_project.view.menu.altered_menu_gui;

import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JScrollPane;
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
		this.setRowHeight(50);
	    centerRenderer= new DefaultTableCellRenderer();
	    centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
		for(int i=0; i < column.length; i++){
	         this.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
		 }		
	}
	
	/* this function is used when we want to add the course table to a panel as a scrollPane
	 * and it also ensures the size of the scrollpane matches that of the table so it allows us to add
	 * the table in a single line of code rather than creating the scrollpane, adjusting its size and
	 * then adding it which is 3 lines, 2 more than what this function allows us to write.
	 * it also ensures we wont forget to set the bounds of the scroll panel */
	public JScrollPane createJScrollPane() {
		JScrollPane scrollPane = new JScrollPane(this);
		Dimension dimension = this.getPreferredSize();
		scrollPane.setPreferredSize(new Dimension(dimension.width,this.getRowHeight()*(this.getRowCount()-1)));
		return scrollPane;
	}

}
