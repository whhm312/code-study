package practices.codeup;

import static org.junit.Assert.assertEquals;

import java.util.Scanner;

import org.junit.Test;

public class Recursion1920 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		sc.close();

		System.out.println(transfer(n, ""));
	}

	private static String transfer(int n, String result) {
		if (n == 0) {
			if ("".equals(result)) {
				return "0";
			}
			return result;
		}

		result = (n % 2) + result;
		return transfer(n / 2, result);
	}

	@Test
	public void test1() {
		String expected = "1010";
		int n = 10;
		assertEquals(expected, transfer(n, ""));
	}

	@Test
	public void test2() {
		String expected = "111";
		int n = 7;
		assertEquals(expected, transfer(n, ""));
	}

	@Test
	public void test3() {
		String expected = "10000000000";
		int n = 1024;
		assertEquals(expected, transfer(n, ""));
	}
	
	@Test
	public void test4() {
		String expected = "0";
		int n = 0;
		assertEquals(expected, transfer(n, ""));
	}
}
