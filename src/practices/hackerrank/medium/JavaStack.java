package practices.hackerrank.medium;

import static org.junit.Assert.assertEquals;

import java.util.Scanner;
import java.util.Stack;

import org.junit.Test;

public class JavaStack {

	@Test
	public void test1() {
		String expected = "true";
		String input = "{}()";
		assertEquals(expected, isPair(input));
	}

	@Test
	public void test2() {
		String expected = "true";
		String input = "({()})";
		assertEquals(expected, isPair(input));
	}

	@Test
	public void test3() {
		String expected = "false";
		String input = "{}(";
		assertEquals(expected, isPair(input));
	}

	@Test
	public void test4() {
		String expected = "true";
		String input = "[]";
		assertEquals(expected, isPair(input));
	}

	@Test
	public void test5() {
		String expected = "false";
		String input = "}()";
		assertEquals(expected, isPair(input));
	}

	public static String isPair(String input) {
		boolean result = true;

		Stack<String> open = new Stack<String>();
		String[] splits = input.split("");
		for (String str : splits) {
			switch (str) {
			case "(":
			case "{":
			case "[":
				open.push(str);
				break;
			case ")":
				result = open.size() > 0 && "(".equals(open.pop());
				break;
			case "}":
				result = open.size() > 0 && "{".equals(open.pop());
				break;
			case "]":
				result = open.size() > 0 && "[".equals(open.pop());
				break;
			}

			if (!result) {
				return Boolean.toString(result);
			}
		}

		result = open.size() < 1;
		return Boolean.toString(result);
	}

	public static void main(String[] argh) {
		Scanner sc = new Scanner(System.in);

		String input = null;
		while (sc.hasNext()) {
			input = sc.next();
			System.out.println(isPair(input));
		}
		sc.close();

	}
}
