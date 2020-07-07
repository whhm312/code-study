package practices.codeup;

import java.util.Scanner;

public class Recursion1915Better {
	private static int[] memo;

	private static int fibonacci(int n) {
		if (n <= 1) {
			return n;
		}
		if (memo[n] > 0) {
			return memo[n];
		}
		memo[n] = fibonacci(n - 1) + fibonacci(n - 2);
		return memo[n];
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		sc.close();

		memo = new int[n + 1];
		System.out.println(fibonacci(n));
	}
}
