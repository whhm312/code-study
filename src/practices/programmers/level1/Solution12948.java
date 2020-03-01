package practices.programmers.level1;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * 핸드폰 번호 가리기
 * 
 * @author hyemin
 *
 */
public class Solution12948 {
	public String solution(String phoneNumber) {
		String answer = "";
		int lastIndex = phoneNumber.length() - 4;
		for (int i = 0; i < lastIndex; i++) {
			answer += "*";
		}
		return answer + phoneNumber.substring(lastIndex);
	}

	public String better(String phone_number) {
		char[] ch = phone_number.toCharArray();
		for (int i = 0; i < ch.length - 4; i++) {
			ch[i] = '*';
		}
		return String.valueOf(ch);
	}

	@Test
	public void test1() {
		String phoneNumber = "01033334444";
		String expected = "*******4444";
		assertEquals(expected, solution(phoneNumber));
	}

	@Test
	public void test2() {
		String phoneNumber = "027778888";
		String expected = "*****8888";
		assertEquals(expected, solution(phoneNumber));
	}
}
