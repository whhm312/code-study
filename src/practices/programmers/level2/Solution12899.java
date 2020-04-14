package practices.programmers.level2;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class Solution12899 {
	public String solution(int n) {
		String answer = "";
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
	
}
