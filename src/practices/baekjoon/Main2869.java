package practices.baekjoon;

import static org.junit.Assert.assertEquals;

import java.util.Scanner;

import org.junit.Test;

public class Main2869 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int up = sc.nextInt();
		int slip = sc.nextInt();
		int meter = sc.nextInt();
		sc.close();

		System.out.println(getDays(up, slip, meter));
	}

	private static int getDays(int up, int slip, int meter) {
		int UP = up - slip;
		int METER = meter - slip;
		int left = METER % UP;
		return METER / UP + (left > 0 ? 1 : 0);

//		AX - B( X - 1 ) >= C 
//		X >= ( C - B ) / ( A - B )
//		up*day - (slip * (day-1) >= meter
//		day >= ( meter - slip ) / ( up - slip )
	}

	@Test
	public void test1() {
		int expected = 4;
		int up = 2;
		int slip = 1;
		int meter = 5;
		assertEquals(expected, getDays(up, slip, meter));
	}
}
