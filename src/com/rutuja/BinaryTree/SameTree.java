package com.rutuja.BinaryTree;

import com.rutuja.BinaryTree.BinaryTree.Node;

public class SameTree {

	private boolean sametree_R(Node r1, Node r2) {
		if (r1 == null && r2 == null)
			return true;
		if (r1 == null || r2 == null)
			return false;
		return (r1.data == r2.data) && sametree_R(r1.leftChild, r2.leftChild)
				&& sametree_R(r1.rightChild, r2.rightChild);

	}

	public boolean sametree(BinaryTree b1, BinaryTree b2) {
		return sametree_R(b1.root, b2.root);
	}

	public static void main(String[] args) {
		BinaryTree bt1 = new BinaryTree();
		for (int i = 0; i < 5; i++) {
			bt1.add(i);
		}
		BinaryTree bt2 = new BinaryTree();
		for (int i = 0; i < 5; i++) {
			bt2.add(i);
		}
		SameTree st = new SameTree();
		System.out.println(st.sametree(bt1, bt2));

	}

}
