package practices.programmers.sw;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import org.junit.Test;

/**
 * 예산
 * 
 * @author hyemin
 *
 */
public class Solution12982 {
	public int solution(int[] d, int budget) {
		Arrays.sort(d);

		int answer = 0;
		int idx = 0;
		while (idx < d.length) {
			if ((answer + d[idx]) <= budget) {
				answer += d[idx];
			} else {
				break;
			}
			idx++;
		}
		return idx;
	}

	public int better(int[] d, int budget) {
		int answer = 0;

		Arrays.sort(d);

		for (int i = 0; i < d.length; i++) {
			budget -= d[i];

			if (budget < 0)
				break;

			answer++;
		}

		return answer;
	}

	@Test
	public void test1() {
		int[] d = { 1, 3, 2, 5, 4 };
		int budget = 9;
		int expected = 3;
		assertEquals(expected, solution(d, budget));
	}

	@Test
	public void test2() {
		int[] d = { 2, 2, 3, 3 };
		int budget = 10;
		int expected = 4;
		assertEquals(expected, solution(d, budget));
	}
}
