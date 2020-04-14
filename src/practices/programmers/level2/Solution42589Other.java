package practices.programmers.level2;

import static org.junit.Assert.assertEquals;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.stream.Collectors;

import org.junit.Test;

public class Solution42589Other {
	public int solution(int[] priorities, int location) {
		String locationValue = null;
		Queue<String> queue = new LinkedList<String>();
		for (int i = 0; i < priorities.length; i++) {
			String wrapPriority = new String(priorities[i] + "");
			queue.add(wrapPriority);
			if (i == location) {
				locationValue = wrapPriority;
			}
		}

		String max = max(queue);
		int printOut = 1;
		String print = null;
		while (queue.size() > 0) {
			print = queue.poll();
			if (max == locationValue) {
				break;
			} else if (max == print) {
				printOut++;
				max = max(queue);
			} else {
				queue.add(print);
			}
		}

		return printOut;
	}

	private String max(Queue<String> queue) {
		String max = null;
		int maxInt = 0;
		int tempInt = 0;
		List<String> list = queue.stream().collect(Collectors.toList());
		for (int i = 0; i < list.size(); i++) {
			tempInt = Integer.parseInt(list.get(i));
			if (maxInt < tempInt) {
				max = list.get(i);
				maxInt = tempInt;
			}
		}
		return max;
	}

	@Test
	public void test1() {
		int[] priorities = { 2, 1, 3, 2 };
		int location = 2;
		int expected = 1;
		assertEquals(expected, solution(priorities, location));
	}

	@Test
	public void test2() {
		int[] priorities = { 1, 1, 9, 1, 1, 1 };
		int location = 0;
		int expected = 5;
		assertEquals(expected, solution(priorities, location));
	}
}
