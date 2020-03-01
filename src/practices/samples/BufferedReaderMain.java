package practices.samples;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BufferedReaderMain {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String readLine = null;

		int firstNum, secondNum = 0;
		StringBuffer result = new StringBuffer();
		String[] reads = null;

		while ((readLine = in.readLine()) != null && !"".equals(readLine)) {
			reads = readLine.split(" ");
			if (reads.length < 2) {
				break;
			}

			firstNum = Integer.parseInt(reads[0]);
			secondNum = Integer.parseInt(reads[1]);

			result.append((firstNum + secondNum) + "\n");
		}
		in.close();

		System.out.print(result.toString());
	}
}
