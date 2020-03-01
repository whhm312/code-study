package practices.programmers.level1;

import static org.junit.Assert.assertArrayEquals;

import java.util.Arrays;

import org.junit.Test;

/**
 * 나누어 떨어지는 숫자 배열
 * 
 * @author hyemin
 *
 */
public class Solution12910 {

//	array의 각 element 중 divisor로 나누어 떨어지는 값을 오름차순으로 정렬한 배열을 반환하는 함수, solution을 작성해주세요.
//	divisor로 나누어 떨어지는 element가 하나도 없다면 배열에 -1을 담아 반환하세요.

//	arr은 자연수를 담은 배열입니다.
//	정수 i, j에 대해 i ≠ j 이면 arr[i] ≠ arr[j] 입니다.
//	divisor는 자연수입니다.
//	array는 길이 1 이상인 배열입니다.

	public int[] solution(int[] arr, int divisor) {
		int[] answer = new int[arr.length];
		int answerIdx = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] % divisor == 0) {
				answer[answerIdx++] = arr[i];
			}
		}
		if (answerIdx == 0) {
			return new int[] { -1 };
		} else {
			answer = Arrays.copyOf(answer, answerIdx);
			Arrays.sort(answer);
			return answer;
		}
	}

	public int[] better(int[] array, int divisor) {
		// ret에 array에 포함된 정수중, divisor로 나누어 떨어지는 숫자를 순서대로 넣으세요.
		return Arrays.stream(array).filter(factor -> factor % divisor == 0).toArray();
	}

	@Test
	public void testResult() {
		Solution12910 sol = new Solution12910();
		int[] arr = { 5, 9, 7, 10 };
		int divisor = 5;
		int[] actual = { 5, 10 };
		assertArrayEquals(sol.solution(arr, divisor), actual);
		arr = new int[] { 2, 36, 1, 3 };
		divisor = 1;
		actual = new int[] { 1, 2, 3, 36 };
		assertArrayEquals(sol.solution(arr, divisor), actual);
		arr = new int[] { 3, 2, 6 };
		divisor = 10;
		actual = new int[] { -1 };
		assertArrayEquals(sol.solution(arr, divisor), actual);
	}

}
