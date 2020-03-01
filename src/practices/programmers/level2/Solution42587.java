package practices.programmers.level2;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.Test;

public class Solution42587 {
	public int solution(int[] priorities, int location) {
		int biggest = findBiggest(priorities);
		LinkedList<Integer> queue = orderQueue(transferQueue(priorities), biggest);
		return queue.indexOf(location) + 1;
	}

	private LinkedList<Integer> transferQueue(int[] priorities) {
		List<Integer> list = Arrays.stream(priorities).boxed().collect(Collectors.toList());
		LinkedList<Integer> queue = new LinkedList<Integer>();
		queue.addAll(list);
		return queue;
	}

	private int findBiggest(int[] array) {
		int biggest = 0;
		for (int i = 0; i < array.length; i++) {
			if (i == 0) {
				biggest = array[i];
			} else {
				if (biggest < array[i]) {
					biggest = array[i];
				}
			}
		}
		return biggest;
	}

	private LinkedList<Integer> orderQueue(LinkedList<Integer> queue, int biggest) {
		int compareInt = queue.peek();
		while (biggest > compareInt) {
			queue.offer(queue.pop());
			compareInt = queue.peek();
		}
		return queue;
	}

	private String[] replace(int[] priorities) {
		char alphabet = 65;
		String[] result = new String[priorities.length];
		for (int i = 0; i < result.length; i++) {
			result[i] = String.valueOf((char) alphabet++);
		}
		return result;
	}

	private Object indexOf(String[] array, int i) {
		return array[i];
	}

	@Test
	public void testIndexOf() {
		String[] array = { "A", "B", "C", "D" };
		int location = 2;
		String expected = "C";
		assertEquals(expected, indexOf(array, location));
	}

	@Test
	public void testReplace() {
		int[] priorities = { 2, 1, 3, 2 };
		String[] expecteds = { "A", "B", "C", "D" };
		assertArrayEquals(expecteds, replace(priorities));
	}

	@Test
	public void testOrderQueue() {
		int[] priorities = { 2, 1, 3, 2 };
		int biggest = findBiggest(priorities);
		LinkedList<Integer> transferedQueue = orderQueue(transferQueue(priorities), biggest);
		LinkedList<Integer> expected = new LinkedList<Integer>();
		expected.offer(3);
		expected.offer(2);
		expected.offer(2);
		expected.offer(1);
		assertEquals(expected, transferedQueue);
	}

	@Test
	public void testFindBiggest() {
		int[] priorities = { 2, 1, 3, 2 };
		int expected = 3;
		assertEquals(expected, findBiggest(priorities));
	}

	@Test
	public void testTransferQueue() {
		int[] priorities = { 2, 1, 3, 2 };
		LinkedList<Integer> expecteds = new LinkedList<Integer>();
		for (int i = 0; i < priorities.length; i++) {
			expecteds.offer((Integer) priorities[i]);
		}

		assertEquals(expecteds, transferQueue(priorities));
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
