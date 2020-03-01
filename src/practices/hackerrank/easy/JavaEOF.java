package practices.hackerrank.easy;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class JavaEOF {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int lineNumber = 1;
		List<String> list = new ArrayList<String>();
		while (scan.hasNext()) {
			list.add((lineNumber++) + " " + scan.nextLine());
		}

		for (String str : list) {
			System.out.println(str);
		}
		scan.close();
	}

}
