package practices.hackerrank.medium;

import static org.junit.Assert.assertArrayEquals;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

import org.junit.Test;

public class JavaBigDecimal {

	public static void main(String[] args) {
		// Input
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		String[] s = new String[n + 2];
		for (int i = 0; i < n; i++) {
			s[i] = sc.next();
		}
		sc.close();

		s = mine(n, s);

		better(s);

		theBest(n, s);

		// Output
		for (int i = 0; i < n; i++) {
			System.out.println(s[i]);
		}
	}

	private static void theBest(int n, String[] s) {
		Arrays.sort(s, 0, n, (x, y) -> (new BigDecimal(y)).compareTo(new BigDecimal(x)));
	}

	private static void better(String[] s) {
		Arrays.sort(s, Collections.reverseOrder(new Comparator<String>() {
			@Override
			public int compare(String a1, String a2) {
				BigDecimal a = new BigDecimal(a1);
				BigDecimal b = new BigDecimal(a2);
				return a.compareTo(b);
			}
		}));
	}

	public static String[] mine(int n, String[] s) {
		java.util.List<BigDecimal> list = new java.util.ArrayList<BigDecimal>();
		for (int i = 0; i < n; i++) {
			list.add(BigDecimal.valueOf(Double.parseDouble(s[i])));
		}

		java.util.Collections.sort(list);
		java.util.Collections.reverse(list);

		String[] newArray = new String[list.size()];
		int idx = 0;
		for (BigDecimal dec : list) {
			for (int i = 0; i < s.length; i++) {
				if (!"".equals(s[i])) {
					if (dec.compareTo(BigDecimal.valueOf(Double.parseDouble(s[i]))) == 0) {
						newArray[idx++] = s[i];
						s[i] = "";
						break;
					}
				}
			}
		}
		s = newArray.clone();
		return s;
	}

	@Test
	public void test() {
		String[] array = { "-100", "50", "0", "56.6", "90", "0.12", ".12", "02.34", "000.000" };
		String[] expecteds = { "90", "56.6", "50", "02.34", "0.12", ".12", "0", "000.000", "-100" };
		assertArrayEquals(expecteds, sort(array));
	}

	private String[] sort(String[] s) {
		List<BigDecimal> list = new ArrayList<BigDecimal>();
		for (String str : s) {
			list.add(BigDecimal.valueOf(Double.parseDouble(str)));
		}

		Collections.sort(list);
		Collections.reverse(list);

		String[] newArray = new String[list.size()];
		int idx = 0;
		for (BigDecimal dec : list) {
			for (int i = 0; i < s.length; i++) {
				if (!"".equals(s[i])) {
					if (dec.compareTo(BigDecimal.valueOf(Double.parseDouble(s[i]))) == 0) {
						newArray[idx++] = s[i];
						s[i] = "";
						break;
					}
				}
			}
		}
		s = newArray.clone();
		return s;
	}

	@Test
	public void testPrintCompareTo() {
		String x = "59.3";
		String y = "59.2";
		System.out.println(new BigDecimal(y).compareTo(new BigDecimal(x)));
	}
}
