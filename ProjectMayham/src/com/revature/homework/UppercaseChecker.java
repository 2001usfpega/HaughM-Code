package com.revature.homework;

import java.util.regex.Pattern;

public class UppercaseChecker extends CaseModifier {

	@Override
	boolean hasCase(String input) {
		return Pattern.matches("[A-Z]", input);
	}

	@Override
	String changeToCase(String input) {
		return input.toUpperCase();
	}

	@Override
	int toIntAndModify(String input) {
		int output = 10;
		output += Integer.getInteger(input, 0);
		return output;
	}

}

abstract class CaseModifier{
	abstract boolean hasCase(String input);
	abstract String changeToCase(String input);
	abstract int toIntAndModify(String input);
}
