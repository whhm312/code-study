package practices.programmers.level1;

/**
 * 문자열 내 p와 y의 개수
 * 
 * @author hyemin
 *
 */
public class Solution12916 {
//	대문자와 소문자가 섞여있는 문자열 s가 주어집니다. s에 'p'의 개수와 'y'의 개수를 비교해 같으면 True, 
//	다르면 False를 return 하는 solution를 완성하세요. 'p', 'y' 모두 하나도 없는 경우는 항상 True를 리턴합니다. 
//	단, 개수를 비교할 때 대문자와 소문자는 구별하지 않습니다.
//
//	예를 들어 s가 pPoooyY면 true를 return하고 Pyy라면 false를 return합니다.

	boolean solution(String s) {
		s = s.toLowerCase();
		int pCount = count(s, "p");
		int yCount = count(s, "y");
		return pCount == yCount;
	}

	public int count(String text, String word) {
		int findIdx = -1;
		int count = 0;
		while ((findIdx = text.indexOf(word, findIdx + 1)) > -1) {
			count++;
		}
		return count;
	}

	boolean better(String s) {
		s = s.toUpperCase();
		return s.chars().filter(e -> 'P' == e).count() == s.chars().filter(e -> 'Y' == e).count();
	}

	public static void main(String[] args) {
		Solution12916 solution = new Solution12916();
		System.out.println(solution.solution("Pyyp"));
	}
}
