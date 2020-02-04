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
		 boolean whileStop = false;
		 dataBase.readFiles();


		System.out.println("Welcome to Rob-U Bank!");
		System.out.println("Are you a returning user?");
		System.out.println(" Yes or No ");
		userInput = bankScan.next();

		//Start of Do
		do {
		while (!whileStop) {
			if(userInput.equals("Yes") || userInput.equals("yes") || userInput.equals("y")) {
				System.out.println("Welcome back! How are you signing in today?");
				whileStop = true;
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
						System.out.println("Hello there, " + userName + ". How can I help you today?");
						System.out.println("1. Balance" + "\n2. Withdraw" + "\n3. deposit" + "\n4. Transfer" + "\n5. Add another user for joint account" + "\nInput 0 to exit.");
						dataBase.printAccounts();
						userInput = bankScan.next();
						balance = 500.45;
						savings = 1375.89;


						boolean oneStep = true;
						boolean userMenu = false;
						while(!userMenu) {
							if(!oneStep) {
								System.out.println("1. Balance" + "\n2. Withdraw" + "\n3. deposit" + "\n4. Transfer" + "\n5. Add another user for joint account" + "\nInput 0 to exit.");
								userInput = bankScan.next();
							}

							switch(userInput) {

							case "1":
							case "1.":
							case "Balance":
							case "balance":
								System.out.println("You have $" + balance + " in your checking." + "\nYou have $" + savings + " in your savings.");
								System.out.println("Would you like to continue?" + "\nYes or No");
								userInput = bankScan.next();
								if(userInput.equals("Yes") || userInput.equals("yes") || userInput.equals("y")) {
									userMenu = false;
									oneStep = false;
								}
								else if (userInput.equals("No") || userInput.equals("no") || userInput.equals("n")) {
									System.out.println("Have a good day!");
									userMenu = true;
									quit = true;
								}

								break;
							case "2":
							case "2.":
							case "Withdraw":
							case "withdraw":
								System.out.println("You currently have $" + balance + " in your checking.");
								System.out.println("How much would you like to withdraw?");
								withdraw = bankScan.nextDouble();

								if(withdraw <= 700.00) {
									System.out.println("You now have $" + (balance - withdraw));
								} else if(withdraw > 700.00) {
									System.out.println("You do not have enough to withdraw.");

								}
								System.out.println("Would you like to continue?" + "\nYes or No");
								userInput = bankScan.next();
								if(userInput.equals("Yes") || userInput.equals("yes") || userInput.equals("y")) {
									userMenu = false;
									oneStep = false;
								}
								else if (userInput.equals("No") || userInput.equals("no") || userInput.equals("n")) {
									System.out.println("Have a good day!");
									userMenu = true;
									quit = true;
								}
								//dataBase.withdraw(user, ihatemylife, Lol);
								//userMenu = true;
								break;
							case "3":
							case "3.":
							case "deposit":
							case "Deposit":
								System.out.println("You currently have $" + balance + " in your checking.");
								System.out.println("How much would you like to deposit?");
								deposit = bankScan.nextDouble();

								System.out.println("You have deposited $" + deposit + "into your account." + "\nYou now have $" + (deposit + balance));
								System.out.println("Would you like to continue?" + "\nYes or No");
								userInput = bankScan.next();
								if(userInput.equals("Yes") || userInput.equals("yes") || userInput.equals("y")) {
									userMenu = false;
									oneStep = false;
								}
								else if (userInput.equals("No") || userInput.equals("no") || userInput.equals("n")) {
									System.out.println("Have a good day!");
									userMenu = true;
									quit = true;
								}
								break;
							case "4":
							case "4.":
							case "Transfer":
							case "transfer":
								System.out.println("You have $" + balance + " in your checking." + "\nYou have $" + savings + " in your savings.");
								System.out.println("Would you like to transfer to Savings or Checking?");
								userInput = bankScan.next();
								if(userInput.equals("Checking") || userInput.equals("checking")) {
									System.out.println("How much would you like to transfer from savings?");
									tempDou = bankScan.nextDouble();
									if(tempDou <= savings) {
										System.out.println("You have transfered $" + tempDou + " from savings." + "\nYou now have $" + (savings - tempDou) + " in savings.");
										System.out.println("You now have $" + (balance + tempDou) + " in your checking.");
									}else {
										System.out.println("You do not have enough in savings for this transfer.");
									}


								} else if(userInput.equals("Savings") || userInput.equals("savings")) {
									System.out.println("How much would you like to transfer from checking?");
									tempDou = bankScan.nextDouble();
									if(tempDou <= balance) {
										System.out.println("You have transfered $" + tempDou + " from checking." + "\nYou now have $" + (balance - tempDou) + " in checking.");
										System.out.println("You now have $" + (savings + tempDou) + " in your savings.");
									}else {
										System.out.println("You do not have enough in checking for this transfer.");
									}

								}
								System.out.println("Would you like to continue?" + "\nYes or No");
								userInput = bankScan.next();
								if(userInput.equals("Yes") || userInput.equals("yes") || userInput.equals("y")) {
									userMenu = false;
									oneStep = false;
								}
								else if (userInput.equals("No") || userInput.equals("no") || userInput.equals("n")) {
									System.out.println("Have a good day!");
									userMenu = true;
									quit = true;
								}
								break;
							case "5":
							case "5.":
							case "Add":
							case "add":
								//Would Add even work without account?
								System.out.println("Would you like to continue?" + "\nYes or No");
								userInput = bankScan.next();
								if(userInput.equals("Yes") || userInput.equals("yes") || userInput.equals("y")) {
									userMenu = false;
									oneStep = false;
								}
								else if (userInput.equals("No") || userInput.equals("no") || userInput.equals("n")) {
									System.out.println("Have a good day!");
									userMenu = true;
									quit = true;
								}
								break;
							case "0":

				                quit = true;
				                System.out.println("Goodbye!");
				                System.exit(0);
								break;
							default:
								System.out.println("I'm sorry, that is not a valid input. Please try again.");


						}




						}

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
						System.out.println("Hello there, " + userName + ". How can I help you today?");
						System.out.println("1. Account" + "\n2. Balances" + "\n3. Personal" +  "\nInput 0 to exit.");
						dataBase.printAccounts();
						userInput = bankScan.next();
						boolean oneStep = true;
						boolean userMenu = false;
						while(!userMenu) {
							if(!oneStep) {
								System.out.println("1. Account" + "\n2. Balances" + "\n3. Personal" +  "\nInput 0 to exit.");
								userInput = bankScan.next();
							}
							switch(userInput) {
							case "1":
							case "1.":
							case "Account":
							case "account":
								System.out.println("This is where the accounts will go for Employee");
								System.out.println("Would you like to continue?" + "\nYes or No");
								userInput = bankScan.next();
								if(userInput.equals("Yes") || userInput.equals("yes") || userInput.equals("y")) {
									userMenu = false;
									oneStep = false;
								}
								else if (userInput.equals("No") || userInput.equals("no") || userInput.equals("n")) {
									System.out.println("Have a good day!");
									userMenu = true;
									quit = true;
									System.exit(0);
								}
								break;
							case "2":
							case "2.":
							case "Balances":
							case "balances":
							case "balance":
							case "Balance":
								System.out.println("This is where the Balances go.");
								System.out.println("Would you like to continue?" + "\nYes or No");
								userInput = bankScan.next();
								if(userInput.equals("Yes") || userInput.equals("yes") || userInput.equals("y")) {
									userMenu = false;
									oneStep = false;
								}
								else if (userInput.equals("No") || userInput.equals("no") || userInput.equals("n")) {
									System.out.println("Have a good day!");
									userMenu = true;
									quit = true;
									System.exit(0);
								}
								break;
							case "3":
							case "3.":
							case "Personal":
							case "personal":
								System.out.println("This is where the Personal go.");
								System.out.println("Would you like to continue?" + "\nYes or No");
								userInput = bankScan.next();
								if(userInput.equals("Yes") || userInput.equals("yes") || userInput.equals("y")) {
									userMenu = false;
									oneStep = false;
								}
								else if (userInput.equals("No") || userInput.equals("no") || userInput.equals("n")) {
									System.out.println("Have a good day!");
									userMenu = true;
									quit = true;
									System.exit(0);
								}
								break;
							case "0":

				                quit = true;
				                System.out.println("Goodbye!");
				                System.exit(0);
								break;
							default:
								System.out.println("I'm sorry, that is not a valid input. Please try again.");


							}
						}

				}else {
					System.out.println("I'm sorry, the username/password is incorrect.");
				}
			} else if(userInput.equals("Admin") || userInput.equals("Admin") || userInput.equals("3") || userInput.equals("3.")) {
				System.out.println("Hello Admin, let's get you signed in.");
				//String userName;
				//String passWord;
				//String fullName;
				System.out.println("Username:");
				userName = bankScan.next();
				System.out.println("Password:");
				passWord = bankScan.next();

				if(dataBase.checkLoggin(userName, passWord) == true) {
					System.out.println("Hello there, " + userName + ". How can I help you today?");
					System.out.println("1. Approve" + "\n2. Functions" + "\n3. Canceling" +  "\nInput 0 to exit.");
					dataBase.printAccounts();
					userInput = bankScan.next();
					boolean oneStep = true;
					boolean userMenu = false;
					while(!userMenu) {
						if(!oneStep) {
							System.out.println("1. Approve" + "\n2. Functions" + "\n3. Users" +  "\nInput 0 to exit.");
							userInput = bankScan.next();
						}
						switch(userInput) {
						case "1":
						case "1.":
						case "Approve":
						case "approve":
							System.out.println("Please type the account number, user name, and opening balence");
							do{int accnumber = bankScan.nextInt();
							System.out.println();
							String holder = bankScan.next();
							System.out.println();
							double balence = bankScan.nextDouble();
							System.out.println();
							System.out.println(dataBase.makeAccount(balence, accnumber, holder));
							}while(false);
							System.out.println("Would you like to continue?" + "\nYes or No");
							userInput = bankScan.next();
							if(userInput.equals("Yes") || userInput.equals("yes") || userInput.equals("y")) {
								userMenu = false;
								oneStep = false;
							}
							else if (userInput.equals("No") || userInput.equals("no") || userInput.equals("n")) {
								System.out.println("Have a good day!");
								userMenu = true;
								quit = true;
								System.exit(0);
							}
							break;
						case "2":
						case "2.":
						case "Functions":
						case "functions":
						case "Function":
						case "function":
							dataBase.printAccounts();
							System.out.println("1. Withdaw" + "\n2. deposit" + "\n3. Transfer" +  "\nInput 0 to exit.");
							userInput = bankScan.next();
							switch(userInput) {
							case "1":
							case "1.":
							case "Withdraw":
							case "withdraw":
								do{
									System.out.println("Please type the account number and amount");
									String accnumber = bankScan.next();
									System.out.println();
									String amount= bankScan.next();
									System.out.println();
									dataBase.withdraw(currentUser, accnumber, amount);
								}while(false);
								break;
							case "2":
							case "2.":
							case "deposit":
							case "Deposit":
								do{
									System.out.println("Please type the account number and amount");
									String accnumber = bankScan.next();
									System.out.println();
									String amount= bankScan.next();
									System.out.println();
									dataBase.deposit(currentUser, accnumber, amount);
								}while(false);
							case "3":
							case "3.":
							case "Transfer":
							case "transfer":
								do{
									System.out.println("Please type the account number to withdraw, then to deposit, and amount");
									String accnumber = bankScan.next();
									System.out.println();
									String acctgt = bankScan.next();
									System.out.println();
									String amount= bankScan.next();
									System.out.println();
									dataBase.transfer(currentUser, accnumber, acctgt, amount);
								}while(false);
								break;
							default:
								}
							System.out.println("Would you like to continue?" + "\nYes or No");
							userInput = bankScan.next();
							if(userInput.equals("Yes") || userInput.equals("yes") || userInput.equals("y")) {
								userMenu = false;
								oneStep = false;
							}
							else if (userInput.equals("No") || userInput.equals("no") || userInput.equals("n")) {
								System.out.println("Have a good day!");
								userMenu = true;
								quit = true;
								System.exit(0);
							}
							break;
						case "3":
						case "3.":
						case "Users":
						case "users":
							System.out.println("This is where the Personal go.");
							System.out.println("Would you like to continue?" + "\nYes or No");
							userInput = bankScan.next();
							if(userInput.equals("Yes") || userInput.equals("yes") || userInput.equals("y")) {
								userMenu = false;
								oneStep = false;
							}
							else if (userInput.equals("No") || userInput.equals("no") || userInput.equals("n")) {
								System.out.println("Have a good day!");
								userMenu = true;
								quit = true;
								System.exit(0);
							}
							break;
						case "0":

			                quit = true;
			                System.out.println("Goodbye!");
			                System.exit(0);
							break;
						default:
							System.out.println("I'm sorry, that is not a valid input. Please try again.");


						}
					}

			}else {
				System.out.println("I'm sorry, the username/password is incorrect.");
			}

			}


			}	else if(userInput.equals("No") || userInput.equals("no") || userInput.equals("n")) {
				System.out.println("Welcome new user! Would you like to setup a account?");
				whileStop = true;
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
					System.exit(0);

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
	}

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
		System.out.println("Please Select: \n1.Account\n2.Users\n3.Requests");
		String choice = bankScan.next().toLowerCase(); //makes exact matches easier
		System.out.println();
		switch(choice){
		case "1.":
		case "1":
		case "number":
		case "1.number":
			printAccountInfoIO(currentUser, bankScan);//menu for account actions
			break;
		case "2.":
		case "2":
		case "users":
		case "2.users":
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
	private static void adminAccountActions(User currentUser, Scanner bankScan){
		System.out.println("Please Select: \n1.Info\n2.Modify\n3.Transactions");
		String choice = bankScan.next().toLowerCase(); //makes exact matches easier
		System.out.println();
		switch(choice){
		case "1.":
		case "1":
		case "number":
		case "1.number":
			printAccountInfoIO(currentUser, bankScan);//menu for account actions
			break;
		case "2.":
		case "2":
		case "users":
		case "2.users":
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
	private static void adminUserActions(User currentUser, Scanner bankScan){
		System.out.println("Please Select: \n1.Create\n2.Info");
		String choice = bankScan.next().toLowerCase(); //makes exact matches easier
		System.out.println();
		switch(choice){
		case "1.":
		case "1":
		case "number":
		case "1.number":
			makeUser(currentUser, bankScan);//menu for account actions
			break;
		case "2.":
		case "2":
		case "users":
		case "2.users":
			Databases.getDatabases().printUsers();
			break;
		}
	}
	
	private static void addUsertoAccountIO(User currentUser, Scanner bankScan){
		System.out.println("please type the user to add");
		String accnumber = bankScan.next();
		System.out.println("\n Please type target account:");
		String acctgt = bankScan.next();
	}
	
	private static void depositIO(User currentUser, Scanner bankScan){//reuses the scanner to minimize initialization lag
		System.out.println("Please type the account number");
		String accnumber = bankScan.next();  //account number as a string
		System.out.println("\nPlease type amount"); 
		String amount= bankScan.next();
		System.out.println();
		Databases.getDatabases().deposit(currentUser, accnumber, amount);  //no need to store a database reference in the local scope
	}
	private static void getRequests(User currentUser, Scanner bankScan){
		//to do
	}
	private static void makeAccountIO(User currentUser, Scanner bankScan){
		System.out.println("Please type the account number:");
		int accnumber = bankScan.nextInt();
		System.out.println("\n Please type user:");
		String accountOwner = bankScan.next();
		System.out.println("\n Please type opening balence:");
		Double amount= bankScan.nextDouble();
		System.out.println();
		Databases.getDatabases().makeAccount(amount, accnumber, accountOwner);
	}
	private static void makeUser(User currentUser, Scanner bankScan){
		System.out.println("Please type the Username.");
		String uName = bankScan.next();
		System.out.println("\n Please type the user password:");
		String pWord = bankScan.next();
		System.out.println("\n Please users full name:");
		String fName= bankScan.next();
		System.out.println("\n Please input user type as Admin, Employee, or Client");
		switch(bankScan.next()){
		case "Admin":
		case "admin":
			Databases.getDatabases().makeSU(uName, pWord, fName);
			break;
		case "Employee":
		case "employee":
			Databases.getDatabases().makeEmployee(uName, pWord, fName);
			break;
		default:
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
	private static void requestAccountAction(User currentUser, Scanner bankScan){//generic ticket system
		//to do
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
