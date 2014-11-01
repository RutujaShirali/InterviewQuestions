package com.rutuja.adhoc;

import java.util.Arrays;
import java.util.HashMap;

public class FindSumof2 {

	public void find(int[] arr, int x) {
		HashMap<Integer, Boolean> map = new HashMap<>();
		for (int i = 0; i <= x; i++) {
			map.put(i, false);
		}
		for (int i = 0; i < arr.length; i++) {
			if (map.get(x - arr[i]) == true)
				System.out.println(arr[i] + " , " + (x - arr[i]));
			else
				map.put(arr[i], true);

		}
	}

	public void find2(int[] arr, int x) {
		Arrays.sort(arr);
		int l = arr[0], r = arr[arr.length - 1];
		for (int i = 0; i < arr.length && l < r && l <arr.length && r >= 0; i++) {
			if (arr[l] + arr[r] == x)
				System.out.println(arr[l] + " , " + arr[r]);
			else if (arr[l] + arr[r] < x)
				l++;
			else
				r--;
		}
	}

	public static void main(String[] args) {
		int[] arr = { 1, 8, 3, 5, 6, 2 };
		// new FindSumof2().find(arr, 13);
		new FindSumof2().find2(arr, 13);
	}

}
