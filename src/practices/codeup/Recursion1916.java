package practices.codeup;

import java.math.BigInteger;
import java.util.Scanner;

public class Recursion1916 {
	private static BigInteger fibonacci(int n, BigInteger left, BigInteger right) {
		if (n <= 1) {
			return right.mod(BigInteger.valueOf(10009));
		}
		return fibonacci(n - 1, right, left.add(right));
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		sc.close();

		System.out.println(fibonacci(n, BigInteger.ZERO, BigInteger.ONE));
	}
}
