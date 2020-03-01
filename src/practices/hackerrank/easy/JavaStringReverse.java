package practices.hackerrank.easy;

import java.util.Scanner;

public class JavaStringReverse {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String A = sc.next();
		sc.close();

		String reverse = "";
		char[] charA = A.toCharArray();
		for (int i = charA.length - 1; i > -1; i--) {
			reverse += String.valueOf(charA[i]);
		}

		System.out.println(A.equals(reverse) ? "Yes" : "No");
	}

}
