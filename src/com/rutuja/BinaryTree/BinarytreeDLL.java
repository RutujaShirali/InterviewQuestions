package com.rutuja.BinaryTree;

import java.util.LinkedList;

import com.rutuja.BinaryTree.BinaryTree.Node;

public class BinarytreeDLL {

	class Node {
		int data;
		Node rightChild;
		Node leftChild;

		public Node(int data, Node rightChild, Node leftChild) {
			super();
			this.data = data;
			this.rightChild = rightChild;
			this.leftChild = leftChild;
		}

		public Node(int data) {
			this(data, null, null);
		}
	}

	public Node add(Node node, int element) {
		if (node == null)
			return new Node(element);
		else {
			if (Math.random() > 0.5)
				node.rightChild = add(node.rightChild, element);
			else
				node.leftChild = add(node.leftChild, element);
		}
		return node;
	}

	public Node createTree(int n) {
		Node root = null;
		for (int i = 0; i < n; i++)
			root = add(root, i);
		return root;
	}

	public static void main(String[] args) {
		new BinarytreeDLL().test_BT2DLL();
		new BinarytreeDLL().test_DLL2BT();
	}

	private void test_BT2DLL() {

		Node root = createTree(10);
		inOrder(root);
		root = BT2DLL(root);
		printDLL(root);

	}

	private void test_DLL2BT() {

		Node root = createTree(10);
		root = BT2DLL(root);
		printDLL(root);
		root = DLL2BT(root);
		inOrder(root);

	}

	public void printDLL(Node head) {
		Node node = head;
		while (node != null) {
			System.out.print(node.data + " <->");
			node = node.rightChild;
		}
		System.out.println();
	}

	public Node BT2DLL(Node root) {
		Node prev = null;
		Node next = null;
		if (root == null)
			return null;
		if (root.leftChild != null) {
			prev = BT2DLL(root.leftChild);
		}
		if (root.rightChild != null) {
			next = BT2DLL(root.rightChild);
		}
		root.leftChild = root.rightChild = null;
		if (prev == null) {
			prev = root;
		} else {
			Node tail = prev;
			while (tail.rightChild != null) {
				tail = tail.rightChild;
			}
			tail.rightChild = root;
			root.leftChild = tail;
		}
		if (next != null) {
			root.rightChild = next;
			next.leftChild = root;
		}
		return prev;

	}

	public void inOrder(Node root) {
		Node curr = root;
		LinkedList<Node> stack = new LinkedList<>();
		while (!stack.isEmpty() || curr != null) {
			if (curr != null) {
				stack.push(curr);
				curr = curr.leftChild;
			} else {
				curr = stack.pop();
				System.out.print(curr.data + " ");
				curr = curr.rightChild;
			}
		}
		System.out.println();
	}

	public Node findMid(Node head) {
		Node f = head, s = head;
		while (f != null) {
			f = f.rightChild;
			if (f != null){
				s = s.rightChild;
				f = f.rightChild;
			}
		}
		return s;
	}

	public Node DLL2BT(Node head) {
		if (head == null)
			return null;
		Node root = findMid(head);
		Node right = null, left = null;
		if (root.leftChild != null) {
			left = head;
			root.leftChild.rightChild = null;
			root.leftChild = null;
		}
		if (root.rightChild != null) {
			right = root.rightChild;
			root.rightChild.leftChild = null;
			root.rightChild = null;
		}

		root.leftChild = DLL2BT(left);
		root.rightChild = DLL2BT(right);
		return root;

	}

}
