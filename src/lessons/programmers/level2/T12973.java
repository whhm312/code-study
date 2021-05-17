package lessons.programmers.level2;

import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.Assert;
import org.junit.Test;

/**
 * 짝지어 제거하기 https://programmers.co.kr/learn/courses/30/lessons/12973
 * 
 * @author whhm312
 *
 */
public class T12973 {

	/**
	 * 출처
   * https://velog.io/@peppermint100/%ED%94%84%EB%A1%9C%EA%B7%B8%EB%9E%98%EB%A8%B8%EC%8A%A4-%EC%A7%9D%EC%A7%80%EC%96%B4-%EC%A0%9C%EA%B1%B0%ED%95%98%EA%B8%B0-in-Java
	 * 
	 * @param s
	 * @return
	 */
	public int solution(String s) {
		Stack<String> stack = new Stack<String>();
		for (int i = 0; i < s.length(); i++) {
			if (stack.isEmpty()) {
				stack.push(String.valueOf(s.charAt(i)));
			} else {
				String lastWord = stack.peek();
				String curWord = String.valueOf(s.charAt(i));
				if (!lastWord.equals(curWord)) {
					stack.push(curWord);
				} else {
					stack.pop();
				}
			}

		}
		return stack.size() > 0 ? 0 : 1;
	}

	/**
	 * 효율성 통과 안됨
	 * 
	 * @param s
	 * @return 성공적으로 수행할 수 있으면 1을, 아닐 경우 0을 리턴
	 */
	public int patternSolution(String s) {
		String regex = "(.)\\1";
		Matcher matcher = Pattern.compile(regex).matcher(s);

		while (matcher.find()) {
			s = matcher.replaceAll("");
			if (s.length() % 2 != 0)
				return 0;

			matcher = Pattern.compile(regex).matcher(s);
		}

		return s.length() > 0 ? 0 : 1;
	}

	/**
	 * 효율성 통과 안됨
	 * 
	 * @param s
	 * @return
	 */
	public int mySolution(String s) {
		int i = 0;

		while (i < s.length() - 1) {
			if (s.charAt(i) == s.charAt(i + 1)) {
				s = s.substring(0, i) + s.substring(i + 2, s.length());
				i = 0;
			} else {
				i++;
			}
		}

		return s.length() > 0 ? 0 : 1;
	}

	@Test
	public void test1() {
		String s = "baabaa";
		int expected = 1;
		Assert.assertEquals(expected, solution(s));
	}

	@Test
	public void test2() {
		String s = "cdcd";
		int expected = 0;
		Assert.assertEquals(expected, solution(s));
	}
}
