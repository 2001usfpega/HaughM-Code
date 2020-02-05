package com.revature.poly;

public class Pitbull extends Mammal{
	public String s = "Steak";
	@Override
	@Override
	public void eat() {
		int a = 5;  // no default value
		System.out.println("Pitbull is eat " + super.s);
		if(a==5){
			int d = 4;// no default value
			System.out.println("Foo! " + d + a);
		}
		//d no longer exists
	}
	// a no longer exists
	
}
