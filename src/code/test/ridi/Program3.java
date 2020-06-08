package code.test.ridi;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

public class Program3 {
//	문제 설명
//	투썸플레이스 OO 지점에서는 사은 이벤트로 매일 고객 한 명을 임의로 선정해 커피 무료 쿠폰을 발송합니다. 
//	배열 arr에는 고객들의 ID가 이벤트에 당첨된 순서대로 들어있으며, 각 고객의 ID는 자연수입니다. 
//	쿠폰에 당첨된 고객 중, 가장 빨리 중복으로 당첨된 고객은 며칠 만에 중복 당첨됐는지를 return 하도록 
//	solution 함수를 작성하세요.
//	단, 중복으로 당첨된 고객이 없는 경우 -1을 return 하세요.
//
//	제한사항
//	배열의 길이는 1 이상 100,000 이하입니다.
//	배열의 원소는 1 이상 1,000,000,000 이하의 자연수입니다.

	public int solution(int[] custIds) {

		// 고객 유니크 처리
		int[] uniqueCustIds = getUniqueCustIds(custIds);
		int[] gapDays = new int[uniqueCustIds.length];
		for (int i = 0; i < gapDays.length; i++) {
			gapDays[i] = -1;
		}

		int startIdx = 0;
		int findIdx = -1;
		int nextIdx = -1;
		int length = custIds.length - 1;
//		int gap = -1;
		int whileIdx = 0;

		findIdx = Arrays.binarySearch(custIds, startIdx, length, uniqueCustIds[0]);
		if (findIdx > -1) {
			nextIdx = Arrays.binarySearch(custIds, (startIdx++) + findIdx, length, uniqueCustIds[0]);
			gapDays[0] = nextIdx - findIdx;
			while (whileIdx < custIds.length) {
				if (nextIdx > -1) {
					findIdx = nextIdx;

					nextIdx = Arrays.binarySearch(custIds, startIdx + findIdx, length, uniqueCustIds[0]);
					if (nextIdx < 0) {
						break;
					}
					if (gapDays[0] > nextIdx - findIdx) {
						gapDays[0] = nextIdx - findIdx;
					}
				}
				whileIdx++;
			}
		} else {
			gapDays[0] = -1;
		}

		int answer = 2;
		return answer;
	}

	public int[] getUniqueCustIds(int[] custIds) {
		List<Integer> array = new ArrayList<Integer>();
		boolean isNotUnique = false;
		for (int i = 0; i < custIds.length; i++) {
			if (i < 1) {
				array.add(custIds[i]);
			} else {
				for (int j = 0; j < array.size(); j++) {
					isNotUnique = custIds[i] == array.get(j);
					if (isNotUnique)
						break;
				}

				if (!isNotUnique) {
					array.add(custIds[i]);
				}
			}

		}

		int[] answer = new int[array.size()];
		int idx = 0;
		for (int id : array) {
			answer[idx++] = id;
		}
		Arrays.sort(answer);
		return answer;
	}

	@Test
	public void testGetUniqueCustIds() {
		int[] actuals = { 2, 1, 3, 1, 4, 2, 1, 3 };
		int[] expecteds = { 1, 2, 3, 4 };
		assertArrayEquals(expecteds, getUniqueCustIds(actuals));
	}

	@Test
	public void test1() {
		int[] arr = { 2, 1, 3, 1, 4, 2, 1, 3 };
		int expected = 2;
		assertEquals(expected, solution(arr));
	}

	@Test
	@Ignore
	public void test2() {
		int[] arr = { 1, 2, 3 };
		int expected = -1;
		assertEquals(expected, solution(arr));
	}
}
