package practices.algorithms;

import java.util.Arrays;

import org.junit.Test;

public class InsertionSort {
	@Test
	public void test() {
		int[] array = { 4, 1, 5, 2, 3 };
		System.out.println(Arrays.toString(array));
		System.out.println(Arrays.toString(insertionSort(array)));
	}

	private int[] insertionSort(int[] array) {
		int temp = 0;
		for (int i = 1; i < array.length; i++) {
			for (int j = 0; j < i; j++) {
				if (array[i] < array[j]) {
					temp = array[j];
					array[j] = array[i];
					array[i] = temp;
					System.out.println(".." + Arrays.toString(array));
				}
			}
		}
		return array;
	}

}
