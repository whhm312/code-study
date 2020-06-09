package code.test.programmers;

import static org.junit.Assert.assertEquals;

import java.util.LinkedList;
import java.util.Queue;

import org.junit.Test;

public class Solution22 {
	public long solution(long n) {
		long answer = 0;
		long temp = n;

		Queue<Long> queue = new LinkedList<Long>();
		while (temp != 0) {
			queue.add(temp % 2);
			temp /= 2;
		}

		temp = 1;
		while (!queue.isEmpty()) {
			answer += queue.peek() * temp;
			temp *= 3;

			queue.poll();
		}

		return answer;
	}

	@Test
	public void test1() {
		long expected = 9;
		long n = 4;
		assertEquals(expected, solution(n));
	}

	@Test
	public void test2() {
		long expected = 31;
		long n = 11;
		assertEquals(expected, solution(n));
	}
}
