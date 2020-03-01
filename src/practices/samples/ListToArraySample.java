package practices.samples;

import static org.junit.Assert.assertArrayEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class ListToArraySample {

	private String[] toStringArray(List<String> list) {
		String[] array = new String[list.size()];
		list.toArray(array);
		return array;
	}

	private int[] toIntArray(List<Integer> list) {
		return list.stream().mapToInt(e -> e).toArray();
	}

	@Test
	public void testToIntArray() {
		int aa = 1;
		int bb = 2;

		List<Integer> list = new ArrayList<Integer>();
		list.add(aa);
		list.add(bb);

		int[] expecteds = { aa, bb };
		assertArrayEquals(expecteds, toIntArray(list));
	}

	@Test
	public void testToStringArray() {
		String aa = "aa";
		String bb = "bb";

		List<String> list = new ArrayList<String>();
		list.add(aa);
		list.add(bb);

		String[] expecteds = { aa, bb };
		assertArrayEquals(expecteds, toStringArray(list));
	}
}
