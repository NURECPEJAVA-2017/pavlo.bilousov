package ua.nure.bilousov;

import org.junit.Test;

import junit.framework.TestCase;

public class UserTest extends TestCase {
	@Test
	public void testFullName() {
		User user = new User();
		user.setFirstName("Pavel");
		user.setLastName("Belousov");
		String fullName = 
		 user.getFullName();
		 assertEquals("Pavel Belousov", fullName);

	}

}
