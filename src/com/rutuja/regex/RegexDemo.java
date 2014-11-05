package com.rutuja.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexDemo {

	public void email(String str) {
		String line = str;
		String pattern = "[A-z][A-z0-9\\.]+@[A-z0-9]+\\.[A-z0-9]+";
		Pattern r = Pattern.compile(pattern);
		Matcher m = r.matcher(line);
		if (m.find()) {
			System.out.println(m.group(0));
		} else
			System.out.println("No match");
	}

	public static void main(String[] args) {
		// String line = "Be here at 9:00 PM sharp! OK?";
		// String pattern = "(\\d{1,2}):(\\d{2})";
		//
		// Pattern r = Pattern.compile(pattern);
		// Matcher m = r.matcher(line);
		// if (m.find()) {
		// System.out.println("Found value: " + m.group(0));
		// System.out.println(m.group(1));
		// System.out.println(m.group(2));
		// } else {
		// System.out.println("No Match");
		// }

		new RegexDemo()
				.email("My email address is rutuja.shirali@gmail.com");

	}

}
