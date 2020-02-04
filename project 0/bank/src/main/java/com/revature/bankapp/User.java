package com.revature.bankapp;

import java.io.Serializable;

abstract public class User implements Serializable {

	/**
	 * V 1.0.0
	 */
	private static final long serialVersionUID = 6085027198494302988L;
	private String username;
	private String password;
	private String fullName;
	private int userID;

	User(String username, String password, String fullName) {// for truly new users strips user input
		this.username = username;
		this.password = password;
		this.fullName = fullName;
		userID = -1;
	}
	
	User(String username, String password, String fullName, int userid) {// for truly new users strips user input
		this.username = username;
		this.password = password;
		this.fullName = fullName;
		this.userID = userid;
	}

	public String getUsername() {
		return username;
	}
	
	public void setUserID(int id){
		userID = id;
	}
	
	public int getUserID(){
		return userID;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}


	public String toString() {
		return  "User:" + username + ':' + fullName;
	}
	public String getType() {
		return "user";
	}
}
