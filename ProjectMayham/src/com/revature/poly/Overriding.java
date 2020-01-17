package com.revature.poly;

public class Overriding {
	/*parent child relationship
	 * methods have same signiture
	 * Name, modifier, parapmiters, exceptions
	 * after 1.5 can have co varient retun type
	 * can return a child of the parrents return type
	 *child extends parent
	 *Fi extends Foo
	 *parent.foo() > returns Foo
	 *child.foo() returns Fi 
	 *
	 * */
	public static void main(String[] args) {
		Mammal m = new Mammal();
		m.eat();
		Pitbull p = new Pitbull();
		p.eat();
		
	}

}
