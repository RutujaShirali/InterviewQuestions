package com.rutuja.dp;

import java.util.Arrays;

public class MaxValSeq {

	public int maxValSeq(int[] arr) {
		int[] maxValj = new int[arr.length];
		int max = arr[0];
		maxValj[0] = arr[0];
		for (int i = 1; i < arr.length; i++) {
			maxValj[i] = Math.max(maxValj[i - 1] + arr[i], arr[i]);
			max = Math.max(max, maxValj[i]);
		}
		return max;
	}

	public int max2(int[] arr) {
		int maxCurr = arr[0], maxSoFar = arr[0];
		int indexTill = 0, count = 0;
		int bestIndexTill = 0, bestCount = 0;
		for (int j = 1; j < arr.length; j++) {
			// maxCurr = Math.max(maxCurr + arr[j], arr[j]);
			// maxSoFar = Math.max(maxSoFar, maxCurr);
			if (maxCurr + arr[j] > arr[j]) {
				maxCurr = maxCurr + arr[j];
				indexTill = j;
				count++;
			} else {
				maxCurr = arr[j];
				indexTill = j;
				count = 0;
			}
			if (maxSoFar < maxCurr) {
				maxSoFar = maxCurr;
				bestIndexTill = indexTill;
				bestCount = count;
			}
			;

		}
		System.out.println(bestIndexTill - bestCount + " " + bestIndexTill);
		return maxSoFar;
	}

	public static void main(String[] args) {
		int[] arr = { 1, 2, -3, 5, 7, 4, -2 };
		System.out.println(new MaxValSeq().maxValSeq(arr));
		System.out.println(new MaxValSeq().max2(arr));

	}

}
