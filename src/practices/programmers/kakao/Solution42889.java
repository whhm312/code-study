package practices.programmers.kakao;

import static org.junit.Assert.assertArrayEquals;

import java.util.Arrays;

import org.junit.Test;

/**
 * 실패율
 * 
 * @author hyemin
 *
 */
public class Solution42889 {
//	실패율은 다음과 같이 정의한다.
//	스테이지에 도달했으나 아직 클리어하지 못한 플레이어의 수 / 스테이지에 도달한 플레이어 수
//	 (일부값 ÷ 전체값) ×100

//	전체 스테이지의 개수 N, 
//	게임을 이용하는 사용자가 현재 멈춰있는 스테이지의 번호가 담긴 배열 stages가 매개변수로 주어질 때, 
//	실패율이 높은 스테이지부터 내림차순으로 스테이지의 번호가 담겨있는 배열을 return 하도록 solution 함수를 완성하라.
	/**
	 * 
	 * @param N      : 스테이지의 개수, 1 이상 500 자연수
	 * @param stages : stages의 길이, 1 이상 200,000 이하, N+1의 경우는 스테이지 클리어.
	 * @return
	 */
	public int[] solution(int N, int[] stages) {
		float[] floatResult = floatPercentages(N, stages);
		return sortPercents(floatResult);
	}

	public int[] sortPercents(float[] result) {
		float[] originResult = result.clone();
		int length = result.length;
		float temp = 0F;
		for (int i = 0; i < length - 1; i++) {
			for (int j = length - 1; j > i; j--) {
				if (result[j - 1] < result[j]) {
					temp = result[j];
					result[j] = result[j - 1];
					result[j - 1] = temp;
				}
			}
		}
		return exchangeStages(originResult, result);
	}

	public int[] exchangeStages(float[] originResult, float[] result) {
		int[] answers = new int[originResult.length];
		for (int i = 0; i < originResult.length; i++) {
			for (int f = 0; f < result.length; f++) {
				if (originResult[i] == result[f]) {
					answers[f] = i + 1;
					result[f] = -1;
					break;
				}
			}
		}
		return answers;
	}

	public int[] sort(float[] result) {
		int[] sortedResult = new int[result.length];
		float[] originResult = result.clone();

		// 오름차순 정렬
		Arrays.sort(result);

		// 내림차순 정렬
		int newIdx = 0;
		float[] newResult = new float[result.length];
		for (int i = result.length - 1; i > 0; i--) {
			newResult[newIdx++] = result[i];
		}

		// 스테이지로 변경
		for (int i = 0; i < originResult.length; i++) {
			for (int f = 0; f < newResult.length; f++) {
				if (originResult[i] == newResult[f]) {
					sortedResult[f] = i + 1;
					newResult[f] = -1;
					break;
				}
			}
		}

		return sortedResult;
	}

	public float[] floatPercentages(int N, int[] stages) {
		float[] result = new float[N];
		int TOTAL_USER_CNT = stages.length;
		int failureCnt = 0; // 현재 스테이지 진행중인 사람 == 실패자
		int passCnt = 0; // 해당 스테이지에 못도달 한 사람
		int stage = 0;

		for (int i = 0; i < N; i++) {
			stage++;
			passCnt = 0;
			failureCnt = 0;

			for (int j = 0; j < TOTAL_USER_CNT; j++) {
				failureCnt += stages[j] == stage ? 1 : 0;
				passCnt += stages[j] < stage ? 1 : 0;
			}
			if (TOTAL_USER_CNT == passCnt) {
				result[i] = 0;
			} else {
				result[i] = ((float) failureCnt / (float) (TOTAL_USER_CNT - passCnt)) * 100;
			}
		}

		return result;
	}

	private int[] createFailPercentages(int N, int[] stages) {
		int[] result = new int[N];
		int TOTAL_USER_CNT = stages.length;
		int failureCnt = 0; // 현재 스테이지 진행중인 사람 == 실패자
		int passCnt = 0; // 해당 스테이지에 못도달 한 사람
		int stage = 0;

		for (int i = 0; i < N; i++) {
			stage++;
			passCnt = 0;
			failureCnt = 0;

			for (int j = 0; j < TOTAL_USER_CNT; j++) {
				failureCnt += stages[j] == stage ? 1 : 0;
				passCnt += stages[j] < stage ? 1 : 0;
			}
			result[i] = (int) (((float) failureCnt / (float) (TOTAL_USER_CNT - passCnt)) * 100);
		}

		return result;
	}

	@Test
	public void testCreateFailPercentages() {
		int N = 5;
		int[] stages = { 2, 1, 2, 6, 2, 4, 3, 3 };
		int[] expecteds = { (int) (((float) 1 / (float) 8) * 100), (int) (((float) 3 / (float) 7) * 100),
				(int) (((float) 2 / (float) 4) * 100), (int) (((float) 1 / (float) 2) * 100),
				(int) (((float) 0 / (float) 1) * 100) };
		assertArrayEquals(expecteds, createFailPercentages(N, stages));
	}

	@Test
	public void testSort() {
		float[] createFailPercentages = { ((float) 1 / (float) 8) * 100, ((float) 3 / (float) 7) * 100,
				((float) 2 / (float) 4) * 100, ((float) 1 / (float) 2) * 100, ((float) 0 / (float) 1) * 100 };
		int[] expecteds = { 3, 4, 2, 1, 5 };
		assertArrayEquals(expecteds, sort(createFailPercentages));
	}

	@Test
	public void test1() {
		int N = 5;
		int[] stages = { 2, 1, 2, 6, 2, 4, 3, 3 };
		int[] expecteds = { 3, 4, 2, 1, 5 };
		assertArrayEquals(expecteds, solution(N, stages));
	}

	@Test
	public void test2() {
		int N = 4;
		int[] stages = { 4, 4, 4, 4, 4 };
		int[] expecteds = { 4, 1, 2, 3 };
		assertArrayEquals(expecteds, solution(N, stages));
	}

	@Test
	public void test3() {
		int N = 5;
		int[] stages = { 4, 4, 4, 4, 4 };
		int[] expecteds = { 4, 1, 2, 3, 5 };
		assertArrayEquals(expecteds, solution(N, stages));
	}
}
