package practices.hackerrank.interview;

import static org.junit.Assert.assertEquals;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.Test;

public class RepeatedString {

	@Test
	public void test1() {
		long expected = 7;
		String s = "aba";
		long n = 10;
		assertEquals(expected, repeatedString(s, n));
	}

	@Test
	public void test2() {
		long expected = 1000000000000L;
		String s = "a";
		long n = 1000000000000L;
		assertEquals(expected, repeatedString(s, n));
	}

	static long repeatedString(String s, long n) {
		long result = 0L;
		int length = s.length();

		Pattern pattern = Pattern.compile("a");
		Matcher matcher = pattern.matcher(s);
		while (matcher.find())
			result++;

		result = result * (n / length);

		long mod = n % length;
		if (mod != 0) {
			String addStr = s.substring(0, (int) mod);

			matcher = pattern.matcher(addStr);

			while (matcher.find())
				result++;
		}
		return result;
	}
}
