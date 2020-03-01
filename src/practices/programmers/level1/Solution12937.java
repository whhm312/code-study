package practices.programmers.level1;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class Solution12937 {
	public String solution(int num) {
		if (num % 2 == 0) {
			return "Even";
		} else {
			return "Odd";
		}
	}

	@Test
	public void test1() {
		Solution12937 sol = new Solution12937();
		int num = 3;
		String expected = "Odd";
		assertEquals(expected, sol.solution(num));
	}

	@Test
	public void test2() {
		Solution12937 sol = new Solution12937();
		int num = 4;
		String expected = "Even";
		assertEquals(expected, sol.solution(num));
	}
}
