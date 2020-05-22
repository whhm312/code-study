package practices.programmers.level2;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Stack;

import org.junit.Test;

public class Solution12909 {
	boolean solution(String s) {
		if (')' == s.charAt(0) || '(' == s.charAt(s.length() - 1) || s.length() % 2 == 1) {
			return false;
		}

		Stack<Character> openStack = new Stack<Character>();
		for (int i = 0; i < s.length(); i++) {
			if ('(' == s.charAt(i)) {
				openStack.push('(');
			} else {
				if (openStack.isEmpty()) {
					return false;
				} else {
					openStack.pop();
				}
			}
		}

		return openStack.isEmpty();
	}

	@Test
	public void test0() {
		String s = "(())()";
		assertTrue(solution(s));
	}

	@Test
	public void test1() {
		String s = "()()";
		assertTrue(solution(s));
	}

	@Test
	public void test2() {
		String s = "(())()";
		assertTrue(solution(s));
	}

	@Test
	public void test3() {
		String s = ")()(";
		assertFalse(solution(s));
	}

	@Test
	public void test4() {
		String s = "(()(";
		assertFalse(solution(s));
	}

	@Test
	public void test5() {
		String s = "()))((()";
		assertFalse(solution(s));
	}

}
