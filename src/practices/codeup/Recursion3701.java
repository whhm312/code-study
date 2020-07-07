package practices.codeup;

import java.util.Scanner;

public class Recursion3701 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		sc.close();

		long[][] array = createPascal(n);

		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array[i].length; j++) {
				if (array[i][j] > 0) {
					System.out.print(array[i][j] + " ");
				}
			}
			System.out.println("");
		}
	}

	private static long[][] createPascal(int n) {
		long[][] array = new long[n][n];
		array[0][0] = 1;
		for (int i = 1; i < n; i++) {
			for (int j = 0; j < i + 1; j++) {
				if (j == 0) {
					array[i][j] = array[i - 1][j];
				} else {
					array[i][j] = array[i - 1][j] + array[i - 1][j - 1];
				}
			}
		}

		return array;
	}
}
