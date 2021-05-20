package lessons.programmers.level2;

import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

import org.junit.Assert;
import org.junit.Test;

/**
 * 더 맵게 : https://programmers.co.kr/learn/courses/30/lessons/42626
 * 
 * @author whhm312
 *
 */
public class T42626 {
	public int solution(int[] scoville, int K) {
		int answer = 0, mixed = 0;

		PriorityQueue<Integer> queue = new PriorityQueue<>(Arrays.stream(scoville).sorted().boxed().collect(Collectors.toList()));
		if (K == 0 || queue.peek() > K) {
			return answer;
		}

		while (queue.peek() < K && queue.size() > 1) {
			mixed = queue.poll() + (queue.poll() * 2);
			queue.add(mixed);
			answer++;
		}

		if (queue.peek() <= K) {
			return -1;
		}

		return answer;
	}

	public int answerSolution(int[] scoville, int K) {
		PriorityQueue<Integer> queue = new PriorityQueue<>();
		for (int i = 0; i < scoville.length; i++) {
			queue.add(scoville[i]);
		}
		int cnt = 0;
		while (queue.peek() < K) {
			if (queue.size() == 1) {
				cnt = -1;
				break;
			}
			int one = (int) queue.poll();
			int two = (int) queue.poll();

			int spicy = one + (two * 2);
			queue.add(spicy);
			cnt++;
		}
		return cnt;
	}

	/**
	 * 테스트케이스 4번부터 실패
	 * 
	 * @param scoville
	 * @param K
	 * @return
	 */
	public int myListSolution(int[] scoville, int K) {
		List<Integer> list = Arrays.stream(scoville).sorted().boxed().collect(Collectors.toList());
		if (list.get(0) > K || K == 0) {
			return 0;
		}

		int answer = 0;
		int mixed = 0;
		while (list.get(0) < K && list.size() > 1) {
			mixed = list.get(0) + (list.get(1) * 2);

			list.remove(0);
			list.remove(0);
			list.add(mixed);

			list = list.stream().sorted().collect(Collectors.toList());
			answer++;
		}

		if (list.get(0) <= K) {
			return -1;
		}

		return answer;
	}

	@Test
	public void test() {
		int[] scoville = { 1, 2, 3, 9, 10, 12 };
		int K = 7;
		int exptected = 2;
		Assert.assertEquals(exptected, solution(scoville, K));
	}

	@Test
	public void test2() {
		int[] scoville = { 10, 10, 10, 10, 10 };
		int K = 100;
		int exptected = 4;
		Assert.assertEquals(exptected, solution(scoville, K));
	}

	@Test
	public void test3() {
		int[] scoville = { 1, 2, 3, 9, 10, 12 };
		int K = 200;
		int exptected = -1;
		Assert.assertEquals(exptected, solution(scoville, K));
	}

	@Test
	public void test4() {
		int[] scoville = { 8, 10, 11 };
		int K = 7;
		int exptected = 0;
		Assert.assertEquals(exptected, solution(scoville, K));
	}

	@Test
	public void test5() {
		int[] scoville = { 0, 0, 1 };
		int K = 3;
		int exptected = -1;
		Assert.assertEquals(exptected, solution(scoville, K));
	}

	@Test
	public void test6() {
		int[] scoville = { 1, 1, 2 };
		int K = 3;
		int exptected = 2;
		Assert.assertEquals(exptected, solution(scoville, K));
	}

	@Test
	public void test7() {
		int[] scoville = { 10, 15, 2, 3, 7, };
		int K = 1000;
		int exptected = -1;
		Assert.assertEquals(exptected, solution(scoville, K));
	}

}
