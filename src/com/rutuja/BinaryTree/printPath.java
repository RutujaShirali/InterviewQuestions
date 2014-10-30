package com.rutuja.BinaryTree;

import com.rutuja.BinaryTree.BinaryTree.Node;

public class printPath {

	public void print(BinaryTree bt) {
		int[] pt = new int[1000];
		print_R(bt.root, 0, pt);
	}

	private void print_R(Node r, int pathlen, int[] path) {
		if (r == null)
			return;
		path[pathlen] = r.data;
		pathlen++;
		if (r.leftChild == null && r.rightChild == null) {
			for (int i = 0; i < pathlen; i++) {
				System.out.print(path[i] + " ");
			}
			System.out.println();
		} else {
			print_R(r.leftChild, pathlen, path);
			print_R(r.rightChild, pathlen, path);
		}

	}

	public static void main(String[] args) {
		BinaryTree b = new BinaryTree();
		for (int i = 1; i < 6; i++) {
			b.add(i);
		}
		printPath p = new printPath();
		p.print(b);

	}
}
