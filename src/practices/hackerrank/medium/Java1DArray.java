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

	@Test
	public void testFindError() {
		int leap = 52;
		int[] game = { 0, 1, 1, 1, 1, 0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 1, 0, 0, 0, 1, 0, 1, 0, 0, 0, 1, 0, 0, 0, 0, 1,
				0, 1, 1, 1, 0, 0, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 1, 0, 0, 0, 0, 1, 1, 1, 1, 0, 1, 1, 0, 1, 1, 0, 0, 0, 0,
				0, 0, 0, 0, 1, 1, 1, 1, 0, 0, 1, 0, 1, 1, 0, 0, 1, 0, 1 };
		assertTrue(canWin(leap, game));
	}

	public static boolean canWin(int leap, int[] game) {
		return isWin(leap, game, 0);
	}

	private static boolean isWin(int leap, int[] game, int i) {
		if (i < 0 || game[i] == 1) {
			return false;
		} else if (i >= game.length - 1 || i + leap > game.length - 1) {
			return true;
		}

		game[i] = 1;

		return isWin(leap, game, i + leap) || isWin(leap, game, i + 1) || isWin(leap, game, i - 1);
	}
}
