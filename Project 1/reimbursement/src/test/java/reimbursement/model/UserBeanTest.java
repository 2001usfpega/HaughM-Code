package reimbursement.model;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class UserBeanTest {

	@Test
	void testToString() {
		UserBean user = new UserBean(12345, "daveguy", "pword1", "Dave", "Guy", 0);
		assertEquals("UserBean [user_id=12345, uname=daveguy, pword=pword1, firstname=Dave, lastname=Guy, usertype=0]", user.toString());
	}

	@Test
	void testGetUser_id() {
		UserBean user = new UserBean(12345, "daveguy", "pword1", "Dave", "Guy", 0);
		assertEquals(12345, user.getUser_id());
	}

	@Test
	void testSetUser_id() {
		UserBean user = new UserBean(12345, "daveguy", "pword1", "Dave", "Guy", 0);
		user.setUser_id(67890);
		assertEquals(67890, user.getUser_id());
	}

	@Test
	void testGetUname() {
		UserBean user = new UserBean(12345, "daveguy", "pword1", "Dave", "Guy", 0);
		assertEquals("daveguy", user.getUname());
	}

	@Test
	void testSetUname() {
		UserBean user = new UserBean(12345, "daveguy", "pword1", "Dave", "Guy", 0);
		user.setUname("Test");
		assertEquals("Test", user.getUname());
	}

	@Test
	void testGetPword() {
		UserBean user = new UserBean(12345, "daveguy", "pword1", "Dave", "Guy", 0);
		assertEquals("pword1", user.getPword());	}

	@Test
	void testSetPword() {
		UserBean user = new UserBean(12345, "daveguy", "pword1", "Dave", "Guy", 0);
		user.setPword("Test");
		assertEquals("Test", user.getPword());
	}

	@Test
	void testGetFirstname() {
		UserBean user = new UserBean(12345, "daveguy", "pword1", "Dave", "Guy", 0);
		assertEquals("Dave", user.getFirstname());
	}

	@Test
	void testSetFirstname() {
		UserBean user = new UserBean(12345, "daveguy", "pword1", "Dave", "Guy", 0);
		user.setFirstname("Test");
		assertEquals("Test", user.getFirstname());
	}

	@Test
	void testGetLastname() {
		UserBean user = new UserBean(12345, "daveguy", "pword1", "Dave", "Guy", 0);
		assertEquals("Guy", user.getLastname());
	}

	@Test
	void testSetLastname() {
		UserBean user = new UserBean(12345, "daveguy", "pword1", "Dave", "Guy", 0);
		user.setLastname("Test");
		assertEquals("Test", user.getLastname());
	}

	@Test
	void testGetUsertype() {
		UserBean user = new UserBean(12345, "daveguy", "pword1", "Dave", "Guy", 0);
		assertEquals(0, user.getUsertype());
	}

	@Test
	void testSetUsertype() {
		UserBean user = new UserBean(12345, "daveguy", "pword1", "Dave", "Guy", 0);
		user.setUsertype(1);
		assertEquals(1, user.getUsertype());
	}

}
