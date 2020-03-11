package practices.hackerrank.interview;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class SockMerchant {
	@Test
	public void test() {
		int n = 7;
		int[] ar = { 1, 2, 1, 2, 1, 3, 2 };
		int expected = 2;
		assertEquals(expected, sockMerchant(n, ar));
	}

	// Complete the sockMerchant function below.
	static int sockMerchant(int n, int[] ar) {
		int result = 0;
		int[] cpAr = ar.clone();

		for (int i = 1; i < ar.length; i++) {
			if (ar[i] < 0) {
				continue;
			}

			for (int j = 0; j < cpAr.length; j++) {
				if (cpAr[i] < 0) {
					continue;
				}

				if (ar[i] == cpAr[j] && i != j) {
					cpAr[i] = -1;
					cpAr[j] = -1;
					ar[i] = -1;
					ar[j] = -1;
					result++;
					break;
				}
			}
		}
		return result;
	}

}
