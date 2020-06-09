package code.test.crema;

import static org.junit.Assert.assertEquals;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.junit.Test;

public class Q5 {
	@Test
	public void test2() {
		int expected = 656502;
		int N = 32327;
		assertEquals(expected, ArithmeticEquation(N));
	}

	@Test
	public void test1() {
		int expected = 1;
		int N = 1;
		assertEquals(expected, ArithmeticEquation(N));
	}

	static int numDivisors(int N) {
		List<Integer> primes = getPrimesUpTo(N);

		/*
		 * Get the number of instances of each prime number in the factorization of N!.
		 */
		Map<Integer, Integer> primeExponents = new HashMap<Integer, Integer>();
		for (int p : primes)
			primeExponents.put(p, getPrimeExponent(N, p));

		/*
		 * Compute the number of integer soutions to the equation (we use long long
		 * types as a safeguard against integer overflows).
		 */
		BigInteger result = new BigInteger("1");
		BigInteger scaleFactor = new BigInteger("2");
		BigInteger addend = new BigInteger("1");

		Iterator<Integer> it = primeExponents.values().iterator();
		while (it.hasNext()) {
			BigInteger term = new BigInteger("" + it.next()).multiply(scaleFactor).add(addend);

			result = result.multiply(term);

			/*
			 * Doing a modulus operation after each multiplication is equivalent to doing
			 * only one at the very end, but the former approach offers yet another
			 * safeguard against integer overflows.
			 */
			result = result.mod(MODULUS_TERM);
		}

		return result.intValue();
	}

	private static final BigInteger MODULUS_TERM = new BigInteger("1000007");

	/*
	 * Method: getPrimeExponent(N, p) Usage: int e = getPrimeExponent(4, 2);
	 * ---------------------------------------------------------------------------
	 * Returns the exponent of the specified prime number p in the prime
	 * factorization of N!.
	 */
	static int getPrimeExponent(int N, int p) {
		int remainingN = N;
		int exponent = 0;

		while (remainingN > 1) {
			remainingN /= p;
			exponent += remainingN;
		}

		return exponent;
	}

	/*
	 * Method: getPrimesUpTo(rangeEnd) Usage: List<Integer> primes =
	 * getPrimesUpTo(4)
	 * ---------------------------------------------------------------------------
	 * Returns a list of all prime numbers in the range [0, rangeEnd].
	 */
	static List<Integer> getPrimesUpTo(int rangeEnd) {
		List<Boolean> isPrime = new ArrayList<Boolean>(Collections.nCopies(rangeEnd + 1, true));

		/* Keep track of all primes in a separate list. */
		List<Integer> primes = new ArrayList<Integer>();

		/*
		 * 2 is the only even prime number. We can consider it in a special case, and
		 * then ignore all successive even numbers in the sieve.
		 */
		if (2 <= rangeEnd)
			primes.add(2);

		/*
		 * Every prime number greater than 2 must be odd, so we'll iterate through odd
		 * numbers only to save time.
		 */
		for (int i = 3; i <= rangeEnd; i += 2) {
			if (isPrime.get(i) == true) {
				primes.add(i);

				/* Mark all multiples of i as NOT prime. */
				for (int multiple = i; multiple <= rangeEnd; multiple += i)
					isPrime.set(multiple, false);
			}
		}

		return primes;
	}

	public static int ArithmeticEquation(int n) {
		return numDivisors(n);
	}

	public void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

		int N = Integer.parseInt(bufferedReader.readLine().trim());

		int result = Q5.ArithmeticEquation(N);

		bufferedWriter.write(String.valueOf(result));
		bufferedWriter.newLine();

		bufferedReader.close();
		bufferedWriter.close();
	}
}
