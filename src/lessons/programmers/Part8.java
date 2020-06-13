package lessons.programmers;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class Part8 {
	public int solution(int[][] triangle) {
		for (int i = triangle.length - 2; i >= 0; i--) {
			for (int j = 0; j < triangle[i].length; j++) {
				int left = triangle[i + 1][j] + triangle[i][j];
				int right = triangle[i + 1][j + 1] + triangle[i][j];
				triangle[i][j] = Math.max(left, right);
			}
		}
		return triangle[0][0];
	}

	public int solutionTopDown(int[][] triangle) {
		int answer = 0;
		for (int i = 1; i < triangle.length; i++) {
			for (int j = 0; j < triangle[i].length; j++) {
				if (j == 0) {
					// 제일 왼쪽인경우
					triangle[i][j] = triangle[i - 1][j] + triangle[i][j];
				} else if (i == j) {
					// 제일 오른쪽인경우
					triangle[i][j] = triangle[i - 1][j - 1] + triangle[i][j];
				} else {
					// 가운데 인 경우
					int left = triangle[i - 1][j - 1] + triangle[i][j];
					int right = triangle[i - 1][j] + triangle[i][j];
					triangle[i][j] = Math.max(left, right);
				}

				answer = Math.max(answer, triangle[i][j]);
			}
		}
		return answer;
	}

	@Test
	public void test1() {
		int expected = 30;
		int[][] triangle = { { 7 }, { 3, 8 }, { 8, 1, 0 }, { 2, 7, 4, 4 }, { 4, 5, 2, 6, 5 } };
		assertEquals(expected, solution(triangle));
	}
}
