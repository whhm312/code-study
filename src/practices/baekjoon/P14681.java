package practices.baekjoon;

import static org.junit.Assert.assertEquals;

import java.util.Scanner;

import org.junit.Test;

/**
 * 사분면 고르기 <br>
 * 흔한 수학 문제 중 하나는 주어진 점이 어느 사분면에 속하는지 알아내는 것이다. 사분면은 아래 그림처럼 1부터 4까지 번호를 갖는다.
 * "Quadrant n"은 "제n사분면"이라는 뜻이다.
 * 
 * @author hyemin
 *
 */
public class P14681 {

	@Test
	public void test1() {
		int x = 12;
		int y = 5;
		int expected = 1;
		assertEquals(expected, getQuadrant(x, y));
	}

	@Test
	public void test2() {
		int x = 9;
		int y = -13;
		int expected = 4;
		assertEquals(expected, getQuadrant(x, y));
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int x = sc.nextInt();
		int y = sc.nextInt();
		sc.close();

		System.out.println(getQuadrant(x, y));
	}

	private static int getQuadrant(int x, int y) {
		if (x > 0 && y > 0) {
			return 1;
		} else if (x < 0 && y > 0) {
			return 2;
		} else if (x < 0 && y < 0) {
			return 3;
		} else if (x > 0 && y < 0) {
			return 4;
		} else {
			return 0;
		}
	}
}
