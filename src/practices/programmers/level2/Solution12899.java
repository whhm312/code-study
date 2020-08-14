package practices.programmers.level2;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class Solution12899 {
	public String solution(int n) {
		if (n < 3) {
			return n + "";
		}

		String answer = "";
		if (n % 3 == 0) {
			answer = answer + "4";
		} else if (n % 3 == 2) {
			answer = answer + "2";
		} else if (n % 3 == 1) {
			answer = answer + "1";
		}
		return answer;
	}

	@Test
	public void test1() {
		String expected = "1";
		int n = 1;
		assertEquals(expected, solution(n));
	}

	@Test
	public void test2() {
		String expected = "2";
		int n = 2;
		assertEquals(expected, solution(n));
	}

	@Test
	public void test3() {
		String expected = "4";
		int n = 3;
		assertEquals(expected, solution(n));
	}

	@Test
	public void test4() {
		String expected = "11";
		int n = 4;
		assertEquals(expected, solution(n));
	}

	@Test
	public void test5() {
		String expected = "21";
		int n = 7;
		assertEquals(expected, solution(n));
	}

	@Test
	public void test6() {
		String expected = "42";
		int n = 11;
		assertEquals(expected, solution(n));
	}
}
