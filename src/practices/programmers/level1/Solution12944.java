package practices.programmers.level1;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class Solution12944 {
	public double solution(int[] arr) {
		double answer = 0;
		for (int i = 0; i < arr.length; i++) {
			answer += arr[i];
		}
		return answer / arr.length;
	}

	@Test
	public void test1() {
		Solution12944 sol = new Solution12944();
		int[] arr = { 1, 2, 3, 4 };
		double expected = 2.5;
		assertTrue(expected == sol.solution(arr));
	}

	@Test
	public void test2() {
		Solution12944 sol = new Solution12944();
		int[] arr = { 5, 5 };
		double expected = 5;
		assertTrue(expected == sol.solution(arr));
	}
}
