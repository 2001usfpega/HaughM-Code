package com.revature.homework;

import java.util.regex.Pattern;

public class UppercaseChecker extends CaseModifier {

	@Override
	public boolean hasCase(String input) {
		for(char c: input.toCharArray()){
			if(Pattern.matches("[A-Z]", ""+c)){
				return true;
			}
		}
		return false;
	}

	@Override
	public String changeToCase(String input) {
		return input.toUpperCase();
	}

	@Override
	public int toIntAndModify(String input) {
		int output = 10;
		output += Integer.parseInt(input);
		return output;
	}

}

abstract class CaseModifier{
	abstract boolean hasCase(String input);
	abstract String changeToCase(String input);
	abstract int toIntAndModify(String input);
}
