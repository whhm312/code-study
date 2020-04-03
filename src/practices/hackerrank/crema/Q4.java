package practices.hackerrank.crema;

import static java.util.stream.Collectors.toList;
import static org.junit.Assert.assertEquals;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

import org.junit.Test;

public class Q4 {

	@Test
	public void test3() {
		int expected = 67;
		assertEquals(expected, droppedRequests(getList3()));
	}

	@Test
	public void test2() {
		int expected = 2;
		assertEquals(expected, droppedRequests(getList2()));
	}

	@Test
	public void test1() {
		int expected = 1;
		assertEquals(expected, droppedRequests(getList1()));
	}

	public static int droppedRequests(List<Integer> list) {
		int[][] limits = { { 1, 3 }, { 10, 20 }, { 60, 60 } };
		int[] reqTimes = list.stream().mapToInt(e -> e).toArray();
		return throttlingGateway(reqTimes, limits);
	}

	private static int throttlingGateway(int[] reqTime, int[][] limits) {
		int res = 0;
		Map<Integer, Integer> map = new HashMap<>();
		int max = Integer.MIN_VALUE;
		for (int i : reqTime) {
			map.put(i, map.getOrDefault(i, 0) + 1);
			max = Math.max(max, i);
		}
		
		int[] nums = new int[max + 1];
		for (int key : map.keySet()) {
			nums[key] = map.get(key);
		}
		int[] preSum = new int[nums.length];
		for (int i = 1; i < nums.length; i++) {
			preSum[i] = preSum[i - 1] + nums[i];
		}
		for (int[] limit : limits) {
			int time = Math.min(limit[0], preSum.length - 1);
			int maxCnt = limit[1];
			for (int i = 0; i < preSum.length - time; i++) {
				int cur = preSum[i + time] - preSum[i];
				res += cur > maxCnt ? cur - maxCnt : 0;
			}
		}
		return res;
	}

	public static int droppedRequestsB(List<Integer> list) {
		List<Integer> keys = new ArrayList<Integer>();
		for (int i = 0; i < list.size(); i++) {
			if (!keys.contains(list.get(i))) {
				keys.add(list.get(i));
			}
		}

		Map<Integer, Integer> droppedRequests = new HashMap<Integer, Integer>();
		int count = 0;

		int firstExceed = 3;

		int secondSecond = 10;
		int secondExceed = 20;

		int thirdSecond = 60;
		int thirdExceed = 60;
		for (int i = 0; i < keys.size(); i++) {
			for (int j = list.indexOf(keys.get(i)); j < list.size(); j++) {
				if (keys.get(i) == list.get(j)) {
					if (count >= firstExceed) {
						droppedRequests.put(j, 1);
					}
					count++;
				} else {
					break;
				}
			}
			count = 0;

			for (int j = list.indexOf(keys.get(i)); j < list.size(); j++) {
				if ((list.get(j) - keys.get(i)) < secondSecond) {
					if (!droppedRequests.containsKey(j) && count >= secondExceed) {
						droppedRequests.put(j, 1);
					}
					count++;
				} else {
					break;
				}
			}
			count = 0;

			for (int j = list.indexOf(keys.get(i)); j < list.size(); j++) {
				if ((list.get(j) - keys.get(i)) < thirdSecond) {
					if (!droppedRequests.containsKey(j) && count >= thirdExceed) {
						droppedRequests.put(j, 1);
					}
					count++;
				} else {
					break;
				}
			}
			count = 0;
		}

		return droppedRequests.values().size();
	}

	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

		int requestTimeCount = Integer.parseInt(bufferedReader.readLine().trim());

		List<String> requestTimeTemp = new ArrayList<>();

		IntStream.range(0, requestTimeCount).forEach(i -> {
			try {
				requestTimeTemp.add(bufferedReader.readLine().replaceAll("\\s+$", ""));
			} catch (IOException ex) {
				throw new RuntimeException(ex);
			}
		});

		List<Integer> requestTime = requestTimeTemp.stream().map(String::trim).map(Integer::parseInt).collect(toList());

		int res = droppedRequests(requestTime);

		bufferedWriter.write(String.valueOf(res));
		bufferedWriter.newLine();

		bufferedReader.close();
		bufferedWriter.close();
	}

	public static List<Integer> getList1() {
		List<Integer> list = new ArrayList<Integer>();
		list.add(1);
		list.add(1);
		list.add(1);
		list.add(1);
		list.add(2);
		return list;
	}

	public static List<Integer> getList2() {
		List<Integer> list = new ArrayList<Integer>();
		list.add(1);
		list.add(1);
		list.add(1);
		list.add(1);

		list.add(2);
		list.add(2);
		list.add(2);

		list.add(3);
		list.add(3);
		list.add(3);

		list.add(4);
		list.add(4);
		list.add(4);

		list.add(5);
		list.add(5);
		list.add(5);

		list.add(6);
		list.add(6);
		list.add(6);

		list.add(7);
		list.add(7);

		return list;
	}

	public static List<Integer> getList3() {
		List<Integer> list = new ArrayList<Integer>();
		list.add(1);
		list.add(1);
		list.add(1);
		list.add(1);

		list.add(2);
		list.add(2);
		list.add(2);

		list.add(3);
		list.add(3);
		list.add(3);
		list.add(3);

		list.add(4);

		list.add(5);
		list.add(5);
		list.add(5);

		list.add(6);
		list.add(6);
		list.add(6);
		list.add(6);

		list.add(7);
		list.add(7);
		list.add(7);

		list.add(8);
		list.add(8);
		list.add(8);
		list.add(8);

		list.add(9);
		list.add(9);
		list.add(9);
		list.add(9);
		list.add(9);

		list.add(10);
		list.add(10);

		list.add(11);
		list.add(11);
		list.add(11);
		list.add(11);
		list.add(11);
		list.add(11);

		list.add(12);
		list.add(12);
		list.add(12);
		list.add(12);
		list.add(12);
		list.add(12);
		list.add(12);

		list.add(13);
		list.add(13);
		list.add(13);
		list.add(13);

		list.add(14);
		list.add(14);
		list.add(14);
		list.add(14);
		list.add(14);

		list.add(16);
		list.add(16);
		list.add(16);
		list.add(16);
		list.add(16);
		list.add(16);

		list.add(17);
		list.add(17);
		list.add(17);

		list.add(18);
		list.add(18);
		list.add(18);
		list.add(18);
		list.add(18);
		list.add(18);
		list.add(18);
		list.add(18);

		list.add(19);
		list.add(19);
		list.add(19);
		list.add(19);
		list.add(19);
		list.add(19);
		list.add(19);

		list.add(20);
		list.add(20);
		list.add(20);
		list.add(20);
		list.add(20);
		return list;
	}
}
