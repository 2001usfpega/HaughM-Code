package bankapp;

import java.io.Serializable;
import java.util.ArrayList;

public class User implements Serializable{

	/**
	 * V 1.0.0
	 */
	private static final long serialVersionUID = 6085027198494302988L;
	private String username;
	private String password;
	private String fullName;
	private String type;
	User(String data){  //for database loads
			String [] info = data.split(":");
			username = info[0];
			password = info[1];
			fullName = info[2];
			type = info[3];
	}
	User(String username,  String password, String fullName, String type){// for truly new users strips user input
		this.username = username.replace(':', ',');  
		this.password = password.replace(':', ',');
		this.fullName = fullName.replace(':', ',');
		this.type = type;
	}
	public String getUsername() {
		return username;
	}
	/*
	public boolean setUsername(String username) {
		if(!database.hasUser(username)){
			database.remap(this.username, this, username)
			this.username = username;
		}
	}
	*/
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
	public String getType() {
		return type;
	}
	public void setType(String type) { 
		//if(type=user||employee||superuser)
		this.type = type;
	}
	public String toString(){
		return username +':'+ password+':'+fullName+':'+type;
	}
}


