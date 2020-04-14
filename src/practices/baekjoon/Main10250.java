package practices.baekjoon;

import static org.junit.Assert.assertEquals;

import java.util.Scanner;

import org.junit.Test;

public class Main10250 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int totalCount = sc.nextInt();
		for (int i = 0; i < totalCount; i++) {
			int H = sc.nextInt();
			sc.nextInt();
			int N = sc.nextInt();
			int floor = N / H + 1;
			int member = N % H;
			if (N % H == 0) {
				floor = N / H;
				member = H;
			}

			System.out.println(member * 100 + floor);
		}
		sc.close();
	}

	public static void myMain(String[] args) {
		Scanner sc = new Scanner(System.in);
		int totalCount = sc.nextInt();
		int H = 0;
		int W = 0;
		int N = 0;
		String[] result = new String[totalCount];

		for (int i = 0; i < result.length; i++) {
			H = sc.nextInt();
			W = sc.nextInt();
			N = sc.nextInt();
			result[i] = getRoomNumber(H, W, N);
		}
		sc.close();

		for (int i = 0; i < result.length; i++) {
			System.out.println(result[i]);
		}
	}

	@SuppressWarnings("unused")
	public static void betterMain(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int i = 0; i < T; i++) {
			int H = sc.nextInt();
			int W = sc.nextInt();
			int N = sc.nextInt();
			int x = (N / H) + 1;
			int y = N % H;
			if (N % H == 0) {
				x = N / H;
				y = H;
			}
			System.out.println(y * 100 + x);
		}
		sc.close();
	}

	private static String getRoomNumber(int H, int W, int N) {
		int h = 1;
		int w = 1;
		int count = 1;
		while (w <= W) {
			while (h <= H) {
				if (count == N) {
					return h + addZero(W, w);
				}
				h++;
				count++;
			}
			h = 1;
			w++;
		}
		return h + addZero(W, w);
	}

	private static String addZero(int W, int w) {
		String result = String.valueOf(w);
		int wLength = String.valueOf(w).length();
		int originWLength = String.valueOf(W).length();

		String zero = "";
		if (originWLength < 2) {
			zero = "0";
		}
		if ((zero.length() + wLength) < originWLength) {
			zero += "0";
		}
		return zero + result;
	}

	@Test
	public void test1() {
		String expected = "402";
		int H = 6;
		int W = 12;
		int N = 10;
		assertEquals(expected, getRoomNumber(H, W, N));
	}

	@Test
	public void test2() {
		String expected = "1203";
		int H = 30;
		int W = 50;
		int N = 72;
		assertEquals(expected, getRoomNumber(H, W, N));
	}

	@Test
	public void test3() {
		String expected = "121";
		int H = 1;
		int W = 99;
		int N = 21;
		assertEquals(expected, getRoomNumber(H, W, N));
	}

	@Test
	public void test4() {
		String expected = "101";
		int H = 1;
		int W = 1;
		int N = 1;
		assertEquals(expected, getRoomNumber(H, W, N));
	}

	@Test
	public void test5() {
		String expected = "101";
		int H = 5;
		int W = 5;
		int N = 1;
		assertEquals(expected, getRoomNumber(H, W, N));
	}
}
