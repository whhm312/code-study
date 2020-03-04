package practices.hackerrank.easy;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import org.junit.Test;

public class JavaMap {
	public static void main(String[] argh) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		in.nextLine();

		Map<String, Integer> phoneBook = new LinkedHashMap<String, Integer>();
		for (int i = 0; i < n; i++) {
			put(phoneBook, in.nextLine(), in.nextInt());
			in.nextLine();
		}

		List<String> resultList = new ArrayList<String>();
		while (in.hasNext()) {
			resultList.add(pop(phoneBook, in.nextLine()));
		}
		in.close();

		for (String val : resultList) {
			System.out.println(val);
		}
	}

	private static Map<String, Integer> put(Map<String, Integer> map, String key, int value) {
		map.put(key, value);
		return map;
	}

	private static String pop(Map<String, Integer> map, String key) {
		if (map.containsKey(key)) {
			return key + "=" + map.get(key);
		} else {
			return "Not found";
		}
	}

	@Test
	public void testGet1() {
		Map<String, Integer> phoneBook = create();
		String expected = "uncle sam=99912222";
		assertEquals(expected, pop(phoneBook, "uncle sam"));
	}

	@Test
	public void testGet2() {
		Map<String, Integer> phoneBook = create();
		String expected = "Not found";
		assertEquals(expected, pop(phoneBook, "uncle tom"));
	}

	@Test
	public void testGet3() {
		Map<String, Integer> phoneBook = create();
		String expected = "harry=12299933";
		assertEquals(expected, pop(phoneBook, "harry"));
	}

	@Test
	public void testPut() {
		Map<String, Integer> phoneBook = create();

		Map<String, Integer> expected = new LinkedHashMap<String, Integer>();
		expected.put("uncle sam", 99912222);
		expected.put("tom", 11122222);
		expected.put("harry", 12299933);

		assertEquals(expected, phoneBook);
	}

	private Map<String, Integer> create() {
		Map<String, Integer> phoneBook = new LinkedHashMap<String, Integer>();
		put(phoneBook, "uncle sam", 99912222);
		put(phoneBook, "tom", 11122222);
		put(phoneBook, "harry", 12299933);
		return phoneBook;
	}

}
