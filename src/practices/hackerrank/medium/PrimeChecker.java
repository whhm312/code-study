package practices.hackerrank.medium;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.Set;

public class PrimeChecker {
	public static class Prime {
		public void checkPrime(int... ns) {
			boolean isPrime = true;
			for (int i = 0; i < ns.length; i++) {
				if (ns[i] == 1) {
					isPrime = false;
				} else {
					for (int j = 2; j <= ns[i]; j++) {
						if (ns[i] % j == 0 && ns[i] != j) {
							isPrime = false;
							break;
						}
					}
				}

				if (isPrime) {
					System.out.print(ns[i] + " ");
				}

				isPrime = true;
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			int n1 = Integer.parseInt(br.readLine());
			int n2 = Integer.parseInt(br.readLine());
			int n3 = Integer.parseInt(br.readLine());
			int n4 = Integer.parseInt(br.readLine());
			int n5 = Integer.parseInt(br.readLine());

			Prime ob = new Prime();
			ob.checkPrime(n1);
			ob.checkPrime(n1, n2);
			ob.checkPrime(n1, n2, n3);
			ob.checkPrime(n1, n2, n3, n4, n5);

			Method[] methods = Prime.class.getDeclaredMethods();
			Set<String> set = new HashSet<>();
			boolean overload = false;
			for (int i = 0; i < methods.length; i++) {
				if (set.contains(methods[i].getName())) {
					overload = true;
					break;
				}
				set.add(methods[i].getName());

			}
			if (overload) {
				throw new Exception("Overloading not allowed");
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
