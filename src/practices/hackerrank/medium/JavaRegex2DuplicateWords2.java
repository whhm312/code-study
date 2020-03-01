package practices.hackerrank.medium;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.Test;

public class JavaRegex2DuplicateWords2 {

	public String[] replaceAll(int numSentences, String[] inputs) {
		String[] array = new String[numSentences];
		int arrayIdx = 0;
		String regex = "\\b(\\w+)(?:\\W+\\1\\b)+";
		Pattern p = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);

		int idx = 0;
		while (numSentences-- > 0) {
			String input = inputs[idx++];
			Matcher m = p.matcher(input);

			// Check for subsequences of input that match the compiled pattern
			while (m.find()) {
				input = input.replaceAll(m.group(), m.group(1));
			}

			// Prints the modified sentence.
			array[arrayIdx++] = input;
		}
		return array;
	}

	public String replace(String input) {
		String regex = "\\b(\\w+)(?:\\W+\\1\\b)+";
		Pattern p = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
		Matcher m = p.matcher(input);

		// Check for subsequences of input that match the compiled pattern
		while (m.find()) {
			input = input.replaceAll(m.group(), m.group(1));
		}
		return input;
	}

	@Test
	public void testReplaceAll() {
		int totalCnt = 5;
		int idx = 0;
		String[] array = new String[totalCnt];
		array[idx++] = "Goodbye bye bye world world world";
		array[idx++] = "Sam went went to to to his business";
		array[idx++] = "Reya is is the the best player in eye eye game";
		array[idx++] = "in inthe";
		array[idx++] = "Hello hello Ab aB";

		idx = 0;
		String[] expecteds = new String[totalCnt];
		expecteds[idx++] = "Goodbye bye world";
		expecteds[idx++] = "Sam went to his business";
		expecteds[idx++] = "Reya is the best player in eye game";
		expecteds[idx++] = "in inthe";
		expecteds[idx++] = "Hello Ab";

		assertArrayEquals(expecteds, replaceAll(totalCnt, array));
	}

	@Test
	public void testReplace1() {
		String input = "Goodbye bye bye world world world";
		String expected = "Goodbye bye world";
		assertEquals(expected, replace(input));
	}

	@Test
	public void testReplace2() {
		String input = "Sam went went to to to his business";
		String expected = "Sam went to his business";
		assertEquals(expected, replace(input));
	}

	@Test
	public void testReplace3() {
		String input = "Reya is is the the best player in eye eye game";
		String expected = "Reya is the best player in eye game";
		assertEquals(expected, replace(input));
	}

	@Test
	public void testReplace4() {
		String input = "in inthe";
		String expected = "in inthe";
		assertEquals(expected, replace(input));
	}

	@Test
	public void testReplace5() {
		String input = "Hello hello Ab aB";
		String expected = "Hello Ab";
		assertEquals(expected, replace(input));
	}

}
