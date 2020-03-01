package practices.hackerrank.easy;

import java.util.Scanner;
import java.util.regex.Pattern;

public class PatternSyntaxChecker {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int testCases = Integer.parseInt(in.nextLine());
		String[] results = new String[testCases];

		String inputPattern = null;
		for (int i = 0; i < results.length; i++) {
			inputPattern = in.nextLine();
			try {
				Pattern.compile(inputPattern);
				results[i] = "Valid";
			} catch (Exception e) {
				results[i] = "Invalid";
			}
		}
		in.close();

		for (int i = 0; i < results.length; i++) {
			System.out.println(results[i]);
		}
	}
}
