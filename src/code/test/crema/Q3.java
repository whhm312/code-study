package code.test.crema;

import static java.util.stream.Collectors.toList;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

class Result {

	public static int longestChain(List<String> words) {
		Collections.sort(words, new Comparator<String>() {
			@Override
			public int compare(String a, String b) {
				return a.length() - b.length();
			}
		});

		int longest = 0;
		Map<String, Integer> map = new HashMap<String, Integer>();
		for (String word : words) {
			int max = 0;
			for (int i = 0; i < word.length(); ++i) {
				String prev = word.substring(0, i) + word.substring(i + 1);
				max = Math.max(max, map.getOrDefault(prev, 0) + 1);
			}
			map.put(word, max);
			longest = Math.max(longest, max);
		}
		return longest;
	}

}

public class Q3 {

	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

		int wordsCount = Integer.parseInt(bufferedReader.readLine().trim());

		List<String> words = IntStream.range(0, wordsCount).mapToObj(i -> {
			try {
				return bufferedReader.readLine();
			} catch (IOException ex) {
				throw new RuntimeException(ex);
			}
		}).collect(toList());

		int result = Result.longestChain(words);

		bufferedWriter.write(String.valueOf(result));
		bufferedWriter.newLine();

		bufferedReader.close();
		bufferedWriter.close();
	}
}