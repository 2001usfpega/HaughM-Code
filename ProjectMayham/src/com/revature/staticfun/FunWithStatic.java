package com.revature.staticfun;

public class FunWithStatic {
	public void nonStaticMethod() {
		System.out.println("Not Static, belongs to an object");
	}
	public static void staticMethod() {
		System.out.println("Static, belongs to the class");
	}
}
