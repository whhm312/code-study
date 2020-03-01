package practices.programmers.level1;

import static org.junit.Assert.assertEquals;

import java.util.Scanner;

import org.junit.Test;

/**
 * 직사각형 별찍기
 * 
 * @author hyemin
 *
 */
public class Solution12969 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int width = sc.nextInt();
		int height = sc.nextInt();
		sc.close();

		System.out.println(gridStars(width, height));
	}

	public static String gridStars(int width, int height) {
		String answer = "";
		for (int i = 0; i < height; i++) {
			for (int j = 0; j < width; j++) {
				answer += "*";
			}
			answer += "\n";
		}
		return answer;
	}

	@Test
	public void test() {
		int a = 5;
		int b = 3;
		String expected = "*****\n*****\n*****\n";
		assertEquals(expected, gridStars(a, b));
	}
}
