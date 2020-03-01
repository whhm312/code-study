package practices.hackerrank.easy;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import java.math.BigInteger;

import org.junit.Test;

public class JavaPrimalityTest {

	public boolean isPrime(String number) {
		return new BigInteger(number).isProbablePrime(1);
	}

	private String printPrime(String number) {
		return isPrime(number) ? "prime" : "not prime";
	}

	@Test
	public void test1() {
		String expected = "prime";
		String number = "13";
		assertEquals(expected, printPrime(number));
	}

	@Test
	public void test2() {
		String expected = "not prime";
		String number = "9";
		assertEquals(expected, printPrime(number));
	}

	@Test
	public void test3() {
		String expected = "prime";
		String number = "9";
		assertNotEquals(expected, printPrime(number));
	}

}
