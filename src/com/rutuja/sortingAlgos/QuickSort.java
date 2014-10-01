package com.rutuja.sortingAlgos;

import java.util.Arrays;

import com.rutuja.debug.Debug;
import com.rutuja.ds.Main;

public class QuickSort {

	public void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	public int[] quickSort(int[] arr, int low, int high) {
		if (low < high) {
			int pivot;
			int left = low + 1, right = high;
			pivot = arr[low];
			while (left < right) {
				while (left < high && arr[left] <= pivot) {
					left++;
				}
				while (pivot < arr[right]) {
					right--;
				}
				if (left < right) {
					swap(arr, left, right);
				}
			}
			if (arr[low] > arr[right])
				swap(arr, low, right);
			quickSort(arr, low, right - 1);
			quickSort(arr, right + 1, high);

		}
		return arr;

	}

	public static void main(String[] args) {
		QuickSort qs = new QuickSort();
		int[] arr = Debug.randomArray();
		System.out.println(Arrays.toString(arr));
		System.out
				.println(Arrays.toString(qs.quickSort(arr, 0, arr.length - 1)));
	}
}
