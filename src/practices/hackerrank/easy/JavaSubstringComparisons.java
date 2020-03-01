package practices.hackerrank.easy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class JavaSubstringComparisons {
	public static String getSmallestAndLargest(String s, int k) {
		List<String> strs = new ArrayList<String>();
		for (int i = 0; i < s.length(); i++) {
			if (s.length() < i + k) {
				break;
			} else {
				strs.add(s.substring(i, i + k));
			}
		}

		Collections.sort(strs);
		return strs.get(0) + "\n" + strs.get(strs.size() - 1);
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String s = scan.next();
		int k = scan.nextInt();
		scan.close();

		System.out.println(getSmallestAndLargest(s, k));
	}
}
