package practices.hackerrank.easy;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

import org.junit.Test;

class Student2 {
	private int id;
	private String fname;
	private double cgpa;

	public Student2(int id, String fname, double cgpa) {
		super();
		this.id = id;
		this.fname = fname;
		this.cgpa = cgpa;
	}

	public int getId() {
		return id;
	}

	public String getFname() {
		return fname;
	}

	public double getCgpa() {
		return cgpa;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Student2) {
			Student2 sObj = (Student2) obj;
			return id == sObj.getId();
		} else {
			return false;
		}
	}
}

public class JavaSort2 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int testCases = Integer.parseInt(in.nextLine());

		List<Student2> studentList = new ArrayList<Student2>();
		while (testCases > 0) {
			int id = in.nextInt();
			String fname = in.next();
			double cgpa = in.nextDouble();

			Student2 st = new Student2(id, fname, cgpa);
			studentList.add(st);

			testCases--;
		}

		in.close();

		Collections.sort(studentList, new Comparator<Student2>() {
			public int compare(Student2 e1, Student2 e2) {
				if (e1.getCgpa() < e2.getCgpa()) {
					return 1;
				} else if (e1.getCgpa() == e2.getCgpa()) {
					return e1.getFname().compareTo(e2.getFname());
				} else if (e1.getCgpa() > e2.getCgpa()) {
					return -1;
				} else {
					return Integer.MAX_VALUE;
				}
			}
		});

		for (Student2 st : studentList) {
			System.out.println(st.getFname());
		}
	}

	@Test
	public void testSort() {

		List<Student2> studentList = new ArrayList<Student2>();
		Student2 student = new Student2(33, "Rumpa", 3.68);
		studentList.add(student);
		student = new Student2(85, "Ashis", 3.85);
		studentList.add(student);
		student = new Student2(56, "Samiha", 3.75);
		studentList.add(student);
		student = new Student2(19, "Samara", 3.75);
		studentList.add(student);
		student = new Student2(22, "Fahim", 3.76);
		studentList.add(student);

		Collections.sort(studentList, new Comparator<Student2>() {
			public int compare(Student2 e1, Student2 e2) {
				if (e1.getCgpa() < e2.getCgpa()) {
					return 1;
				} else if (e1.getCgpa() == e2.getCgpa()) {
					return e1.getFname().compareTo(e2.getFname());
				} else if (e1.getCgpa() > e2.getCgpa()) {
					return -1;
				} else {
					return Integer.MAX_VALUE;
				}
			}
		});

		List<Student2> expecteds = new ArrayList<Student2>();
		expecteds.add(new Student2(85, "Ashis", 3.85));
		expecteds.add(new Student2(22, "Fahim", 3.76));
		expecteds.add(new Student2(19, "Samara", 3.75));
		expecteds.add(new Student2(56, "Samiha", 3.75));
		expecteds.add(new Student2(33, "Rumpa", 3.68));

		assertEquals(expecteds, studentList);
	}
}
