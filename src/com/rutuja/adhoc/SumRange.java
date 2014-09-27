package com.rutuja.adhoc;
/**
 * Finds the sum between the range i and j in an array
 * 
 */

import java.util.Arrays;

import com.rutuja.debug.Debug;

public class SumRange {
	
	private int[] arr;
	
	

	public SumRange(int[] arr) {
		super();
		this.arr = arr;
		preprocess(arr);
	}

	private void preprocess(int[] arr) {
		for (int i = 1; i < arr.length; i++) {
			arr[i] += arr[i - 1];
		}
	}

	public int sumRange( int i, int j) {
		return i==0?arr[j]:arr[j] - arr[i - 1];

	}

	public static void main(String[] args) {
		int[] arr = Debug.randomArray(10,0,10);
		System.out.println(Arrays.toString(arr));
		SumRange s = new SumRange(arr);
		System.out.println(s.sumRange(4, 6));
		System.out.println(s.sumRange(0, 3));

	}

}
