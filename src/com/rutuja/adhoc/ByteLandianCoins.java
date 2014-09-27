package com.rutuja.adhoc;

import java.util.Arrays;

public class ByteLandianCoins {

	static int[] memo = new int[1000];

	static int f(int n) {
		if (memo[n] != -1)
			return memo[n];
		if (n == 0)
			return 0;
		else
			return memo[n] = Math.max(n, f(n / 2) + f(n / 3) + f(n / 4));
	}

	public static void main(String[] args) {

		Arrays.fill(memo, -1);

		int[] dp = new int[10000];
		dp[0] = 0;
		for (int i = 1; i < dp.length; i++)
			dp[i] = Math.max(i, dp[i / 2] + dp[i / 3] + dp[i / 4]);
	}

}
