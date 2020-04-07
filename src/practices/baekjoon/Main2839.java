package practices.baekjoon;

import static org.junit.Assert.assertEquals;

import java.util.Scanner;

import org.junit.Test;

public class Main2839 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int sugars = sc.nextInt();
		sc.close();
		System.out.println(count(sugars));
	}

	private static int count(int requestKG) {
		int PER_3KG = 3;
		int PER_5KG = 5;
		
		for(int count = requestKG / PER_5KG; count > -1; count--) {
			int remain = requestKG - count * PER_5KG;
			if(remain % 3 == 0) {
				int tmp = remain / PER_3KG;
				return count + tmp;
			}
		}
		return -1;
	}

	@Test
	public void test1() {
		int expected = 4;
		int sugars = 18;
		assertEquals(expected, count(sugars));
	}

	@Test
	public void test2() {
		int expected = -1;
		int sugars = 4;
		assertEquals(expected, count(sugars));
	}

	@Test
	public void test3() {
		int expected = 2;
		int sugars = 6;
		assertEquals(expected, count(sugars));
	}

	@Test
	public void test4() {
		int expected = 3;
		int sugars = 9;
		assertEquals(expected, count(sugars));
	}

	@Test
	public void test5() {
		int expected = 3;
		int sugars = 11;
		assertEquals(expected, count(sugars));
	}

}
