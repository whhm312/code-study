package practices.codeup;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Scanner;

public class Recursion3701 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int r = sc.nextInt();
		int c = sc.nextInt();
		sc.close();

		long[][] array = new long[r][c];
		for (int i = 0; i < 1; i++) {
			for (int j = 0; j < array[i].length; j++) {
				array[i][j] = 1;
			}
		}

		for (int i = 1; i < r; i++) {
			for (int j = 0; j < c; j++) {
				for (int k = 0; k < j + 1; k++) {
					array[i][j] = array[i][j] + array[i - 1][k];
				}
			}
		}

		BigInteger sum = BigInteger.ZERO;
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array[i].length; j++) {
				System.out.print(array[i][j] + " ");
				sum = sum.add(BigInteger.valueOf(array[i][j]));
			}
			System.out.println("");
		}

		System.out.println(sum);
		System.out.println(sum.mod(BigInteger.valueOf(100000000)));

		for (int i = 0; i < array.length; i++) {
			sum.add(BigInteger.valueOf(Arrays.stream(array[i]).sum()));
		}
		System.out.println(sum);
		System.out.println(sum.mod(BigInteger.valueOf(100000000)));
	}
}
