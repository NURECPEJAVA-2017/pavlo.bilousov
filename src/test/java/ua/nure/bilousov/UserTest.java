package ua.nure.bilousov;

import java.util.Calendar;
import java.util.Date;

import org.junit.Test;

import junit.framework.TestCase;

public class UserTest extends TestCase {
	// ���� ���������� �� 7.12.2017
	private static final int DATE_OF_BIRTH = 5;
	private static final int DATE_OF_BIRTH2 = 7;
	private static final int DATE_OF_BIRTH3 = 9;
	private static final int MONTH_OF_BIRTH = Calendar.DECEMBER;
	private static final int MONTH_OF_BIRTH2 = Calendar.NOVEMBER;
	private static final int MONTH_OF_BIRTH3 = Calendar.JANUARY;
	private static final int CURRENT_YEAR = 2017;
	private static final int YEAR_OF_BIRTH = 2000;
	// ���������, ������� ���������� �� �������� ���� � ���� ��� �������� ���
	// �������
	private static final int ETALONE_AGE = CURRENT_YEAR - YEAR_OF_BIRTH;
	private static final int ETALONE_AGE2 = CURRENT_YEAR - YEAR_OF_BIRTH - 1;
	private User user;
	private Date dateOfBirthd;

	protected void setUp() throws Exception {
		super.setUp();
		user = new User();
	}

	@Test
	public void testFullName() {
		user.setFirstName("Pavel");
		user.setLastName("Belousov");
		assertEquals("Pavel Belousov", user.getFullName());

	}

	// ����(1) ���� �������� ��� ������, �� ����� ��� ����.
	public void testGetAge1() {
		Calendar calendar = Calendar.getInstance();
		calendar.set(YEAR_OF_BIRTH, MONTH_OF_BIRTH, DATE_OF_BIRTH);
		dateOfBirthd = calendar.getTime();
		user.setBirthday(dateOfBirthd);
		assertEquals(ETALONE_AGE, user.getAge());
	}

	// ����(2) ����� �������� ��� ������ � ���� ����.
	public void testGetAge2() {
		Calendar calendar = Calendar.getInstance();
		calendar.set(YEAR_OF_BIRTH, MONTH_OF_BIRTH2, DATE_OF_BIRTH);
		dateOfBirthd = calendar.getTime();
		user.setBirthday(dateOfBirthd);
		assertEquals(ETALONE_AGE, user.getAge());
	}

	// ����(3) ���� �������� �������
	public void testGetAge3() {
		Calendar calendar = Calendar.getInstance();
		calendar.set(YEAR_OF_BIRTH, MONTH_OF_BIRTH, DATE_OF_BIRTH);
		dateOfBirthd = calendar.getTime();
		user.setBirthday(dateOfBirthd);
		assertEquals(ETALONE_AGE, user.getAge());
	}

	// ����(4) ����� �������� ����, �� ���� �������� ��� � ������.
	public void testGetAge4() {
		Calendar calendar = Calendar.getInstance();
		calendar.set(YEAR_OF_BIRTH, MONTH_OF_BIRTH, DATE_OF_BIRTH3);
		dateOfBirthd = calendar.getTime();
		user.setBirthday(dateOfBirthd);
		assertEquals(ETALONE_AGE2, user.getAge());
	}

	// ����(5) ����� �������� ��� �� �������
	public void testGetAge5() {
		Calendar calendar = Calendar.getInstance();
		calendar.set(YEAR_OF_BIRTH + 1, MONTH_OF_BIRTH3, DATE_OF_BIRTH);
		dateOfBirthd = calendar.getTime();
		user.setBirthday(dateOfBirthd);
		assertEquals(ETALONE_AGE2, user.getAge());
	}
}
