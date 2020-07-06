package practices.codeup;

import java.util.Scanner;

public class Recursion1912 {
	private static int factorier(int n) {
		if (n == 1) {
			return n;
		}

		return n * factorier(n - 1);
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		sc.close();

		System.out.println(factorier(n));
	}
}
