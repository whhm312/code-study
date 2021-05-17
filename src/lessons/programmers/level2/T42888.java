package lessons.programmers.level2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;

/**
 * 오픈채팅방 https://programmers.co.kr/learn/courses/30/lessons/42888
 * 
 * @author whhm312
 *
 */
public class T42888 {
	public String[] solution(String[] record) {
		String[] tempInfo;

		Map<String, String> nickNames = new HashMap<String, String>();
		for (String member : record) {
			tempInfo = member.split(" ");
			if (tempInfo.length > 2) {
				nickNames.put(tempInfo[1], tempInfo[2]);
			}
		}

		List<String> answer = new ArrayList<String>();
		for (int i = 0; i < record.length; i++) {
			tempInfo = record[i].split(" ");
			if ("Enter".equals(tempInfo[0])) {
				answer.add(nickNames.get(tempInfo[1]) + "님이 들어왔습니다.");
			} else if ("Leave".equals(tempInfo[0])) {
				answer.add(nickNames.get(tempInfo[1]) + "님이 나갔습니다.");
			}
		}

		return answer.toArray(new String[answer.size()]);
	}

	@Test
	public void test1() {
		String[] record = { "Enter uid1234 Muzi", "Enter uid4567 Prodo", "Leave uid1234", "Enter uid1234 Prodo",
				"Change uid4567 Ryan" };
		String[] expecteds = { "Prodo님이 들어왔습니다.", "Ryan님이 들어왔습니다.", "Prodo님이 나갔습니다.", "Prodo님이 들어왔습니다." };

		Assert.assertArrayEquals(expecteds, solution(record));
	}
}
