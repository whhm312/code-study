package lessons.programmers;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class Part5 {
	public int solution(String[][] clothes) {
		int answer = 0;
		// 각 의상 갯수 만큼 +
		for (int i = 0; i < clothes.length; i++) {
			answer += clothes[i].length / 2;
		}
		
		
		// 각 의상별로 분리하기
		// 각 의상 갯수 * 후 더하기

		return answer;
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
