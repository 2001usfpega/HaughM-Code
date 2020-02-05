package com.revature.homework;

class UpercaseTester {

	@Test
	void testHasCase() {
		UppercaseChecker u = new UppercaseChecker();
		assertTrue(u.hasCase("Foo"));
		assertFalse(u.hasCase("foo"));
	}

	@Test
	void testChangeToCase() {
		UppercaseChecker u = new UppercaseChecker();
		assertEquals("FOO",u.changeToCase("foo"));
	}

	@Test
	void testToIntAndModify() {
		UppercaseChecker u = new UppercaseChecker();
		assertEquals(20,u.toIntAndModify("10"));
	}

}
