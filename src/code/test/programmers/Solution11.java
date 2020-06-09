package code.test.programmers;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class Solution11 {

	public int[] toArray(int p) {
		int temp = p;
		int[] array = new int[4];
		int idx = 0;
		while (temp != 0) {
			array[idx++] = temp % 10;
			temp = temp / 10;
		}

		idx = 0;
		int[] result = new int[4];
		for (int i = array.length - 1; i >= 0; i--) {
			result[idx++] = array[i];
		}
		return result;
	}

	public int duplicated(int p) {
		int[] array = toArray(p);
		int result = -1;
		for (int i = 0; i < array.length; i++) {
			for (int j = i + 1; j < array.length; j++) {
				if (j != i && array[i] == array[j]) {
					return result;
				}
			}
		}
		return p;
	}

	public int solution(int p) {
		int newYear = p + 1;
		while (duplicated(newYear) < 0) {
			newYear++;
		}
		return newYear;
	}

	@Test
	public void testToArray() {
		int[] expecteds = { 1, 2, 3, 4 };
		int p = 1234;
		assertArrayEquals(expecteds, toArray(p));
	}

	@Test
	public void test1() {
		int expected = 1987;
		int p = 1987;
		assertEquals(expected, duplicated(p));
	}

	@Test
	public void test2() {
		int expected = -1;
		int p = 2001;
		assertEquals(expected, duplicated(p));
	}

	@Test
	public void test3() {
		int expected = 2013;
		int p = 1987;
		assertEquals(expected, solution(p));
	}

	@Test
	public void test4() {
		int expected = 2016;
		int p = 2015;
		assertEquals(expected, solution(p));
	}
}
