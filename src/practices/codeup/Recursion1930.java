package practices.codeup;

import static org.junit.Assert.assertEquals;

import java.util.Scanner;

import org.junit.Test;

public class Recursion1930 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (sc.hasNext()) {
			int k = sc.nextInt();
			int n = sc.nextInt();

			System.out.println(superSum(k, n));
		}
		sc.close();
	}

	private static int superSum(int k, int n) {
		if (k == 0) {
			return n;
		}

		int sum = 0;
		while (n != 0) {
			sum += superSum(k - 1, n--);
		}
		return sum;
	}

	@Test
	public void test1() {
		int expected = 6;
		int k = 1;
		int n = 3;
		assertEquals(expected, superSum(k, n));
	}
	
	@Test
	public void test2() {
		int expected = 10;
		int k = 2;
		int n = 3;
		assertEquals(expected, superSum(k, n));
	}
	
	@Test
	public void test3() {
		int expected = 2002;
		int k = 4;
		int n = 10;
		assertEquals(expected, superSum(k, n));
	}
	
	@Test
	public void test4() {
		int expected = 167960;
		int k = 10;
		int n = 10;
		assertEquals(expected, superSum(k, n));
	}
}
