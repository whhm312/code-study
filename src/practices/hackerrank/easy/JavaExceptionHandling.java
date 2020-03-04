package practices.hackerrank.easy;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Scanner;

import org.junit.Test;

public class JavaExceptionHandling {
	static class MyCalculator {
		public long power(int n, int p) throws Exception {
			if (n == 0 && p == 0) {
				throw new Exception("n and p should not be zero.");
			} else if (n < 0 || p < 0) {
				throw new Exception("n or p should not be negative.");
			}
			return (long) Math.pow(n, p);
		}
	}

	public static final MyCalculator my_calculator = new MyCalculator();
	public static final Scanner in = new Scanner(System.in);

	public static void main(String[] args) {
		while (in.hasNextInt()) {
			int n = in.nextInt();
			int p = in.nextInt();

			try {
				System.out.println(my_calculator.power(n, p));
			} catch (Exception e) {
				System.out.println(e);
			}
		}
	}

	@Test
	public void test1() {
		int n = 3;
		int p = 5;
		long expected = 243;
		try {
			assertEquals(expected, new MyCalculator().power(n, p));
		} catch (Exception e) {
			assertTrue(false);
		}
	}

	@Test
	public void test2() {
		int n = 2;
		int p = 4;
		long expected = 16;
		try {
			assertEquals(expected, new MyCalculator().power(n, p));
		} catch (Exception e) {
			assertTrue(false);
		}
	}

	@Test
	public void test3() {
		int n = 0;
		int p = 0;
		try {
			new MyCalculator().power(n, p);
			assertTrue(false);
		} catch (Exception e) {
			String expected = "java.lang.Exception: n and p should not be zero.";
			assertEquals(expected, e.toString());
		}
	}

	@Test
	public void test4() {
		int n = -1;
		int p = -2;
		try {
			new MyCalculator().power(n, p);
		} catch (Exception e) {
			String expected = "java.lang.Exception: n or p should not be negative.";
			assertEquals(expected, e.toString());
		}
	}

	@Test
	public void test5() {
		int n = -1;
		int p = 3;
		String expected = "java.lang.Exception: n or p should not be negative.";
		try {
			new MyCalculator().power(n, p);
		} catch (Exception e) {
			assertEquals(expected, e.toString());
		}
	}
}
