package practices.hackerrank.easy;

public class JavaSingletonPattern {
	private static final JavaSingletonPattern INSTANCE = new JavaSingletonPattern();

	public String str;

	private JavaSingletonPattern() {
	}

	public static JavaSingletonPattern getSingleInstance() {
		return INSTANCE;
	}
}
