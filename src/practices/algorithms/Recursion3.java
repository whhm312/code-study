package practices.algorithms;

import java.util.Arrays;
import java.util.Scanner;

import org.junit.Test;

public class Recursion3 {

	@Test
	public void testCountString() {
		String str = "ace";
		System.out.println(str + "'s length is " + length(str));
	}

	private int length(String str) {
		if (str == null || str.equals("")) {
			return 0;
		}
		return 1 + length(str.substring(1));
	}

	@Test
	public void testPrintString() {
		String str = "title";
		System.out.println("print() start.");
		print(str);
		System.out.println();
		System.out.println("print() end.");
	}

	private void print(String str) {
		if (str == null || str.equals("")) {
			return;
		} else {
			System.out.print(str.charAt(0));
			print(str.substring(1));
		}
	}

	@Test
	public void testReversePrint() {
		String str = "love";
		System.out.println("start of reverse " + str);
		reversePrint(str);
		System.out.println();
		System.out.println("end of reverse " + str);
	}

	private void reversePrint(String str) {
		if (str == null || str.equals("")) {
			return;
		} else {
			reversePrint(str.substring(1));
			System.out.print(str.charAt(0));
		}
	}

	@Test
	public void testPrintBinary() {
		System.out.println("start of testPrintBinary()");
		int n = 4;
		printBinary(n);
		System.out.println();
		System.out.println("end of testPrintBinary()");
	}

	private void printBinary(int n) {
		if (n < 2) {
			System.out.print(n);
		} else {
			printBinary(n / 2);
			System.out.print(n % 2);
		}
	}

	@Test
	public void testSumIntArray() {
		int[] array = { 2, 3, 5, 20 };
		System.out.println("sumIntArray()");
		System.out.println(sumIntArray(array.length, array));
	}

	private int sumIntArray(int length, int[] array) {
		if (length < 1) {
			return 0;
		} else {
			return sumIntArray(length - 1, array) + array[length - 1];
		}
	}

	@Test
	public void testRead() {
		Scanner scan = new Scanner(System.in);
		int n = 4;
		int[] array = new int[n];
		read(n, array, scan);
		System.out.println("read array : " + Arrays.toString(array));
	}

	private void read(int n, int[] array, Scanner scan) {
		if (n <= 0) {
			return;
		} else {
			read(n - 1, array, scan);
			array[n - 1] = scan.nextInt();
		}
	}
}
