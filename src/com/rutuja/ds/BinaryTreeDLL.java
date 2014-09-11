package com.rutuja.ds;

public class BinaryTreeDLL {
	class BinarySearchTree {
		Node root;
		Node head;
		Node tail;

		public boolean insert(int element) {
			if (root == null) {
				root = new Node(element);
				return true;
			} else
				return insert_R(root, element);

		}

		private boolean insert_R(Node node, int element) {
			if (element == node.value)
				return false;
			else if (element < node.value) {
				if (node.leftChild == null) {
					node.leftChild = new Node(element);
					return true;
				} else
					return insert_R(node.leftChild, element);
			} else {
				if (node.rightChild == null) {
					node.rightChild = new Node(element);
					return true;
				} else
					return insert_R(node.rightChild, element);
			}
		}

		class Node {
			public Node(int n) {
				value = n;
			}

			Node leftChild;
			Node rightChild;
			Node next;
			Node previous;

			int value;

			public int countChild() {
				return (leftChild != null ? 1 : 0)
						+ (rightChild != null ? 1 : 0);
			}
		}

		public void treeDLL() {
			head = treeDLL_R(root)[0];

		}

		private Node[] treeDLL_R(Node node) {
			Node[] left = null;
			Node[] right = null;
			if (node.leftChild != null) {
				left = treeDLL_R(node.leftChild);
			}
			if (node.rightChild != null) {
				right = treeDLL_R(node.rightChild);
			}
			Node h1, t1, h2, t2;
			if (left != null && right != null) {
				h1 = left[0];
				t1 = left[1];
				h2 = right[0];
				t2 = right[1];
				t1.next = node;
				node.next = h2;
				node.previous = t1;
				h2.previous = node;
				return new Node[] { h1, t2 };
			}
			if (left == null && right == null)
				return new Node[] { node, node };
			if (left == null) {
				node.next = right[0];
				right[0].previous = node;
				return new Node[] { node, right[1] };

			} else {
				node.previous = left[1];
				left[1].next = node;
				return new Node[] { left[0], node };
			}

		}

		@Override
		public String toString() {
			StringBuilder sb = new StringBuilder();
			Node node = head;
			do {
				sb.append(node.value).append(" ");
				node = node.next;
			} while (node != null);
			return sb.toString();
		}
	}

	public static void main(String[] args) {
		BinaryTreeDLL b = new BinaryTreeDLL();
		BinaryTreeDLL.BinarySearchTree bst = b.new BinarySearchTree();
		bst.insert(5);
		bst.insert(4);
		bst.insert(6);
		bst.insert(3);
		bst.insert(7);
		bst.treeDLL();
		System.out.println(bst.toString());

	}
}
