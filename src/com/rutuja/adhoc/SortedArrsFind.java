package com.rutuja.adhoc;
/**
 * 
 * Prints the common elements in 3 arrays
 * @author Rutuja
 *
 */

public class SortedArrsFind {

	public boolean binarySearch(int element, int[] arr, int low, int high) {
		int mid = (low + high) / 2;
		if (low > high)
			return false;
		if (arr[mid] == element)
			return true;
		if (arr[mid] > element)
			return binarySearch(element, arr, low, mid - 1);
		else
			return binarySearch(element, arr, mid + 1, high);

	}

	public void findIntersection(int[] A, int[] B, int[] C) {
		int minLen = Math.min(A.length, Math.min(B.length, C.length));
		if (A.length == minLen) {
			for (int i = 0; i < A.length; i++) {
				if (binarySearch(A[i], B, 0, B.length - 1)
						&& binarySearch(A[i], C, 0, C.length - 1))
					System.out.print(A[i] + " ");
			}
		} else if (B.length == minLen) {
			for (int i = 0; i < B.length; i++) {
				if (binarySearch(B[i], A, 0, A.length - 1)
						&& binarySearch(B[i], C, 0, C.length - 1))
					System.out.print(B[i] + " ");
			}
		} else {
			for (int i = 0; i < C.length; i++) {
				if (binarySearch(C[i], A, 0, A.length - 1)
						&& binarySearch(C[i], B, 0, B.length - 1))
					System.out.print(C[i] + " ");
			}
		}

	}

	public static void main(String[] args) {
		int[] A = { 1, 5, 5 };
		int[] B = { 3, 4, 5, 5, 10 };
		int[] C = { 5, 5, 10, 20 };
		new SortedArrsFind().findIntersection(A, B, C);

	}

}
