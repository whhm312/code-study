package practices.programmers.level1;

import java.util.regex.Pattern;

/**
 * 문자열 다루기 기본
 * 
 * @author hyemin
 *
 */
public class Solution12918 {
//	문제 설명
//	문자열 s의 길이가 4 혹은 6이고, 숫자로만 구성돼있는지 확인해주는 함수, solution을 완성하세요. 예를 들어 s가 a234이면 False를 리턴하고 1234라면 True를 리턴하면 됩니다.
//
//	제한 사항
//	s는 길이 1 이상, 길이 8 이하인 문자열입니다.

	public boolean solution(String s) {
		if (s.length() == 4 || s.length() == 6) {
			return Pattern.matches("^[0-9]+$", s);
		}
		return false;
	}

	public static void main(String[] args) {
		Solution12918 sol = new Solution12918();
		String s = "";
//		s = "a234"; // false
//		s = "1234"; // true
		s = "12234"; // false
		System.out.println(sol.solution(s));
	}

}
