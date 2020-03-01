package practices.programmers.level1;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * 약수의 합
 * 
 * @author hyemin
 *
 */
public class Solution12928 {
	public int solution(int n) {
		int result = 0;
		for (int i = 1; i <= n; i++) {
			if (n % i == 0) {
				result += i;
			}
		}
		return result;
	}

	@Test
	public void test1() {
		Solution12928 sol = new Solution12928();
		int n = 12;
		int actual = 28;
		assertEquals(sol.solution(n), actual);
	}

	@Test
	public void test2() {
		Solution12928 sol = new Solution12928();
		int n = 5;
		int actual = 6;
		assertEquals(sol.solution(n), actual);
	}
}
