package practices.samples;
import java.util.Scanner;

public class ScannerMain {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String line = sc.nextLine();
		sc.close();

		System.out.println(line);
	}

}
