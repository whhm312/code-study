package lessons.programmers;

import static org.junit.Assert.assertEquals;

import java.util.Stack;

import org.junit.Test;

public class Part7 {
	class P {
		int open, close;

		P(int open, int close) {
			this.open = open;
			this.close = close;
		}
	}

	public int solution(int n) {
		int answer = 0;

		Stack<P> stack = new Stack<>();
		stack.push(new P(0, 0));

		while (!stack.isEmpty()) {
			P p = stack.pop();

			if (p.open > n) {
				continue;
			}
			if (p.open < p.close) {
				continue;
			}
			if (p.open + p.close == 2 * n) {
				answer++;
				continue;
			}

			stack.push(new P(p.open + 1, p.close));
			stack.push(new P(p.open, p.close + 1));
		}

		return answer;
	}

	@Test
	public void test1() {
		int expected = 2;
		int n = 2;
		assertEquals(expected, solution(n));
	}

	@Test
	public void test2() {
		int expected = 5;
		int n = 3;
		assertEquals(expected, solution(n));
	}

}
