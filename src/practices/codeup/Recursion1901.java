package practices.codeup;

import java.util.Scanner;

public class Recursion1901 {
	private static void print(int k) {
		if (k < 1) {
			return;
		}

		print(k - 1);
		System.out.println(k);
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int k = sc.nextInt();
		sc.close();

		print(k);
	}

}
