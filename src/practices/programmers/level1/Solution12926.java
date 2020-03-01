package practices.programmers.level1;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * 시저 암호
 * 
 * @author hyemin
 *
 */
public class Solution12926 {
	public String solution(String s, int n) {
		String answer = "";
		char[] arrys = s.toCharArray();
		char spell = 0;
		int bigZ = 90;
		int smallZ = 122;
		for (int i = 0; i < arrys.length; i++) {
			spell = arrys[i];

			if (spell == 32) { // 공백
				answer += spell;
			} else {
				if (spell >= 65 && spell <= bigZ) { // 65 - 106 A-Z
					answer += Character.toString((char) ((spell + n > bigZ) ? ((spell + n) - bigZ) + 64 : spell + n));
				} else {
					if (spell >= 97 && spell <= smallZ) { // 97 - 122 a-z
						answer += Character
								.toString((char) ((spell + n > smallZ) ? ((spell + n) - smallZ) + 96 : spell + n));
					}
				}
			}
		}
		return answer;
	}

	@Test
	public void test() {
		Solution12926 sol = new Solution12926();
		String s = "AB";
		int n = 1;
		String actual = "BC";
		assertEquals(sol.solution(s, n), actual);

		s = "z";
		n = 1;
		actual = "a";
		assertEquals(sol.solution(s, n), actual);

		s = "a B z";
		n = 4;
		actual = "e F d";
		assertEquals(sol.solution(s, n), actual);
	}

	@Test
	public void test25() {
		Solution12926 sol = new Solution12926();
		String s = "AaZz";
		int n = 25;
		String actual = "ZzYy";
		assertEquals(sol.solution(s, n), actual);
	}
}
