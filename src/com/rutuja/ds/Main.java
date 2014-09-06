package com.rutuja.ds;

import java.util.PriorityQueue;

public class Main {

	public static void main(String[] args) {
		BinaryHeap bh = new BinaryHeap();
		bh.push(10);
		bh.push(60);
		bh.push(50);
		bh.push(5);
		System.out.println(bh);
		while (!bh.isEmpty())
			System.out.println(bh.pop());

		PriorityQueue<Integer> pq = new PriorityQueue<>();
		for (int i : new int[] { 10, 60, 50, 5 })
			pq.add(i);
		while (!pq.isEmpty())
			System.out.println(pq.poll());

	}

}
