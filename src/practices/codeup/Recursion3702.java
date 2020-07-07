package practices.codeup;

import static org.junit.Assert.assertEquals;

import java.math.BigInteger;
import java.util.Scanner;

import org.junit.Test;

public class Recursion3702 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int r = sc.nextInt();
		int c = sc.nextInt();
		sc.close();

		BigInteger result = get(r, c);
		System.out.println(result);
	}

	private static BigInteger get(int r, int c) {
		BigInteger[][] array = new BigInteger[r][c];
		for (int i = 0; i < 1; i++) {
			for (int j = 0; j < array[i].length; j++) {
				array[i][j] = BigInteger.ONE;
			}
		}

		for (int i = 1; i < r; i++) {
			for (int j = 0; j < c; j++) {
				for (int k = 0; k < j + 1; k++) {
					if (array[i][j] == null) {
						array[i][j] = array[i - 1][k];
					} else {
						array[i][j] = array[i][j].add(array[i - 1][k]);
					}
				}
			}
		}

		return array[r - 1][c - 1].mod(BigInteger.valueOf(100000000));
	}

	@Test
	public void test1() {
		BigInteger expected = BigInteger.valueOf(18389602);
		int r = 36;
		int c = 37;
		assertEquals(expected, get(r, c));
	}
}
