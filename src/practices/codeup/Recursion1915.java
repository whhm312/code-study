package practices.codeup;

import java.util.Scanner;

public class Recursion1915 {
	private static int fibonacci(int n, int left, int right) {
		if (n <= 1) {
			return right;
		}
		return fibonacci(n - 1, right, left + right);
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		sc.close();

		System.out.println(fibonacci(n, 0, 1));
	}
}
