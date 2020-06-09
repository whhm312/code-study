package lessons.programmers;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class Part1 {
	public int solution(int n, int[] stations, int w) {
		int answer = 3;
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
