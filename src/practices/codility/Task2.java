package practices.codility;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class Task2 {
	public int solution(int[] blocks) {
		int leftFrog = 0;
		int rightFrog = 0;

		int nextBlock = 0;
		int leftIdx = 0;
		int rightIdx = 0;

		int[] results = new int[blocks.length];
		for (int startIdx = 0; startIdx < blocks.length; startIdx++) {
			leftFrog = blocks[0];
			rightFrog = blocks[0];
			leftIdx = startIdx;
			rightIdx = startIdx;

			for (int i = startIdx; i > 0; i--) {
				leftFrog = blocks[i];
				nextBlock = blocks[i - 1];
				if (nextBlock >= leftFrog) {
					leftFrog = nextBlock;
					leftIdx = i - 1;
					continue;
				} else {
					break;
				}
			}

			for (int i = startIdx; i < blocks.length - 1; i++) {
				rightFrog = blocks[i];
				nextBlock = blocks[i + 1];
				if (nextBlock >= rightFrog) {
					rightIdx = i + 1;
					rightFrog = nextBlock;
					continue;
				} else {
					break;
				}
			}

			results[startIdx] = (rightIdx + 1) - leftIdx;
		}

		int answer = 0;
		for (int i = 0; i < results.length; i++) {
			if (answer < results[i]) {
				answer = results[i];
			}
		}
		return answer;
	}

	@Test
	public void test1() {
		int expected = 3;
		int[] blocks = { 2, 6, 8, 5 };
		assertEquals(expected, solution(blocks));
	}

	@Test
	public void test2() {
		int expected = 4;
		int[] blocks = { 1, 5, 5, 2, 6 };
		assertEquals(expected, solution(blocks));
	}

	@Test
	public void test3() {
		int expected = 2;
		int[] blocks = { 1, 1 };
		assertEquals(expected, solution(blocks));
	}
}
