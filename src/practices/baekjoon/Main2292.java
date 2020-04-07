package practices.baekjoon;

import static org.junit.Assert.assertEquals;

import java.util.Scanner;

import org.junit.Test;

public class Main2292 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		sc.close();

		System.out.println(get(N));
	}

	private static int get(int N) {
		int i = 1;
		int G = 6;
		int S = 2;
		int E = S + (G * i++);

		if (N < S) {
			return 1;
		}
		
		while ((S <= N && E > N) == false) {
			S = E;
			E = S + (G * i++);
		}
		return i;
	}

	@Test
	public void test1() {
		int expected = 3;
		int N = 13;
		assertEquals(expected, get(N));
	}

	@Test
	public void test2() {
		int expected = 2;
		int N = 5;
		assertEquals(expected, get(N));
	}

	@Test
	public void test3() {
		int expected = 4;
		int N = 37;
		assertEquals(expected, get(N));
	}
	
	@Test
	public void test4() {
		int expected = 1;
		int N = 1;
		assertEquals(expected, get(N));
	}
}
