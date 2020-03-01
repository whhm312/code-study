package practices.hackerrank.easy;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;

import org.junit.Test;

public class JavaAnagrams {
	static boolean isAnagram(String a, String b) {
		a = a.toLowerCase();
		b = b.toLowerCase();

		char[] charA = a.toCharArray();
		char[] charB = b.toCharArray();

		Arrays.sort(charA);
		Arrays.sort(charB);

		a = String.valueOf(charA);
		b = String.valueOf(charB);
		return a.equals(b);
	}

	@Test
	public void test1() {
		String a = "anagram";
		String b = "margana";
		assertTrue(isAnagram(a, b));
	}

	@Test
	public void test2() {
		String a = "anagramm";
		String b = "marganaa";
		assertFalse(isAnagram(a, b));
	}

	@Test
	public void test3() {
		String a = "hello";
		String b = "Hello";
		assertTrue(isAnagram(a, b));
	}
}
