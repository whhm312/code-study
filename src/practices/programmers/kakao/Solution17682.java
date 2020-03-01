package practices.programmers.kakao;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.Test;

/**
 * [1차] 다트 게임
 * 
 * @author hyemin
 *
 */
public class Solution17682 {

//	점수|보너스|[옵션]으로 이루어진 문자열 3세트.
//	예) 1S2D*3T
//
//	점수는 0에서 10 사이의 정수이다.
//	보너스는 S, D, T 중 하나이다.
//	옵선은 *이나 # 중 하나이며, 없을 수도 있다.
	public int solution(String result) {
		String[] dartSets = splitPerSet(result); // [1S, 2D*, 3T]
		return sumScores(dartSets);
	}

	public String[] splitPerSet(String dartResult) {
		String regex = "[0-9]+[S|D|T]{1}[\\#|\\*]?";
		return split(dartResult, regex);
	}

	public String[] splitScore(String text) {
		String regex = "[1]?[0-9]{1}";
		String[] first = split(text, regex);
		regex = "[S|D|T]{1}";
		String[] second = split(text, regex);
		regex = "[\\#|\\*]";
		String[] third = split(text, regex);

		String[] answer = new String[first.length + second.length + third.length];
		int idx = 0;
		for (int i = 0; i < first.length; i++) {
			answer[idx++] = first[i];
		}
		for (int i = 0; i < second.length; i++) {
			answer[idx++] = second[i];
		}
		for (int i = 0; i < third.length; i++) {
			answer[idx++] = third[i];
		}
		return answer;
	}

	public String[] split(String text, String regex) {
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(text);

		List<String> list = new ArrayList<String>();
		while (matcher.find()) {// 패턴에 맞는 m 매처가 있다면
			list.add(matcher.group());// 그것에 접근
		}

		String[] myArray = new String[list.size()];
		list.toArray(myArray);
		return myArray;
	}

	public int sumScores(String[] scores) {
		int sum = 0;

		String[] score = null;
		int optional = 1;
		int[] calScores = new int[scores.length];
		for (int i = 0; i < scores.length; i++) {
			score = splitScore(scores[i]);
			optional = getOptional(score);
			calScores[i] = (int) Math.pow(Integer.parseInt(score[0]), getMultiples(score[1])) * optional;

			if (optional > 1 && i > 0) {
				calScores[(i - 1)] = calScores[(i - 1)] * optional;
			}
		}

		for (int i = 0; i < calScores.length; i++) {
			sum += calScores[i];
		}

		return sum;
	}

	/**
	 * 옵션으로 스타상(*) , 아차상(#)이 존재하며 스타상(*) 당첨 시 해당 점수와 바로 전에 얻은 점수를 각 2배로 만든다. <br>
	 * 아차상(#) 당첨 시 해당 점수는 마이너스된다.
	 * 
	 * @param score
	 * @return
	 */
	public int getOptional(String[] score) {
		int result = 1;
		if (score.length > 2) {
			if ("*".equals(score[2])) {
				result = 2;
			} else if ("#".equals(score[2])) {
				result = -1;
			}
		}
		return result;
	}

	/**
	 * 점수와 함께 Single(S), Double(D), Triple(T) <br>
	 * 영역이 존재하고 각 영역 당첨 시 점수에서 1제곱, 2제곱, 3제곱 (점수1 , 점수2 , 점수3 )으로 계산된다.
	 * 
	 * @param str
	 * @return
	 */
	public int getMultiples(String str) {
		int result = 1;
		switch (str) {
		case "S":
			result = 1;
			break;
		case "D":
			result = 2;
			break;
		case "T":
			result = 3;
			break;
		}
		return result;
	}

	@Test
	public void testCalScore() {
		String[] scores = { "1S", "2D*", "3T" };
		int expected = 37;
		assertEquals(expected, sumScores(scores));
	}

	@Test
	public void testSplitDetail() {
		String text = "10S";
		String[] actuals = splitScore(text);
		String[] expecteds = { "10", "S" };
		assertArrayEquals(expecteds, actuals);
	}

	@Test
	public void testSplitDartResult() {
		String dartResult = "1S2D*3T";
		String[] expecteds = { "1S", "2D*", "3T" };
		assertArrayEquals(expecteds, splitPerSet(dartResult));
	}

	@Test
	public void test1() {
		String dartResult = "1S2D*3T";
		int expected = 37;
		assertEquals(expected, solution(dartResult));
	}

	@Test
	public void test2() {
		String dartResult = "1D2S#10S";
		int expected = 9;
		assertEquals(expected, solution(dartResult));
	}

	@Test
	public void test3() {
		String dartResult = "1D2S0T";
		int expected = 3;
		assertEquals(expected, solution(dartResult));
	}

	@Test
	public void test4() {
		String dartResult = "1S*2T*3S";
		int expected = 23;
		assertEquals(expected, solution(dartResult));
	}

	@Test
	public void test5() {
		String dartResult = "1D#2S*3S";
		int expected = 5;
		assertEquals(expected, solution(dartResult));
	}

	@Test
	public void test6() {
		String dartResult = "1T2D3D#";
		int expected = -4;
		assertEquals(expected, solution(dartResult));
	}

	@Test
	public void test7() {
		String dartResult = "1D2S3T*";
		int expected = 59;
		assertEquals(expected, solution(dartResult));
	}
}
