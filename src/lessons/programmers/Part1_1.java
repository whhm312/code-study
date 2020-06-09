package lessons.programmers;

import static org.junit.Assert.assertEquals;

import java.util.LinkedList;
import java.util.Queue;

import org.junit.Test;

public class Part1_1 {
	public int solution(int n, int[] stations, int w) {
		int answer = 0;
		Queue<Integer> sq = new LinkedList<Integer>();
		for (int s : stations) {
			sq.offer(s);
		}

		int position = 1;
		while (position <= n) {
			if (!sq.isEmpty() && sq.peek() - w <= position) {
				position = sq.poll() + w + 1;
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
