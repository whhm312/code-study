package practices.codeup;

import java.util.Scanner;

public class Recursion1929 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		sc.close();

		print(n);
	}

	private static void print(int n) {
		if (n == 1) {
			System.out.println(n);
			return;
		}

		if (n % 2 == 0) {
			print(n / 2);
		} else {
			print((3 * n) + 1);
		}

		System.out.println(n);
	}
}
