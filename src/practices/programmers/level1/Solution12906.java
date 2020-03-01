package practices.programmers.level1;

import java.util.ArrayList;

import practices.commons.Tools;

/**
 * 같은 숫자는 싫어
 * 
 * @author hyemin
 *
 */
public class Solution12906 {

	public static int[] solution(int[] arr) {
		int[] newArr = new int[arr.length];
		int newArrIdx = 0;
		for (int i = 0; i < arr.length; i++) {
			if (i == 0) {
				newArr[newArrIdx++] = arr[i];
			} else {
				if (arr[i - 1] != arr[i]) {
					newArr[newArrIdx++] = arr[i];
				}
			}
		}

		arr = new int[newArrIdx];
		for (int i = 0; i < newArrIdx; i++) {
			arr[i] = newArr[i];
		}
		return arr;
	}

	public int[] better(int[] arr) {
		ArrayList<Integer> tempList = new ArrayList<Integer>();
		int preNum = 10;
		for (int num : arr) {
			if (preNum != num)
				tempList.add(num);
			preNum = num;
		}
		int[] answer = new int[tempList.size()];
		for (int i = 0; i < answer.length; i++) {
			answer[i] = tempList.get(i).intValue();
		}
		return answer;
	}

	public static void main(String[] args) {
		int[] testData = { 1, 1, 3, 3, 0, 1, 1 };
		Tools.printArray(solution(testData));
	}

}
