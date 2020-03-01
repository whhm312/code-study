package practices.programmers.level1;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * 자릿수 더하기
 * 
 * @author hyemin
 *
 */
public class Solution12931 {
	public int solution(int num) {
		int answer = 0;
		String strNum = String.valueOf(num);
		for (int i = 0; i < strNum.length(); i++) {
			answer += Integer.parseInt(String.valueOf(strNum.charAt(i)));
		}
		return answer;
	}

	public int better(int n) {
		int answer = 0;

		while (n != 0) {
			answer += n % 10;
			n /= 10;
		}

		return answer;
	}

	@Test
	public void basicTest1() {
		Solution12931 sol = new Solution12931();
		int n = 123;
		int actual = 6;
		assertEquals(sol.solution(n), actual);
	}

	@Test
	public void basicTest2() {
		Solution12931 sol = new Solution12931();
		int n = 987;
		int actual = 24;
		assertEquals(sol.solution(n), actual);
	}
}
