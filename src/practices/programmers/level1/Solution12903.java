package practices.programmers.level1;

/**
 * 가운데 글자 가져오기
 * 
 * @author hyemin
 *
 */
public class Solution12903 {
	public static String solution(String str) {
		int strLength = str.length();
		if (strLength % 2 == 0) {
			return str.substring(strLength / 2 - 1, strLength / 2 + 1);
		} else {
			return str.substring(strLength / 2, strLength / 2 + 1);
		}
	}

	public static String better(String word) {
		return word.substring((word.length() - 1) / 2, word.length() / 2 + 1);
	}

	public static void main(String[] args) {
		String word = "abcd";
		System.out.println(solution(word));
		System.out.println(better(word));
	}
}
