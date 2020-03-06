package practices.algorithms;

import org.junit.Test;

public class SequentialSearch {
	@Test
	public void test() {
		String[] array = { "ass", "xxz", "eew", "vvb", "ccx" };
		String findStr = "ccx";
		search(array, findStr);
	}

	private void search(String[] array, String findStr) {
		int findedIdx = -1;
		for (int i = 0; i < array.length; i++) {
			System.out.println("searching...");
			if (array[i].equals(findStr)) {
				findedIdx = i;
				break;
			}
		}
		System.out.println("findedIdx : " + findedIdx);
	}

}
