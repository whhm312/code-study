package practices.programmers.level1;

import java.text.ParseException;

/**
 * 2016년
 * 
 * @author hyemin
 *
 */
public class Solution12901 {

	public String solution(int month, int day) {
		final String[] DAYS = { "SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT" };
		int totalDays = 0;
		for (int i = 0; i < month; i++) {
			switch (i) {
			case 1:
			case 3:
			case 5:
			case 7:
			case 8:
			case 10:
			case 12:
				totalDays += 31;
				break;
			case 2:
				totalDays += 29;
				break;
			case 4:
			case 6:
			case 9:
			case 11:
				totalDays += 30;
				break;
			}

		}

		totalDays += day;
		return DAYS[(totalDays + 4) % 7];
	}

	public static void main(String[] args) throws ParseException {
		int month = 5;
		int day = 1;
		Solution12901 solution12901 = new Solution12901();
		System.out.println(solution12901.solution(month, day));
	}

}
