package practices.hackerrank.easy;

import java.util.Scanner;

public class JavaStringsIntroduction {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		String A = sc.next();
		String B = sc.next();
		sc.close();

		int totalLength = A.length() + B.length();
		String campare = isGreater(A, B);
		String capitalized = capitalize(A) + " " + capitalize(B);

		System.out.println(totalLength);
		System.out.println(campare);
		System.out.println(capitalized);
	}

	private static String capitalize(String str) {
		return String.valueOf(str.charAt(0)).toUpperCase() + str.substring(1);
	}

	private static String isGreater(String a, String b) {
		char firstA = a.charAt(0);
		char firstB = b.charAt(0);
		return firstA > firstB ? "Yes" : "No";
	}
}
