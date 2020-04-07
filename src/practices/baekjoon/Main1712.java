package practices.baekjoon;

import static org.junit.Assert.assertEquals;

import java.util.Scanner;

import org.junit.Test;

public class Main1712 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int fixedCost = sc.nextInt();
		int variableCost = sc.nextInt();
		int income = sc.nextInt();
		sc.close();

		System.out.println(calculate(fixedCost, variableCost, income));
	}

	private static int calculate(int fixedCost, int variableCost, int income) {
		if (variableCost >= income) {
			return -1;
		} else {
			return (fixedCost / (income - variableCost)) + 1;
		}
	}

	@Test
	public void test() {
		int expected = 11;
		int fixedCost = 1000;
		int variableCost = 70;
		int income = 170;
		assertEquals(expected, calculate(fixedCost, variableCost, income));
	}
}
