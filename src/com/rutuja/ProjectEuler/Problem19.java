package com.rutuja.ProjectEuler;

import java.sql.Date;

public class Problem19 {
	@SuppressWarnings("deprecation")
	public int countSundays() {
		int sundays = 0;
		for (int year = 1; year <= 100; year++) {
			for (int month = 0; month <= 11; month++) {
				if (new java.util.Date(year, month, 1).getDay() == 0)
					sundays += 1;
			}
		}
		return sundays;
	}

	public static void main(String[] args) {
		System.out.println(new Problem19().countSundays());
	}

}
