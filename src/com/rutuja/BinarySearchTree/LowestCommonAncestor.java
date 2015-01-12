package com.rutuja.BinarySearchTree;

public class LowestCommonAncestor {

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

	private int lca_R(Node node, int n1, int n2) {
		if (node == null)
			return 0;
		if (node.data > n1 && node.data > n2)
			return lca_R(node.leftChild, n1, n2);
		if (node.data < n1 && node.data < n2)
			return lca_R(node.rightChild, n1, n2);
		return node.data;
	}

	public int lca(int n1, int n2) {
		return lca_R(root, n1, n2);
	}

	public static void main(String[] args) {
		LowestCommonAncestor l = new LowestCommonAncestor();
		l.insert(20);
		l.insert(8);
		l.insert(22);
		l.insert(4);
		l.insert(12);
		l.insert(10);
		l.insert(14);
		System.out.println(l.lca(10, 14));

	}

}
