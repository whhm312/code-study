package practices.programmers.kakao;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

/**
 * [2020카카오공채] 문자열 압축
 * 
 * @author hyemin
 *
 */
public class Solution60057 {
	public int solution(String str) {
		if (str.length() < 2) {
			return 1;
		}

		int size = str.length() / 2;
		int[] compressLengths = new int[size];
		int gap = 1;
		for (int i = 0; i < size; i++) {
			compressLengths[i] = toString(merge(split(str, gap++))).length();
		}
		Arrays.sort(compressLengths);
		return compressLengths[0];
	}

	private String[] split(String s, int gap) {
		int beginIndex = 0;
		int endIndex = gap;
		List<String> list = new ArrayList<String>();
		while (beginIndex < s.length()) {
			if (endIndex >= s.length()) {
				list.add(s.substring(beginIndex));
			} else {
				list.add(s.substring(beginIndex, endIndex));
			}

			beginIndex += gap;
			endIndex += gap;
		}
		String[] strArray = new String[list.size()];
		return list.toArray(strArray);
	}

	public String[] merge(String[] array) {
		int cnt = 1;
		List<String> list = new ArrayList<String>();
		for (int i = 0; i < array.length; i++) {
			cnt = 1;
			for (int j = i + 1; j < array.length; j++) {
				if (array[i].equals(array[j])) {
					cnt++;
				} else {
					break;
				}
			}

			if (cnt > 1) {
				list.add(cnt + array[i]);
				i += cnt - 1;
			} else {
				list.add(array[i]);
			}
		}

		String[] answers = new String[list.size()];
		return list.toArray(answers);
	}

	private String toString(String[] array) {
		String answer = "";
		for (int i = 0; i < array.length; i++) {
			answer += array[i];
		}
		return answer;
	}

	private int compress(String s) {
		int loopCnt = s.length() / 2;
		int[] compressLengths = new int[loopCnt];
		int gap = 1;
		for (int i = 0; i < loopCnt; i++) {
			compressLengths[i] = toString(merge(split(s, gap++))).length();
		}
		Arrays.sort(compressLengths);
		return compressLengths[0];
	}

	@Test
	public void testCompress() {
		String s = "aabbaccczx";
		int expected = 9;
		assertEquals(expected, compress(s));
	}

	@Test
	public void testCompressLengthes() {
		String s = "aabbaccczx";
		int loopCnt = s.length() / 2;
		int[] compressLengths = new int[loopCnt];
		int gap = 1;
		for (int i = 0; i < loopCnt; i++) {
			compressLengths[i] = toString(merge(split(s, gap++))).length();
		}
		Arrays.sort(compressLengths);
		assertArrayEquals(new int[] { 9, 10, 10, 10, 10 }, compressLengths);
	}

	@Test
	public void testCompressLengthes2() {
		String s = "aabbaccc";
		int loopCnt = s.length() / 2;
		int[] compressLengths = new int[loopCnt];
		int gap = 1;
		for (int i = 0; i < loopCnt; i++) {
			compressLengths[i] = toString(merge(split(s, gap++))).length();
		}
		Arrays.sort(compressLengths);
		assertArrayEquals(new int[] { 7, 8, 8, 8 }, compressLengths);
	}

	@Test
	public void testToString() {
		String[] array = { "a", "a", "b", "b", "a", "c", "c", "c" };
		String expected = "2a2ba3c";
		assertEquals(expected, toString(merge(array)));
	}

	@Test
	public void testMerge1() {
		String[] array = { "a", "a", "b", "b", "a", "c", "c", "c" };
		String[] expecteds = { "2a", "2b", "a", "3c" };
		assertArrayEquals(expecteds, merge(array));
	}

	@Test
	public void testMerge2() {
		String s = "ababcdcdababcdcd";
		String[] array = split(s, 2);
		String[] expecteds = { "2ab", "2cd", "2ab", "2cd" };
		assertArrayEquals(expecteds, merge(array));
	}

	@Test
	public void testSplitBy1() {
		String s = "aabbaccc";
		int gap = 1;
		String[] expecteds = { "a", "a", "b", "b", "a", "c", "c", "c" };
		assertArrayEquals(expecteds, split(s, gap));
	}

	@Test
	public void testSplitBy2() {
		String s = "aabbacccz";
		int gap = 2;
		String[] expecteds = { "aa", "bb", "ac", "cc", "z" };
		assertArrayEquals(expecteds, split(s, gap));
	}

	@Test
	public void testSplitBy3() {
		String s = "aabbaccczx";
		int gap = 3;
		String[] expecteds = { "aab", "bac", "ccz", "x" };
		assertArrayEquals(expecteds, split(s, gap));
	}

	@Test
	public void testSplitBy4() {
		String s = "aabbaccczx";
		int gap = 4;
		String[] expecteds = { "aabb", "accc", "zx" };
		assertArrayEquals(expecteds, split(s, gap));
	}

	@Test
	public void test1() {
		String s = "aabbaccc";
		int expected = 7;
		assertEquals(expected, solution(s));
	}

	@Test
	public void test2() {
		String s = "ababcdcdababcdcd";
		int expected = 9;
		assertEquals(expected, solution(s));
	}

	@Test
	public void test3() {
		String s = "abcabcdede";
		int expected = 8;
		assertEquals(expected, solution(s));
	}

	@Test
	public void test4() {
		String s = "abcabcabcabcdededededede";
		int expected = 14;
		assertEquals(expected, solution(s));
	}

	@Test
	public void test5() {
		String s = "xababcdcdababcdcd";
		int expected = 17;
		assertEquals(expected, solution(s));
	}

	@Test
	public void test6() {
		String s = "x";
		int expected = 1;
		assertEquals(expected, solution(s));
	}
}
