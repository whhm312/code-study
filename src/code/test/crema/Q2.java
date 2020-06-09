package code.test.crema;

import static java.util.stream.Collectors.toList;
import static org.junit.Assert.assertEquals;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

import org.junit.Test;

public class Q2 {
	@Test
	public void test2() {
		int expected = 1;
		int n = 2;
		List<Integer> sprints = new ArrayList<Integer>();
		sprints.add(1);
		sprints.add(5);
		assertEquals(expected, getMostVisited(n, sprints));
	}

	@Test
	public void test1() {
		int expected = 5;
		int n = 10;
		List<Integer> sprints = new ArrayList<Integer>();
		sprints.add(1);
		sprints.add(5);
		sprints.add(10);
		sprints.add(3);
		assertEquals(expected, getMostVisited(n, sprints));
	}

	public static int getMostVisited2(int n, List<Integer> sprints) {
		int maxSprint = Collections.max(sprints);
		int[] totalVisits = new int[maxSprint + 1];
		String[] visits = new String[totalVisits.length];
		
		int start = 0;
		int end = 0;
		int max = 0;
		int temp = 0;
		
		for (int i = 0; i < sprints.size() - 1; i++) {
			start = sprints.get(i);
			end = sprints.get(i + 1);
			
			if (start > end) {
				temp = start;
				start = end;
				end = temp;
			}
			
			for (int k = start; k <= end; k++) {
				totalVisits[k] = totalVisits[k] + 1;
				visits[k] = String.valueOf(totalVisits[k]);
				if (max < totalVisits[k]) {
					max = totalVisits[k];
				}
			}
		}
		List<String> listVisitedStr = new ArrayList<String>(Arrays.asList(visits));
		return listVisitedStr.indexOf(String.valueOf(max));
	}
	
	public static int getMostVisited(int n, List<Integer> sprints) {
		int maxSprint = Collections.max(sprints);
		int[] totalVisits = new int[maxSprint + 1];
		String[] visits = new String[totalVisits.length];

		int start = 0;
		int end = 0;
		int max = 0;
		int temp = 0;

		for (int i = 0; i < sprints.size() - 1; i++) {
			start = sprints.get(i);
			end = sprints.get(i + 1);

			if (start > end) {
				temp = start;
				start = end;
				end = temp;
			}

			for (int k = start; k <= end; k++) {
				totalVisits[k] = totalVisits[k] + 1;
				visits[k] = String.valueOf(totalVisits[k]);
				if (max < totalVisits[k]) {
					max = totalVisits[k];
				}
			}
		}
		List<String> listVisitedStr = new ArrayList<String>(Arrays.asList(visits));
		return listVisitedStr.indexOf(String.valueOf(max));
	}

	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

		int n = Integer.parseInt(bufferedReader.readLine().trim());

		int sprintsCount = Integer.parseInt(bufferedReader.readLine().trim());

		List<Integer> sprints = IntStream.range(0, sprintsCount).mapToObj(i -> {
			try {
				return bufferedReader.readLine().replaceAll("\\s+$", "");
			} catch (IOException ex) {
				throw new RuntimeException(ex);
			}
		}).map(String::trim).map(Integer::parseInt).collect(toList());

		int result = Q2.getMostVisited(n, sprints);

		bufferedWriter.write(String.valueOf(result));
		bufferedWriter.newLine();

		bufferedReader.close();
		bufferedWriter.close();
	}
}