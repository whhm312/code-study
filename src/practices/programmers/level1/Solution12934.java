package practices.programmers.level1;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * 정수 제곱근 판별
 * 
 * @author hyemin
 *
 */
public class Solution12934 {
	public long solution(long num) {
		double sqrtNum = Math.sqrt(num);
		if (sqrtNum - Math.floor(sqrtNum) == 0.0) {
			return (long) Math.pow((sqrtNum + 1), 2);
		} else {
			return -1;
		}
	}

	@Test
	public void test1() {
		Solution12934 sol = new Solution12934();
		long n = 121;
		long actual = 144;
		assertEquals(actual, sol.solution(n));
	}

	@Test
	public void test2() {
		Solution12934 sol = new Solution12934();
		long n = 3;
		long actual = -1;
		assertEquals(actual, sol.solution(n));
	}
}
