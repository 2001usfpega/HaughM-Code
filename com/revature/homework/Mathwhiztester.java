package com.revature.homework;

class Mathwhiztester {

	
	
	@Test
	void testAddition() {
		MathWhiz m = new MathWhiz();
		assertEquals(40d,m.addition(20f, 20l));
		assertEquals(40d,m.addition(20, 20d));
	}

	@Test
	void testSubtraction() {
		MathWhiz m = new MathWhiz();
		assertEquals(0d,m.subtraction(20f, 20l));
		assertEquals(0d,m.subtraction(20, 20d));
	}

	@Test
	void testMultiplication() {
		MathWhiz m = new MathWhiz();
		assertEquals(400d,m.multiplication(20f, 20l));
		assertEquals(400d,m.multiplication(20, 20d));
	}

	@Test
	void testDivision() {
		MathWhiz m = new MathWhiz();
		assertEquals(1d,m.division(20f, 20l));
		assertEquals(1d,m.division(20, 20d));
	}

}
