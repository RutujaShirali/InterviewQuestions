package com.rutuja.string;

public class LongestPalindrome {

	public int longPal(String str) {
		int i = 0, j = str.length() - 1;
		if (i > j)
			return 0;
		else if (i == j)
			return 1;
		else if (str.charAt(i) == str.charAt(j))
			return 2 + longPal(str.substring(i + 1, j));
		else
			return Math.max(longPal(str.substring(i, j)),
					longPal(str.substring(i + 1)));
	}

	public int longPal2(String str, int i, int j) {
		if (i > j)
			return 0;
		else if (i == j)
			return 1;
		else if (str.charAt(i) == str.charAt(j))
			return 2 + longPal2(str, i + 1, j - 1);
		else
			return Math.max(longPal2(str, i, j - 1), longPal2(str, i + 1, j));
	}

	public static void main(String[] args) {
		String str = "I like kayaks";
		System.out.println(new LongestPalindrome().longPal(str));
		System.out.println(new LongestPalindrome().longPal2(str, 0,
				str.length() - 1));
	}

}
