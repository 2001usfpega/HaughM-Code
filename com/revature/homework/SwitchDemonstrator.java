package com.revature.homework;

public class SwitchDemonstrator {
	String [] outputStringArray = new String[0];
	Double outputDouble;
	
	SwitchDemonstrator(int input, Number number){
		switch(input) {
		case 1:
			outputDouble = Math.sqrt(number.doubleValue());
			System.out.println(outputDouble);
			break;
		case 2:
			System.out.println(java.time.LocalDate.now());
			break;
			
		case 3:
			String b = "I am learning Core Java";
			outputStringArray = b.split(" ");
			
		}
	}
}
