package com.rutuja.evernote;

import java.util.Scanner;

public class CalvinVehicle {
	private static int[] method3;
	private static int sqrt;

	public static void preprocess(int[] arr) {
		sqrt = (int) Math.sqrt(arr.length);
		method3 = new int[(int) Math.ceil(Math.sqrt(arr.length))];

		for (int i = 0, j = 0; i < method3.length; i++, j += sqrt) {
			method3[i] = minRange1(arr, j, j + sqrt - 1);
		}

	}

	public static int minRange1(int[] arr, int i, int j) {
		if (i < 0 || i >= arr.length)
			return Integer.MAX_VALUE;
		int min = arr[i];
		j = Math.min(j, arr.length - 1);
		for (int k = i + 1; k <= j; k++) {
			if (min > arr[k]) {
				min = arr[k];
			}
		}
		return min;
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int length = scan.nextInt();
		int test = scan.nextInt();
		int[] arr = new int[length];
		for (int i = 0; i < length; i++) {
			arr[i] = scan.nextInt();
		}
		preprocess(arr);
		for (int i = 0; i < test; i++) {
			int x = scan.nextInt(), y = scan.nextInt();
			if (y - x <= 200)
				System.out.println(minRange1(arr, x, y));
			else
				System.out.println(minRange(arr, x, y));
		}
	}

	private static int minRange(int[] arr, int i, int j) {
		int start, end = j - (j % sqrt);
		if (i % sqrt == 0)
			start = i;
		else
			start = i + sqrt - (i % sqrt);
		int min = minRange1(arr, i, start - 1);
		min = Math.min(minRange1(method3, start / sqrt, end / sqrt - 1), min);
		min = Math.min(minRange1(arr, end, j), min);
		return min;

	}
}
