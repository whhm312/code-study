package practices.programmers.level2;

import static org.junit.Assert.assertArrayEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.Test;

public class Solution42586 {
	public int[] betterSolution(int[] progresses, int[] speeds) {
		int[] dayOfend = new int[100];
		int day = -1;
		for (int i = 0; i < progresses.length; i++) {
			while (progresses[i] + (day * speeds[i]) < 100) {
				day++;
			}
			dayOfend[day]++;
		}
		return Arrays.stream(dayOfend).filter(i -> i != 0).toArray();
	}

	public int[] solution(int[] progresses, int[] speeds) {
		int[] dayOfEnd = new int[100];
		int day = -1;
		for (int i = 0; i < progresses.length; i++) {
			while (progresses[i] + (day * speeds[i]) < 100) {
				day++;
			}
			dayOfEnd[day]++;
		}
		return Arrays.stream(dayOfEnd).filter(i -> i != 0).toArray();
	}

	public int[] originSolution(int[] progresses, int[] speeds) {
		int releasCount = 0;
		List<Integer> resultList = new ArrayList<Integer>();
		List<Integer> progressList = Arrays.stream(progresses).boxed().collect(Collectors.toList());
		List<Integer> speedList = Arrays.stream(speeds).boxed().collect(Collectors.toList());
		while (progressList.size() > 0) {
			if (progressList.get(0) >= 100) {
				releasCount++;
				progressList.remove(0);
				speedList.remove(0);

				if (progressList.isEmpty()) {
					resultList.add(releasCount);
					releasCount = 0;
				}
			} else {
				if (releasCount > 0) {
					resultList.add(releasCount);
					releasCount = 0;
				} else {
					for (int i = 0; i < progressList.size(); i++) {
						progressList.set(i, progressList.get(i) + speedList.get(i));
					}
				}
			}
		}

		int[] answer = new int[resultList.size()];
		for (int i = 0; i < answer.length; i++) {
			answer[i] = resultList.get(i);
		}
		return answer;
	}

	@Test
	public void test1() {
		int[] expecteds = { 2, 1 };
		int[] progresses = { 93, 30, 55 };
		int[] speeds = { 1, 30, 5 };
		assertArrayEquals(expecteds, solution(progresses, speeds));
	}
}
