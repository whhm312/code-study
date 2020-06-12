package lessons.programmers;

import static org.junit.Assert.assertEquals;

import java.util.LinkedList;
import java.util.Queue;

import org.junit.Test;

public class Part6 {
	class Position {
		int x, y;

		Position(int y, int x) {
			this.y = y;
			this.x = x;
		}

		boolean isValid(int width, int height) {
			if (x < 0 || x >= width) {
				return false;
			}

			if (y < 0 || y >= height) {
				return false;
			}

			return true;
		}
	}

	public int solution(int[][] maps) {
		int mapsWidth = maps[0].length;
		int mapsHeight = maps.length;
		final int[][] moving = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

		int[][] count = new int[mapsHeight][mapsWidth];
		boolean[][] isVisited = new boolean[mapsHeight][mapsWidth];
		Queue<Position> queue = new LinkedList<Position>();

		queue.offer(new Position(0, 0));
		count[0][0] = 1;
		isVisited[0][0] = true;

		while (!queue.isEmpty()) {
			Position current = queue.poll();
			int currentCount = count[current.y][current.x];

			for (int i = 0; i < moving.length; i++) {
				Position moved = new Position(current.y + moving[i][0], current.x + moving[i][1]);
				if (!moved.isValid(mapsWidth, mapsHeight)) {
					continue;
				}
				if (maps[moved.y][moved.x] == 0) {
					continue;
				}
				if (isVisited[moved.y][moved.x]) {
					continue;
				}

				count[moved.y][moved.x] = currentCount + 1;
				isVisited[moved.y][moved.x] = true;
				queue.offer(moved);
			}

		}

		int answer = count[mapsHeight - 1][mapsWidth - 1];
		if (answer == 0) {
			return -1;
		}
		return answer;
	}

	@Test
	public void test1() {
		int expected = 11;
		int[][] maps = { { 1, 0, 1, 1, 1 }, { 1, 0, 1, 0, 1 }, { 1, 0, 1, 1, 1 }, { 1, 1, 1, 0, 1 },
				{ 0, 0, 0, 0, 1 } };
		assertEquals(expected, solution(maps));
	}

	@Test
	public void test2() {
		int expected = -1;
		int[][] maps = { { 1, 0, 1, 1, 1 }, { 1, 0, 1, 0, 1 }, { 1, 0, 1, 1, 1 }, { 1, 1, 1, 0, 0 },
				{ 0, 0, 0, 0, 1 } };
		assertEquals(expected, solution(maps));
	}
}
