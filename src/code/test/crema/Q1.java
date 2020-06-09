package code.test.crema;

import static java.util.stream.Collectors.toList;
import static org.junit.Assert.assertEquals;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

import org.junit.Test;

public class Q1 {

	@Test
	public void test8() {
		int expected = 3;
		int k = 2;
		List<Integer> marks = new ArrayList<Integer>();
		marks.add(7);
		marks.add(8);
		marks.add(9);
		marks.add(9);
		marks.add(10);
		assertEquals(expected, numofPrizes(k, marks));
	}

	public void test7() {
		int expected = 2;
		int k = 2;
		List<Integer> marks = new ArrayList<Integer>();
		marks.add(0);
		marks.add(0);
		marks.add(0);
		marks.add(9);
		marks.add(10);
		assertEquals(expected, numofPrizes(k, marks));
	}

	@Test
	public void test6() {
		int expected = 1;
		int k = 4;
		List<Integer> marks = new ArrayList<Integer>();
		marks.add(0);
		marks.add(0);
		marks.add(0);
		marks.add(0);
		marks.add(1);
		assertEquals(expected, numofPrizes(k, marks));
	}

	@Test
	public void test5() {
		int expected = 4;
		int k = 4;
		List<Integer> marks = new ArrayList<Integer>();
		marks.add(0);
		marks.add(1);
		marks.add(1);
		marks.add(1);
		marks.add(1);
		assertEquals(expected, numofPrizes(k, marks));
	}

	@Test
	public void test4() {
		int expected = 5;
		int k = 4;
		List<Integer> marks = new ArrayList<Integer>();
		marks.add(1);
		marks.add(1);
		marks.add(1);
		marks.add(1);
		marks.add(1);
		assertEquals(expected, numofPrizes(k, marks));
	}

	@Test
	public void test3() {
		int expected = 0;
		int k = 4;
		List<Integer> marks = new ArrayList<Integer>();
		marks.add(0);
		marks.add(0);
		marks.add(0);
		marks.add(0);
		marks.add(0);
		assertEquals(expected, numofPrizes(k, marks));
	}

	@Test
	public void test2() {
		int expected = 5;
		int k = 4;
		List<Integer> marks = new ArrayList<Integer>();
		marks.add(2);
		marks.add(2);
		marks.add(3);
		marks.add(4);
		marks.add(5);
		assertEquals(expected, numofPrizes(k, marks));
	}

	@Test
	public void test1() {
		int expected = 4;
		int k = 4;
		List<Integer> marks = new ArrayList<Integer>();
		marks.add(20);
		marks.add(40);
		marks.add(60);
		marks.add(80);
		marks.add(100);
		assertEquals(expected, numofPrizes(k, marks));
	}

	public static int numofPrizes(int k, List<Integer> marks) {
		Collections.sort(marks);
		Collections.reverse(marks);
		for (int i = marks.size() - 1; i >= 0; i--) {
			if (marks.get(i) == 0) {
				marks.remove(i);
			} else {
				break;
			}
		}
		if (marks.size() == 0) {
			return 0;
		}

		int result = 0;
		int count = 0;
		int[] ranks = new int[marks.size()];
		ranks[0] = 1;

		for (int i = 1; i < ranks.length; i++) {
			if (marks.get(i) == marks.get(i - 1)) {
				ranks[i] = ranks[i - 1];
				count++;
			} else {
				if (count > 0) {
					ranks[i] = ranks[i - 1] + 1 + count;
					count = 0;
				} else {
					ranks[i] = i + 1;
				}
			}
		}

		for (int i = 0; i < ranks.length; i++) {
			if (ranks[i] <= k) {
				result++;
			} else {
				break;
			}
		}
		return result;
	}

	/**
	 * 
	 * @param k     : 상 받을 최대 랭킹
	 * @param marks : 점수, 오름차순, 0 점은 무조건 못받음.
	 * @return
	 */
	public static int numofPrizes2(int k, List<Integer> marks) {
		marks.removeIf(n -> n == 0);
		if (marks.size() == 0) {
			return 0;
		}

		Collections.reverse(marks);

		int result = 0;
		int count = 0;

		int[] ranks = new int[marks.size()];
		ranks[0] = 1;

		for (int i = 1; i < ranks.length; i++) {
			if (marks.get(i) == marks.get(i - 1)) {
				ranks[i] = ranks[i - 1];
				count++;
			} else {
				if (count > 0) {
					ranks[i] = ranks[i - 1] + 1 + count;
					count = 0;
				} else {
					ranks[i] = i + 1;
				}
			}
		}

		for (int j = 0; j < ranks.length; j++) {
			if (ranks[j] <= k) {
				result++;
			} else {
				break;
			}
		}
		return result;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

		int k = Integer.parseInt(bufferedReader.readLine().trim());

		int marksCount = Integer.parseInt(bufferedReader.readLine().trim());

		List<Integer> marks = IntStream.range(0, marksCount).mapToObj(i -> {
			try {
				return bufferedReader.readLine().replaceAll("\\s+$", "");
			} catch (IOException ex) {
				throw new RuntimeException(ex);
			}
		}).map(String::trim).map(Integer::parseInt).collect(toList());

		int result = Q1.numofPrizes(k, marks);

		bufferedWriter.write(String.valueOf(result));
		bufferedWriter.newLine();

		bufferedReader.close();
		bufferedWriter.close();
	}
}