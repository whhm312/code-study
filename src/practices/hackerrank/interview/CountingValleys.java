package practices.hackerrank.interview;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class CountingValleys {
	@Test
	public void test1() {
		int expected = 1;
		int n = 8;
		String s = "UDDDUDUU";
		assertEquals(expected, countingValleys(n, s));
	}

	@Test
	public void test2() {
		int expected = 2;
		int n = 8;
		String s = "DDUUUUDD";
		assertEquals(expected, countingValleys(n, s));
	}
	@Test
	public void test3() {
		int expected = 2;
		int n = 12;
		String s = "DDUUDDUDUUUD";

		assertEquals(expected, countingValleys(n, s));
	}

	static int countingValleys(int n, String s) {
		int maxNum = 0;
		int num = 0;
		String[] array = s.split("");
		for (int i = 0; i < array.length; i++) {
			if ("U".equals(array[i])) {
				num++;
			} else if ("D".equals(array[i])) {
				num--;
			}

			if (maxNum < num) {
				maxNum = num;
			}
		}
		return maxNum;
	}

}
