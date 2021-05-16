package lessons.programmers.level2;

import java.util.HashSet;

import org.junit.Assert;
import org.junit.Test;

public class T12981 {

	/**
	 * <pre>
	 * 테스트 2 〉	통과 (0.05ms, 52.6MB)
	 * 테스트 4 〉	통과 (0.07ms, 52.3MB)
	 * 테스트 5 〉	통과 (0.08ms, 52.4MB)
	 * 테스트 20 〉	통과 (0.21ms, 52.9MB)
	 * </pre>
	 * 
	 * @param n
	 * @param words
	 * @return
	 */
	public int[] solution(int n, String[] words) {
		int[] answer = { 0, 0 };

		HashSet<String> wordsSet = new HashSet<String>();
		wordsSet.add(words[0]);

		for (int i = 1; i < words.length; i++) {
			// 본인 첫글자와, 본인 앞의 마지막 글자 비교
			if (!words[i].substring(0, 1)
					.equals(words[i - 1].substring(words[i - 1].length() - 1, words[i - 1].length()))) {
				answer[0] = (i % n) + 1;
				answer[1] = (i / n) + 1;
				return answer;
			}

			// 중복문자 찾기
			wordsSet.add(words[i]);
			if (wordsSet.size() != i + 1) {
				answer[0] = (i % n) + 1;
				answer[1] = (i / n) + 1;
				return answer;
			}
		}

		return answer;
	}

	/**
	 * <pre>
	 * 테스트 2 〉	통과 (2.07ms, 53.3MB)
	 * 테스트 4 〉	통과 (1.75ms, 52.8MB)
	 * 테스트 5 〉	통과 (1.81ms, 52.9MB)
	 * 테스트 20 〉	통과 (1.08ms, 53MB)
	 * </pre>
	 * 
	 * @param n
	 * @param words
	 * @return
	 */
	public int[] mySolution(int n, String[] words) {
		int[] answer = new int[2];
		answer[0] = 0;
		answer[1] = 0;

		for (int i = 1; i < words.length; i++) {
			// 본인 첫글자와, 본인 앞의 마지막 글자 비교
			if (!words[i].substring(0, 1)
					.equals(words[i - 1].substring(words[i - 1].length() - 1, words[i - 1].length()))) {
				answer[0] = (i + 1) % n == 0 ? n : (i + 1) % n;
				answer[1] = (int) Math.ceil((double) (i + 1) / n);
				return answer;
			}

			// 중복문자 찾기
			for (int j = 0; j < i; j++) {
				if (words[i].equals(words[j])) {
					answer[0] = (i + 1) % n == 0 ? n : (i + 1) % n;
					answer[1] = (int) Math.ceil((double) (i + 1) / n);
					return answer;
				}
			}
		}

		return answer;
	}

	@Test
	public void test1() {
		String[] words = { "tank", "kick", "know", "wheel", "land", "dream", "mother", "robot", "tank" };
		int n = 3;
		int[] expecteds = { 3, 3 };
		Assert.assertArrayEquals(expecteds, solution(n, words));
	}

	@Test
	public void test2() {
		String[] words = { "hello", "observe", "effect", "take", "either", "recognize", "encourage", "ensure",
				"establish", "hang", "gather", "refer", "reference", "estimate", "executive" };
		int n = 5;
		int[] expecteds = { 0, 0 };
		Assert.assertArrayEquals(expecteds, solution(n, words));
	}

	@Test
	public void test3() {
		String[] words = { "hello", "one", "even", "never", "now", "world", "draw" };
		int n = 2;
		int[] expecteds = { 1, 3 };
		Assert.assertArrayEquals(expecteds, solution(n, words));
	}

	@Test
	public void test4() {
		String[] words = { "a", "aba", "aba", "a" };
		int n = 4;
		int[] expecteds = { 3, 1 };
		Assert.assertArrayEquals(expecteds, solution(n, words));
	}

	@Test
	public void test5() {
		String[] words = { "abb", "baa", "ccc", "cda", "abb" };
		int n = 5;
		int[] expecteds = { 3, 1 };
		Assert.assertArrayEquals(expecteds, solution(n, words));
	}

	@Test
	public void test6() {
		String[] words = { "land", "dream", "mom", "mom", "ror" };
		int n = 2;
		int[] expecteds = { 2, 2 };
		Assert.assertArrayEquals(expecteds, solution(n, words));
	}
}
