package practices.programmers.level1;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import org.junit.Test;

/**
 * 자연수 뒤집어 배열로 만들기
 * 
 * @author hyemin
 *
 */
public class Solution12932 {
	public int[] solution(long num) {
		int[] answer = new int[String.valueOf(num).length()];
		int answerIdx = 0;
		while (num != 0) {
			answer[answerIdx++] = (int) (num % 10);
			num /= 10;
		}
		return answer;
	}

	@Test
	public void test() {
		Solution12932 sol = new Solution12932();
		long n = 12345;
		int[] actual = { 5, 4, 3, 2, 1 };
		assertEquals(Arrays.toString(sol.solution(n)), Arrays.toString(actual));
	}
}
