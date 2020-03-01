package practices.programmers.kakao;

import static org.junit.Assert.assertArrayEquals;

import org.junit.Test;

/**
 * [1차] 비밀지도
 * 
 * @author hyemin
 *
 */
public class Solution17681 {

//	지도는 한 변의 길이가 n인 정사각형 배열 형태로, 각 칸은 공백(" ) 또는벽(#") 두 종류로 이루어져 있다.
//	전체 지도는 두 장의 지도를 겹쳐서 얻을 수 있다. 각각 지도 1과 지도 2라고 하자. 
//	지도 1 또는 지도 2 중 어느 하나라도 벽인 부분은 전체 지도에서도 벽이다. 
//	지도 1과 지도 2에서 모두 공백인 부분은 전체 지도에서도 공백이다.	

//	지도 1과 지도 2는 각각 정수 배열로 암호화되어 있다.
//	암호화된 배열은 지도의 각 가로줄에서 벽 부분을 1, 공백 부분을 0으로 부호화했을 때 얻어지는 이진수에 해당하는 값의 배열이다.

	public String appendZero(int totalLength, String str) {
		String addZero = "";
		if (str.length() < totalLength) {
			for (int j = 0; j < totalLength - str.length(); j++) {
				addZero = "0" + addZero;
			}
			str = addZero + str;
		}
		return str;
	}

	public String[] solution(int n, int[] arr1, int[] arr2) {
		String[] answer = new String[n];
		for (int i = 0; i < answer.length; i++) {
			answer[i] = "";
		}

		String binaryArr1 = null;
		String[] binaryArrs = null;
		String binaryArr2 = null;
		for (int i = 0; i < n; i++) {
			binaryArr1 = Integer.toBinaryString(arr1[i]);
			binaryArr1 = appendZero(n, binaryArr1);
			binaryArrs = binaryArr1.split("");
			for (int j = 0; j < n; j++) {
				if ("1".equals(binaryArrs[j])) {
					answer[i] += "#";
				} else {
					answer[i] += "B";
				}
			}
		}

		String[] answers = null;
		String newAnswer = "";
		for (int i = 0; i < n; i++) {
			binaryArr2 = Integer.toBinaryString(arr2[i]);
			binaryArr2 = appendZero(n, binaryArr2);
			binaryArrs = binaryArr2.split("");
			answers = answer[i].split("");
			for (int j = 0; j < binaryArrs.length; j++) {
				if ("1".equals(binaryArrs[j])) {
					if (!"#".equals(answers[j])) {
						newAnswer += "#";
					} else {
						newAnswer += answers[j];
					}
				} else {
					if (!"#".equals(answers[j])) {
						newAnswer += "B";
					} else {
						newAnswer += answers[j];
					}
				}
			}
			answer[i] = newAnswer;
			newAnswer = "";
		}

		for (int i = 0; i < answer.length; i++) {
			answer[i] = answer[i].replace("B", " ");
		}
		return answer;
	}

	public String[] better(int n, int[] arr1, int[] arr2) {
		String[] result = new String[n];
		for (int i = 0; i < n; i++) {
			result[i] = Integer.toBinaryString(arr1[i] | arr2[i]);
		}

		for (int i = 0; i < n; i++) {
			result[i] = String.format("%" + n + "s", result[i]);
			result[i] = result[i].replaceAll("1", "#");
			result[i] = result[i].replaceAll("0", " ");
		}

		return result;
	}

	@Test
	public void test1() {
		int n = 5;
		int[] arr1 = { 9, 20, 28, 18, 11 };
		int[] arr2 = { 30, 1, 21, 17, 28 };
		String[] expecteds = { "#####", "# # #", "### #", "#  ##", "#####" };
		assertArrayEquals(expecteds, solution(n, arr1, arr2));
	}

	@Test
	public void test2() {
		int n = 6;
		int[] arr1 = { 46, 33, 33, 22, 31, 50 };
		int[] arr2 = { 27, 56, 19, 14, 14, 10 };
		String[] expecteds = { "######", "###  #", "##  ##", " #### ", " #####", "### # " };
		assertArrayEquals(expecteds, solution(n, arr1, arr2));
	}
}
