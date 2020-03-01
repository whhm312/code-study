package practices.programmers.level1;

import java.util.Arrays;

/**
 * 문자열 내림차순으로 배치하기
 * 
 * @author hyemin
 *
 */
public class Solution12917 {

	public String solution(String str) {
		char[] strArr = str.toCharArray();
		Arrays.sort(strArr);

		String bigLatters = "";
		String smallLatters = "";
		char spel = 0;
		for (int i = 0; i < strArr.length; i++) {
			spel = strArr[i];
			if (spel > 64 && spel < 91) {
				bigLatters = String.valueOf(spel) + bigLatters;
			} else {
				smallLatters = String.valueOf(spel) + smallLatters;
			}
		}

		return smallLatters + bigLatters;
	}

	public static void main(String[] args) {
		Solution12917 sol = new Solution12917();
		String s = "ZbAcdefgZ";
		System.out.println(sol.solution(s));
		;
	}

}
