package practices.codeup;

import java.util.Scanner;

public class Recursion1367 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		sc.close();

		printStars(n, 0, n);
	}

	private static void printStars(int n, int idx, int totalStar) {
		if (n == 0) {
			return;
		}

		printSpace(n - 1, idx);

		oneLineStars(totalStar);

		System.out.println("");

		printStars(n - 1, idx++, totalStar);
	}

	private static void printSpace(int n, int idx) {
		if (n == idx) {
			return;
		}
		System.out.print(" ");
		printSpace(n - 1, idx);
	}

	private static void oneLineStars(int totalStar) {
		if (totalStar == 0) {
			return;
		}

		System.out.print("*");
		oneLineStars(totalStar - 1);
	}
}
