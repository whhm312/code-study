package practices.baekjoon;

import static org.junit.Assert.assertEquals;

import java.util.Scanner;

import org.junit.Test;

public class Main1193 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		sc.close();

		System.out.println(get(N));
	}

	private static String get(int N) {
		if (N < 2) {
			return "1/1";
		}

		int m = 0;
		int M = 0;
		int D = 0;
		int count = 0;

		while (count < N) {
			m++;
			System.out.println();
			if (m % 2 == 0) {
				M = 1;
				D = m;
				while (M <= m) {
					count++;
					System.out.println("count " + count + " : " + M + "/" + D);
					if (count >= N) {
						break;
					}

					M++;
					D--;
				}
			} else {
				M = m;
				D = 1;
				while (M >= 1) {
					count++;
					System.out.println("count " + count + " : " + M + "/" + D);
					if (count >= N) {
						break;
					}

					M--;
					D++;
				}
			}
		}

		System.out.println();
		return M + "/" + D;
	}

	@Test
	public void test1() {
		String expected = "2/4";
		int N = 14;
		assertEquals(expected, get(N));
	}

	@Test
	public void test2() {
		String expected = "2/1";
		int N = 3;
		assertEquals(expected, get(N));
	}

	@Test
	public void test3() {
		String expected = "1/3";
		int N = 6;
		assertEquals(expected, get(N));
	}

	@Test
	public void test4() {
		String expected = "2/2";
		int N = 5;
		assertEquals(expected, get(N));
	}

	@Test
	public void test5() {
		String expected = "1/4";
		int N = 7;
		assertEquals(expected, get(N));
	}

	@Test
	public void test6() {
		String expected = "3/2";
		int N = 9;
		assertEquals(expected, get(N));
	}
}
