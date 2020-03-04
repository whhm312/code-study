package practices.hackerrank.easy;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import org.junit.Test;

class Student implements Comparable<Student> {
	private int id;
	private String fname;
	private double cgpa;

	public Student(int id, String fname, double cgpa) {
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
		if (obj instanceof Student) {
			Student sObj = (Student) obj;
			return fname.equals(sObj.getFname());
		} else {
			return false;
		}
	}

	@Override
	public int compareTo(Student student) {
		if (getCgpa() < student.getCgpa()) {
			return 1;
		} else if (getCgpa() == student.getCgpa()) {
			return getFname().compareTo(student.getFname());
		} else if (getCgpa() > student.getCgpa()) {
			return -1;
		} else {
			return Integer.MAX_VALUE;
		}
	}

	@Override
	public String toString() {
		return "id=" + id + ", fname=" + fname + ", cgpa=" + cgpa;
	}

}

public class JavaSort {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int testCases = Integer.parseInt(in.nextLine());

		List<Student> studentList = new ArrayList<Student>();
		while (testCases > 0) {
			int id = in.nextInt();
			String fname = in.next();
			double cgpa = in.nextDouble();

			Student st = new Student(id, fname, cgpa);
			studentList.add(st);

			testCases--;
		}

		in.close();

		Collections.sort(studentList);

		for (Student st : studentList) {
			System.out.println(st.getFname());
		}
	}

	@Test
	public void testSort() {

		List<Student> studentList = new ArrayList<Student>();
		Student student = new Student(33, "Rumpa", 3.68);
		studentList.add(student);
		student = new Student(85, "Ashis", 3.85);
		studentList.add(student);
		student = new Student(56, "Samiha", 3.75);
		studentList.add(student);
		student = new Student(19, "Samara", 3.75);
		studentList.add(student);
		student = new Student(22, "Fahim", 3.76);
		studentList.add(student);

		Collections.sort(studentList);

		List<Student> expecteds = new ArrayList<Student>();
		expecteds.add(new Student(85, "Ashis", 3.85));
		expecteds.add(new Student(22, "Fahim", 3.76));
		expecteds.add(new Student(19, "Samara", 3.75));
		expecteds.add(new Student(56, "Samiha", 3.75));
		expecteds.add(new Student(33, "Rumpa", 3.68));

		assertEquals(expecteds, studentList);
	}
}
