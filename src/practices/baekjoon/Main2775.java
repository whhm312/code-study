package practices.baekjoon;

import static org.junit.Assert.assertEquals;

import java.util.Scanner;

import org.junit.Test;

public class Main2775 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int totalCount = sc.nextInt();
		int K = 0;
		int N = 0;
		int[] result = new int[totalCount];

		for (int i = 0; i < result.length; i++) {
			K = sc.nextInt();
			N = sc.nextInt();
			result[i] = count(K, N);

			System.out.println(better(K, N));
		}
		sc.close();

		for (int i = 0; i < result.length; i++) {
			System.out.println(result[i]);
		}
	}

	private static int count(int floor, int number) {
		int[] zeroFloor = new int[number + 1];
		for (int i = 0; i < zeroFloor.length; i++) {
			zeroFloor[i] = i;
		}

		int[][] building = new int[floor + 1][];
		building[0] = zeroFloor;
		int[] createFloor = null;
		for (int i = 1; i < building.length; i++) {
			createFloor = new int[number + 1];
			for (int j = 0; j < createFloor.length; j++) {
				for (int k = 0; k <= j; k++) {
					createFloor[j] += building[i - 1][k];
				}
			}
			building[i] = createFloor;
		}

		return building[floor][number];
	}

	static int better(int k, int n) {
		if (n == 1) {
			return 1;
		} else if (k == 0) {
			return n;
		} else {
			return better(k, n - 1) + better(k - 1, n);
		}
	}

	@Test
	public void test1() {
		int expected = 6;
		int K = 1;
		int N = 3;
		assertEquals(expected, count(K, N));
	}

	@Test
	public void test2() {
		int expected = 10;
		int K = 2;
		int N = 3;
		assertEquals(expected, count(K, N));
	}

	@Test
	public void test3() {
		int expected = 70;
		int K = 3;
		int N = 5;
		assertEquals(expected, count(K, N));
	}
}
