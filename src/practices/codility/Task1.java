package practices.codility;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import org.junit.Test;

public class Task1 {

	public int solution(int N) {
		int max = Integer.MIN_VALUE;
		int[] array = toArray(N);
		for (int i = 0; i < array.length; i++) {
			if (max < array[i]) {
				max = array[i];
			}
		}

		return max;
	}

	private int[] toArray(int n) {
		boolean isNegative = n < 0;
		String strN = isNegative ? (n * -1) + "" : n + "";
		int[] array = new int[strN.length() + 1];
		String start = "";
		String end = "";
		for (int i = 0; i < array.length; i++) {
			if (i == array.length - 1) {
				start = strN.substring(0, i);
				end = "";
			} else {
				start = strN.substring(0, i);
				end = strN.substring(i);
			}

			array[i] = Integer.parseInt(start + 5 + end) * (isNegative ? -1 : 1);
		}
		return array;
	}

	@Test
	public void testGetArray() {
		int N = 268;
		int[] expecteds = { 5268, 2568, 2658, 2685 };
		assertArrayEquals(expecteds, toArray(N));
	}

	@Test
	public void testArrayString() {
		int N = 268;
		String strN = N + "";
		String[] array = new String[strN.length() + 1];
		String[] expecteds = new String[strN.length() + 1];
		String start = "";
		String end = "";
		for (int i = 0; i < array.length; i++) {
			if (i == array.length - 1) {
				start = strN.substring(0, i);
				end = "";
			} else {
				start = strN.substring(0, i);
				end = strN.substring(i);
			}
			array[i] = start + 5 + end;
		}
		expecteds[0] = strN.substring(0, 0) + 5 + strN.substring(0);
		expecteds[1] = strN.substring(0, 1) + 5 + strN.substring(1);
		expecteds[2] = strN.substring(0, 2) + 5 + strN.substring(2);
		expecteds[3] = strN.substring(0, 3) + 5;

		System.out.println("expecteds : " + Arrays.toString(expecteds));
		System.out.println("array : " + Arrays.toString(array));
		assertArrayEquals(expecteds, array);

	}

	@Test
	public void test1() {
		int expected = 5268;
		int N = 268;
		assertEquals(expected, solution(N));
	}

	@Test
	public void test2() {
		int expected = -5999;
		int N = -999;
		assertEquals(expected, solution(N));
	}
}
