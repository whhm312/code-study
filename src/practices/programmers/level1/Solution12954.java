package practices.programmers.level1;

import static org.junit.Assert.assertArrayEquals;

import org.junit.Test;

/**
 * x만큼 간격이 있는 n개의 숫자
 * 
 * @author hyemin
 *
 */
public class Solution12954 {
//	함수 solution은 정수 x와 자연수 n을 입력 받아, 
//	x부터 시작해 x씩 증가하는 숫자를 n개 지니는 리스트를 리턴해야 합니다. 
//	다음 제한 조건을 보고, 조건을 만족하는 함수, solution을 완성해주세요.

//	x는 -10000000 이상, 10000000 이하인 정수입니다.
//	n은 1000 이하인 자연수입니다.
	public long[] solution(long x, int n) {
		long[] answer = new long[n];
		for (int i = 0; i < n; i++) {
			answer[i] = x * (i + 1);
		}
		return answer;
	}

	@Test
	public void test1() {
		int x = 2;
		int n = 5;
		long[] expecteds = { 2, 4, 6, 8, 10 };
		assertArrayEquals(expecteds, solution(x, n));
	}

	@Test
	public void test2() {
		int x = 4;
		int n = 3;
		long[] expecteds = { 4, 8, 12 };
		assertArrayEquals(expecteds, solution(x, n));
	}

	@Test
	public void test3() {
		int x = -4;
		int n = 2;
		long[] expecteds = { -4, -8 };
		assertArrayEquals(expecteds, solution(x, n));
	}

	@Test
	public void test4() {
		int x = -4;
		int n = 1;
		long[] expecteds = { -4 };
		assertArrayEquals(expecteds, solution(x, n));
	}
}
