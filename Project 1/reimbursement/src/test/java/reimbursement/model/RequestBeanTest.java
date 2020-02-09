package reimbursement.model;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.Date;

import org.junit.jupiter.api.Test;

class RequestBeanTest {
	
	

	@Test
	void testToString() {
		Date placeholder = new Date(0);
		RequestBean test = new RequestBean(0, 0, 0, 0, placeholder, placeholder, 0, "placeholder");
		assertEquals("RequestBean [request_id=0, u_id_fk=0, request_type=0, ammount=0.0, date_submited=1969-12-31, date_resolved=1969-12-31, status=0, descript=placeholder]", test.toString());
	}

	@Test
	void testGetRequest_id() {
		Date placeholder = new Date(0);
		RequestBean test = new RequestBean(0, 0, 0, 0, placeholder, placeholder, 0, "placeholder");
		assertEquals(0, test.getRequest_id());
	}

	@Test
	void testSetRequest_id() {
		Date placeholder = new Date(0);
		RequestBean test = new RequestBean(0, 0, 0, 0, placeholder, placeholder, 0, "placeholder");
		test.setRequest_id(1);
		assertEquals(1, test.getRequest_id());
	}

	@Test
	void testGetU_id_fk() {
		Date placeholder = new Date(0);
		RequestBean test = new RequestBean(0, 0, 0, 0, placeholder, placeholder, 0, "placeholder");
		assertEquals(0, test.getU_id_fk());
	}

	@Test
	void testSetU_id_fk() {
		Date placeholder = new Date(0);
		RequestBean test = new RequestBean(0, 0, 0, 0, placeholder, placeholder, 0, "placeholder");
		test.setU_id_fk(1);
		assertEquals(1, test.getU_id_fk());
	}

	@Test
	void testGetRequest_type() {
		Date placeholder = new Date(0);
		RequestBean test = new RequestBean(0, 0, 0, 0, placeholder, placeholder, 0, "placeholder");
		assertEquals(0, test.getRequest_type());
	}

	@Test
	void testSetRequest_type() {
		Date placeholder = new Date(0);
		RequestBean test = new RequestBean(0, 0, 0, 0, placeholder, placeholder, 0, "placeholder");
		test.setRequest_type(1);
		assertEquals(1, test.getRequest_type());
	}

	@Test
	void testGetAmmount() {
		Date placeholder = new Date(0);
		RequestBean test = new RequestBean(0, 0, 0, 0, placeholder, placeholder, 0, "placeholder");
		assertEquals(0, test.getAmmount());
	}

	@Test
	void testSetAmmount() {
		Date placeholder = new Date(0);
		RequestBean test = new RequestBean(0, 0, 0, 0, placeholder, placeholder, 0, "placeholder");
		test.setAmmount(1);
		assertEquals(1, test.getAmmount());
	}

	@Test
	void testGetDate_submited() {
		Date placeholder = new Date(0);
		RequestBean test = new RequestBean(0, 0, 0, 0, placeholder, placeholder, 0, "placeholder");
		assertEquals(placeholder, test.getDate_submited());
	}

	@Test
	void testSetDate_submited() {
		Date placeholder = new Date(0);
		RequestBean test = new RequestBean(0, 0, 0, 0, placeholder, placeholder, 0, "placeholder");
		Date p2 = new Date(System.currentTimeMillis());
		test.setDate_submited(p2);
		assertEquals(p2, test.getDate_submited());
	}

	@Test
	void testGetDate_resolved() {
		Date placeholder = new Date(0);
		RequestBean test = new RequestBean(0, 0, 0, 0, placeholder, placeholder, 0, "placeholder");
		assertEquals(placeholder, test.getDate_resolved());
	}

	@Test
	void testSetDate_resolved() {
		Date placeholder = new Date(0);
		RequestBean test = new RequestBean(0, 0, 0, 0, placeholder, placeholder, 0, "placeholder");
		Date p2 = new Date(System.currentTimeMillis());
		test.setDate_resolved(p2);
		assertEquals(p2, test.getDate_resolved());
	}

	@Test
	void testGetStatus() {
		Date placeholder = new Date(0);
		RequestBean test = new RequestBean(0, 0, 0, 0, placeholder, placeholder, 0, "placeholder");
		assertEquals(0, test.getStatus());
	}

	@Test
	void testSetStatus() {
		Date placeholder = new Date(0);
		RequestBean test = new RequestBean(0, 0, 0, 0, placeholder, placeholder, 0, "placeholder");
		test.setStatus(1);
		assertEquals(1, test.getStatus());
	}

	@Test
	void testGetDescript() {
		Date placeholder = new Date(0);
		RequestBean test = new RequestBean(0, 0, 0, 0, placeholder, placeholder, 0, "placeholder");
		assertEquals("placeholder", test.getDescript());
	}

	@Test
	void testSetDescript() {
		Date placeholder = new Date(0);
		RequestBean test = new RequestBean(0, 0, 0, 0, placeholder, placeholder, 0, "placeholder");
		test.setDescript("test");
		assertEquals("test", test.getDescript());
	}

}
