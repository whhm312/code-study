package practices.codeup;

import static org.junit.Assert.assertEquals;

import java.util.Scanner;

import org.junit.Test;

public class Recursion1919 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		sc.close();

		System.out.println(reverse(n, 0));
	}

	private static long reverse(int n, long result) {
		if (n == 0) {
			return result;
		}

		result = (result * 10) + (n % 10);
		return reverse(n / 10, result);
	}

	@Test
	public void test1() {
		long expected = 7463847412L;
		int n = 2147483647;
		assertEquals(expected, reverse(n, 0));
	}
	
	@Test
	public void test2() {
		long expected = 321;
		int n = 12300;
		assertEquals(expected, reverse(n, 0));
	}
}
