package practices.programmers.level1;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * 콜라츠 추측
 * 
 * @author hyemin
 *
 */
public class Solution12943 {
	public int solution(long num) {
		if (8000000 <= num) {
			return -1;
		}

		int answer = 0;
		while (num > 1 && answer < 500) {
			if (num % 2 == 0) {
				num = num / 2;
			} else {
				num = (num * 3) + 1;
			}
			answer++;
		}

		return answer == 500 ? -1 : answer;
	}

	@Test
	public void test1() {
		int num = 6;
		int expected = 8;
		assertEquals(expected, solution(num));
	}

	@Test
	public void test2() {
		int num = 626331;
		int expected = -1;
		assertEquals(expected, solution(num));
	}

	@Test
	public void test3() {
		int num = 16;
		int expected = 4;
		assertEquals(expected, solution(num));
	}

	@Test
	public void test4() {
		int num = 1;
		int expected = 0;
		assertEquals(expected, solution(num));
	}
}
