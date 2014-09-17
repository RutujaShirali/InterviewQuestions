package com.rutuja.ds;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

public class FindMaxinK {

	class Pair implements Comparable<Pair> {
		int val;
		int index;

		public Pair(int val, int index) {
			super();
			this.val = val;
			this.index = index;
		}

		@Override
		public int compareTo(Pair o) {
			int a = val; // 4
			int b = o.val; // 5
			if (a < b)
				return 1;
			if (a == b)
				return 0;
			else
				return -1;
		}

	}

	public void findMax(int[] arr, int k) {
		PriorityQueue<Pair> pq = new PriorityQueue<>();
		for (int i = 0; i < k; i++) {
			pq.add(new Pair(arr[i], i));
		}
		for (int i = k; i < arr.length; i++) {
			System.out.println(pq.peek().val);
			while (!pq.isEmpty() && pq.peek().index <= i - k) {
				pq.poll();
			}
			pq.add(new Pair(arr[i], i));

		}
		System.out.println(pq.peek().val);

	}

	public void findMax2(int[] arr, int k) {
		LinkedList<Integer> q = new LinkedList<Integer>();
		for (int i = 0; i < k; i++) {
			while (!q.isEmpty() && arr[i] >= arr[q.getLast()]) {
				q.removeLast();
			}
			q.addLast(i);

		}
		System.out.println(arr[q.get(0)]);
		for (int i = k; i < arr.length; i++) {
			while (!q.isEmpty() && arr[i] >= arr[q.getLast()]) {
				q.removeLast();
			}
			while (!q.isEmpty() && q.getFirst() <= i - k) {
				q.removeFirst();
			}
			q.addLast(i);
			System.out.println(arr[q.getFirst()]);
		}

	}

	public static void main(String[] args) {

		int[] arr = { 5, -1, 3, 4, 5, 1, 7, 9 };
		FindMaxinK f = new FindMaxinK();
		f.findMax2(arr, 3);
	}

}
