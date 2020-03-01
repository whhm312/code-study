package practices.programmers.level1;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * 이상한 문자 만들기
 * 
 * @author hyemin
 *
 */
public class Solution12930 {
//	문제 설명
//	문자열 s는 한 개 이상의 단어로 구성되어 있습니다. 
//	각 단어는 하나 이상의 공백문자로 구분되어 있습니다. 
//	각 단어의 짝수번째 알파벳은 대문자로, 
//	홀수번째 알파벳은 소문자로 바꾼 문자열을 리턴하는 함수, solution을 완성하세요.
//
//	제한 사항
//	문자열 전체의 짝/홀수 인덱스가 아니라, 단어(공백을 기준)별로 짝/홀수 인덱스를 판단해야합니다.
//	첫 번째 글자는 0번째 인덱스로 보아 짝수번째 알파벳으로 처리해야 합니다.
	public String solution(String str) {
		String[] strArr = str.split(" ");
		int textLength = 0;
		String text = "";
		char[] texts = null;
		for (int i = 0; i < strArr.length; i++) {
			texts = strArr[i].toCharArray();
			textLength = texts.length;
			for (int j = 0; j < textLength; j++) {
				if (j == 0 || j % 2 == 0) {
					text += String.valueOf(texts[j]).toUpperCase();
				} else {
					text += String.valueOf(texts[j]).toLowerCase();
				}
			}
			strArr[i] = text;
			text = "";
		}

		String answer = "";
		for (int i = 0; i < strArr.length; i++) {
			answer += strArr[i] + " ";
		}
		return answer.substring(0, answer.length() - 1);
	}

	@Test
	public void test() {
		Solution12930 sol = new Solution12930();
		String s = "try hello world";
		String actual = "TrY HeLlO WoRlD";
		assertEquals(sol.solution(s), actual);
	}

	@Test
	public void testDubleSpace() {
		Solution12930 sol = new Solution12930();
		String s = "aa  bb ccc";
		String actual = "Aa  Bb CcC";
		assertEquals(sol.solution(s), actual);
	}

	@Test
	public void testUserCase() {
		Solution12930 sol = new Solution12930();
		String s = "sp ace";
		String actual = "Sp AcE";
		assertEquals(sol.solution(s), actual);
	}
}
