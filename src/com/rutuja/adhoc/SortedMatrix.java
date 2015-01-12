package com.rutuja.adhoc;

import java.util.Arrays;
import java.util.PriorityQueue;

public class SortedMatrix {

	class Triplet implements Comparable<Triplet> {

		int row, column, element;

		public Triplet(int row, int column, int element) {
			super();
			this.row = row;
			this.column = column;
			this.element = element;
		}

		@Override
		public int compareTo(Triplet hut) {
			return Integer.compare(this.element, hut.element);
		}

	}

	public void printMatrix(int[][] mat) {
		PriorityQueue<Triplet> pq = new PriorityQueue<>();
		for (int i = 0; i < mat.length; i++) {
			pq.add(new Triplet(i, 0, mat[i][0]));
		}
		while (!pq.isEmpty()) {
			Triplet t = pq.poll();
			System.out.print(t.element + " ");
			if (t.column + 1 < mat[0].length)
				pq.add(new Triplet(t.row, t.column + 1,
						mat[t.row][t.column + 1]));

		}

	}

	// Method 2 using Binary heap

	public void printMatrix2(int[][] mat) {
		for (int i = 0; i < mat.length; i++) {
			for (int j = 0; j < mat[0].length; j++) {
				System.out.print(mat[0][0] + " ");
				mat[0][0] = Integer.MAX_VALUE;
				siftDown(mat, 0, 0);
				

			}
		}

	}

	private void siftDown(int[][] mat, int i, int j) {
		int mini = i, minj = j;
		if (j + 1 < mat[0].length && mat[i][j + 1] < mat[mini][minj]) {
			mini = i;
			minj = j + 1;
		}
		if (i + 1 < mat.length && mat[i + 1][j] < mat[mini][minj]) {
			mini = i + 1;
			minj = j;
		}
		if (!(i == mini && j == minj)) {
			int temp = mat[i][j];
			mat[i][j] = mat[mini][minj];
			mat[mini][minj] = temp;
			siftDown(mat, mini, minj);
		}

	}

	public static void main(String[] args) {
		int[][] mat = { { 10, 20, 30, 40 }, { 15, 25, 35, 45 },
				{ 27, 29, 37, 48 }, { 32, 33, 39, 50 } };
		new SortedMatrix().printMatrix2(mat);
	}

}
