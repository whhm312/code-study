package practices.programmers.level2;

import static org.junit.Assert.assertArrayEquals;

import org.junit.Test;

public class Solution42584 {
	public int[] solution(int[] prices) {
		int count = 0;
		int[] answer = new int[prices.length];
		for (int i = 0; i < prices.length; i++) {
			for (int j = i; j < prices.length; j++) {
				if (prices[i] <= prices[j]) {
					if (i != j) {
						count++;
					}
				} else {
					count++;
					break;
				}
			}
			answer[i] = count;
			count = 0;
		}
		return answer;
	}

	@Test
	public void test() {
		int[] expecteds = { 4, 3, 1, 1, 0 };
		int[] prices = { 1, 2, 3, 2, 3 };
		assertArrayEquals(expecteds, solution(prices));
	}
}
