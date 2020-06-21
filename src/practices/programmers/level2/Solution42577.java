package practices.programmers.level2;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;

import org.junit.Test;

public class Solution42577 {
	public boolean solution(String[] phone_book) {
		Arrays.sort(phone_book);

		for (int i = 0; i < phone_book.length; i++) {
			for (int j = i + 1; j < phone_book.length; j++) {
				if (phone_book[j].indexOf(phone_book[i]) == 0) {
					return false;
				}
			}
		}

		return true;
	}

	@Test
	public void test1() {
		String[] phone_book = { "119", "97674223", "1195524421" };
		assertFalse(solution(phone_book));
	}

	@Test
	public void test2() {
		String[] phone_book = { "123", "456", "789" };
		assertTrue(solution(phone_book));
	}

	@Test
	public void test3() {
		String[] phone_book = { "12", "123", "1235", "567", "88" };
		assertFalse(solution(phone_book));
	}
}
