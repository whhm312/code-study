package lessons.programmers;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

public class Part5 {
	public int solution(String[][] clothes) {
		int answer = Arrays.stream(clothes).map(c -> c[1]).distinct()
				.map(type -> (int) Arrays.stream(clothes).filter(c -> c[1].equals(type)).count()).map(c -> c + 1)
				.reduce(1, (c, n) -> c * n);

		return answer - 1;
	}

	public int mySolution(String[][] clothes) {
		Map<String, Integer> map = new HashMap<String, Integer>();
		for (String[] strings : clothes) {
			map.put(strings[1], map.getOrDefault(strings[1], 0) + 1);
		}

		int answer = 1;
		for (int i : map.values()) {
			answer *= i + 1;
		}

		return answer - 1;
	}

	@Test
	public void test1() {
		int expected = 5;
		String[][] clothes = { { "yellow_hat", "headgear" }, { "blue_sunglasses", "eyewear" },
				{ "green_turban", "headgear" } };
		assertEquals(expected, solution(clothes));
	}

	@Test
	public void test2() {
		int expected = 3;
		String[][] clothes = { { "crow_mask", "face" }, { "blue_sunglasses", "face" }, { "smoky_makeup", "face" } };
		assertEquals(expected, solution(clothes));
	}
}
