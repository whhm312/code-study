package practices.codeup;

import java.util.Scanner;

public class Recursion1905 {
	private static int sum(int n) {
		if (n < 1) {
			return n;
		}

		return n + sum(n - 1);
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		sc.close();

		System.out.println(sum(n));
	}
}
