package lessons.programmers;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class Part3 {

	public int solution(int[] budgets, int M) {
		int min = 0;
		int max = 0;
		for (int b : budgets) {
			if (b > max) {
				max = b;
			}
		}

		int answer = 0;
		while (min <= max) {
			int mid = (min + max) / 2;

			int sum = 0;
			for (int b : budgets) {
				if (b > mid) {
					sum += mid;
				} else {
					sum += b;
				}
			}

			if (sum <= M) {
				min = mid + 1;
				answer = mid;
			} else {
				max = mid - 1;
			}
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
