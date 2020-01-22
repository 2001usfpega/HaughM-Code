package com.revature.homework;


import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class Homework1tester {
	@Test
	public void testBubbleSort() {
		int [] input = { 1, 0, 5, 6, 3, 2, 3, 7, 9, 8, 4};
		int [] expected = { 0, 1, 2, 3, 3, 4, 5, 6, 7, 8, 9};
		int [] output = assignment1.bubbleSort(input);
		assertArrayEquals(expected, output);
		
	}

	@Test
	public void testFibonacci() {
		int [] expected = {0,1,1,2,3,5,8,13,21,34,55,89,144,233,377,610,987,1597,2584,4181,6765,10946,17711,28657,46368};
		int [] output = assignment1.fibonacci();
		assertArrayEquals(expected, output);
	}

	@Test
	public void testReverseString() {
		String expected = "reverse";
		String output = assignment1.reverseString("esrever");
		assertEquals(expected, output);
	}

	@Test
	public void testNFactorial() {
		int expected = 120;
		int output = assignment1.nFactorial(5);
		assertEquals(expected, output);
	}

	@Test
	public void testGetSubstring() {
		assertEquals("test",assignment1.getSubstring("test string", 4));
	}

	@Test
	public void testIsEven() {
		assertEquals(false, assignment1.isEven(3));
		assertEquals(true, assignment1.isEven(2));
	}

	@Test
	public void testDividesCleanly() {
		assertFalse(assignment1.dividesCleanly(3,2));
		assertTrue(assignment1.dividesCleanly(2,2));
	}

	@Test
	public void testPrimes() {
		Integer[] expecteds = {2,3,5,7};
		Integer[] input = {0, 1,2,3,4,5,6,7,8,9};
		Integer[] actuals = new Integer[assignment1.primes(input).size()]; 
		assignment1.primes(input).toArray(actuals);
		assertArrayEquals(expecteds, actuals);
	}

	@Test
	public void testMin() {
		assertEquals(true,(assignment1.min(100,1).intValue()==1));
	}

	@Test
	public void testGetFromOtherPackage() {
		assertEquals(true, assignment1.getFromOtherPackage()==70.89f);
	}

	@Test
	public void testEvens() {
		Integer[] input = {1,2,3,4,5,6,7,8,8,10};
		Integer[] expecteds = {2,4,6,8,8,10};
		assertArrayEquals(expecteds, assignment1.evens(input));
	}



	@Test
	public void testSimpleInterest() {
		assertEquals(300d, assignment1.simpleInterest(3000, .01, 10));
	}

	@Test
	public void testArrayListDemo() {
		Integer[] expected = {1,4,6,8,9,10};
		assertArrayEquals(expected, assignment1.arrayListDemo().toArray());
	}

}
