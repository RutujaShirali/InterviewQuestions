package com.rutuja.sortingAlgos;

import java.util.Arrays;

public class MergeSort {

	private int[] numbers;
	private int[] helper;
	private int number;

	public void sort(int[] values) {
		this.numbers = values;
		this.number = values.length;
		this.helper = new int[number];
		mergeSort(0, number - 1);
	}

	private void mergeSort(int low, int high) {
		if (low < high) {
			int middle = (low + high) / 2;
			mergeSort(low, middle);
			mergeSort(middle + 1, high);
			merge(low, middle, high);
		}
	}

	private void merge(int low, int middle, int high) {
		for (int i = low; i <= high; i++) {
			helper[i] = numbers[i];
		}
		int i = low;
		int j = middle + 1;
		int k = low;
		while (i <= middle && j <= high) {
			if (helper[i] < helper[j]) {
				numbers[k] = helper[i];
				i++;
			} else {
				numbers[k] = helper[j];
				j++;
			}
			k++;
		}
		while (i <= middle) {
			numbers[k] = helper[i];
			k++;
			i++;
		}
		while (j <= high) {
			numbers[k] = helper[j];
			k++;
			j++;
		}

	}

	public static void main(String[] args) {
		MergeSort ms = new MergeSort();
		int[] arr = { 10, 15, 3, 2, 40, 20 };
		ms.sort(arr);
		System.out.println(Arrays.toString(arr));

	}

}
