package practices.hackerrank.easy;

import static org.junit.Assert.assertArrayEquals;

import java.util.Scanner;
import java.util.regex.Pattern;

import org.junit.Test;

public class JavaStringTokens {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String s = scan.nextLine();
		printStringTokens(s);
		scan.close();
	}

	private static void printStringTokens(String s) {
		try {
			String[] splits = split(s);
			System.out.println(splits.length);
			for (int i = 0; i < splits.length; i++) {
				System.out.println(splits[i]);
			}
		} catch (Exception e) {
		}
	}

	private static String[] split(String s) throws Exception {
		s = s.trim();
		if (s.isEmpty()) {
			return new String[0];
		}
		if (s.length() > 400000) {
			throw new Exception("Out Of String Length.");
		}

		String matches = "[ !,?._'@]+";
		Pattern pattern = Pattern.compile(matches);
		return pattern.split(s);
	}

	@Test
	public void testSplits() throws Exception {
		String s = "He is a very very good boy, isn't he?";
		String[] expecteds = { "He", "is", "a", "very", "very", "good", "boy", "isn", "t", "he" };
		assertArrayEquals(expecteds, split(s));
	}

	@Test
	public void test1() throws Exception {
		String s = "hh";
		String[] expecteds = { "hh" };
		assertArrayEquals(expecteds, split(s));
	}

	@Test
	public void test2() throws Exception {
		String s = "hh. dd  sd";
		String[] expecteds = { "hh", "dd", "sd" };
		assertArrayEquals(expecteds, split(s));
	}

	@Test
	public void test3() throws Exception {
		String s = "a@b..C ";
		String[] expecteds = { "a", "b", "C" };
		assertArrayEquals(expecteds, split(s));
	}

	@Test
	public void test4() throws Exception {
		String s = "";
		String[] expecteds = {};
		assertArrayEquals(expecteds, split(s));
	}
}
