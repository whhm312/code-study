package lessons.programmers;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Comparator;

import org.junit.Test;

public class Part2 {
	public String solution(int[] numbers) {
		int idx = 0;
		String[] temp = new String[numbers.length];
		for (int i = 0; i < numbers.length; i++) {
			temp[idx++] = numbers[i] + "";
		}

		Arrays.sort(temp, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				return (o2 + o1).compareTo(o1 + o2);
			}
		});

		String answer = "";
		for (String str : temp) {
			answer += str;
		}

		if (answer.charAt(0) == '0') {
			return "0";
		}
		return answer;
	}

	@Test
	public void test1() {
		String expected = "6210";
		int[] numbers = { 6, 10, 2 };
		assertEquals(expected, solution(numbers));
	}

	@Test
	public void test2() {
		String expected = "9534330";
		int[] numbers = { 3, 30, 34, 5, 9 };
		assertEquals(expected, solution(numbers));
	}
	
	@Test
	public void test3() {
		String expected = "0";
		int[] numbers = { 0, 0, 0, 0, 0 };
		assertEquals(expected, solution(numbers));
	}
}
