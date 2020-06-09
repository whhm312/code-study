package lessons.programmers;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class Part3 {

	public int solution(int[] budgets, int M) {
		int answer = 0;
		for (int i = 0; i < budgets.length; i++) {
			answer += budgets[i];
		}

		if (answer > M) {

		}
		return answer;
	}

	@Test
	public void test1() {
		int expected = 127;
		int[] budgets = { 120, 110, 140, 150 };
		int M = 485;
		assertEquals(expected, solution(budgets, M));
	}
}
