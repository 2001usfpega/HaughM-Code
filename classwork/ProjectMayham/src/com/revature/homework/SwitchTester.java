package com.revature.homework;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class SwitchTester {

	@Test
	void test() {
		SwitchDemonstrator s = new SwitchDemonstrator(1, 245.4);
		assertEquals(15.665248162732693,s.outputDouble);
		s = new SwitchDemonstrator(3, 245.4);
		String[] expecteds = {"I","am","learning","Core","Java"};
		assertArrayEquals(expecteds, s.outputStringArray);

	}

}
