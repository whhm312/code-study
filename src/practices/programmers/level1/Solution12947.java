package practices.programmers.level1;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * 하샤드 수
 * 
 * @author hyemin
 *
 */
public class Solution12947 {

//	양의 정수 x가 하샤드 수이려면 x의 자릿수의 합으로 x가 나누어져야 합니다. 
//	예를 들어 18의 자릿수 합은 1+8=9이고, 18은 9로 나누어 떨어지므로 18은 하샤드 수입니다. 
//	자연수 x를 입력받아 x가 하샤드 수인지 아닌지 검사하는 함수, solution을 완성해주세요.
	public boolean solution(int x) {
		String strX = String.valueOf(x);
		int sum = 0;
		for (int i = 0; i < strX.length(); i++) {
			sum += Integer.parseInt(strX.substring(i, i + 1));
		}

		if (sum < x) {
			int temp = sum;
			sum = x;
			x = temp;
		}
		return sum % x == 0;
	}

	@Test
	public void test1() {
		int x = 10;
		assertTrue(solution(x));
	}

	@Test
	public void test2() {
		int x = 12;
		assertTrue(solution(x));
	}

	@Test
	public void test3() {
		int x = 11;
		assertFalse(solution(x));
	}

	@Test
	public void test4() {
		int x = 13;
		assertFalse(solution(x));
	}
}
