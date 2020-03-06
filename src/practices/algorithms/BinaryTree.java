package practices.algorithms;

import java.util.Arrays;

import org.junit.Test;

public class BinaryTree {

	@Test
	public void test() {
		int[] array = { 1, 2, 3, 4, 5, 6, 7, 8 };
		int findNum = 6;

		find(array, findNum);
		findFromStart(array, findNum);
	}

	private void findFromStart(int[] array, int findNum) {
		System.out.println("be called findFromStart()");
		int findedIdx = 0;
		for (int i = 0; i < array.length; i++) {
			System.out.println("looking for " + findNum);
			if (findNum == array[i]) {
				findedIdx = i;
				break;
			}
		}
		System.out.println("Find by findFromStart()!!!");
		System.out.println("index : " + findedIdx + ", value : " + array[findedIdx]);
	}

	private void find(int[] array, int findNum) {
		System.out.println("looking for " + findNum);
		if (array.length > 1) {
			int midIdx = array.length / 2;
			if (array[midIdx] > findNum) {
				find(Arrays.copyOfRange(array, 0, midIdx), findNum);
			} else if (array[midIdx] < findNum) {
				find(Arrays.copyOfRange(array, midIdx, array.length - 1), findNum);
			} else {
				System.out.println("Find by find()!!!");
				System.out.println("index : " + midIdx + ", value : " + array[midIdx]);
				return;
			}

		} else {
			System.out.println("index : 0, value : " + array[0]);
		}
	}
}
