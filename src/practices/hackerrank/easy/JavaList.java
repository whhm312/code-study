package practices.hackerrank.easy;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class JavaList {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int length = scan.nextInt();
		List<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i < length; i++) {
			list.add(scan.nextInt());
		}

		String query = null;
		length = scan.nextInt();
		while (length-- > 0) {
			query = scan.next();
			if ("Insert".equals(query)) {
				list.add(scan.nextInt(), scan.nextInt());
			} else if ("Delete".equals(query)) {
				list.remove(scan.nextInt());
			}
		}
		scan.close();

		for (Integer intVal : list) {
			System.out.print(intVal + " ");
		}
	}
}
