package practices.algorithms;

import org.junit.Ignore;
import org.junit.Test;

public class Recursion {

	public void countdown(int num) {
		if (num == 0) {
			return;
		}

		System.out.println(num--);
		countdown(num);
	}

	@Test
	@Ignore
	public void testRecursion() {
		System.out.println("Recursion");
		countdown(10);
	}

	public void loopCountdown(int num) {
		System.out.println(num);
	}

	@Test
	@Ignore
	public void test2() {
		System.out.println("for");
		for (int num = 10; num > 0; num--) {
			loopCountdown(num);
		}
	}

	@Test
	@Ignore
	public void test3() {
		System.out.println("while");
		int num = 10;
		while (num > 0) {
			loopCountdown(num--);
		}
	}

	@Test
	@Ignore
	public void testMultiply() {
		System.out.println("muliply");
		int a = 2;
		int b = 9;
		muliply(a, b);
	}

	private void muliply(int a, int b) {
		if (b > 0) {
			System.out.printf("%d * %d = %d%n", a, b, (a * b));
			muliply(a, --b);
		} else {
			return;
		}

	}

	@Test
	@Ignore
	public void testMuliplyRightOrder() {
		System.out.println("muliplyRightOrder");
		int a = 2;
		int b = 10;
		muliplyRightOrder(a, b);
	}

	private void muliplyRightOrder(int a, int b) {
		if (b < 1) {
			return;
		} else {
			muliplyRightOrder(a, b - 1);
			System.out.printf("%d * %d = %d%n", a, b, (a * b));
		}

	}

	@Test
	@Ignore
	public void testFactorial() {
		int num = 2;
		System.out.println(num + "의 차례곱 : " + factorial(num));
		num = 5;
		System.out.println(num + "의 차례곱 : " + factorial(num));
	}

	private int factorial(int i) {
		if (i == 1) {
			return i;
		}

		return i * factorial(--i);
	}
}
