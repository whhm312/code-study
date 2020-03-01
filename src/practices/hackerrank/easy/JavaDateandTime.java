package practices.hackerrank.easy;

import static org.junit.Assert.assertEquals;

import java.util.Calendar;

import org.junit.Test;

public class JavaDateandTime {
	public static String findDay(int month, int day, int year) {
		Calendar rightNow = Calendar.getInstance();
		rightNow.set(Calendar.YEAR, year);
		rightNow.set(Calendar.MONTH, month - 1);
		rightNow.set(Calendar.DAY_OF_MONTH, day);

		String[] WEEKS = { "SUNDAY", "MONDAY", "TUESDAY", "WEDNESDAY", "THURSDAY", "FRIDAY", "SATURDAY" };
		return WEEKS[rightNow.get(Calendar.DAY_OF_WEEK) - 1];
	}

	private Calendar setYear(int year) {
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.YEAR, year);
		return cal;
	}

	private Calendar setMonth(int year, int month) {
		Calendar rightNow = Calendar.getInstance();
		rightNow.set(Calendar.YEAR, year);
		rightNow.set(Calendar.MONTH, month - 1);
		return rightNow;
	}

	private Calendar setDate(int year, int month, int day) {
		Calendar rightNow = Calendar.getInstance();
		rightNow.set(Calendar.YEAR, year);
		rightNow.set(Calendar.MONTH, month - 1);
		rightNow.set(Calendar.DAY_OF_MONTH, day);
		return rightNow;
	}

	private String getDayOfWeeks(int year, int month, int day) {
		Calendar rightNow = setDate(year, month, day);
		int intDayOfWeek = rightNow.get(Calendar.DAY_OF_WEEK) - 1;
		String[] WEEKS = { "SUNDAY", "MONDAY", "TUESDAY", "WEDNESDAY", "THURSDAY", "FRIDAY", "SATURDAY" };
		return WEEKS[intDayOfWeek];
	}

	@Test
	public void testGetDayOfWeeks() {
		int month = 8;
		int day = 5;
		int year = 2015;
		String expected = "WEDNESDAY";
		assertEquals(expected, getDayOfWeeks(year, month, day));
	}

	@Test
	public void testSetDay() {
		int month = 8;
		int day = 5;
		int year = 2015;
		int expected = 5;
		Calendar cal = setDate(year, month, day);
		assertEquals(expected, cal.get(Calendar.DAY_OF_MONTH));
		assertEquals(month - 1, cal.get(Calendar.MONTH));
		assertEquals(year, cal.get(Calendar.YEAR));
	}

	@Test
	public void testSetMonth() {
		int year = 2015;
		int month = 8;
		int expected = 7;
		Calendar cal = setMonth(year, month);
		assertEquals(expected, cal.get(Calendar.MONTH));
	}

	@Test
	public void testSetYear() {
		int year = 2015;
		int expected = 2015;
		Calendar cal = setYear(year);
		assertEquals(expected, cal.get(Calendar.YEAR));
	}

	@Test
	public void test() {
		String expected = "WEDNESDAY";
		int month = 8;
		int day = 5;
		int year = 2015;
		assertEquals(expected, findDay(month, day, year));
	}

}
