package practices.codeup;

import java.util.Scanner;

public class Recursion1917 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		sc.close();

		System.out.println(po(n, k));
	}

	private static long po(int n, int k) {
		if (n == 1) {
			return 1;
		} else if (n == -1) {
			return k % 2 == 0 ? 1 : -1;
		}

		if (k < 1) {
			return 1;
		} else if (k == 1) {
			return n;
		}

		return n * po(n, k - 1);
	}
}
