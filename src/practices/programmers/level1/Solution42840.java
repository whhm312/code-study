package practices.programmers.level1;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

/**
 * 모의고사
 * 
 * @author hyemin
 *
 */
public class Solution42840 {
	private final static int[] FIRST = { 1, 2, 3, 4, 5 };
	private final static int[] SECOND = { 2, 1, 2, 3, 2, 4, 2, 5 };
	private final static int[] THIRD = { 3, 3, 1, 1, 2, 2, 4, 4, 5, 5 };

	public int[] solution(int[] answers) {
		int firstResult = matches(FIRST, answers);
		int secondResult = matches(SECOND, answers);
		int thirdResult = matches(THIRD, answers);
		int[] results = { firstResult, secondResult, thirdResult };
		int maxValue = getMaxNumber(results);
		results = getMatchedValues(results, maxValue);

		results = Arrays.stream(results).filter(e -> e > 0).toArray();
		if (results.length < 1) {
			return new int[] { 1, 2, 3 };
		}

		int[] ranks = new int[results.length];
		for (int i = 0; i < results.length; i++) {
			if (results[i] == firstResult) {
				ranks[i] = 1;
				firstResult = -1;
			} else if (results[i] == secondResult) {
				ranks[i] = 2;
				secondResult = -1;
			} else if (results[i] == thirdResult) {
				ranks[i] = 3;
				thirdResult = -1;
			}
		}

		Arrays.sort(ranks);
		return ranks;
	}

	private int matches(int[] patterns, int[] answers) {
		int correction = 0;
		int[] newPattern = append(patterns, answers.length);
		for (int i = 0; i < answers.length; i++) {
			if (newPattern[i] == answers[i]) {
				correction++;
			}
		}

		return correction;
	}

	private int[] append(int[] array, int length) {
		String arrayStr = "";
		for (int i = 0; i < array.length; i++) {
			arrayStr += array[i];
		}

		int[] newArray = new int[length];
		int beginIndex = 0;
		for (int i = 0; i < length; i++) {
			if (beginIndex >= arrayStr.length()) {
				beginIndex = 0;
			}
			newArray[i] = Integer.parseInt(arrayStr.substring(beginIndex++, beginIndex));
		}
		return newArray;
	}

	private int getMaxNumber(int[] array) {
		int max = 0;
		for (int i = 0; i < array.length; i++) {
			if (max < array[i]) {
				max = array[i];
			}
		}
		return max;
	}

	private int[] getMatchedValues(int[] array, int value) {
		List<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i < array.length; i++) {
			if (array[i] == value) {
				list.add(array[i]);
			}
		}

		int idx = 0;
		int[] answer = new int[list.size()];
		for (Integer val : list) {
			answer[idx++] = val;
		}

		return answer;
	}

	@Test
	public void tstGetMatchedValues() {
		int[] array = { 1, 1, 2, 3, 4 };
		int[] expecteds = { 4 };
		assertArrayEquals(expecteds, getMatchedValues(array, 4));
	}

	@Test
	public void testGetMaxNumber() {
		int[] array = { 1, 1, 2, 3, 4 };
		int expected = 4;
		assertEquals(expected, getMaxNumber(array));
	}

	@Test
	public void testAppend() {
		int[] expecteds = { 1, 2, 3, 4, 5, 1, 2, 3, 4, 5 };
		assertArrayEquals(expecteds, append(FIRST, 10));
	}

	@Test
	public void testMatches1() {
		int[] answers = { 1, 2, 3, 4, 5 };
		int expected = 5;
		assertEquals(expected, matches(FIRST, answers));
	}

	@Test
	public void testMatches2() {
		int[] answers = { 1, 2, 3, 4, 5 };
		int expected = 0;
		assertEquals(expected, matches(SECOND, answers));
	}

	@Test
	public void testMatches3() {
		int[] answers = { 1, 2, 3, 4, 5 };
		int expected = 0;
		assertEquals(expected, matches(THIRD, answers));
	}

	@Test
	public void test1() {
		int[] answers = { 1, 2, 3, 4, 5 };
		int[] expecteds = { 1 };
		assertArrayEquals(expecteds, solution(answers));
	}

	@Test
	public void test2() {
		int[] answers = { 1, 3, 2, 4, 2 };
		int[] expecteds = { 1, 2, 3 };
		assertArrayEquals(expecteds, solution(answers));
	}
	
	@Test
	public void test3() {
		int[] answers = { 5 };
		int[] expecteds = { 1, 2, 3 };
		assertArrayEquals(expecteds, solution(answers));
	}
}
