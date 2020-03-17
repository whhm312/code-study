package practices.algorithms;

import org.junit.Test;

public class Recursion2 {
	@Test
	public void testPrint() {
		print(4);
	}

	public void print(int n) {
		if (n <= 0) {
			return;
		} else {
			System.out.println(n + " Hello..");
			print(n - 1);
			System.out.println(n + " Bye...");
		}
	}

	@Test
	public void testFactorial() {
		int n = 4;
		System.out.println(n + "! = " + factorial(n));
	}

	private int factorial(int n) {
		if (n == 0) {
			return 1;
		} else {
			return n * factorial(n - 1);
		}
	}

	@Test
	public void testPower() {
		long n = 4;
		int power = 2;
		System.out.println(n + "의 " + power + "승 = " + power(n, power));
	}

	private long power(long n, int power) {
		if (power == 0) {
			return 1;
		} else {
			return n * power(n, power - 1);
		}
	}

	@Test
	public void testFibonacci() {
		long n = 11;
		System.out.println(n + "의 피보나치 수는 " + fibonacci(n));
	}

	private long fibonacci(long n) {
		if (n < 2) {
			return n;
		}
		return fibonacci(n - 1) + fibonacci(n - 2);
	}

	@Test
	public void testGcd() {
		int n = 3;
		int m = 11;
		System.out.println("최대공약수 : " + gcd(m, n));
		System.out.println("최대공약수V2 : " + gcdV2(m, n));
	}

	private int gcd(int m, int n) {
		if (m < n) {
			int temp = m;
			m = n;
			n = temp;
		}

		if (m % n == 0) {
			return n;
		} else {
			return gcd(n, m % n);
		}
	}

	private int gcdV2(int p, int q) {
		if (p == 0) {
			return q;
		} else {
			return gcd(q, p % q);
		}
	}
}
