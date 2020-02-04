package com.revature.bankapp;

import java.util.HashMap;

import com.revature.bankapp.Account;
import com.revature.bankapp.MappingNotFound;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Databases {
	private static Databases database;
	
	public static Databases getDatabases(){
		if(database == null){
			database = new Databases();
		}
		return database;
	}
	
	
	private final String AccountFile = "Accounts.txt";
	public  HashMap<Integer, Account> Accountlist = new HashMap<Integer, Account>();
	private final String UserFile = "Users.txt";
	public HashMap<String, User> Userlist = new HashMap<String, User>();

	// write method
	public void writeFiles() {
		for(User u: Userlist.values()){
			UserPLSQL.getSQL().updateUser(u);
		}
		for(Account a: Accountlist.values()){
			AccountPLSQL.getSQL().updateAccount(a);
		}
	}

	// Read methods
	public void readFiles() {
		for(User u: UserPLSQL.getSQL().findAll()){
			Userlist.put(u.getUsername(), u);
		}

		for(Account a: AccountPLSQL.getSQL().findAll()){
			Accountlist.put(a.getAccountNumber(), a);
		}
	}

	private Databases() {
		readFiles();
	}

	boolean validateAccountModification(User currentUser, Account targetAccount) {// Validates a user has permissions for some action aggaisnt
															// an account
		if (targetAccount.checkUser(currentUser.getUsername()) || SuperUser.class.isInstance(currentUser)) {
			return true;
		}
		return false;
	}

	boolean validateAccountInfoCheck(User currentUser, Account targetAccount) {// Validates a user has permissions for some action aggaisnt
															// an account
		if (targetAccount.checkUser(currentUser.getUsername()) || Employee.class.isInstance(currentUser)) {
			return true;
		}
		return false;
	}

	Account getAccount(Integer targetAccount) throws MappingNotFound {
		if (Accountlist.containsKey(targetAccount)) {
			return Accountlist.get(targetAccount);
		} else {
			System.out.println("\r\nCould not resolve account: " + targetAccount);
			throw new MappingNotFound();
		}
	}

	User getUser(String targetAccount) throws MappingNotFound {
		if (Userlist.containsKey(targetAccount)) {
			return Userlist.get(targetAccount);
		} else {
			System.out.println("\r\nCould not resolve User: " + targetAccount);
			throw new MappingNotFound();
		}
	}

	void transfer(User currentUser, String withdrawFrom, String depositInto, String targetAccount) {
		Double amount = Double.valueOf(targetAccount);
		Account withdraw;
		Account deposit;

		try {
			withdraw = getAccount(Integer.parseInt(withdrawFrom));
		} catch (MappingNotFound e) {
			return;
		}

		try {
			deposit = getAccount(Integer.parseInt(depositInto));
		} catch (MappingNotFound e) {
			return;
		}

		if (!validateAccountModification(currentUser, withdraw) && !validateAccountModification(currentUser, deposit)) {
			System.out.println("\r\nAccess denied");
			return;
		}
		if (amount <= 0) {
			System.out.println("\r\nValue must be positive");
			return;
		}
		if (withdraw.getBalance() < amount) {
			System.out.println("\r\nCharge would result in overdraft");
			return;
		}
		withdraw.withdraw(amount);
		deposit.deposit(amount);
		System.out.println("\r\nSucsesfuly transfered " + targetAccount + " from " + withdrawFrom + " to " + depositInto);
		writeFiles();
	}

	void withdraw(User currentUser, String withdrawFrom, String targetAccount) {
		Double amount = Double.valueOf(targetAccount);
		Account withdraw;
		try {
			withdraw = getAccount(Integer.parseInt(withdrawFrom));
		} catch (MappingNotFound e) {
			return;
		}
		if (!validateAccountModification(currentUser, withdraw)) {
			System.out.println("\r\nAccess denied");
			return;
		}
		if (amount <= 0) {
			System.out.println("\r\nValue must be positive");
			return;
		}
		if (withdraw.getBalance() < amount) {
			System.out.println("\r\nCharge would result in overdraft");
			return;
		}
		withdraw.withdraw(amount);
		System.out.println("\r\nSucsesfuly made a withdrawal of " + targetAccount + " from " + withdrawFrom);
		writeFiles();
	}

	void deposit(User currentUser, String depositInto, String targetAccount) {
		Double amount = Double.valueOf(targetAccount);
		Account deposit;
		try {
			deposit = getAccount(Integer.parseInt(depositInto));
		} catch (MappingNotFound e) {
			return;
		}
		if (!validateAccountModification(currentUser, deposit)) {
			System.out.println("\r\nAccess denied");
			return;
		}
		if (amount <= 0) {
			System.out.println("\r\nValue must be positive");
			return;
		}
		deposit.deposit(amount);
		System.out.println("\r\nSucsesfuly made a deposit of " + targetAccount + " from " + depositInto);
		writeFiles();
	}

	boolean makeClient(String username, String password, String fullName) {
		if (!Userlist.containsKey(username)) {
			Userlist.put(username, new Client(username, password, fullName));
			writeFiles();
			System.out.println("\r\nClient profile created successfully");
			return true;
		}
		System.out.println("\r\nUsername alredy exists.");
		return false;
	}

	boolean makeEmployee(String username, String password, String fullName) {// should be exposed only to superusers
		if (!Userlist.containsKey(username)) {
			Userlist.put(username, new Employee(username, password, fullName));
			writeFiles();
			System.out.println("\r\nEmployee profile created sucsesfuly");
			writeFiles();
			return true;
		}
		System.out.println("\r\nUsername alredy exists.");
		return false;
	}

	boolean makeSU(String username, String password, String fullName) {// should be exposed only to superusers
		if (!Userlist.containsKey(username)) {
			Userlist.put(username, new SuperUser(username, password, fullName));
			System.out.println("\r\nAdministrator profile created successfully");
			writeFiles();
			return true;
		}
		System.out.println("\r\nUsername already exists.");
		return false;
	}

	boolean addUserToAccount(User currentUser, String toadd, String targetAccount) {
		User usertoAdd;
		Account account;
		try {
			usertoAdd = getUser(toadd);
			account = getAccount(Integer.parseInt(targetAccount));
		} catch (MappingNotFound e) {
			return false;
		}

		if (usertoAdd.getClass().isInstance(Employee.class)) {
			System.out.println("\r\nEmployee profies are not permitted on accounts");
			return false;
		}
		if (!validateAccountModification(currentUser, account)) {
			System.out.println("\r\nAccess denied");
			return false;
		}
		account.addUser(toadd);
		System.out.println("Added " + toadd + " to " + targetAccount);
		writeFiles();
		return true;
	}

	boolean removeUserFromAccount(User currentUser, String toRemove, String targetAccount) { // expose only to super
		Account account;
		try {
			account = getAccount(Integer.parseInt(targetAccount));
		} catch (MappingNotFound e) {
			return false;
		}
		boolean out = account.removeUser(toRemove);
		writeFiles();
		return out;
	}
	
	void printAccountInfo(String targetAccount, User currentUser) {
		System.out.println();
		Account toPrint;
		try {
			toPrint = getAccount(Integer.parseInt(targetAccount));
		} catch (MappingNotFound e) {
			System.out.println("Account not found");
			return;
		}
		if (validateAccountInfoCheck(currentUser, toPrint)) {
			System.out.println(toPrint.toString());
		}
	}

	void printAccounts() {// should only be exposed to employees
			System.out.println();
			for (Account targetAccount : Accountlist.values()) {
				System.out.println(targetAccount.toString());
			}
		
	}
	void printUsers() {// should only be exposed to employees
		System.out.println();
		for (User targetUser : Userlist.values()) {
			System.out.println(targetUser.toString());
		}
	}
	void printAccountsForTarget(User currentUser, String targetUser) {
		if (!Userlist.containsKey(targetUser)) {
			if (Employee.class.isInstance(currentUser)) {
				System.out.println();
				for (Account targetAccount : Accountlist.values()) {
					if(targetAccount.checkUser(targetUser)&&(currentUser.getUsername()==targetUser||Employee.class.isInstance(currentUser))){
						System.out.println(targetAccount.toString());
					}
				}
			}
		}
	}

	boolean checkLoggin(String currentUser, String password) {
		User userLoggingIn;
		try {
			userLoggingIn = getUser(currentUser);
		} catch (MappingNotFound e) {
			return false;
		}
		if (password.equals(userLoggingIn.getPassword())) {
			return true;
		}
		return false;
	}
	boolean makeAccount(double openingbalance, int accountnumber, String username) {
		if (!Accountlist.containsKey(accountnumber)) {
			Accountlist.put(accountnumber, new Account(openingbalance, accountnumber, username));
			System.out.println("\r\nAccount created successfully");
			return true;
		}
		System.out.println("\r\nAccount alredy exists.");
		return false;
	}
}
