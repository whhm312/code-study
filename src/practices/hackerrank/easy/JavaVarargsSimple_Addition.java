package practices.hackerrank.easy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

public class JavaVarargsSimple_Addition {
	static class Add {
		public void add(int... n) {
			String output = "";
			int sum = 0;
			for (int i = 0; i < n.length; i++) {
				output += n[i] + "+";
				sum += n[i];
			}
			System.out.println(output.substring(0, output.length() - 1) + "=" + sum);
		}
	}

	@Test
	public void test() {
		new Add().add(1, 2);
		new Add().add(1, 2, 3);
		new Add().add(1, 2, 3, 4, 5);
		new Add().add(1, 2, 3, 4, 5, 6);
	}

	public static void main(String[] args) {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			int n1 = Integer.parseInt(br.readLine());
			int n2 = Integer.parseInt(br.readLine());
			int n3 = Integer.parseInt(br.readLine());
			int n4 = Integer.parseInt(br.readLine());
			int n5 = Integer.parseInt(br.readLine());
			int n6 = Integer.parseInt(br.readLine());
			Add ob = new Add();
			ob.add(n1, n2);
			ob.add(n1, n2, n3);
			ob.add(n1, n2, n3, n4, n5);
			ob.add(n1, n2, n3, n4, n5, n6);
			Method[] methods = Add.class.getDeclaredMethods();
			Set<String> set = new HashSet<>();
			boolean overload = false;
			for (int i = 0; i < methods.length; i++) {
				if (set.contains(methods[i].getName())) {
					overload = true;
					break;
				}
				set.add(methods[i].getName());

			}
			if (overload) {
				throw new Exception("Overloading not allowed");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
