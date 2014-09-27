package com.rutuja.adhoc;

import java.util.Arrays;

public class ArrayinTree {
	class BinarySearchTree {
		Node root;

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

		public int printInorder(int[] arr) {
			return printInorder_R(root, arr, 0);
		}

		private int printInorder_R(Node node, int[] arr, int index) {
			if (node != null && index < arr.length) {
				index = printInorder_R(node.leftChild, arr, index);
				if (index == -1 || arr[index] < node.value)
					return -1;
				else if (arr[index] == node.value)
					index++;
				index = printInorder_R(node.rightChild, arr, index);
			}
			return index;

		}

		public boolean arrBST(int[] arr, int lo, int hi) {
			return arrBST(arr, lo, hi, root);
		}

		private boolean arrBST(int[] arr, int low, int high, Node node) {
			if (low > high)
				return true;
			if (node == null)
				return false;
			int mid = Arrays.binarySearch(arr, low, high + 1, node.value);
			if (mid >= 0) {
				return arrBST(arr, low, mid - 1, node.leftChild)
						&& arrBST(arr, mid + 1, high, node.rightChild);
			} else
				return arrBST(arr, ~mid, high, node.rightChild)
						&& arrBST(arr, low, ~mid - 1, node.leftChild);
		}
	}

	public static void main(String[] args) {
		ArrayinTree b = new ArrayinTree();
		ArrayinTree.BinarySearchTree bst = b.new BinarySearchTree();
		bst.insert(5);
		bst.insert(1);
		bst.insert(2);
		bst.insert(3);
		bst.insert(4);
		bst.insert(6);
		bst.insert(10);
		int[] arr = { 1, 2, 3, 4, 6, 10 };
		if (bst.printInorder(arr) == arr.length)
			System.out.println("true");
		else
			System.out.println("false");

		System.out.println(bst.arrBST(arr, 0, arr.length - 1));;

	}

}
