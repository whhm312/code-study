package practices.hackerrank.easy;

import static org.junit.Assert.assertArrayEquals;

import java.util.Scanner;

import org.junit.Test;

public class JavaArraylist {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int length = scan.nextInt();
		int[][] array = new int[length][];
		int[] subArray = null;
		int subLength = 0;
		for (int i = 0; i < length; i++) {
			subLength = scan.nextInt();
			subArray = new int[subLength];
			for (int j = 0; j < subLength; j++) {
				subArray[j] = scan.nextInt();
			}
			array[i] = subArray;
		}

		length = scan.nextInt();
		int[][] cordinates = new int[length][];
		for (int i = 0; i < length; i++) {
			subArray = new int[2];
			subArray[0] = scan.nextInt();
			subArray[1] = scan.nextInt();
			cordinates[i] = subArray;
		}

		String[] results = find(array, cordinates);
		for (int i = 0; i < results.length; i++) {
			System.out.println(results[i]);
		}
		scan.close();
	}

	private static String[] find(int[][] array, int[][] cordis) {
		int cordisLength = cordis.length;
		String[] values = new String[cordisLength];
		for (int i = 0; i < cordisLength; i++) {
			try {
				int x = cordis[i][0] - 1;
				int y = cordis[i][1] - 1;
				values[i] = String.valueOf(array[x][y]);
			} catch (Exception e) {
				values[i] = "ERROR!";
			}
		}
		return values;
	}

	@Test
	public void test() {
		int[] arr1 = { 41, 77, 74, 22, 44 };
		int[] arr2 = { 12 };
		int[] arr3 = { 37, 34, 36, 52 };
		int[] arr4 = new int[0];
		int[] arr5 = { 20, 22, 33 };
		int[][] array = { arr1, arr2, arr3, arr4, arr5 };
		int[][] cordis = { { 1, 3 }, { 3, 4 }, { 3, 1 }, { 4, 3 }, { 5, 5 } };

		String[] expecteds = { "74", "52", "37", "ERROR!", "ERROR!" };
		assertArrayEquals(expecteds, find(array, cordis));
	}

}
