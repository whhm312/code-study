package practices.programmers.cote;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class Solution12 {

	public int[] array(int p) {
		int idx = 0;
		int temp = p;
		int[] array = new int[4];
		while (temp != 0) {
			array[idx++] = temp % 10;
			temp = temp / 10;
		}
		return array;
	}

	public boolean check(int p) {
		int[] array = array(p);
		for (int i = 0; i < array.length; i++) {
			for (int j = i + 1; j < array.length; j++) {
				if (j != i && array[i] == array[j]) {
					return false;
				}
			}
		}
		return true;
	}

	public int solution(int p) {
		int temp = p + 1;
		while (!check(temp)) {
			temp++;
		}
		return temp;
	}

	@Test
	public void testToArray() {
		int[] expecteds = { 4, 3, 2, 1 };
		int p = 1234;
		assertArrayEquals(expecteds, array(p));
	}

	@Test
	public void test2() {
		int p = 2001;
		assertFalse(check(p));
	}

	@Test
	public void test3() {
		int p = 1987;
		assertTrue(check(p));
	}

	@Test
	public void test1() {
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
