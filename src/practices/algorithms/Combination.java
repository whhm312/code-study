package practices.algorithms;

import java.util.Arrays;

import org.junit.Test;

public class Combination {
	@Test
	public void test() {
		int[] array = { 1, 7, 3, 4 };
		int[] selected = new int[2];
		comb(array, selected, 0, 0);
	}

	public void comb(int[] array, int[] selected, int n, int k) {
		// System.out.println("k:" + k + ", n:" + n);
		if (k == selected.length) {
			System.out.println(Arrays.toString(selected));
			return;
		}

		if (n == array.length) {
			return;
		}

		selected[k] = array[n];
		comb(array, selected, n + 1, k + 1);
		comb(array, selected, n + 1, k);
	}
}
