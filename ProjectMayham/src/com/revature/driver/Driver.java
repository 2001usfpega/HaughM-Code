package com.revature.driver;

import com.revature.bean.Person;
import com.revature.staticfun.FunWithStatic; //<-- Fully Qualified Class Name

public class Driver {
	//single line comment
	/*
	 * multi line
	 * comment
	 *
	 * Naming Conventions
	 * Classes and Projects - Pascal casing ex. ProjectMayhem
	 * Methods and Variables - Camel casing ex. firstSecondThird
	 *
	 * package - all lower case, separated by periods
	 * constants - ALL_CAPS_LOLZ
	 */
	//Main method - serves as the entry point for an application
	@SuppressWarnings("static-access")
	public static void main(String [] args) {
		//public- access modifiers errbody can "see" it
		//static- belongs to class, no object needed
		// void- doesn't return anything
		// main- name of method
		// String [] args-  an array of Strings called args
		int a=3;
		int b=46;
		int c= a+b;
		System.out.println("I like to eat "+ c + " tacos" );
		/*
		 * Members of a class- can diff forms
		 * Variables, Methods, and Constructors
		 * Instance variables- property belongs to specific object
		 * Static variables- belong to class/all instances
		 * Instance methods- behavior related to a specific object
		 * Static methods - relative to the entire class
		 * Constructors- instantiates the 
		 * class using the keyword "new"
		 */
		Person p = new Person();
		p.setName("Jim");
		System.out.println(p);
		p.increaseAgeBy(3);
		System.out.println(p.getAge());
		Person q= new Person("BobPam", 81, 27);
		System.out.println(q);
		
		FunWithStatic fws = new FunWithStatic();
		fws.nonStaticMethod();
		FunWithStatic.staticMethod();
		fws.staticMethod();
	}
}


 final class finalthings{ // can't have child classes
	 final int b; // must be set in constructor
	 finalthings(){
		 b = 5;
	 }
	 final int a = 4; //set in the class, could easily be static
	 static final int c = 6; //Effectively a constant
		final int getA() {//can't be overridden by child classes
		 return a;
	 }
 }
