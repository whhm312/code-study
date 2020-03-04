package practices.hackerrank.easy;

import org.junit.Test;

class Animal {
	void walk() {
		System.out.println("I am walking");
	}
}

class Bird extends Animal {
	void fly() {
		System.out.println("I am flying");
	}

	void sing() {
		System.out.println("I am singing");
	}
}

public class JavaInheritanceI {
	public static void main(String args[]) {

		Bird bird = new Bird();
		bird.walk();
		bird.fly();
		bird.sing();

	}

	@Test
	public void test() {
		Bird bird = new Bird();
		bird.sing();
	}
}
