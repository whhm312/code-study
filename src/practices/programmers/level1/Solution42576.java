package practices.programmers.level1;

import java.util.Arrays;
import java.util.HashMap;

/**
 * 완주하지 못한 선수
 * 
 * @author hyemin
 *
 */
public class Solution42576 {
	public String solution(String[] participant, String[] completion) {
		Arrays.sort(participant);
		Arrays.sort(completion);

		String answer = "";
		String name = null;

		// 있는지 여부 검사
		boolean isFinished = false;
		for (int i = 0; i < participant.length; i++) {
			name = participant[i];
			for (int j = 0; j < completion.length; j++) {
				isFinished = name.equals(completion[j]);
				if (isFinished) {
					break;
				}
			}

			if (!isFinished) {
				return name;
			}
		}

		// 동명 이인 검사
		int partDuplCnt = 0;
		int compDuplCnt = 0;
		int fromIndex = 0;
		String partStr = Arrays.toString(participant);
		String compStr = Arrays.toString(completion);
		for (int i = 0; i < participant.length; i++) {
			name = participant[i];
			while ((fromIndex = partStr.indexOf(name, fromIndex)) > -1) {
				fromIndex++;
				partDuplCnt++;
			}

			fromIndex = 0;
			if (partDuplCnt > 1) {
				while ((fromIndex = compStr.indexOf(name, fromIndex)) > -1) {
					fromIndex++;
					compDuplCnt++;
				}

				if (partDuplCnt != compDuplCnt) {
					return name;
				}
				compDuplCnt = 0;
			}
			partDuplCnt = 0;
		}
		return answer;
	}

	public String better(String[] participant, String[] completion) {
		String answer = "";
		HashMap<String, Integer> hm = new HashMap<>();
		for (String player : participant)
			hm.put(player, hm.getOrDefault(player, 0) + 1);
		for (String player : completion)
			hm.put(player, hm.get(player) - 1);

		for (String key : hm.keySet()) {
			if (hm.get(key) != 0) {
				answer = key;
			}
		}
		return answer;
	}

	public static void main(String[] args) {
		Solution42576 solution42076 = new Solution42576();
//		String[] participant = { "marina", "josipa", "nikola", "vinko", "filipa" };
//		String[] completion = { "marina", "josipa", "nikola", "filipa" };
//		String[] participant = { "leo", "kiki", "eden" };
//		String[] completion = { "eden", "kiki" };

		String[] participant = { "mislav", "stanko", "ana", "ana", "sa" };
		String[] completion = { "stanko", "ana", "mislav", "ana" };
		System.out.println(solution42076.solution(participant, completion));
	}

}
