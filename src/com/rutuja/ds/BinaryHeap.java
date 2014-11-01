package com.rutuja.ds;

import java.util.Arrays;

public class BinaryHeap {
	int size = 0;
	int[] arr = new int[10];

	public int[] push(int element) {
		arr[size] = element;
		size++;
		siftUp(size - 1);
		return arr;
	}

	public boolean less(int a, int b) {
		return (a < b); // a.compareTo(b) < 0 --> a < b
	}

	private void siftUp(int index) {
		if (index > 0 && !less(arr[(index - 1) / 2], arr[index])) {
			int temp = arr[(index - 1) / 2];
			arr[(index - 1) / 2] = arr[index];
			arr[index] = temp;
			siftUp((index - 1) / 2);

		}
	}

	public void heapify(int[] arr) {
		this.arr = arr;
		this.size = arr.length;
		for (int i = arr.length / 2; i >= 0; i--)
			siftDown(i);
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public int pop() {
		int element = arr[0];
		arr[0] = arr[size - 1];
		size--;
		siftDown(0);
		return element;
	}

	private void siftDown(int index) {
		int minIndex = index;
		if (((2 * index) + 1) < size
				&& less(arr[(2 * index) + 1], arr[minIndex]))
			minIndex = (2 * index) + 1;
		if (((2 * index) + 2) < size
				&& less(arr[(2 * index) + 2], arr[minIndex]))
			minIndex = (2 * index) + 2;
		if (minIndex != index) {
			int temp = arr[index];
			arr[index] = arr[minIndex];
			arr[minIndex] = temp;
			siftDown(minIndex);
		}
	}

	@Override
	public String toString() {
		return Arrays.toString(arr);
	}
	
	public static void main(String[] args) {
		int[] arr = new int[]{9, 8,7,6,5,4,3,2,1,0 };
		BinaryHeap heap = new BinaryHeap();
		heap.heapify(arr);
		System.out.println(heap);
	}

}
