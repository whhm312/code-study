package practices.codeup;

import java.util.Scanner;

public class Recursion1902 {
	private static void print(int start, int end) {
		if (start > end) {
			return;
		}

		System.out.print(start % 2 == 1 ? start + " " : "");
		print(start + 1, end);
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int start = sc.nextInt();
		int end = sc.nextInt();
		sc.close();

		print(start, end);
	}

}
