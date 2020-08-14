package practices.programmers.surv;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class Solution62946 {
	public int solution(int n, int[] stations, int w) {
		int[] apts = new int[n];

		// 준비 : 아파트 배열 만들기
		apts = createApts(n);

		// 1차 : stations와 affect를 -1로 만들기
		apts = removeApts(apts, stations, w);

		// 2차 : 0보다 큰 부분을 나누어 affect로 나누기 하여 몫(버림), 나머지 구함
		int start = -1;
		int end = -1;
		for (int i = 0; i < apts.length; i++) {
			if (apts[i] > 0 ) {

			}
		}
		// 3차 : 몫 + 나머지

		int answer = 3;
		return answer;
	}

	private int[] removeApts(int[] apt, int[] stations, int w) {
		for (int i = 0; i < stations.length; i++) {
			int idx = stations[i] - 1;

			for (int j = idx - w; j <= idx + w; j++) {
				if (j < 0) {
					continue;
				} else if (j >= apt.length) {
					break;
				} else {
					apt[j] = -1;
				}
			}
		}
		return apt;
	}

	private int[] createApts(int n) {
		int[] apt = new int[n];
		for (int i = 0; i < n; i++) {
			apt[i] = i + 1;
		}
		return apt;
	}

	@Test
	public void test1() {
		int expected = 3;
		int n = 11;
		int[] stations = { 4, 11 };
		int w = 1;
		assertEquals(expected, solution(n, stations, w));
	}

	@Test
	public void test2() {
		int expected = 3;
		int n = 16;
		int[] stations = { 9 };
		int w = 2;
		assertEquals(expected, solution(n, stations, w));
	}

	@Test
	public void testCreateApt() {
		int[] expecteds = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
		int n = 10;
		assertArrayEquals(expecteds, createApts(n));

		int[] expecteds2 = { 1, 2, 3, 4, 5 };
		n = 5;
		assertArrayEquals(expecteds2, createApts(n));
	}

	@Test
	public void testRemoveApts() {
		int[] expecteds = { 1, 2, -1, -1, -1, 6, 7, 8, 9, -1, -1 };
		int n = 11;
		int[] apt = createApts(n);
		int[] stations = { 4, 11 };
		int w = 1;
		assertArrayEquals(expecteds, removeApts(apt, stations, w));

		int[] expecteds2 = { 1, 2, 3, 4, 5, 6, -1, -1, -1, -1, -1, 12, 13, 14, 15, 16 };
		n = 16;
		apt = createApts(n);
		int[] stations2 = { 9 };
		w = 2;
		assertArrayEquals(expecteds2, removeApts(apt, stations2, w));
	}
}
