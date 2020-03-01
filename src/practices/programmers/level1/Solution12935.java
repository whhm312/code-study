package practices.programmers.level1;

import static org.junit.Assert.assertArrayEquals;

import java.util.Arrays;

import org.junit.Test;

/**
 * 제일 작은 수 제거하기
 * 
 * @author hyemin
 *
 */
public class Solution12935 {
	public int[] solution(int[] arr) {
		if (arr.length < 2) {
			return new int[] { -1 };
		}

		int minNum = 0;
		for (int i = 0; i < arr.length; i++) {
			if (i == 0) {
				minNum = arr[i];
			} else {
				if (minNum > arr[i]) {
					minNum = arr[i];
				}
			}
		}

		for (int i = 0; i < arr.length; i++) {
			if (minNum == arr[i]) {
				arr[i] = -1;
			}
		}

		return Arrays.stream(arr).filter(n -> n > 0).toArray();
	}

	public int[] solution2(int[] arr) {
		if (arr.length < 2) {
			return new int[] { -1 };
		}

		int minNum = 0;
		for (int i = 0; i < arr.length; i++) {
			if (i == 0) {
				minNum = arr[i];
			} else {
				if (minNum > arr[i]) {
					minNum = arr[i];
				}
			}
		}

		for (int i = 0; i < arr.length; i++) {
			if (minNum == arr[i]) {
				arr[i] = -1;
			}
		}

		int[] answer = new int[arr.length - 1];
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] > 0) {
				answer[i] = arr[i];
			}
		}
		return answer;
	}

	@Test
	public void test1_1() {
		Solution12935 sol = new Solution12935();
		int[] arr = { 4, 3, 2, 1 };
		int[] expecteds = { 4, 3, 2 };
		assertArrayEquals(expecteds, sol.solution(arr));
	}

	@Test
	public void test1_2() {
		Solution12935 sol = new Solution12935();
		int[] arr = { 4, 3, 2, 1 };
		int[] expecteds = { 4, 3, 2 };
		assertArrayEquals(expecteds, sol.solution2(arr));
	}

	@Test
	public void test2() {
		Solution12935 sol = new Solution12935();
		int[] arr = { 10 };
		int[] expecteds = { -1 };
		assertArrayEquals(expecteds, sol.solution(arr));
	}

}
