package lessons.programmers;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import org.junit.Test;

public class Part4 {

	public int solution(int[] A, int[] B) {
		Arrays.sort(A);
		Arrays.sort(B);

		int bIdx = B.length - 1;
		int answer = 0;

		for (int i = A.length - 1; i >= 0; i--) {
			if (A[i] < B[bIdx]) {
				bIdx--;
				answer++;
			}
		}
		return answer;
	}

	@Test
	public void test1() {
		int expected = 3;
		int[] A = { 5, 1, 3, 7 };
		int[] B = { 2, 2, 6, 8 };
		assertEquals(expected, solution(A, B));
	}

	@Test
	public void test2() {
		int expected = 0;
		int[] A = { 2, 2, 2, 2 };
		int[] B = { 1, 1, 1, 1 };
		assertEquals(expected, solution(A, B));
	}
}
