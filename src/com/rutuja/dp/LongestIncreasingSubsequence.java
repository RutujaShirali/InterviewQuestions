package com.rutuja.dp;

import java.util.Arrays;

public class LongestIncreasingSubsequence {

	public int longestIncSeq(int[] arr) {
		int[] parent = new int[arr.length];
		int maxIndex = 0;
		int[] LIS = new int[arr.length];
		Arrays.fill(parent, -1);
		Arrays.fill(LIS, 1);
		for (int i = 1; i < arr.length; i++) {
			for (int j = 0; j < LIS.length; j++) {
				if (arr[j] < arr[i]) {
					// LIS[i] = Math.max(LIS[j] + 1, LIS[i]);
					if (LIS[j] + 1 > LIS[i]) {
						LIS[i] = LIS[j] + 1;
						parent[i] = j;
					}
				}
			}
			if (LIS[maxIndex] < LIS[i])
				maxIndex = i;
		}
		int i = maxIndex;
		while (i >= 0) {
			System.out.print(arr[i] + " ");
			i = parent[i];
		}
		System.out.println("");
		return LIS[maxIndex];
	}

	public static void main(String[] args) {
		int[] arr = { 1, 3, 2, 5, 4, 6 };
		System.out.println(new LongestIncreasingSubsequence()
				.longestIncSeq(arr));
	}
}
