package ua.nure.bilousov;

import java.util.Calendar;
import java.util.Date;

import org.junit.Test;

import junit.framework.TestCase;

public class UserTest extends TestCase {
	
	 private static final int ETALONE_AGE = 2017 - 1984;
	 private User user;
	 private Date dateOfBirthd;
	 
	 protected void setUp () throws Exception {
		 super.setUp();
		 user = new User();
		 
		 
		 Calendar calendar = Calendar.getInstance();
		 calendar.set(1984, Calendar.MAY, 26);
		 dateOfBirthd = calendar.getTime();	 
	 }
	
	@Test
	public void testFullName() {
		user.setFirstName("Pavel");
		user.setLastName("Belousov");
		 assertEquals("Pavel Belousov", user.getFullName());

	}
	
	public void testGetAge() {
		user.setBirthday(dateOfBirthd);
		assertEquals(ETALONE_AGE, user.getAge());
		
		
	}
	
	
	

}
