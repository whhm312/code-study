package practices.programmers.level1;

import static org.junit.Assert.assertArrayEquals;

import org.junit.Test;

public class Solution12940 {
	public int[] solution(int n, int m) {
		// 최소공배수
		int tempN = n;
		int tempM = m;

		if (n < m) {
			int temp = n;
			n = m;
			m = temp;
		}

		// 최대공약수
		int round = 1;
		while (round > 0) {
			round = n % m;
			n = m;
			m = round;
		}

		// 최소공배수
		int LCM = tempN * tempM / n;
		return new int[] { n, LCM };
	}

	@Test
	public void test1() {
		Solution12940 sol = new Solution12940();
		int n = 3;
		int m = 12;
		int[] expecteds = { 3, 12 };
		assertArrayEquals(expecteds, sol.solution(n, m));
	}

	@Test
	public void test2() {
		Solution12940 sol = new Solution12940();
		int n = 2;
		int m = 5;
		int[] expecteds = { 1, 10 };
		assertArrayEquals(expecteds, sol.solution(n, m));
	}
}
