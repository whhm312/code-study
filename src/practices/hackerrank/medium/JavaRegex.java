package practices.hackerrank.medium;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Scanner;

import org.junit.Test;

class MyRegex {
	public String pattern = "^([01]?\\d?\\d|2[0-4]\\d|25[0-5])\\.([01]?\\d?\\d|2[0-4]\\d|25[0-5])\\.([01]?\\d?\\d|2[0-4]\\d|25[0-5])\\.([01]?\\d?\\d|2[0-4]\\d|25[0-5])?";
}

public class JavaRegex {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		while (in.hasNext()) {
			String IP = in.next();
			System.out.println(IP.matches(new MyRegex().pattern));
		}
		in.close();
	}

	@Test
	public void testMyRexInvalid1() {
		String str = "000.12.234.23.23";
		assertFalse(str.matches(new MyRegex().pattern));
	}

	@Test
	public void testMyRexInvalid2() {
		String str = "666.666.23.23";
		assertFalse(str.matches(new MyRegex().pattern));
	}

	@Test
	public void testMyRexInvalid3() {
		String str = ".213.123.23.32";
		assertFalse(str.matches(new MyRegex().pattern));
	}

	@Test
	public void testMyRexInvalid4() {
		String str = "23.45.22.32.";
		assertFalse(str.matches(new MyRegex().pattern));
	}

	@Test
	public void testMyRexInvalid5() {
		String str = "I.Am.not.an.ip";
		assertFalse(str.matches(new MyRegex().pattern));
	}

	@Test
	public void testMyRexValid1() {
		String str = "000.12.12.034";
		assertTrue(str.matches(new MyRegex().pattern));
	}

	@Test
	public void testMyRexValid2() {
		String str = "121.234.12.12";
		assertTrue(str.matches(new MyRegex().pattern));
	}

	@Test
	public void testMyRexValid3() {
		String str = "23.45.12.56";
		assertTrue(str.matches(new MyRegex().pattern));
	}

}