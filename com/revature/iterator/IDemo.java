package com.revature.iterator;

public class IDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<String> a1 = new ArrayList<String>();
		a1.add("C");
		a1.add("D");
		a1.add("G");
		a1.add("B");
		a1.add("A");
		a1.add("F");
		a1.add("E");
		//display
		System.out.println("A1 original:");
		Iterator <String> itr = a1.iterator();
		while(itr.hasNext()){
			String element = itr.next();
			System.out.print(element+" ");
		}
		ListIterator <String> litr = a1.listIterator();
		while(litr.hasNext()){
			String element = litr.next();
			litr.set(element+"+");
		}
		System.out.println("\nA1 mod:");
		Iterator <String> itr2 = a1.iterator();
		while(itr2.hasNext()){
			String element = itr2.next();
			System.out.print(element+" ");
		}
		System.out.println("\nModifed List Backwards");
		while(litr.hasPrevious()){
			String element = litr.previous();

			System.out.print(element+" ");
		}
	}

}
