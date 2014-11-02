package com.rutuja.string;

public class ImplementRegex {

	public boolean isMatch(String s, String p) {
		System.out.println(s + "," + p);
		if (p.length() == 0)
			return s.length() == 0;
		if (p.length() > 1 && p.charAt(1) != '*')
			return ((p.charAt(0) == s.charAt(0)) || (p.charAt(0) == '.' && s
					.length() > 0)) && isMatch(s.substring(1), p.substring(1));

		if (p.length() > 1 && p.charAt(1) == '*') {
			while (p.charAt(0) == s.charAt(0)
					|| (p.charAt(0) == '.' && s.length() > 0)) {
				if (p.length() > 1 && isMatch(s, p.substring(2)))
					return true;
				s = s.substring(1);
				if (s.length() == 0)
					break;
			}
			return p.length() > 1 && isMatch(s, p.substring(2));
		}
		return s.charAt(0) == p.charAt(0) || p.charAt(0) == '.';
	}

	public static void main(String[] args) {
		System.out.println(new ImplementRegex().isMatch("aaab", "aaa."));
	}
}
