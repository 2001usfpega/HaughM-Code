package com.revature.homework;

import java.util.ArrayList;

//8
class PalendromeSeperator {
	private ArrayList<String> palendromes = new ArrayList<String>();
	private ArrayList<String> input = new ArrayList<String>();
	PalendromeSeperator(){
		String[] strings = {"karan", "madam", "tom", "civic", "radar", "jimmy", "kayak", "john",  "refer", "billy", "did"};
		for(String s: strings) {
			input.add(s);
		}
		sortPalendromes();
	}
	PalendromeSeperator(String [] input){
		for(String i: input) {
			this.input.add(i);
		}
		sortPalendromes();
	}
	PalendromeSeperator(ArrayList<String> input){
		for(String i: input) {
			this.input.add(i);
		}
		sortPalendromes();
	}
	ArrayList<String> getInput() {
		return input;
	}
	ArrayList<String> getPalendromes() {
		return palendromes;
	}
	void sortPalendromes(){
		for(String s: input){
			boolean isPalendrome=true;
			for(int i = 0; i<=s.length()/2;i++){
				if(s.charAt(i)!=s.charAt(s.length()-(i+1))) {
					isPalendrome=false;
					break;
				}
			}
			if(isPalendrome){
				palendromes.add(s);
			}
		}
	}
}
