package practices.programmers.level1;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * 문자열을 정수로 바꾸기
 * 
 * @author hyemin
 *
 */
public class Solution12925 {
	public int solution(String s) {
		return Integer.parseInt(s);
	}

	@Test
	public void test() {
		Solution12925 sol = new Solution12925();
		String s = "1234";
		assertTrue(sol.solution(s) > 0);

		s = "-1234";
		assertTrue(sol.solution(s) > 0);
	}
}
