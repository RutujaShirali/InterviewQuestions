package com.rutuja.adhoc;

/*
 * This program gives the length of the largest contiguous sub array.
 *  O(n^2)
 */

public class LargestContSubarray {

	public int Length(int[] arr) {
		int maxlen = 1;
		for (int i = 0; i < arr.length; i++) {
			int mn = arr[i], mx = arr[i]; // Initialize min and max for
											// subarrays
			for (int j = i + 1; j < arr.length; j++) { // for all subarrays
														// starting i ending in
														// j update min and max
				mn = Math.min(mn, arr[j]);
				mx = Math.max(mx, arr[j]);
				if (Math.abs(mx - mn) == j - i) {
					maxlen = Math.max(maxlen, mx - mn + 1);
				}
			}
		}
		return maxlen;
	}

	public static void main(String[] args) {
		int[] arr = { 1, 56, 58, 57, 90, 92, 94, 93, 91, 45 };
		System.out.println(new LargestContSubarray().Length(arr));
	}

}
