package practices.programmers.level2;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.junit.Test;

public class Solution49993 {

	public int betterSolution(String skill, String[] skill_trees) {
		int answer = 0;
		ArrayList<String> skillTrees = new ArrayList<String>(Arrays.asList(skill_trees));
		Iterator<String> it = skillTrees.iterator();

		while (it.hasNext()) {
			if (skill.indexOf(it.next().replaceAll("[^" + skill + "]", "")) != 0) {
				it.remove();
			}
		}
		answer = skillTrees.size();
		return answer;
	}

	public int solution(String skill, String[] skill_trees) {
		int answer = 0;
		List<String> skillTrees = new ArrayList<String>(Arrays.asList(skill_trees));
		Iterator<String> it = skillTrees.iterator();
		while (it.hasNext()) {
			String s = it.next().replaceAll("[^" + skill + "]", "");
			System.out.println("S : " + s);

			if (skill.indexOf(s) != 0) {
				it.remove();
			}
		}
		answer = skillTrees.size();
		return answer;
	}

	public int mySolution(String skill, String[] skill_trees) {
		String[] skillArray = skill.split("");
		int[] skillIndexArray = null;

		int answer = 0;
		for (int i = 0; i < skill_trees.length; i++) {
			skillIndexArray = indexOfs(skillArray, skill_trees[i]);
			answer += isRightSkillTree(skillIndexArray);
		}

		return answer;
	}

	private int isRightSkillTree(int[] skillIndexArray) {
		int count = 0;
		for (int i = 0; i < skillIndexArray.length; i++) {
			if (i == 0 && skillIndexArray[i] > -1) {
				count++;
			} else if (skillIndexArray[i] < 0) {
				count++;
			}
		}
		if (count == skillIndexArray.length) {
			return 1;
		}

		if (skillIndexArray[0] < 0 || skillIndexArray[1] < skillIndexArray[0]) {
			return 0;
		}

		if (skillIndexArray.length > 2) {
			for (int i = 2; i < skillIndexArray.length; i++) {
				if (skillIndexArray[i] > -1 && skillIndexArray[i] < skillIndexArray[i - 1]) {
					return 0;
				}
			}
		}

		return 1;
	}

	private int[] indexOfs(String[] skillArray, String skillTree) {
		int[] indexs = new int[skillArray.length];
		for (int i = 0; i < skillArray.length; i++) {
			indexs[i] = skillTree.indexOf(skillArray[i]);
		}
		return indexs;
	}

	@Test
	public void test1() {
		int expected = 2;
		String skill = "CBD";
		String[] skill_trees = { "BACDE", "CBADF", "AECB", "BDA" };
		assertEquals(expected, solution(skill, skill_trees));
	}

	@Test
	public void test2() {
		int expected = 3;
		String skill = "CBD";
		String[] skill_trees = { "BACDE", "CBADF", "AECB", "BDA", "ASF" };
		assertEquals(expected, solution(skill, skill_trees));
	}

	@Test
	public void test3() {
		int expected = 4;
		String skill = "CBD";
		String[] skill_trees = { "BACDE", "CBADF", "AECB", "BDA", "ASF", "FCT" };
		assertEquals(expected, solution(skill, skill_trees));
	}
}
