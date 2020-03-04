package practices.hackerrank.easy;

import static org.junit.Assert.assertEquals;

import java.util.Scanner;

import org.junit.Test;

public class Java2DArray {
	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		int[][] arr = new int[6][6];

		for (int i = 0; i < 6; i++) {
			String[] arrRowItems = scanner.nextLine().split(" ");
			scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

			for (int j = 0; j < 6; j++) {
				int arrItem = Integer.parseInt(arrRowItems[j]);
				arr[i][j] = arrItem;
			}
		}
		scanner.close();
		System.out.println(findMax(arr));
	}

	private static int findMax(int[][] arr) {
		int sum = 0;
		int maxSum = Integer.MIN_VALUE;

		int readLine = 0;
		int startIdx = 0;
		while (readLine + 2 < 6) {
			while (startIdx + 2 < 6) {
				sum = arr[readLine][startIdx] + arr[readLine][startIdx + 1] + arr[readLine][startIdx + 2];
				sum += arr[readLine + 1][startIdx + 1];
				sum += arr[readLine + 2][startIdx] + arr[readLine + 2][startIdx + 1] + arr[readLine + 2][startIdx + 2];
				if (sum > maxSum) {
					maxSum = sum;
				}
				startIdx++;
			}
			startIdx = 0;
			readLine++;
		}

		return maxSum;
	}

	@Test
	public void test1() {
		int[] arr1 = { 1, 1, 1, 0, 0, 0 };
		int[] arr2 = { 0, 1, 0, 0, 0, 0 };
		int[] arr3 = { 1, 1, 1, 0, 0, 0 };
		int[] arr4 = { 0, 0, 2, 4, 4, 0 };
		int[] arr5 = { 0, 0, 0, 2, 0, 0 };
		int[] arr6 = { 0, 0, 1, 2, 4, 0 };
		int[][] arr = { arr1, arr2, arr3, arr4, arr5, arr6 };

		int expected = 19;

		assertEquals(expected, findMax(arr));
	}

	@Test
	public void test2() {
		int[] arr1 = { 1, 1, 1, 0, 0, 0 };
		int[] arr2 = { 0, 1, 0, 0, 0, 0 };
		int[] arr3 = { 1, 1, 1, 0, 0, 0 };
		int[] arr4 = { 0, 9, 2, -4, -4, 0 };
		int[] arr5 = { 0, 0, 0, -2, 0, 0 };
		int[] arr6 = { 0, 0, -1, -2, -4, 0 };
		int[][] arr = { arr1, arr2, arr3, arr4, arr5, arr6 };

		int expected = 13;

		assertEquals(expected, findMax(arr));
	}

}
