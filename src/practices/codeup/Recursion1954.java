package practices.codeup;

import java.util.Scanner;

public class Recursion1954 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		sc.close();

		print(n);
	}

	private static void print(int n) {
		if (n == 0) {
			return;
		}

		print(n - 1);
		oneLineStars(n);

		System.out.println("");

	}

	private static void oneLineStars(int n) {
		if (n == 0) {
			return;
		}

		oneLineStars(n - 1);

		System.out.print("*");
	}
}
