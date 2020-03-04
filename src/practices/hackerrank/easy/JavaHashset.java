package practices.hackerrank.easy;

import static org.junit.Assert.assertEquals;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

import org.junit.Test;

public class JavaHashset {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int t = s.nextInt();
		String[] pair_left = new String[t];
		String[] pair_right = new String[t];

		for (int i = 0; i < t; i++) {
			pair_left[i] = s.next();
			pair_right[i] = s.next();
		}
		s.close();

		int[] result = new int[t];
		Set<String> hashset = new LinkedHashSet<String>();
		for (int i = 0; i < t; i++) {
			hashset.add(pair_left[i] + " " + pair_right[i]);
			result[i] = hashset.size();
		}

		for (int i = 0; i < result.length; i++) {
			System.out.println(result[i]);
		}
	}

	private static Set<String> add(Set<String> hashset, String val) {
		hashset.add(val);
		return hashset;
	}

	@Test
	public void testAdd() {
		Set<String> hashset = new LinkedHashSet<String>();
		add(hashset, "john tom");
		add(hashset, "john mary");
		add(hashset, "john tom");

		Set<String> expecteds = new LinkedHashSet<String>();
		expecteds.add("john tom");
		expecteds.add("john mary");
		expecteds.add("john tom");
		assertEquals(expecteds, hashset);
	}

	@Test
	public void testLinkedHashSet() {
		Set<String> hashset = new LinkedHashSet<String>();
		hashset.add("john tom");
		hashset.add("john mary");
		hashset.add("john tom");

		String expected = "[john tom, john mary]";
		assertEquals(expected, hashset.toString());
	}

}
