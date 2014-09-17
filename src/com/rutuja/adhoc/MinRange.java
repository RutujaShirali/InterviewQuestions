package com.rutuja.adhoc;

import java.util.Arrays;

import com.rutuja.debug.Debug;

public class MinRange {

	private int[] arr;

	private int[][] method2;
	private int[] method3;

	private int sqrt;

	public MinRange(int[] arr) {
		super();
		this.arr = arr;
		preprocess(arr);
	}

	private void preprocess(int[] arr) {
		// Method2:
		method2 = new int[arr.length][arr.length];
		for (int i = 0; i < arr.length; i++) {

			for (int j = i; j < arr.length; j++) {
				if (j == i)
					method2[i][j] = arr[i];
				else
					method2[i][j] = Math.min(arr[j], method2[i][j - 1]);
			}
		}

		sqrt = (int) Math.sqrt(arr.length);
		method3 = new int[(int)Math.ceil(Math.sqrt(arr.length))];

		for (int i = 0, j = 0; i < method3.length; i++, j += sqrt) {
			method3[i] = minRange1(j, j + sqrt-1);
		}

	}

	public int minRange1(int i, int j) {
		int min = arr[i];
		j = Math.min(j, arr.length - 1);
		for (int k = i + 1; k <= j; k++) {
			if (min > arr[k]) {
				min = arr[k];
			}
		}
		return min;
	}

	public int minRange2(int i, int j) {
		return method2[i][j];
	}

	public int minRange3(int i, int j) {
		int start,end=j-(j%sqrt);
		if(i%sqrt == 0) start = i;
		else start = i+ sqrt-(i%sqrt);
		int min = arr[i];
		for(int k = i+1; k<start; k++){
			min = Math.min(arr[k], min);
		}
		System.out.println(min);
		for(int k = start/sqrt; k < end/sqrt; k++){
			min = Math.min(method3[k],min);
		}
		System.out.println(min);

		for(int k = end; k <=j; k++){
			min = Math.min(arr[k], min);
		}
		System.out.println(Arrays.toString(method3));
		return min;
	}

	public static void main(String[] args) {
		int i = 2;
		int j = 9;
		int[] arr = Debug.randomArray(10);
		System.out.println(Arrays.toString(arr));
		MinRange s = new MinRange(arr);
		System.out.println(s.minRange1(i, j));
		System.out.println(s.minRange2(i, j));
		System.out.println(s.minRange3(i, j));
	}

}
