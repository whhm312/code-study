package practices.programmers.level1;

import static org.junit.Assert.assertEquals;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

import practices.commons.Tools;

/**
 * 체육복
 * 
 * @author hyemin
 *
 */
public class Solution42862 {
	public int solution(int n, int[] lost, int[] reserve) {
		Set<Integer> setLost = Tools.createSet(lost);
		setLost.removeAll(Tools.createSet(reserve));
		Integer[] newLost = new Integer[setLost.size()];
		setLost.toArray(newLost);

		Set<Integer> setReserve = Tools.createSet(reserve);
		setReserve.removeAll(Tools.createSet(lost));
		Integer[] newReserve = new Integer[setReserve.size()];
		setReserve.toArray(newReserve);

		int attend = 0;
		for (int i = 0; i < newLost.length; i++) {
			for (int j = 0; j < newReserve.length; j++) {
				if (newLost[i] - 1 == newReserve[j] || newLost[i] + 1 == newReserve[j]) {
					newReserve[j] = -1;
					attend++;
					break;
				}
			}

		}
		return n - newLost.length + attend;
	}

	@Test
	public void testGetSet() {
		int[] array = { 0, 1, 2, 3, 4, 5 };
		Set<Integer> expected = new HashSet<Integer>();
		for (int i = 0; i < array.length; i++) {
			expected.add(array[i]);
		}

		assertEquals(expected, Tools.createSet(array));
	}

	@Test
	public void test1() {
		int n = 5;
		int[] lost = { 2, 4 };
		int[] reserve = { 1, 3, 5 };
		int expected = 5;
		assertEquals(expected, solution(n, lost, reserve));
	}

	@Test
	public void test2() {
		int n = 5;
		int[] lost = { 2, 4 };
		int[] reserve = { 3 };
		int expected = 4;
		assertEquals(expected, solution(n, lost, reserve));
	}

	@Test
	public void test3() {
		int n = 3;
		int[] lost = { 3 };
		int[] reserve = { 1 };
		int expected = 2;
		assertEquals(expected, solution(n, lost, reserve));
	}

	@Test
	public void test4() {
		int n = 10;
		int[] lost = { 3, 9, 10 };
		int[] reserve = { 3, 8, 9 };
		int expected = 9;
		assertEquals(expected, solution(n, lost, reserve));
	}
}
