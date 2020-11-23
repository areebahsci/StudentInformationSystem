package com.areebahsci.gui_project.model.user;

// administrator is a user 
public class Administrator extends User {

	// constructor 
	public Administrator(String ID, String name, String username, String password) {
		super(ID, name, username, password);
	}

	/* used to print data for validation purposes to ensure the methods are functioning the way they are
	 * supposed to be */
	@Override
	public void printData() {
		
	}

}
