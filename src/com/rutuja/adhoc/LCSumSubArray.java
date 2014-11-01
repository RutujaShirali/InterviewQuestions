package com.rutuja.adhoc;

public class LCSumSubArray {

	public int maxSum(int[] arr) {
		int maxSum = 0, tempSum = 0;
		int index1 = 0, index2 = 0;
		for (int i = 0; i < arr.length; i++) {
			tempSum = arr[i];
			for (int j = i + 1; j < arr.length; j++) {
				tempSum += arr[j];
				if (tempSum > maxSum) {
					maxSum = tempSum;
					index1 = i;
					index2 = j;
				}
			}
		}
		System.out.println(index1 + " " + index2);
		return maxSum;
	}

	public int kadaneAlgo(int[] arr) {
		int maxsofar = 0, maxendinghere = 0;
		for (int i = 0; i < arr.length; i++) {
			maxendinghere = maxendinghere + arr[i];
			if (maxendinghere < 0)
				maxendinghere = 0;
			else if (maxsofar < maxendinghere)
				maxsofar = maxendinghere;
		}
		return maxsofar;
	}

	public static void main(String[] args) {
		int[] arr = { 1, 8, -2, 3, -5 };
		System.out.println(new LCSumSubArray().maxSum(arr));
		System.out.println(new LCSumSubArray().kadaneAlgo(arr));

	}

}
