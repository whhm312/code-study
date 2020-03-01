package practices.programmers.level1;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

/**
 * 소수 찾기
 * 
 * @author hyemin
 *
 */
//1부터 입력받은 숫자 n 사이에 있는 소수의 개수를 반환하는 함수, solution을 만들어 보세요.
//
//소수는 1과 자기 자신으로만 나누어지는 수를 의미합니다.
//(1은 소수가 아닙니다.)
//
//제한 조건
//n은 2이상 1000000이하의 자연수입니다.
public class Solution12921 {

	public int solution(int n) {
		List<Map<Integer, Integer>> arr = new ArrayList<Map<Integer, Integer>>();
		Map<Integer, Integer> map = null;
		for (int i = 2; i < n; i++) {
			map = new LinkedHashMap<Integer, Integer>();
			map.put(i, i);
			arr.add(map);
		}

		System.out.println(arr.toString());
		return arr.size();
	}

//	문제 설명
//	1부터 입력받은 숫자 n 사이에 있는 소수의 개수를 반환하는 함수, solution을 만들어 보세요.
//
//	소수는 1과 자기 자신으로만 나누어지는 수를 의미합니다.
//	(1은 소수가 아닙니다.)
//
//	제한 조건
//	n은 2이상 1000000이하의 자연수입니다.

	public int first(int n) {
//		찾고자 하는 범위의 자연수를 나열한다.
		int[] arr = new int[n];
		int num = 1;
		for (int i = 0; i < n; i++) {
			if (arr[i] % 2 != 0) {
				if (num == 1) {
					arr[i] = -1;
					num++;
				} else {
					arr[i] = num++;
				}
			}
		}

//		3부터 시작하여, 3의 배수를 지워나간다.
		int insideLoop = arr.length - 1;
		int outsideLoop = num - 1;
		for (int i = 3; i < outsideLoop; i++) {
			for (int j = insideLoop; j > 0; j--) {
				arr[j] = arr[j] > 1 && arr[j] != i && arr[j] % i == 0 ? -1 : arr[j];
			}
		}

		return arr.length;
	}

	public int second(int n) {
		int[] arr = createArray(n);

		int length = arr.length;
		int arrIdx = length - 1;
		int data = 0;
		int num = 2;

		while (num < length) {
			while (arrIdx > 0) {
				data = arr[arrIdx];
				if (data % num == 0 && data != num) {
					arr[arrIdx] = -1;
				}
				arrIdx--;
			}

			num++;
			arr = Arrays.stream(arr).filter(e -> e > 0).toArray();
			length = arr.length;
			arrIdx = length - 1;

			while (Arrays.binarySearch(arr, num) < 0) {
				num++;
			}
		}
		return arr.length;
	}

	private int[] createArray(int n) {
		int[] arr = new int[n];
		int num = 1;
		for (int i = 0; i < n; i++) {
			if (num == 1) {
				arr[i] = -1;
				num++;
			} else {
				arr[i] = num++;
			}
		}
		return arr;
	}

	@Test
	public void test1() {
		Solution12921 sol = new Solution12921();
		int n = 10;
		int result = 4;
		assertTrue(sol.second(n) == result);
	}

	@Test
	public void test2() {
		Solution12921 sol = new Solution12921();
		int n = 5;
		int result = 3;
		assertTrue(sol.second(n) == result);
	}

	@Test
	public void test3() {
		Solution12921 sol = new Solution12921();
		int n = 1;
		int result = 1;
		assertTrue(sol.second(n) == result);
	}

	@Test
	public void testSpeed() {
		Solution12921 sol = new Solution12921();
		int n = 1000000;
		int result = 78498;
		assertTrue(sol.second(n) == result);
	}

}
