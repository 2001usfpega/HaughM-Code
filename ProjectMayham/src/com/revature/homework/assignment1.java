package com.revature.homework;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class assignment1 {

	public static void main(String[] args) {
		do {
			int[] input = { 1, 0, 5, 6, 3, 2, 3, 7, 9, 8, 4 };
			int[] out = bubbleSort(input);
			for (int i : input) {
				System.out.print(i);
			}
			System.out.println();
			for (int i : out) {
				System.out.print(i);
			}
			System.out.println();
		} while (false);
		for(int i:fibonacci()) {
			System.out.println(i);
		}
		do {
			String input = "Its going to reverse Me!";
			System.out.println(input);
			System.out.println(reverseString(input));
		} while (false);
		do {
			int input = 5;
			System.out.println("Nfactorial of " + input);
			System.out.println(nFactorial(input));
		} while (false);
		do {
			String input1 = "The quick brown fox jumped over the lazy dog.";
			int input2 = 15;
			System.out.println("first " + input2 + " char from: \"" + input1 + "\"");
			System.out.println(getSubstring(input1, input2));
		} while (false);
		do {
			for (int i = 1; i <= 20; i++) {
				System.out.println("Is " + i + " even? " + isEven(i));
			}
		} while (false);
		palendromes();
		
		for(int i:primes()){
			System.out.println(i);
		}
		do {
			Integer[] input = array1To100();
			double d = 54.28d;
			for (int i : input) {
				System.out.println("Min of this pair: " + min(i, d));
			}
		} while (false);
		evens();
		pyramid();
		readFromFile();
		arrayListDemo();
	}

	// 1
	static int[] bubbleSort(int... input) {
		// runs the bubble sort algorithm on an arbitrarily long array
		// first clone the input to prevent unexpected array modifications
		int[] holder = new int[input.length];
		for (int i = 0; i < input.length; i++) {
			holder[i] = input[i];
		}
		boolean c; // continuation check, falls out of scope if inside the do loop
		int g = 1; // trade memory for slight speed efficiency
		do {
			c = false;
			for (int i = 0; i < holder.length - g; i++) {
				if (holder[i] > holder[i + 1]) {
					int temp = holder[i];// holds the value
					holder[i] = holder[i + 1];// swaps the low value back
					holder[i + 1] = temp;// writes the value forward
					c = true;// count
				}
			}
			g++;
		} while (c);
		return holder;
	}

	// 2
	static int[] fibonacci() {
		return iterativeAdditionSequence(25, 0, 1);
	}

	static int[] iterativeAdditionSequence(int toDo, int n0, int n1) { // runs the fibonacci equation on any two numbers
																		// for any length
		int[] out = new int[toDo];
		for (int i = 0; i < toDo; i++) {
			out[i] = n0;
			int holder = n0 + n1;
			n0 = n1;
			n1 = holder;
		}
		return out;
	}

	// 3
	static String reverseString(String input) {
		String out = "";// you need a holder so you don't overwrite data you need latter, warning makes
						// strings a ton of times
		for (int i = input.length() - 1; i >= 0; i--) {// walks through the string backwards and appends to the output
			out += input.charAt(i);
		}
		return out;
	}

	// 4
	static int nFactorial(int in) {
		int out = 1;
		for (int i = in; i > 0; i--) {
			out = i * out;
		}
		return out;
	}

	// 5
	static String getSubstring(String str, int idx) {
		String out = "";
		for (int i = 0; i < idx; i++) {
			out += str.charAt(i);
		}
		return out;
	}

	// 6
	static boolean isEven(int input) {
		return dividesCleanly(input, 2);
	}

	static boolean dividesCleanly(int numerator, int denominator) {
		int product = numerator / denominator;
		return (product * denominator) == numerator;
	}
	// 7
	//com.revature.homework.employee
	// 8
	static void palendromes(){
		PalendromeSeperator p = new PalendromeSeperator();
		for(String s: p.getInput()){
			System.out.print(s+", ");
		}
		System.out.println();
		for(String s: p.getPalendromes()){
			System.out.print(s+", ");
		}
		System.out.println();
	}

	// 9

	static Integer[] array1To100() {
		Integer[] out = new Integer[100];
		for (int i = 0; i < 100; i++) {
			out[i] = i + 1;
		}
		return out;
	}

	static ArrayList<Integer> primes() {
		return primes(array1To100());
	}

	static ArrayList<Integer> primes(Integer[] integers) {
		ArrayList<Integer> out = new ArrayList<Integer>();
		next: for (int i : integers) {
			if(i>-2&&i<2) {  // one, zero and -1 isn't considered prime
				continue;
			}
			for (int n = 2; n<=Math.sqrt(i);n++) {  // for i/n=r where n > sqrt(i)  r is always either not an integer or >Sqrt(I)
				if (i % n == 0) {
					continue next;
				}
			}
			
			out.add(i);
		}
		return out;
	}

	// 10
	static Number min(Number n1, Number n2) {
		return n1.doubleValue() > n2.doubleValue() ? n2 : n1;
	}
	// 11
	static Float getFromOtherPackage(){
		System.out.println(com.revature.homework2.Question11Holder.float1);
		System.out.println(com.revature.homework2.Question11Holder.getFloat2());
		return com.revature.homework2.Question11Holder.float1 + com.revature.homework2.Question11Holder.getFloat2();
	}
	// 12
	static void evens() {
		evens(array1To100());
	}

	static Integer[] evens(Integer[] input) {
		ArrayList<Integer> output = new ArrayList<Integer>();
		for (int i : input) {
			if (isEven(i)) {
				output.add(i);
			}
		}
		Integer[] out = new Integer[output.size()];
		return output.toArray(out);
	}
	//13
	
	static void pyramid(){
		pyramid(false, 4);
	}
	static void pyramid(boolean nextIsOne, int levels){
		for(int y = 1; y<= levels; y++){
			for(int x = 1;x<=y;x++) {
				System.out.print(nextIsOne?1+" ":0+" ");
				nextIsOne=!nextIsOne;
			}
			System.out.println();
		}
	}
	//17
	static double simpleInterest() throws NumberFormatException, IOException {
		BufferedReader reader =  new BufferedReader(new InputStreamReader(System.in)); 
		double a = 0;
		double b = 0;
		double c = 0;
		System.out.println("Input Principle:");
		a = Double.valueOf(reader.readLine());
		System.out.println();
		System.out.println("Input rate of return as a decimal value (not percentage):");
		b = Double.valueOf(reader.readLine());
		System.out.println();
		System.out.println("Input Years:");
		c = Double.valueOf(reader.readLine());
		System.out.println();
		Double out = simpleInterest(a, b, c);
		System.out.println(out);
		return out;
	}
	static double simpleInterest(double a, double b, double c){
		return a*b*c;
	}
	
	//19
	static ArrayList<Integer> arrayListDemo(){
		ArrayList<Integer> holder = new ArrayList<Integer>();
		
		for(int i = 1; i<=10; i++){
			holder.add(i);
		}
		int out = 0;
		for(int i: holder){
			if(isEven(i)){
				out += i;
			}
		}
		System.out.println(out);
		out = 0;
		for(int i: holder){
			if(!isEven(i)){
				out += i;
			}
		}
		System.out.println(out);
		Integer[] temp = new Integer[10];
		ArrayList<Integer> filter = primes(holder.toArray(temp));
		holder.removeAll(filter);
		for(Integer i: holder) {
			System.out.println(i);
		}
		return holder;
	}
	//20
	static String [][] readFromFile(){
		String input = "replace:withfile:21:state";  // replace me with that file IO!
			String holder []=input.split("/R");
			String [][] output = new String [holder.length][4];
			 for(int i = 0; i< holder.length; i++){
				 for(int y = 0; y <  4 ;y++){
					 output[i][y] =  holder[i].split(":")[y];
				 }
			 }
			 for(String[] s: output){
				 System.out.println("Name: "+s[0]+" "+s[1]+" age: "+s[2]+" state: "+s[3]);
			 }
		return output;
	}
}


