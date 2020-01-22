package com.revature.project0;

import java.util.ArrayList;

public class User {
	private String username;
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
		this.type = type;
	}
	public ArrayList<String> getAccountNumbers() {
		ArrayList<String> out = new ArrayList<String>(accountNumbers.size());  //to prevent untracked modifications
		for(String s: accountNumbers){
			out.add(s);
			}
		return out;
	}
	public void addAccountNumber(String in){
		accountNumbers.add(in);
	}
	public void removeAccountNumber(String in){
		for(String s: accountNumbers){
			if(s.equals(in)){
				accountNumbers.remove(s);
			}
		}
	}
	
	private String password;
	private String fullName;
	private String type;
	private ArrayList<String> accountNumbers;
	User(String data){
		String [] info = data.split(":");
			username = info[0];
			password = info[1];
			fullName = info[2];
			type = info[3];
			if(info.length>4){
				accountNumbers = new ArrayList<String>(info.length-4);
				for(int i = 4; i < info.length;i++){
					accountNumbers.add(info[i]);
				}
			}else {
					accountNumbers = new ArrayList<String>(0);
			}
	}
}


