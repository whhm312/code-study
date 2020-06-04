package practices.programmers.level2;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;
import java.util.stream.Collectors;

import org.junit.Test;

public class Solution42583 {
	public int solution(int bridgeLength, int limitedWeight, int[] truckWeights) {
		List<Integer> trucks = Arrays.stream(truckWeights).boxed().collect(Collectors.toList());
		int time = 0; // 트럭은 1초에 1만큼 움직이며
		int move = 1; // 다리 길이는 bridge_length이고

		Stack<Integer> crossedBridge = new Stack<Integer>();

		boolean isContinue = true;
		Queue<Integer> onBridge = new LinkedList<Integer>();

		System.out.println("");
		System.out.println("time : " + time + ", crossed : " + crossedBridge + ", on the bridge : " + onBridge
				+ ", waiting : " + trucks);
		while (isContinue) {
			time++;
			move++;

			if (onBridge.isEmpty()) {
				onBridge.add(trucks.get(0));
				trucks.remove(0);
			} else {
				if (onBridge.peek() < limitedWeight) {
					int sum = onBridge.peek() + (trucks.isEmpty() ? 0 : trucks.get(0));
					if (sum <= limitedWeight && !trucks.isEmpty()) {
						onBridge.add(trucks.get(0));
						trucks.remove(0);
					}
				}
			}

			if (move == bridgeLength) {
				move = 1;
				crossedBridge.add(onBridge.poll());
			}

			if (trucks.isEmpty() && onBridge.isEmpty() && crossedBridge.size() == truckWeights.length) {
				isContinue = false;
			}
			System.out.println("move : " + move + ", crossed : " + crossedBridge + ", on the bridge : " + onBridge
					+ ", waiting : " + trucks);
		}
		return time;
	}

	// @Test
	public void test3() {
		int expected = 110;
		int bridgeLength = 100;
		int weight = 100;
		int[] truckWeights = { 10, 10, 10, 10, 10, 10, 10, 10, 10, 10 };
		assertEquals(expected, solution(bridgeLength, weight, truckWeights));
	}

	@Test
	public void test2() {
		int expected = 101;
		int bridgeLength = 100;
		int weight = 100;
		int[] truckWeights = { 10 };
		assertEquals(expected, solution(bridgeLength, weight, truckWeights));
	}

	@Test
	public void test1() {
		int expected = 8;
		int bridgeLength = 2;
		int weight = 10;
		int[] truckWeights = { 7, 4, 5, 6 };
		assertEquals(expected, solution(bridgeLength, weight, truckWeights));
	}

}
