package practices.programmers.level2;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class Solution49993 {
	public int solution(String skill, String[] skill_trees) {
//		String[] skills = skill.split("");
//		String skill_tree = null;
//		for (int i = 0; i < skill_trees.length; i++) {
//			skill_tree = skill_trees[i];
//
//			for (int sk = 0; sk < skills.length; sk++) {
//				if (skill_tree.indexOf(skills[sk]) > -1) {
//					skill_tree = skill_tree.substring(skill_tree.indexOf(skills[sk]));
//				}
//			}
//
//		}
		int answer = 0;
		return answer;
	}

	@Test
	public void test() {
		int expected = 2;
		String skill = "CBD";
		String[] skill_trees = { "BACDE", "CBADF", "AECB", "BDA" };
		assertEquals(expected, solution(skill, skill_trees));
	}
}
