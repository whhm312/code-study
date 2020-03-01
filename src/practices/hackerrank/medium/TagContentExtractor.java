package practices.hackerrank.medium;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TagContentExtractor {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int testCases = Integer.parseInt(scan.nextLine());

		while (testCases-- > 0) {
			String line = scan.nextLine();

			boolean matchFound = false;
			Pattern r = Pattern.compile("<(.+)>([^<]+)</\\1>");
			Matcher m = r.matcher(line);

			while (m.find()) {
				System.out.println(m.group(2));
				matchFound = true;
			}
			if (!matchFound) {
				System.out.println("None");
			}
		}
		scan.close();
	}

	public void copySolution() {
		String line = null;
		boolean matchFound = false;
		String rexp = "<(.+)>([^<]+)</\\1>";
		Pattern pattern = Pattern.compile(rexp);
		Matcher matcher = null;

		Scanner scan = new Scanner(System.in);
		int testCases = Integer.parseInt(scan.nextLine());
		while (testCases-- > 0) {
			line = scan.nextLine();
			matcher = pattern.matcher(line);

			while (matcher.find()) {
				System.out.println(matcher.group(2));
				matchFound = true;
			}
			if (!matchFound) {
				System.out.println("None");
			}
			matchFound = false;
		}
		scan.close();
	}
}
