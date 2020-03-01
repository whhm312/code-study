package practices.programmers.level1;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * 수박수박수박수박수박수?
 * 
 * @author hyemin
 *
 */
public class Solution12922 {

	public String solution(int n) {
		String answer = "";
		for (int i = 0; i < n; i++) {
			answer += (i % 2 == 0) ? "수" : "박";
		}
		return answer;
	}

	@Test
	public void test() {
		Solution12922 sol = new Solution12922();
		int n = 4;
		String actual = "수박수박";
		assertEquals(sol.solution(n), actual);

		n = 3;
		actual = "수박수";
		assertEquals(sol.solution(n), actual);
	}
}
