package practices.hackerrank.easy;

import static org.junit.Assert.assertEquals;

import java.util.Scanner;

import org.junit.Test;

public class JavaExceptionHandlingTryCatch {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println(cal(scan.next(), scan.next()));
		scan.close();
	}

	private static String cal(String strX, String strY) {
		String result = null;
		try {
			int x = Integer.parseInt(strX);
			int y = Integer.parseInt(strY);
			result = String.valueOf(x / y);
		} catch (NumberFormatException ne) {
			result = "java.util.InputMismatchException";
		} catch (Exception e) {
			result = e.toString();
		}

		return result;
	}

	@Test
	public void test1() {
		String expected = "3";
		assertEquals(expected, cal("10", "3"));
	}

	@Test
	public void test2() {
		String expected = "java.util.InputMismatchException";
		assertEquals(expected, cal("10", "Hello"));
	}

	@Test
	public void test3() {
		String expected = "java.lang.ArithmeticException: / by zero";
		assertEquals(expected, cal("10", "0"));
	}

	@Test
	public void test4() {
		String expected = "java.util.InputMismatchException";
		assertEquals(expected, cal("23.323", "0"));
	}
}
