package com.revature.homework;

public class assignment1 {
	
	public static void main (String [] args) {
		do {
			int [] input = {1,0,5,6,3,2,3,7,9,8,4};
			int [] out = bubbleSort(input);
			for (int i: input) {
				System.out.print(i);
			}
			System.out.println();
			for(int i: out){
				System.out.print(i); 
			}
			System.out.println();
		}while(false);
		fibonacci();
		do{
			String input = "Its going to reverse Me!";
			System.out.println(input);
			System.out.println(reverseString(input));
		}while(false);
		do{
			int input = 5;
			System.out.println("Nfactorial of " + input);
			System.out.println(nFactorial(input));
		}while(false);
		do{
			String input1 = "The quick brown fox jumped over the lazy dog.";
			int input2 = 15;
			System.out.println("first "+input2+" char from: \""+input1+"\"");
			System.out.println(getSubstring(input1, input2));
		}while(false);
		do{
			for(int i = 1; i <=20; i++) {
				System.out.println("Is "+i+" even? "+isEven(i));
			}
		}while(false);
		primes();
		do{
			int[] input = array1To100();
			double d = 54.28d;
			for(int i: input) {
				System.out.println("Min of this pair: "+min(i,d));
			}
		}while(false);
		evens();
	}
	
	 //1
	static int[] bubbleSort(int ... input){
		//runs the bubble sort algorithm on an arbitrarily long array
		//first clone the input to prevent unexpected array modifications
		int [] holder = new int[input.length];
		for(int i = 0; i<input.length; i++) {
			holder[i]=input[i];
		}
		boolean c; //continuation check, falls out of scope if inside the do loop
		int g = 1; //trade memory for slight speed efficiency
		do {
			c = false;
			for(int i = 0; i<holder.length-g; i++) {
				if(holder[i]>holder[i+1]) {
					int temp = holder[i];//holds the value
					holder[i]=holder[i+1];//swaps the low value back
					holder[i+1] = temp;//writes the value forward
					c = true;//count
				}
			}
			g++;
		}while(c);
		return holder;
	}
	//2
	static int [] fibonacci() {
		return iterativeAdditionSequence(25, 0, 1);
	}
	static int [] iterativeAdditionSequence(int toDo, int n0, int n1){ //runs the fibonacci equation on any two numbers for any length
		int []out = new int[toDo];
		for(int i = 0; i<toDo; i++) {
			System.out.println(n0);  //comment out to stop displaying
			out[i] = n0;
			int holder = n0 + n1;
			n0 = n1;
			n1 = holder;
		}
		return out;
	}
	//3
	static String reverseString(String input) {
		String out = "";// you need a holder so you don't overwrite data you need latter, warning makes strings a ton of times
		for(int i=input.length()-1;i>=0;i--){//walks through the string backwards and appends to the output
			out+=input.charAt(i);
		}
		return out;
	}
	//4
	static int nFactorial(int in){
		int out = 1;
		for(int i = in; i>0; i--) {
			out=i*out;
		}
		return out;
	}
	//5
	static String getSubstring(String input, int stopIndex){
		String out = "";
		for(int i = 0; i<stopIndex;i++){
			out += input.charAt(i);
		}
		return out;
	}
	//6
	static boolean isEven(int input) {
		return dividesCleanly(input, 2);
	}
	static boolean dividesCleanly(int numerator, int denominator){
		int product = numerator/denominator;
		return (product*denominator)==numerator;
	}
	 //7
	
	//8
	
	//9
	
	static int [] array1To100(){
		int [] out = new int[100];
		for(int i=0;i<100;i++){
			out[i] = i+1;
		}
		return out;
	}
	static void primes(){
		primes(array1To100());
	}
	static void primes(int [] input) {
		for(int i: input) {
			int c = 0;
			for(int d: array1To100()) {
				if(i%d==0) {
					c++;
				}
			}
			if(c==2){
				System.out.println(i);
			}
		}
	}
	
	//10
	static Number min(Number n1, Number n2){
		return n1.doubleValue()>n2.doubleValue()? n2:n1;
	}
	//11
	
	//12
	static void evens() {
		evens(array1To100());
	}
	static void evens(int[] input) {
		for(int i: input){
			if(isEven(i)){
				System.out.println(i);
			}
		}
	}
}


class PalendromeSeperator{
	
}
