package practices.baekjoon;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int fixedCost = sc.nextInt();
		int variableCost = sc.nextInt();
		int income = sc.nextInt();
		sc.close();

		int count = 1;
		while (true) {
			if (variableCost >= income) {
				count = -1;
				break;
			}

			if ((fixedCost + (variableCost * count)) < (income * count)) {
				break;
			}

			count++;
		}
		System.out.println(count);
	}
}
