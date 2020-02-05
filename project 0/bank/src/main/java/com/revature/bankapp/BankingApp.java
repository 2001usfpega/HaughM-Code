package com.revature.bankapp;

import java.util.Scanner;

public class BankingApp {
	// UserObject currentUser;
	// DatabasesObject databases
	//live databases in memory
//:P:
	public static double balance;
	public static double savings;
	public static double withdraw;
	public static double deposit;
	public static double tempDou;
	 public static String userName;
	 public static String passWord;
	 public static String realName;

	public static void main(String[] args) {

		Databases dataBase = Databases.getDatabases();
		 Scanner bankScan = new Scanner(System.in);
		 User currentUser = null;

		 String userInput;
		 boolean quit = false;
		 dataBase.readFiles();

		 do {
		System.out.println("Welcome to Bank!");
		System.out.println("Are you a returning user?");
		System.out.println(" Yes or No ");
		userInput = bankScan.next();

		//Start of Do
		
		
			if(userInput.equals("Yes") || userInput.equals("yes") || userInput.equals("y")) {
				System.out.println("Welcome back! How are you signing in today?");
				System.out.println("\n1.User" + "\n2.Employee" + "\n3.Admin");
				//userChoice = bankScan.nextInt();
				userInput = bankScan.next();
				//Client Enters
				if(userInput.equals("User") || userInput.equals("user") || userInput.equals("1") || userInput.equals("1.")) {
					System.out.println("Hello User, let's get you signed in.");
					//String userName;
					//String passWord;
					//String fullName;
					System.out.println("Username:");
					userName = bankScan.next();
					System.out.println("Password:");
					passWord = bankScan.next();

					if(dataBase.checkLoggin(userName, passWord)) {
						try {
							currentUser = dataBase.getUser(userName);
						} catch (MappingNotFound e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						usersIO(currentUser, bankScan);
						
					}else {
						System.out.println("I'm sorry, the username/password is incorrect.");
					}



				}//Employee start
				else if(userInput.equals("Employee") || userInput.equals("employee") || userInput.equals("2") || userInput.equals("2.")) {
					System.out.println("Hello Employee, let's get you signed in.");
					//String userName;
					//String passWord;
					//String fullName;
					System.out.println("Username:");
					userName = bankScan.next();
					System.out.println("Password:");
					passWord = bankScan.next();

					if(dataBase.checkLoggin(userName, passWord) == true) {
						try {
							currentUser = dataBase.getUser(userName);
						} catch (MappingNotFound e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						System.out.println("Hello there, " + userName + ". How can I help you today?");
						
						employeesAccountLookups(currentUser, bankScan);

				}else {
					System.out.println("I'm sorry, the username/password is incorrect.");
				}
			} else if(userInput.equals("Admin") || userInput.equals("admin") || userInput.equals("3") || userInput.equals("3.")) {
				System.out.println("Hello Admin, let's get you signed in.");
				//String userName;
				//String passWord;
				//String fullName;
				System.out.println("Username:");
				userName = bankScan.next();
				System.out.println("Password:");
				passWord = bankScan.next();

				if(dataBase.checkLoggin(userName, passWord) == true) {
					try {
						currentUser = dataBase.getUser(userName);
					} catch (MappingNotFound e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					System.out.println("Hello there, " + userName + ". How can I help you today?");
						adminActions(currentUser, bankScan);
					}

			}else {
				System.out.println("I'm sorry, the username/password is incorrect.");
			}



			} else if(userInput.equals("No") || userInput.equals("no") || userInput.equals("n")) {
				System.out.println("Welcome new user! Would you like to setup a account?");
				System.out.println("Yes or No");
				userInput = bankScan.next();
				if(userInput.equals("Yes") || userInput.equals("yes") || userInput.equals("y")) {
					System.out.println("Wonderful! Let's begin.");
					System.out.println("What is your name?");
					//Hates spaces for some reason (Amanda look into it when there's more time
					realName = bankScan.next();
					System.out.println("And what username would you like?");

					userName = bankScan.next();
					System.out.println("");
					System.out.println("What password will you use?");
					passWord = bankScan.next();
					//Needs to check to see if Admin or Employee approves
					dataBase.makeClient(userName, passWord, realName);
					System.out.println("Perfect! A account has been made for you.");
				}
				else {
					System.out.println("Alright, thanks for visiting!");
					quit = true;

				}
			}else {
				System.out.println("Wrong Input, Try again.");
				userInput = bankScan.next();

		}




		/*
		 * do { System.out.println("1. deposit money"); System.out.
		 * print("Input a number through 1 - 4 to select a menu. Input 0 to exit.");
		 * userChoice = bankScan.nextInt(); if(userChoice == 0) quit = true;
		 *
		 *
		 * } while (!quit); System.out.println("Have a good day!");
		 */

		 //bankScan.close();

	// Sysout "NAME"
	// Scanner.nextinput
	// Sysout "
	// Password"
	// scanner.nextinput
	// Input Options
	// If statements;
	// WriteFIle
	// Method
	//
	
	}while (!quit);
	bankScan.close();	
	}
//atomization
	private static void accountActionsMenue(User currentUser, Scanner bankScan) {
		System.out.println("Please Select: \n1.Withdraw\n2.Transfer\3.Deposit");
		String choice = bankScan.next().toLowerCase();
		System.out.println();
		switch(choice){
		case "1.":
		case "1":
		case "withdraw":
		case "1.withdraw":
			withdrawIO(currentUser, bankScan);
			break;
		case "2.":
		case "2":
		case "transfer":
		case "2.transfer":
			transferIO(currentUser, bankScan);
			break;
		case "3.":
		case "3":
		case "deposit":
		case "3.deposit":
			depositIO(currentUser, bankScan);
			break;
		default:
		}
	}
	private static void usersIO(User currentUser, Scanner bankScan) {
		System.out.println("Please Select: \n1.tansact\n2.lookup");
		String choice = bankScan.next().toLowerCase();
		System.out.println();
		switch(choice){
		case "1.":
		case "1":
		case "tansact":
		case "1.tansact":
			accountActionsMenue(currentUser, bankScan);
			break;
		case "2.":
		case "2":
		case "lookup":
		case "2.lookup":
			usersAccountLookups(currentUser, bankScan);
			break;
		default:
		}
	}
	private static void usersAccountLookups(User currentUser, Scanner bankScan) {
		System.out.println("Please Select: \n1.Single\n2.All");
		String choice = bankScan.next().toLowerCase();
		System.out.println();
		switch(choice){
		case "1.":
		case "1":
		case "single":
		case "1.single":
			printAccountInfoIO(currentUser, bankScan);
			break;
		case "2.":
		case "2":
		case "all":
		case "2.all":
			printAccountsForUserIO(currentUser, bankScan);
			break;
		default:
		}
	}
	private static void employeesAccountLookups(User currentUser, Scanner bankScan) {
		System.out.println("Please Select: \n1.Number\n2.User\n3.All");
		String choice = bankScan.next().toLowerCase(); //makes exact matches easier
		System.out.println();
		switch(choice){
		case "1.":
		case "1":
		case "number":
		case "1.number":
			printAccountInfoIO(currentUser, bankScan);
			break;
		case "2.":
		case "2":
		case "user":
		case "2.user":
			printAccountsForUserIO(currentUser, bankScan);
			break;
		case "3.":
		case "3":
		case "3.all":
		case "all":
			printAllAccountsIO();
			break;
		}
	}
	
	private static void adminActions(User currentUser, Scanner bankScan){
		System.out.println("Please Select: \n1.Info\n2.New\n3.alter");
		String choice = bankScan.next().toLowerCase(); //makes exact matches easier
		System.out.println();
		switch(choice){
		case "1.":
		case "1":
		case "info":
		case "1.info":
			employeesAccountLookups(currentUser, bankScan);
			break;
		case "2.":
		case "2":
		case "new":
		case "2.new":
			make(currentUser, bankScan);
			break;
		case "3.":
		case "3":
		case "3.transactions":
		case "transactions":
			alter(currentUser, bankScan);
			break;
		}
	}

	private static void alter(User currentUser, Scanner bankScan){
		System.out.println("Please Select: \n1.user\n2.account");
		String choice = bankScan.next().toLowerCase(); //makes exact matches easier
		System.out.println();
		switch(choice){
		case "1.":
		case "1":
		case "user":
		case "1.user":
			alterUser(currentUser, bankScan);
			break;
		case "2.":
		case "2":
		case "account":
		case "2.account":
			 alterAccount(currentUser, bankScan);
			break;
			}
		}
	private static void alterAccount(User currentUser, Scanner bankScan){
		System.out.println("Please Select: \n1.add\2.remove\n3.transact");
		String choice = bankScan.next().toLowerCase(); //makes exact matches easier
		System.out.println();
		switch(choice){
		case "1.":
		case "1":
		case "user":
		case "1.user":
			addUsertoAccountIO(currentUser, bankScan);
			break;
		case "2.":
		case "2":
		case "remove":
		case "2.remove":
			 removeUserFromAccountIO(currentUser, bankScan);
			break;
		case "3.":
		case "3":
		case "transact":
		case "3.transact":
			accountActionsMenue(currentUser, bankScan);
			break;
			}
		}
	private static void alterUser(User currentUser, Scanner bankScan){
		System.out.println("please type the username");
		String targetUser = bankScan.next();
		User trgt;
		try {
			trgt = Databases.getDatabases().getUser(targetUser);
		} catch (MappingNotFound e) {
			return;
		}
		System.out.println("please choose username, password, fullname");
		String swch= bankScan.next();
		System.out.println("please type the value");
		String set = bankScan.next();
		switch(swch.toLowerCase()){
		case "username":
			trgt.setUsername(set);
			break;
		case "password":
			trgt.setPassword(set);
			break;
		case "fullname":
			trgt.setFullName(set);
			break;
		}
		Databases.getDatabases().writeFiles();
	}
	
	private static void make(User currentUser, Scanner bankScan){
		System.out.println("Please Select: \n1.user\n2.account");
		String choice = bankScan.next().toLowerCase(); //makes exact matches easier
		System.out.println();
		switch(choice){
		case "1.":
		case "1":
		case "user":
		case "1.user":
			makeUser(currentUser, bankScan);
			break;
		case "2.":
		case "2":
		case "account":
		case "2.account":
			makeAccountIO(currentUser, bankScan);
			break;
		}
	}
	
	
	private static void addUsertoAccountIO(User currentUser, Scanner bankScan){
		System.out.println("please type the user to add");
		String toadd = bankScan.next();
		System.out.println("\n Please type target account:");
		String acctgt = bankScan.next();
		Databases.getDatabases().addUserToAccount(currentUser, toadd, acctgt);
	}
	
	private static void depositIO(User currentUser, Scanner bankScan){//reuses the scanner to minimize initialization lag
		System.out.println("Please type the account number");
		String accnumber = bankScan.next();  //account number as a string
		System.out.println("\nPlease type amount"); 
		String amount= bankScan.next();
		System.out.println();
		Databases.getDatabases().deposit(currentUser, accnumber, amount);  //no need to store a database reference in the local scope
	}
	private static void makeAccountIO(User currentUser, Scanner bankScan){
		System.out.println("\n Please type user:");
		String accountOwner = bankScan.next();
		System.out.println("\n Please type opening balence:");
		Double amount= bankScan.nextDouble();
		System.out.println(Databases.getDatabases().makeAccount(amount, accountOwner));
	}
	private static void makeUser(User currentUser, Scanner bankScan){
		System.out.println("Please type the Username.");
		String uName = bankScan.next();
		System.out.println("\n Please type the user password:");
		String pWord = bankScan.next();
		System.out.println("\n Please users full name:");
		String fName= bankScan.next();
		System.out.println("\n Please input user type as Admin, Employee, or Client");
		String swtch = bankScan.next();
		swtch = bankScan.next();
		switch(swtch){
		case "Admin":
		case "admin":
			Databases.getDatabases().makeSU(uName, pWord, fName);
			break;
		case "Employee":
		case "employee":
			Databases.getDatabases().makeEmployee(uName, pWord, fName);
			break;
		case "client":
		case "Client":
			Databases.getDatabases().makeClient(uName, pWord, fName);
			break;
		}
	}
	private static void printAccountInfoIO(User currentUser, Scanner bankScan){
		System.out.println("Please type the account number to check:");
		String accnumber = bankScan.next();
		System.out.println();
		Databases.getDatabases().printAccountInfo(accnumber, currentUser);
	}
	private static void printAllAccountsIO(){
		Databases.getDatabases().printAccounts();
	}
	private static void printAccountsForUserIO(User currentUser, Scanner bankScan){
		String uNameToCheck = currentUser.getUsername();
		if(Employee.class.isInstance(currentUser)){
			System.out.println("Please type the username to check:");
			uNameToCheck = bankScan.next();
		}
		Databases.getDatabases().printAccountsForTarget(currentUser, uNameToCheck);
	}
	private static void removeUserFromAccountIO(User currentUser, Scanner bankScan){//also removes orphan accounts if balence is zero
		System.out.println("Removes a user from an account, to remove"+
							"\nthe last user the account balence must be zero."+
							"\nAccounts with no users close automaticly."+
							"\nPlease type the account number:");
		String accnumber = bankScan.next();
		System.out.println("\n Please type the name of the user to remove:");
		String targetUser = bankScan.next();
		System.out.println();
		Databases.getDatabases().removeUserFromAccount(currentUser, targetUser, accnumber);
	}
	
	private static void transferIO(User currentUser, Scanner bankScan) {
		System.out.println("Please type the account number to withdraw from:");
		String accnumber = bankScan.next();
		System.out.println("\n Please type target account:");
		String acctgt = bankScan.next();
		System.out.println("\n Please type amount:");
		String amount= bankScan.next();
		System.out.println();
		Databases.getDatabases().transfer(currentUser, accnumber, acctgt, amount);
	}
	
	private static void withdrawIO(User currentUser, Scanner bankScan){//reuses the scanner to minimize initialization lag
		System.out.println("Please type the account number and amount");
		String accnumber = bankScan.next();
		System.out.println();
		String amount= bankScan.next();
		System.out.println();
		Databases.getDatabases().withdraw(currentUser, accnumber, amount);  //no need to store a database reference in the local scope
	}
	
}
