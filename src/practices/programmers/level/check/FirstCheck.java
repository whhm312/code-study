package practices.programmers.level.check;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.regex.Pattern;

import org.junit.Test;

public class FirstCheck {
	public static String organizeStr(String str) {
		str = str.toLowerCase();
		return str;
	}

	public static List<String> split(String str) {
		Pattern pattern = Pattern.compile("[!@#$%^&*(),.?\":{}|<>[+][-]=\\s]");
		Pattern pattern2 = Pattern.compile("[0-9]");

		List<String> list = new ArrayList<String>();
		String temp = null;
		for (int i = 0; i < str.length() - 1; i = i + 1) {
			temp = str.substring(i, i + 2);
			if (!pattern.matcher(temp).find() && !pattern2.matcher(temp).find()) {
				list.add(temp);
			}
		}

		Collections.sort(list);
		String tempStr = null;
		for (int i = 1; i < list.size(); i++) {
			tempStr = list.get(i - 1);
			if (tempStr.indexOf("_") > 0) {
				tempStr = tempStr.substring(0, tempStr.indexOf("_"));
			}

			if (tempStr.equals(list.get(i))) {
				list.set(i, list.get(i) + "_" + i);
			}
		}
		return list;
	}

	public <T> List<T> union(List<T> list1, List<T> list2) {
		for (T t : list2) {
			if (!list1.contains(t)) {
				list1.add(t);
			}
		}
		return list1;
	}

	public <T> List<T> intersection(List<T> list1, List<T> list2) {
		List<T> list = new ArrayList<T>();
		for (T t : list2) {
			if (list1.contains(t)) {
				list.add(t);
			}
		}

		return list;
	}

	private final int NUMBER = 65536;

	public int solution(String str1, String str2) {
		str1 = organizeStr(str1);
		str2 = organizeStr(str2);

		System.out.println(split(str1));
		System.out.println(split(str2));
		int intersectionSize = intersection(split(str1), split(str2)).size();
		int unionSize = union(split(str1), split(str2)).size();
		if (intersectionSize < 1 || unionSize < 1) {
			return NUMBER;
		}

		Double answer = (intersectionSize / Double.valueOf(unionSize)) * NUMBER;
		return answer.intValue();
	}

	@Test
	public void test1() {
		int expected = 16384;
		String str1 = "FRANCE";
		String str2 = "french";
		assertEquals(expected, solution(str1, str2));
	}

	@Test
	public void test2() {
		int expected = 65536;
		String str1 = "handshake";
		String str2 = "shake hands";
		assertEquals(expected, solution(str1, str2));
	}

	@Test
	public void test3() {
		int expected = 43690;
		String str1 = "aa1+aa2";
		String str2 = "AAAA12";
		assertEquals(expected, solution(str1, str2));
	}

	@Test
	public void test4() {
		int expected = 65536;
		String str1 = "E=M*C^2";
		String str2 = "e=m*c^2";
		assertEquals(expected, solution(str1, str2));
	}
}
