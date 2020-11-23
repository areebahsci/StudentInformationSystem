package com.areebahsci.gui_project.model.user;

public abstract class User {
	
	// every user will have a name, username, password and ID
	protected String name;
	protected String username;
	protected String password;
	protected String ID;
	
	// constructor 
	public User(String ID, String name, String username, String password) {
		this.name=name;
		this.username=username;
		this.password=password;
		this.ID=ID;
	}
	
	/* used to print data for validation purposes to ensure the methods are functioning the way they are
	 * supposed to be */
	public abstract void printData();
	
	// GENERIC GETTERS AND SETTERS

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getID() {
		return ID;
	}

	public void setID(String iD) {
		ID = iD;
	}
	
}
