package practices.samples;

public interface TestInterface {
	public boolean isEmpty();

	public int size();

	default void print() {
		System.out.println("to String---");
	}

	default int getZero() {
		return 0;
	}

	public static void youCanTest() {
		System.out.println("test~");
	}
}
