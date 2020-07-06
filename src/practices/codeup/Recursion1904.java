package practices.codeup;

import java.util.Scanner;

public class Recursion1904 {
	private static void print(int k) {
		if (k < 1) {
			return;
		}

		System.out.println(k);
		print(k - 1);
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int k = sc.nextInt();
		sc.close();

		print(k);
	}

}
