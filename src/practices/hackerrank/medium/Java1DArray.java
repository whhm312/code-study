package practices.hackerrank.medium;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class Java1DArray {
	@Test
	public void test1() {
		int leap = 3;
		int[] game = { 0, 0, 0, 0, 0 };
		assertTrue(canWin(leap, game));
	}

	@Test
	public void test2() {
		int leap = 5;
		int[] game = { 0, 0, 0, 1, 1, 1 };
		assertTrue(canWin(leap, game));
	}

	@Test
	public void test3() {
		int leap = 3;
		int[] game = { 0, 0, 1, 1, 1, 0 };
		assertFalse(canWin(leap, game));
	}

	@Test
	public void test4() {
		int leap = 1;
		int[] game = { 0, 1, 0 };
		assertFalse(canWin(leap, game));
	}

	public static boolean canWin(int leap, int[] game) {
		int idx = 0;
		int endIdx = game.length - 1;
		while (idx < endIdx) {
			if (idx + leap <= endIdx && game[idx + leap] == 0) {
				idx += leap;
				game[idx] = 1;
			} else if (idx + 1 <= endIdx && game[idx + 1] == 0) {
				idx += 1;
				game[idx] = 1;
			} else {
				if (idx + leap > endIdx) {
					return true;
				} else if (idx != 0 && game[idx - 1] == 0) {
					idx -= 1;
					game[idx] = 1;
				} else {
					return false;
				}
			}
		}
		return true;
	}
}
