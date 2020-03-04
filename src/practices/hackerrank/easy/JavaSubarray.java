package practices.hackerrank.easy;

import static org.junit.Assert.assertEquals;

import java.util.Scanner;

import org.junit.Test;

public class JavaSubarray {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int length = scan.nextInt();
		int[] array = new int[length];
		for (int i = 0; i < length; i++) {
			array[i] = scan.nextInt();
		}

		System.out.println(count(array));
		scan.close();
	}

	private static int count(int[] array) {
		int length = array.length;
		int count = 0;

		int sum = 0;
		int repeat = 0;
		int items = 1;
		int last = 0;

		while (items <= length) {
			last = items - 1;
			for (int i = 0; i < length - last; i++) {
				sum = 0;
				repeat = 0;
				while (repeat < items) {
					sum += array[repeat++ + i];
				}
				if (sum < 0) {
					count++;
				}
			}
			items++;
		}

		return count;
	}

	@Test
	public void test() {
		int[] array = { 1, -2, 4, -5, 1 };
		int expected = 9;
		assertEquals(expected, count(array));
	}

}
