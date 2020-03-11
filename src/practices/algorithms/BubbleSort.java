package practices.algorithms;

import java.util.Arrays;

import org.junit.Test;

public class BubbleSort {
	@Test
	public void testSort() {
		int[] array = { 3, 2, 4, 1 };
		System.out.println(Arrays.toString(array));
		System.out.println(Arrays.toString(bubbleSort(array)));
	}

	private int[] bubbleSort(int[] array) {
		int temp = -1;
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array.length - 1 - i; j++) {
				System.out.printf("sorting..array[j](%d), array[j + 1](%d)%n", array[j], array[j + 1]);
				if (array[j] > array[j + 1]) {
					temp = array[j + 1];
					array[j + 1] = array[j];
					array[j] = temp;
					System.out.println(Arrays.toString(array));
				}
			}
		}
		return array;
	}

}
