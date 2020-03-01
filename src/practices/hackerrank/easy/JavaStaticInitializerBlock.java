package practices.hackerrank.easy;

import java.util.Scanner;

public class JavaStaticInitializerBlock {

	static boolean flag = false;
	static int B = 0;
	static int H = 0;
	static {
		String worning = "java.lang.Exception: Breadth and height must be positive";
		try {
			Scanner scanner = new Scanner(System.in);
			B = scanner.nextInt();
			H = scanner.nextInt();
			scanner.close();

			flag = B >= 0 && H >= 0;
			if (!flag) {
				System.out.println(worning);
			}
		} catch (Exception e) {
			System.out.println(worning);
		}
	}

	public static void main(String[] args) {
		if (flag) {
			int area = B * H;
			System.out.print(area);
		}
	}// end of main
}
