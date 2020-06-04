package practices.programmers.cote;

import static org.junit.Assert.assertEquals;

import java.util.LinkedList;
import java.util.Queue;

import org.junit.Test;

public class Solution21 {
	public long solution(long n) {
		Queue<Long> queue = new LinkedList<Long>();
		while (n != 0) {
			queue.add(n % 2);
			n /= 2;
		}

		long answer = 0;
		long sum = 1;
		while (!queue.isEmpty()) {
			answer += queue.peek() * sum;
			sum *= 3;
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
