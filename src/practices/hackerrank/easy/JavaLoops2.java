package practices.hackerrank.easy;

import static org.junit.Assert.assertArrayEquals;

import java.util.Scanner;

import org.junit.Test;

public class JavaLoops2 {
	public static void main(String[] argh) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		int a = 0;
		int b = 0;
		int n = 0;

		int results[][] = new int[t][];
		int result[] = null;
		for (int i = 0; i < t; i++) {
			a = in.nextInt();
			b = in.nextInt();
			n = in.nextInt();

			result = new int[n];
			for (int j = 0; j < n; j++) {
				result[j] = a;
				for (int k = 0; k < j + 1; k++) {
					result[j] += (int) Math.pow(2, k) * b;
				}
			}
			results[i] = result;
		}
		in.close();

		String print = "";
		for (int i = 0; i < results.length; i++) {
			for (int j = 0; j < results[i].length; j++) {
				print += results[i][j] + " ";
			}
			print = print.substring(0, print.length() - 1);
			System.out.println(print);
			print = "";
		}
	}

	public int[][] formulas(int t, int a, int b, int n) {
		int results[][] = new int[t][];
		int result[] = null;
		for (int i = 0; i < t; i++) {
			result = new int[n];
			for (int j = 0; j < n; j++) {
				result[j] = a;
				for (int k = 0; k < j + 1; k++) {
					result[j] += (int) Math.pow(2, k) * b;
				}
			}
			results[i] = result;
		}
		return results;
	}

	public int[] formula(int a, int b, int n) {
		int result[] = null;
		result = new int[n];
		for (int j = 0; j < n; j++) {
			result[j] = a;
			for (int k = 0; k < j + 1; k++) {
				result[j] += (int) Math.pow(2, k) * b;
			}
		}
		return result;
	}

	@Test
	public void testFormula1() {
		int a = 0;
		int b = 2;
		int n = 10;
		int[] formula = formula(a, b, n);
		int[] expecteds = { 2, 6, 14, 30, 62, 126, 254, 510, 1022, 2046 };
		assertArrayEquals(expecteds, formula);
	}

	@Test
	public void testFormula2() {
		int a = 5;
		int b = 3;
		int n = 5;
		int[] formula = formula(a, b, n);
		int[] expecteds = { 8, 14, 26, 50, 98 };
		assertArrayEquals(expecteds, formula);
	}

	@Test
	public void testAddFormula() {
		int t = 2;
		int a = 0;
		int b = 0;
		int n = 0;
		int[][] formulas = new int[t][];
		a = 0;
		b = 2;
		n = 10;
		formulas[0] = formula(a, b, n);
		a = 5;
		b = 3;
		n = 5;
		formulas[1] = formula(a, b, n);

		int[] first = { 2, 6, 14, 30, 62, 126, 254, 510, 1022, 2046 };
		int[] second = { 8, 14, 26, 50, 98 };
		int[][] expecteds = { first, second };

		assertArrayEquals(expecteds, formulas);
	}

}
