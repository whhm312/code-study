package practices.commons;

import java.math.BigInteger;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class Tools {
	public static boolean isPrime(String number) {
		return new BigInteger(number).isProbablePrime(1);
	}

	public static void printArray(int[] array) {
		System.out.print("[");
		for (int i = 0; i < array.length; i++) {
			if (i == (array.length - 1)) {
				System.out.print(array[i]);
			} else {
				System.out.print(array[i] + ", ");
			}
		}
		System.out.print("]");
	}

	public static int count(String str, String countStr) {
		int fromIndex = -1;
		int count = 0;
		while ((fromIndex = str.indexOf(countStr, fromIndex + 1)) > -1) {
			count++;
		}
		return count;
	}

	public static Set<Integer> createSet(int[] array) {
		Integer[] integerArray = createIntegerArray(array);

		Set<Integer> integerSet = new HashSet<Integer>();
		Collections.addAll(integerSet, integerArray);
		return integerSet;
	}

	public static Integer[] createIntegerArray(int[] array) {
		Integer[] integerArray = new Integer[array.length];
		for (int i = 0; i < array.length; i++) {
			integerArray[i] = array[i];
		}
		return integerArray;
	}
}
