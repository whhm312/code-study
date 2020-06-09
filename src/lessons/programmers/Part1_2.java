package lessons.programmers;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class Part1_2 {
	public int solution(int n, int[] stations, int w) {
		int answer = 0;
		int stationIdx = 0;
		int position = 1;
		while (position <= n) {
			if (stationIdx < stations.length && stations[stationIdx] - w <= position) {
				position = stations[stationIdx] + w + 1;
				stationIdx = stationIdx + 1;
			} else {
				answer++;
				position += w + 1 + w;
			}
		}
		return answer;
	}

	@Test
	public void test1() {
		int expected = 3;
		int n = 11;
		int w = 1;
		int[] stations = { 4, 11 };
		assertEquals(expected, solution(n, stations, w));
	}

	@Test
	public void test2() {
		int expected = 3;
		int n = 16;
		int w = 2;
		int[] stations = { 9 };
		assertEquals(expected, solution(n, stations, w));
	}
}
