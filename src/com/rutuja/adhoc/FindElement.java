package com.rutuja.adhoc;

/**
 * Given a sorted array of n integers that has been rotated an unknown number of
 * times, give an O(log n) algorithm that finds an element in the array. You may
 * assume that the array was originally sorted in increasing order.
 * 
 * 
 * 
 * @author Rutuja
 *
 */

public class FindElement {
	
	public int findIndex(int[] arr, int element){
		return findIndex(arr, element, 0, arr.length -1);
	}

	public int findIndex(int[] arr, int element, int low, int high) {
		if (low <= high) {
			int mid = (low + high) / 2;
			if (arr[mid] == element)
				return mid;
			if (arr[low] < arr[mid]) {
				if (element >= arr[low] && element < arr[mid])
					return findIndex(arr, element, low, mid - 1);
				else
					return findIndex(arr, element, mid + 1, high);
			} else {
				if (arr[mid] < element && arr[high] >= element)
					return findIndex(arr, element, mid + 1, high);
				else
					return findIndex(arr, element, low, mid - 1);
			}
		}
		return -1;

	}

	public static void main(String[] args) {
		int[] arr = { 15, 16, 19, 20, 25, 1, 3, 4, 5, 7, 10, 14 };
		for(int i = 0; i< arr.length; i++){
		System.out.println(new FindElement().findIndex(arr, arr[i]));
		}
		System.out.println(new FindElement().findIndex(arr, Integer.MAX_VALUE));
		System.out.println(new FindElement().findIndex(arr, Integer.MIN_VALUE));

	}

}
