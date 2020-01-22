package com.revature.homework;

//15

class MathWhiz implements DoesMath{
	public double addition(Number input1, Number input2){
		return input1.doubleValue()+input2.doubleValue();
	}
	public double subtraction(Number input1, Number input2){
		return input1.doubleValue()-input2.doubleValue();
	}
	public double multiplication(Number input1, Number input2){
		return input1.doubleValue()*input2.doubleValue();
	}
	public double division(Number input1, Number input2){
		return input1.doubleValue()/input2.doubleValue();
	}
}