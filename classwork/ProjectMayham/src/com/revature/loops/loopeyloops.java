package com.revature.loops;

public class loopeyloops {
	/*if(BOOL){scope
	 * }else{other scope}
	 * if(){
	 * }else if(){
	 * }else{}
	 * 
	 */
	public static void oldCheck(int age) {
		if(age>60){
			System.out.println("dude be old");
		}else if(age>30) {
			System.out.println("Half way there");
		} else {
			System.out.println("So young");
		}
	}
	
	public static void switcher(String Color) {
		switch(Color) {
		case "red":System.out.println("Sun");
		break;
		case "green":System.out.println("Grass");
		break;
		case "blue":System.out.println("Water");
		break;
		default: System.out.println("Fish!");
		}
	}
	public static void main(String[] args) {
		oldCheck(140);
		oldCheck(40);
		oldCheck(4);
	}

}
