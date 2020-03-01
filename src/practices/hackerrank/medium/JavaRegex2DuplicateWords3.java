package practices.hackerrank.medium;

import static org.junit.Assert.assertEquals;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.Test;

public class JavaRegex2DuplicateWords3 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		int numSentences = Integer.parseInt(in.nextLine());
		String[] prints = new String[numSentences];
		int printIdx = 0;

		while (numSentences-- > 0) {
			prints[printIdx++] = replaceAll(in.nextLine());
		}
		in.close();

		for (int i = 0; i < prints.length; i++) {
			System.out.println(prints[i]);
		}
	}

	public static String replaceAll(String input) {
		String regex = null;
		Pattern p = null;
		Matcher m = null;

		String newInput = "";
		String[] arrayInput = input.split(" ");
		while (input.length() > 1) {
			regex = arrayInput[0];
			p = Pattern.compile("\\b" + regex + "\\b", Pattern.CASE_INSENSITIVE);
			m = p.matcher(input);

			while (m.find()) {
				input = input.replaceAll("\\b(?i)" + regex + "\\b", "");
				m = p.matcher(input);
			}

			newInput += regex + " ";
			input = input.trim();
			arrayInput = input.split(" ");
		}
		return newInput.trim();
	}

	@Test
	public void testReplaceAll1() {
		String input = "Goodbye bye bye world world world";
		String expected = "Goodbye bye world";
		assertEquals(expected, replaceAll(input));
	}

	@Test
	public void testReplaceAll2() {
		String input = "Sam went went to to to his business";
		String expected = "Sam went to his business";
		assertEquals(expected, replaceAll(input));
	}

	@Test
	public void testReplaceAll3() {
		String input = "Reya is is the the best player in eye eye game";
		String expected = "Reya is the best player in eye game";
		assertEquals(expected, replaceAll(input));
	}

	@Test
	public void testReplaceAll4() {
		String input = "in inthe";
		String expected = "in inthe";
		assertEquals(expected, replaceAll(input));
	}

	@Test
	public void testReplaceAll5() {
		String input = "Hello hello Ab aB";
		String expected = "Hello Ab";
		assertEquals(expected, replaceAll(input));
	}

}
