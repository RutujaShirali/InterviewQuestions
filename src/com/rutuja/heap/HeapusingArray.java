package com.rutuja.heap;

public class HeapusingArray {

	private int capacity;
	private int[] heapArr;
	private int size = 0;

	public HeapusingArray(int capacity) {
		super();
		this.capacity = capacity;
		this.heapArr = new int[capacity];
	}

	public void add(int element) {
		if (size < capacity) {
			heapArr[size] = element;
			siftUp();
			size++;
		}
	}

	public int delete() {
		int item = heapArr[0];
		heapArr[0] = heapArr[size-1];
		size--;
		siftDown();
		System.out.println("Deleted item is:");
		return item;
	}

	private void siftDown() {
		int maxIndex = 0;
		int root = 0;
		while (root < size) {
			maxIndex = root;
			int l = 2 * root + 1, r = 2 * root + 2;
			if (l < size && heapArr[l] > heapArr[maxIndex]) {
				maxIndex = l;
			}
			if (r < size && heapArr[r] > heapArr[maxIndex]) {
				maxIndex = r;
			}
			if (maxIndex != root) {
				swap(maxIndex, root);
				root = maxIndex;
			} else
				break;
		}

	}

	private void siftUp() {
		int child = size;
		int parent = (child - 1) / 2;
		while (parent != 0 && heapArr[child] > heapArr[parent]) {
			swap(child, parent);
			child = parent;
			parent = (child - 1) / 2;
		}

	}

	private void swap(int child, int parent) {
		int temp = heapArr[child];
		heapArr[child] = heapArr[parent];
		heapArr[parent] = temp;

	}

	public void print() {
		for (int i = 0; i < size; i++) {
			System.out.print(heapArr[i] + " , ");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		HeapusingArray h = new HeapusingArray(16);
		h.add(18);
		h.add(10);
		h.add(15);
		h.add(9);
		h.add(10);
		h.add(6);
		h.add(8);
		h.add(5);
		h.add(2);
		h.add(9);
		h.add(7);
		h.add(3);
		h.add(2);
		h.add(4);
		h.add(3);
		h.print();
		System.out.println(h.delete());
		System.out.println();
		h.print();

	}
}
