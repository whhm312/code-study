package code.test.ridi;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class Program4 {
//	문제 설명
//	총 N개의 디렉토리가 다음과 같이 트리(tree) 형태의 간단한 구조를 이루고 있습니다.
//
//	모든 디렉토리에는 1부터 N까지 번호가 붙어있습니다.
//	모든 디렉토리에는 이름이 붙어있습니다.
//	최상위 디렉토리는 1개만 존재하며, 최상위 디렉토리의 번호는 1번입니다.
//	모든 디렉토리는 0개 이상의 하위 디렉토리를 가질 수 있습니다.
//	최상위 디렉토리를 제외한 나머지 디렉토리는 정확히 1개의 상위 디렉토리를 가집니다.
//	모든 디렉토리는 같은 이름의 하위 디렉토리를 2개 이상 가질 수 없습니다.

//	전체 디렉토리의 개수 N, 
//	디렉토리의 관계를 나타내는 배열 relation, 
//	각 디렉토리의 이름이 순서대로 들어있는 배열 dirname이 매개변수로 주어질 때, 
//	가장 긴 경로(가장 많은 문자를 사용한 경로)의 길이를 return 하도록 solution 함수를 완성해주세요.

	public int solution(int N, int[][] relation, String[] dirname) {
		return getMaxLengthPath(getFullPath(N, relation, dirname));
	}

	public String[] getFullPath(int N, int[][] relation, String[] dirname) {
		List<String> pathes = new ArrayList<String>();
		String path = null;
		String lastPath = null;
		String fistPath = null;
		String newPath = null;
		String[] lastPaths = null;
		for (int i = 0; i < N - 1; i++) {
			path = dirname[relation[i][0] - 1] + "/" + dirname[relation[i][1] - 1];
			if (i < 1) {
				pathes.add(path);
			} else {
				// 새로 추가하려는 path의 /로 나눠서 처음
				fistPath = path.split("/")[0];
				// 기존에 들어있는 path를 /로 나눠서 마지막
				for (int j = 0; j < pathes.size(); j++) {
					lastPaths = pathes.get(j).split("/");
					lastPath = lastPaths[lastPaths.length - 1];
					// 위의 두개가 동일하면
					if (fistPath.equals(lastPath)) {
						// 새로 pathes.add 할 애는 동일한 애 + "/" + 새로 추가하려는 애
						newPath = pathes.get(j) + path.substring(path.indexOf(fistPath) + fistPath.length());
					}
				}
				pathes.add(newPath != null ? newPath : path);
				newPath = null;
			}
		}

		pathes.add(0, "root");
		String[] myArray = new String[pathes.size()];
		pathes.toArray(myArray);
		return myArray;
	}

	private int getMaxLengthPath(String[] originalPathes) {
		int length = originalPathes.length;
		int[] originalPathLength = new int[length];
		for (int i = 0; i < originalPathLength.length; i++) {
			originalPathLength[i] = originalPathes[i].length();
		}

		Arrays.sort(originalPathLength);
		return originalPathLength[length - 1];
	}

	@Test
	public void testSortPath1() {
		int N = 7;
		int[][] relation = { { 1, 2 }, { 2, 5 }, { 2, 6 }, { 1, 3 }, { 1, 4 }, { 3, 7 } };
		String[] dirname = { "root", "abcd", "cs", "hello", "etc", "hello", "solution" };
		int expected = 16;
		String[] originalPathes = getFullPath(N, relation, dirname);
		assertEquals(expected, getMaxLengthPath(originalPathes));
	}

	@Test
	public void testGetFullPath() {
		int N = 7;
		int[][] relation = { { 1, 2 }, { 2, 5 }, { 2, 6 }, { 1, 3 }, { 1, 4 }, { 3, 7 } };
		String[] dirname = { "root", "abcd", "cs", "hello", "etc", "hello", "solution" };
		String[] expecteds = { "root", "root/abcd", "root/abcd/etc", "root/abcd/hello", "root/cs", "root/hello",
				"root/cs/solution" };
		assertArrayEquals(expecteds, getFullPath(N, relation, dirname));
		assertEquals(N, getFullPath(N, relation, dirname).length);
	}

	@Test
	public void test1_1() {
		int N = 7;
		int[][] relation = { { 1, 2 }, { 2, 5 }, { 2, 6 }, { 1, 3 }, { 1, 4 }, { 3, 7 } };
		String[] dirname = { "root", "abcd", "cs", "hello", "etc", "hello", "solution" };
		int expected = 16;
		assertEquals(expected, solution(N, relation, dirname));
	}

	@Test
	public void test1_2() {
		int N = 7;
		int[][] relation = { { 1, 2 }, { 2, 6 }, { 1, 3 }, { 1, 4 }, { 3, 7 }, { 2, 5 } };
		String[] dirname = { "root", "abcd", "cs", "hello", "etc", "hello", "solution" };
		int expected = 16;
		assertEquals(expected, solution(N, relation, dirname));
	}

	@Test
	public void test2() {
		int N = 7;
		int[][] relation = { { 1, 2 }, { 2, 3 }, { 3, 4 }, { 4, 5 }, { 1, 6 }, { 6, 7 } };
		String[] dirname = { "root", "a", "b", "c", "d", "efghij", "k" };
		int expected = 13;
		assertEquals(expected, solution(N, relation, dirname));
	}
}
