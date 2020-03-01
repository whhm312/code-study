package practices.programmers.level1;

import static org.junit.Assert.assertArrayEquals;

import org.junit.Test;

/**
 * 행렬의 덧셈
 * 
 * @author hyemin
 *
 */
public class Solution12950 {
	public int[][] solution(int[][] arr1, int[][] arr2) {
		int iLength = arr1.length;
		int kLength = arr1[0].length;
		int[][] answer = new int[iLength][kLength];
		for (int i = 0; i < iLength; i++) {
			for (int k = 0; k < kLength; k++) {
				answer[i][k] = arr1[i][k] + arr2[i][k];
			}
		}
		return answer;
	}

	@Test
	public void test1() {
		int[][] arr1 = { { 1, 2 }, { 2, 3 } };
		int[][] arr2 = { { 3, 4 }, { 5, 6 } };
		int[][] expecteds = { { 4, 6 }, { 7, 9 } };
		assertArrayEquals(expecteds, solution(arr1, arr2));
	}

	@Test
	public void test2() {
		int[][] arr1 = { { 1 }, { 2 } };
		int[][] arr2 = { { 3 }, { 4 } };
		int[][] expecteds = { { 4 }, { 6 } };
		assertArrayEquals(expecteds, solution(arr1, arr2));
	}
}
