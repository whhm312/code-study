package practices.hackerrank.easy;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;

public class JavaReflection_Attributes {
	class Student {
		private String name;
		public String id;
		public String email;

		public String getName() {
			return name;
		}

		public void setId(String id) {
			this.id = id;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public void anothermethod() {
		}
	}

	public static void main(String[] args) {
		Class<Student> student = Student.class;
		Method[] methods = student.getDeclaredMethods();

		ArrayList<String> methodList = new ArrayList<String>();
		for (int i = 0; i < methods.length; i++) {
			methodList.add(methods[i].getName());
		}
		Collections.sort(methodList);
		for (String name : methodList) {
			System.out.println(name);
		}
	}

}
