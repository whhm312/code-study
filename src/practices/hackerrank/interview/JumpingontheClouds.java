package practices.hackerrank.interview;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class JumpingontheClouds {
	@Test
	public void test1() {
		int[] array = { 0, 1, 0, 0, 0, 1, 0 };
		int expected = 3;
		assertEquals(expected, jumpingOnClouds(array));
	}

	@Test
	public void test2() {
		int[] array = { 0, 0, 1, 0, 0, 1, 0 };
		int expected = 4;
		assertEquals(expected, jumpingOnClouds(array));
	}

	static int jumpingOnClouds(int[] c) {
		int result = 0;
		int lastIndex = c.length - 1;
		int location = 0;
		while (location < lastIndex) {
			if (c[location] == 0) {
				location += 2;
				result++;
			} else if (c[location] == 1) {
				location--;
			}
		}
		return result;
	}

}
