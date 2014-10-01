package com.rutuja.dp;

public class LongestPalindrome {

	public String longestPalin(String check) {
		boolean[][] dp = new boolean[check.length()][check.length()];
		int len, startIndex = 0, endIndex = 0;
		for (int i = 0; i < check.length(); i++) {
			dp[i][i] = true;// len = 1
			if (i + 1 < check.length() && check.charAt(i) == check.charAt(i + 1)){ // len 2
				dp[i][i + 1] = true;
			    startIndex = i;
			    endIndex = i+1;
			}
		}
		for (len = 3; len < check.length(); len++) {
			for (int i = 0; i + len < check.length(); i++) {
				int j = i + len - 1;
				if (check.charAt(i) == check.charAt(j) && dp[i + 1][j - 1]) {
					dp[i][j] = true;
					startIndex = i;
					endIndex = j;
				}
			}
		}
		return check.substring(startIndex, endIndex + 1);
	}

	public static void main(String[] args) {
		LongestPalindrome lp = new LongestPalindrome();
		System.out.println(lp.longestPalin("gauurv"));

	}

}
