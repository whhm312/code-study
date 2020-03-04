package practices.hackerrank.easy;

import static org.junit.Assert.assertEquals;

import java.math.BigInteger;
import java.util.Scanner;

import org.junit.Test;

public class JavaBigInteger {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		BigInteger bigA = new BigInteger(scan.nextLine());
		BigInteger bigB = new BigInteger(scan.nextLine());
		scan.close();

		System.out.println(bigA.add(bigB));
		System.out.println(bigA.multiply(bigB));
	}

	@Test
	public void test() {
		String a = "1234";
		String b = "20";
		BigInteger bigA = new BigInteger(a);
		BigInteger bigB = new BigInteger(b);

		BigInteger expectedForAdd = new BigInteger("1254");
		BigInteger expectedForMultiply = new BigInteger("24680");

		assertEquals(expectedForAdd, bigA.add(bigB));
		assertEquals(expectedForMultiply, bigA.multiply(bigB));
	}
}
