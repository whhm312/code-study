package practices.programmers.level1;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import org.junit.Test;

/**
 * 정수 내림차순으로 배치하기
 * 
 * @author hyemin
 *
 */
public class Solution12933 {
	public long solution(long n) {
		String[] array = String.valueOf(n).split("");
		Arrays.sort(array);

		String newSort = "";
		int count = array.length - 1;
		for (int i = count; i > -1; i--) {
			newSort += array[i];
		}

		return Long.parseLong(newSort);
	}

	@Test
	public void test() {
		Solution12933 sol = new Solution12933();
		long n = 118372;
		long actual = 873211;
		assertEquals(sol.solution(n), actual);
	}
}
