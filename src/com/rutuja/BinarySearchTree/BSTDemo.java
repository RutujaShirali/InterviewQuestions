package com.rutuja.BinarySearchTree;

public class BSTDemo {
	Node root;

	class Node {
		int data;
		Node rightChild;
		Node leftChild;
		int size;

		public Node(int data, Node rightChild, Node leftChild) {
			super();
			this.data = data;
			this.rightChild = rightChild;
			this.leftChild = leftChild;
			this.size = 1;
		}

		public Node(int data) {
			this(data, null, null);
		}

	}

	public int next(int element) {
		Node lastLeft = null;
		Node r = root;
		while (r != null) {
			if (r.data == element)
				break;
			if (element < r.data) {
				lastLeft = r;
				r = r.leftChild;
			} else
				r = r.rightChild;
		}
		if (r != null && r.rightChild != null) {
			r = r.rightChild;
			while (r.leftChild != null) {
				r = r.leftChild;
			}
			return r.data;
		} else {
			if (lastLeft == null)
				return -1;
			else
				return lastLeft.data;
		}
	}

	public boolean insert(int element) {
		Node node = new Node(element);
		if (root == null) {
			root = node;
			return true;
		}
		Node r = root;
		Node prev = null;
		while (r != null) {
			prev = r;
			if (r.data == node.data)
				return false;
			if (r.data > node.data) {
				r = r.leftChild;
			} else
				r = r.rightChild;
		}
		r = root;
		while (r != null) {
			r.size++;
			if (r.data > node.data) {
				r = r.leftChild;
			} else
				r = r.rightChild;
		}
		if (prev.data > node.data) {
			prev.leftChild = node;
		} else
			prev.rightChild = node;
		return true;
	}

	public int leastAnc(int a, int b) {
		Node r = root;
		while (r != null) {
			if (a == r.data || b == r.data)
				return r.data;
			if (a < r.data && b < r.data)
				r = r.leftChild;
			else if (a > r.data && b > r.data)
				r = r.rightChild;
			else
				return r.data;
		}
		return -1;
	}

	public int fksmallest(int k) {
		return fksmallest_R(root, k);
	}

	private int fksmallest_R(Node r, int k) {
		int lsize;
		if (r == null)
			return -1;
		lsize = r.leftChild != null ? r.leftChild.size : 0;
		if (lsize >= k)
			return fksmallest_R(r.leftChild, k);
		if (lsize + 1 == k)
			return r.data;
		else
			return fksmallest_R(r.rightChild, k - lsize - 1);

	}

	public boolean isBST() {
		return isBST_R(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}

	private boolean isBST_R(Node node, int min, int max) {
		if (node == null)
			return true;
		return (node.data >= min && node.data <= max)
				&& isBST_R(node.leftChild, min, node.data)
				&& isBST_R(node.rightChild, node.data, max);
	}

	public static void testBST() {
		BSTDemo bt = new BSTDemo();
		bt.insert(7);
		bt.insert(5);
		bt.insert(9);
		bt.insert(3);
		bt.insert(6);
		bt.insert(4);
		System.out.println(bt.leastAnc(6, 4));
		System.out.println(bt.next(6));
		System.out.println(bt.fksmallest(1));
	}

	public static void main(String[] args) {
		testBST();
	}

}
