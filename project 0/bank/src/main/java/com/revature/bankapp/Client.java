package com.revature.bankapp;

public class Client extends User {

	/**
	 *
	 */
	private static final long serialVersionUID = 4107273125997056355L;

	Client(String username, String password, String fullName) {
		super(username, password, fullName);
	}
	
	Client(String username, String password, String fullName, int id) {
		super(username, password, fullName, id);
	}
	public String toString() {
		return  "Client:" + getUsername() + ':' + getFullName();
	}
	public String getType() {
		return "customer";
	}
}
