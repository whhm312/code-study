package practices.hackerrank.easy;

import static org.junit.Assert.assertEquals;

import java.text.NumberFormat;
import java.util.Locale;
import java.util.Scanner;

import org.junit.Test;

public class JavaCurrencyFormatter {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		double payment = scanner.nextDouble();
		scanner.close();

		System.out.println("US: " + format(Locale.US, payment));
		System.out.println("India: " + format(indiaLocale(), payment));
		System.out.println("China: " + format(Locale.CHINA, payment));
		System.out.println("France: " + format(Locale.FRANCE, payment));
	}

	public static String format(Locale locale, double payment) {
		NumberFormat numberFormat = NumberFormat.getCurrencyInstance(locale);
		return numberFormat.format(payment);
	}

	public static Locale indiaLocale() {
		String language = "en";
		String country = "IN";
		return new Locale(language, country);
	}

	private String getEnCurrency(double payment) {
		return format(Locale.US, payment);
	}

	@Test
	public void testIndiaLocale() {
		String expected = "Rs.12,324.13";
		double payment = 12324.134;
		assertEquals(expected, format(indiaLocale(), payment));
	}

	@Test
	public void testFranceLocale() {
		String expected = "12 324,13 €";
		double payment = 12324.134;
		assertEquals(expected, format(Locale.FRANCE, payment));
	}

	@Test
	public void testChinaLocale() {
		String expected = "￥12,324.13";
		double payment = 12324.134;
		assertEquals(expected, format(Locale.CHINA, payment));
	}

	@Test
	public void testFormatCurrency() {
		String expected = "$12,324.13";
		double payment = 12324.134;
		assertEquals(expected, format(Locale.US, payment));
	}

	@Test
	public void testGetEnCurrency() {
		String expected = "$12,324.13";
		double payment = 12324.134;
		assertEquals(expected, getEnCurrency(payment));
	}

}
